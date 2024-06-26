/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters.Compostion;

import com.telloing.frame.Scenary;
import com.telloing.frame.Chracters.Elements.ActCharac;
import com.telloing.frame.Chracters.Collision.ActivationZone1D;
import com.telloing.frame.Chracters.Collision.ActivationZoneObj;
import com.telloing.frame.Chracters.Consumer;
import com.telloing.frame.Chracters.Food;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;
import java.awt.Container;
import java.awt.event.KeyEvent;

/**
 *
 * @author josue
 */
class Sushis_onLine {

    static public final long lapse = 500; // milisegundos

    private List<Food> sushisToShow;
    //private Delayer delayer;
    private int index;

    public Sushis_onLine() {
        this.sushisToShow = new LinkedList<Food>();
        //this.delayer = new Delayer(lapse);
    }

    public List<Food> getSushisToShow() {
        return sushisToShow;
    }

    public void updateList(List<Food> sushis) {
        sushisToShow.retainAll(sushis);
        if (index > sushisToShow.size()) { index = sushisToShow.size(); }

       /* if (!delayer.isTime()) {
            return;
        }
        delayer.startTimer(); */
        if (index < sushis.size()) {
            sushisToShow.add(sushis.get(index));
            index++;
        }
    }


}

class OnlineAction implements ActCharac {

    private Food sushi;
    private Container container;

    public OnlineAction(Food sushi, Container container) {
        this.sushi = sushi;
        this.container = container;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public Food getSushi() {
        return sushi;
    }

    public void setSushi(Food sushi) {
        this.sushi = sushi;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(sushi.getAttributes().getFrame(), sushi.getAttributes().getX(), sushi.getAttributes().getY(),
                container);
    }

    @Override
    public void update() {
        sushi.getAttributes().setX(sushi.getAttributes().getX() + sushi.getAttributes().getSpeed());
    }

    @Override
    public String toString() {
        return "Sushi_Online [sushi=" + sushi.toString() + "]";
    }

}

public class SushiLine implements ActCharac {
    public static final int upHandKey = KeyEvent.VK_Z;
    public static final int INITIAL_POSITION = 72;

    private final long delay = Sushis_onLine.lapse;
    private final int max = 32;

    
    private List<Food> sushis;
    private OnlineAction action;
    private ActivationZone1D activation;

    public SushiLine() {
        this.sushis = new LinkedList<>();
        this.action = new OnlineAction(null, null);
        this.activation = new ActivationZone1D(ActivationZone1D.collisionFood);
        
        ActivationZone1D.fillArea(450, 2, ActivationZone1D.collisionFood, 5);

    }

    public boolean isLimit(){
        if (this.sushis.size() >= max) {
            return true;
        }
        return false;
    }

    public boolean add(Food character) {
        if (this.sushis.size() >= max) {
            return false;
        }
        action.setContainer(character.getContainer());
        return this.sushis.add(character);
    }

    public boolean remove(Food character) {
        return this.sushis.remove(character);
    }

    public Food getChild(Food character) {
        int index = this.sushis.indexOf(character);
        if (index == -1) {
            return null;
        }
        return this.sushis.get(index);
    }

    @Override
    public void draw(Graphics2D g) {
        for (Food sushi : sushis) { // se ocupa actualizar cada vez que se itera
            if (sushi.getAttributes().getLifeTime().isVisible()) {
                action.setSushi(sushi);
                action.draw(g);
            }
        }
    }

    @Override
    public void update() {
        //sushisToShow.updateList(sushis);
        for (Food sushi : sushis) {
            checkActivators();
            if (sushi.getAttributes().getLifeTime().isReady()) {
                checkActivation(sushi); // no activation: action.update();
            }
        }
        activateActivations(); // revisa los sushis a eliminar, A HUEVO, se hace asi
        // porque si borramos directamente, y nos quedamos sin sushis, EXCEPTION
        // java.util.ConcurrentModificationException
    }

    private void checkActivators() {
        final int zone = 20;
        final int point = 130;
        switch (Scenary.listener.getKeyCode()) {
            case SushiLine.upHandKey:
                // activa animacion de mano;
                if(Consumer.isUpHand){
                    ActivationZone1D.fillArea(point, 3, ActivationZone1D.collisionFood, zone);
                }
                break;
            default:
                ActivationZone1D.fillArea(point, 0, ActivationZone1D.collisionFood, zone);
        }
    }

    private void checkActivation(Food sushi) {
        action.setSushi(sushi);
        int actualPos = sushi.getAttributes().getX() - SushiLine.INITIAL_POSITION;
        int objSymbol = activation.checkArea(actualPos, sushi.getAttributes().getFrame().getWidth());
        switch (objSymbol) {
            case 0:
                action.update();
                break;
            case 3: // si quieres que la mano siempre interactue con los sushis.
                activation.getActivatedObjs().add(new ActivationZoneObj(objSymbol, sushi));
                action.update();
                break;
            default:
                activation.getActivatedObjs().add(new ActivationZoneObj(objSymbol, sushi));
        }
    }

    private void activateActivations() {
        for (ActivationZoneObj obj : activation.getActivatedObjs()) {
            switch (obj.getObjSymbol()) {
                case 2:
                case -1:
                    obj.getObj().getAttributes().setX(SushiLine.INITIAL_POSITION);
                    obj.getObj().getAttributes().getLifeTime().startTimer(this.delay);
                    break;
                case 3:
                    boolean isDeletable = Scenary.sushisToEat.add(obj.getObj());
                    if (isDeletable) {
                        sushis.remove(obj.getObj());
                    }
                    break;
            }
        }
        activation.getActivatedObjs().clear();
    }

}
