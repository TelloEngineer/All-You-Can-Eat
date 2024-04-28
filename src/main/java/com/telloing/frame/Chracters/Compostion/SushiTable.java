package com.telloing.frame.Chracters.Compostion;

import java.awt.Graphics2D;
import java.util.LinkedList;
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

public class SushiTable implements ActCharac {
    private final int max = 7;

    private List<Food> sushis;
    private List<Food> sushisToRemove;
    private int[] posiciones;
    private Sushi_Ontable action;

    public SushiTable(){
        this.sushis = new LinkedList<>();
        this.sushisToRemove = new LinkedList<>();
        this.action = new Sushi_Ontable(null, null);
        // inicializar el random
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
            action.setSushi(sushi);
            action.draw(g);
        }
    }

    @Override
    public void update() {
        // condicion, si se activo la bandera de que acabo la animacion, sera true o false
        //operador ternario, en donde si es true, pide un nuevo numero random
        // si no lo es, simplemente vuelve a guardar su propio valor.
        //defino un random del 0 - 3;
        //declaro switch
        // cada case es un numero del random 
        // dentro case, llama a la animacion del cocinero.
        // cada case, tiene un nombre en especifico.
        // se llama cada funcion. pero antes la bandera se pone en false.
    }

    // creamos  un metodo, por accion, 1 duerme, 2 estatico, 3 interactua. parametro
    // dentro de cada metodo, llamara a la banderita, para saber, que ya acabo la animacion.
    // cambiamos de numero random.

}
