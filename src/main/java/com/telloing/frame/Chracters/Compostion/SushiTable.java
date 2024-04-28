package com.telloing.frame.Chracters.Compostion;

import java.awt.Graphics2D;
import java.util.List;

import com.telloing.frame.Chracters.ActCharac;
import com.telloing.frame.Chracters.Food;
import java.awt.Container;

class Sushi_Ontable implements ActCharac {

    private Food sushi;
    private Container container;

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

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(sushi.getAttributes().getImage(), sushi.getAttributes().getX(), sushi.getAttributes().getY(),
                container);
    }

    @Override
    public void update() {
        
    }

    
}

public class SushiTable {
    private List<Food> sushis;
    private List<Food> sushisToRemove;
   private Sushi_Ontable action;
}
