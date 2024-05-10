package com.telloing.frame.Chracters.Compostion;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import com.telloing.frame.Scenary;
import com.telloing.frame.Chracters.Elements.ActCharac;
import com.telloing.frame.Chracters.Consumer;
import com.telloing.frame.Chracters.Food;
import com.telloing.frame.Chracters.Ornament;
import com.telloing.frame.Chracters.ChracterBuilder.OrnamentDirector;
import com.telloing.frame.Frames.Animations;

import java.awt.Container;

class Sushi_Ontable {

    private boolean isEating;
    private Food sushi;
    private Container container;

    public Sushi_Ontable(Food sushi, Container container) {
        this.sushi = sushi;
        this.container = container;
    }

    public boolean isEating() {
        return isEating;
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
        g.drawImage(sushi.getAttributes().getFrame(), sushi.getAttributes().getX(), sushi.getAttributes().getY(),
                container);
    }

    public boolean update() {
        Animations animation = this.sushi.getAttributes().getListAnimations().get("comer");
        if (animation.updateNextFrame()) {
            sushi.getAttributes().setFrame(animation.getActualFrame());
            sushi.getAttributes().setX(120);
            sushi.getAttributes().setY(160);
            isEating = true;
            return false;
        }
        isEating = false;
        return true;
    }

}

public class SushiTable implements ActCharac {
    public static final int eatKey = KeyEvent.VK_X;

    private final int max_sushis = 7;
    private final int[] positionX = { 222, 252, 282, 312, 342, 372, 402 };
    private final int positionY = 260;
    private final int elementToDelete = 0;

    private List<Food> sushis;
    private List<Food> sushis_toAdd;
    private Sushi_Ontable action;
    private Ornament eatAnimation;
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
        if (action.isEating()) {
            eatAnimation.draw(g);
        }
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
        boolean isAte;
        if (sushis.isEmpty() || Consumer.isSleep) {
            return;
        }
        action.setSushi(sushis.get(elementToDelete));
        switch (Scenary.listener.getKeyCode()) {
            case SushiTable.eatKey:
                // animacion comer
                isAte = action.update();
                this.eatAnimation = OrnamentDirector.getInstance().createSleep("NubeComer.png", action.getContainer(),
                        action.getSushi().getAttributes().getX() - 10,
                        action.getSushi().getAttributes().getY() - 20);
                eatAnimation.update();
                if (isAte) {
                    sushis.remove(elementToDelete);
                }
                break;
        }

    }

}
