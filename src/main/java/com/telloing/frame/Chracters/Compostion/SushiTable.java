package com.telloing.frame.Chracters.Compostion;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import com.telloing.frame.Scenary;
import com.telloing.frame.Chracters.ActCharac;
import com.telloing.frame.Chracters.Food;
import com.telloing.frame.Frames.Animations;

import java.awt.Container;

class Sushi_Ontable {

    private Food sushi;
    private Container container;
    private int index;

    public Sushi_Ontable(Food sushi, Container container) {
        this.sushi = sushi;
        this.container = container;
        this.index = 1;
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

    public void draw(Graphics2D g) {
        g.drawImage(sushi.getAttributes().getImage(), sushi.getAttributes().getX(), sushi.getAttributes().getY(),
                container);
        //activar condicion
            //dibujar particular
            // use draw method
    }

    public boolean update() {
        Animations animation = this.sushi.getAttributes().getListAnimations().get("comer");
        if (index < animation.getFrames().size()) {
            sushi.getAttributes().setImage(animation.getFrames().get(index++));
            sushi.getAttributes().setX(120);
            sushi.getAttributes().setY(160);
            // bandera
            return false;
        }
        index = 1;
        return true;
    }

}

public class SushiTable implements ActCharac {
    private final int max_sushis = 7;
    private final int[] positionX = { 222, 252, 282, 312, 342, 372, 402 };
    private final int positionY = 260;
    private final int elementToDelete = 0;

    private List<Food> sushis;
    private List<Food> sushis_toAdd;
    private Sushi_Ontable action;
    private int indexSushi;

    public SushiTable() {
        this.sushis = new LinkedList<>();
        this.sushis_toAdd = new LinkedList<>();
        this.action = new Sushi_Ontable(null, null);
        // inicializar el random
    }

    public boolean add(Food character) {
        character.getAttributes().reset();
        if (this.sushis.size() >= max_sushis) {
            return false;
        }
        action.setContainer(character.getContainer());
        character.getAttributes().setX(positionX[indexSushi]);
        character.getAttributes().setY(positionY);
        indexSushi = indexSushi < max_sushis - 1 ? ++indexSushi : 0;
        return this.sushis_toAdd.add(character);
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
        sushis.addAll(sushis_toAdd);

        // System.out.println(this.sushis.size() + " : " + this.sushis_toAdd.size());
        for (Food sushi : sushis) { // se ocupa actualizar cada vez que se itera
            action.setSushi(sushi);
            action.draw(g);
        }
        sushis_toAdd.clear();

        // System.out.println(this.sushis.size() + " - " + this.sushis_toAdd.size());
    }

    @Override
    public void update() {

        checkListener();
    }

    private void checkListener() {
        if (sushis.isEmpty()) {
            return;
        }
        action.setSushi(sushis.get(elementToDelete));
        switch (Scenary.listener.getKeyCode()) {
            case KeyEvent.VK_E:
                // animacion comer
                if (action.update()) {
                    sushis.remove(elementToDelete);
                }
                Scenary.listener.setKeyCode(-1);
                break;
            default:
                //restablece original values.
        }

    }

}
