/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters.Compostion;

import com.telloing.frame.Scenary;
import com.telloing.frame.Chracters.ActCharac;
import com.telloing.frame.Chracters.Food;
import com.telloing.frame.Chracters.Collision.CollisionerPlaneArea;
import com.telloing.frame.Chracters.Food;

import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;

/**
 *
 * @author josue
 */

class Sushis_onLine {
    private final int lapse = 8;
    private final int limitSushis = 32;

    private List<Food> sushisToShow;
    private int timer; // define el espacio entre sushis
    private int index; // define el sushi en el que se esta

    public Sushis_onLine() {
        this.sushisToShow = new LinkedList<Food>();
        this.timer = 8;
    }

    public List<Food> getSushisToShow() {
        return sushisToShow;
    }

    public void addSushi(List<Food> sushis) {
        //System.out.println("arriba: " + sushisToShow.size() + " index" + index);
        if (timer > lapse) {
            timer = 0;
            if (index < sushis.size()) {
                if (!sushisToShow.contains(sushis.get(index))) {

                    sushisToShow.add(sushis.get(index));
                }
            }
            index = index < limitSushis ? sushisToShow.size() : 0;


        }
        timer++;
        
        
        // System.out.println( "Index: " + Integer.toString(index) + " timer:"+
        // Integer.toString(timer) + sushisToShow.toString());
    }

}

class Sushi_Online implements ActCharac {

    private Food sushi;
    private Container container;

    public Sushi_Online(Food sushi, Container container) {
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
        g.drawImage(sushi.getAttributes().getImage(), sushi.getAttributes().getX(), sushi.getAttributes().getY(),
                container);
    }

    @Override
    public void update() {
        sushi.getAttributes().setX(sushi.getAttributes().getX() + sushi.getAttributes().getSpeed());
    }

}

public class SushiLine implements ActCharac {
    private final int delay = 300;

    private List<Food> sushis;
    private List<Food> sushisToRemove;
    private Sushi_Online action;
    private Sushis_onLine sushisToShow;

    public SushiLine() {
        this.sushis = new LinkedList<>();
        this.sushisToRemove = new LinkedList<>();
        this.action = new Sushi_Online(null, null);
        setNewCollisionerArea(430, 3, 2);
        this.sushisToShow = new Sushis_onLine();

    }

    public boolean add(Food character) {
        if (this.sushis.size() >= 32) {
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
        for (Food sushi : sushisToShow.getSushisToShow()) { // se ocupa actualizar cada vez que se itera
            if (sushi.getAttributes().isReady()) {
                action.setSushi(sushi);
                action.draw(g);
            }
        }
        // System.out.println(Arrays.toString(CollisionerPlaneArea.collisionFood));
    }

    @Override
    public void update() {
        // System.out.println(Arrays.toString(CollisionerPlaneArea.collisionFood));
        sushisToShow.addSushi(sushis);
        sushisToRemove.clear(); // lista para guardar cuales a eliminar. se vacia, para iniciar en 0
        for (Food sushi : sushisToShow.getSushisToShow()) {
            if (sushi.getAttributes().isReady()) {
                action.setSushi(sushi);
                checkListener(sushi);
                checkCollision(sushi); // default: action.update();
            }
        }
        sushis.removeAll(sushisToRemove); // revisa los sushis a eliminar, A HUEVO, se hace asi
        // porque si borramos directamente, y nos quedamos sin sushis, EXCEPTION
        // java.util.ConcurrentModificationException
        sushisToShow.getSushisToShow().removeAll(sushisToRemove);
    }

    private void checkListener(Food sushi) {
        switch (Scenary.listener.getKeyCode()) {
            case KeyEvent.VK_E:
                setNewCollisionerArea(415, 10, 3);
                break;
            default:
                setNewCollisionerArea(415, 10, 0);
        }
        Scenary.listener.setKeyCode(-1);

    }

    private void checkCollision(Food sushi) {
        int idObj = sushi.getCollisionChecker().updateCollision(sushi.getAttributes().getSpeed());
        switch (idObj) {
            case 2:
                sushi.getAttributes().setX(72);
                sushi.getCollisionChecker().getCollisionZone()[sushi.getCollisionChecker().getActualPosition()] = 0;
                sushi.getCollisionChecker().setActualPosition(0);
                sushi.getAttributes().setTimer(this.delay);
                break;
            case 3:
                sushi.getCollisionChecker().getCollisionZone()[sushi.getCollisionChecker().getActualPosition()] = 0;
                sushi.getCollisionChecker().setActualPosition(0);
                System.out.println(sushisToRemove.add(sushi));
                break;
            default:
                action.update();
        }
    }

    private void setNewCollisionerArea(int point, int dimension, int symbol) {
        for (int i = 0; i < dimension; i++) {
            CollisionerPlaneArea.collisionFood[point + i] = symbol;
        }
    }
}
