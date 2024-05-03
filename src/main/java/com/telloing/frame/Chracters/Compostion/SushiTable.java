package com.telloing.frame.Chracters.Compostion;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.telloing.frame.Scenary;
import com.telloing.frame.Chracters.ActCharac;
import com.telloing.frame.Chracters.Food;
import com.telloing.frame.Chracters.Collision.CollisionerPlaneArea;
import com.telloing.frame.Frames.Animations;

import java.awt.Container;

class Sushi_Ontable {

    private Food sushi;
    private Container container;
    private int index;

    public Sushi_Ontable(Food sushi, Container container) {
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

    public void draw(Graphics2D g) {
        g.drawImage(sushi.getAttributes().getImage(), sushi.getAttributes().getX(), sushi.getAttributes().getY(),
                container);
    }

    public boolean update() {
        Animations animation = this.sushi.getAttributes().getListAnimations().get("comer");
        if (index < animation.getFrames().size()) {
            sushi.getAttributes().setImage(animation.getFrames().get(index++));
            return false;
        }
        index = 0;
        return true;
    }

}

public class SushiTable implements ActCharac {
    private final int max = 7;
    private final int[] positionX = { 372, 342, 312, 282, 252, 222, 192 };
    private final int positionY = 260;
    private final int elementToDelete = 0;
    private final int lapse = 8;

    private List<Food> sushis;
    private Sushi_Ontable action;
    private int timer;

    public SushiTable() {
        this.sushis = new LinkedList<>();
        this.action = new Sushi_Ontable(null, null);
        // inicializar el random
    }

    public boolean add(Food character) {
        character.getAttributes().reset();
        if (this.sushis.size() >= max) {
            return false;
        }
        action.setContainer(character.getContainer());
        character.getAttributes().setX(positionX[sushis.size()]);
        character.getAttributes().setY(positionY);
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
            action.setSushi(sushi);
            action.draw(g);
        }
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
                if (action.update()) {
                    sushis.remove(elementToDelete);
                }
                Scenary.listener.setKeyCode(-1);
                break;
        }

    }

}
