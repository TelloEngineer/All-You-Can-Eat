package com.telloing.frame.Chracters.ChracterBuilder;

import java.awt.Container;
import java.util.Map;

import com.telloing.frame.Chracters.ChracterAttri;
import com.telloing.frame.Chracters.Consumer;
import com.telloing.frame.Chracters.MovCharact;
import com.telloing.frame.Frames.Animations;

class CoordenatesCuter{
    private int height;
    private int width;
    private int row;
    private int col;

    

    public CoordenatesCuter(int height, int width, int row, int col) {
        this.height = height;
        this.width = width;
        this.row = row;
        this.col = col;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }

    
}


class ConsumerBuilder{
    private Consumer consumer;
    private Container container;
    private ChracterAttri attributos;
    private MovCharact listener;
    private Map<String, Animations> listAnimations;
    private static ConsumerBuilder consumerBuilder;

    private ConsumerBuilder(){

    }
    
    public static ConsumerBuilder getInstance(){
        if(consumerBuilder == null){
            consumerBuilder = new ConsumerBuilder();
        }
        return consumerBuilder;
    }

    public void buildContainer(Container container){
        this.container = container;
    }

    public void buildAttri(final int x, final int y){
        this.attributos = new ChracterAttri(x, y, 1, this.listAnimations);
    }
    
    public void buildListener(MovCharact character){
        this.listener = character;
    }

    public Consumer getConsumer() {
        // Define here the position of the ornament
        this.consumer = new Consumer(this.attributos, this.listener,this.container);
        return this.consumer;
    }
}


public class ConsumerDirector {
    private ConsumerBuilder consumerBuilder;

    private static ConsumerDirector consumerDirector;
    
    private ConsumerDirector(){
        this.consumerBuilder = ConsumerBuilder.getInstance();
    }

    public static ConsumerDirector getInstance(){
        if(consumerDirector == null){
            consumerDirector = new ConsumerDirector();
        }
        return consumerDirector;
    }


    
}
