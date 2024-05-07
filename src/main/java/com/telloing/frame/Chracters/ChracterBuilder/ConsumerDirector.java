package com.telloing.frame.Chracters.ChracterBuilder;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.telloing.frame.Scenary;
import com.telloing.frame.Chracters.Elements.ChracterAttri;
import com.telloing.frame.Chracters.Consumer;
import com.telloing.frame.Chracters.Elements.MovCharact;
import com.telloing.frame.Frames.Animations;
import java.util.logging.Level;
import java.util.logging.Logger;



class ConsumerBuilder{
    private Consumer consumer;
    private Container container;
    private ChracterAttri attributos;
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

    private Animations buildFrames(String nameFile, CoordenatesCuter coord) {
        BufferedImage setFrames;
        
        try {
            setFrames = ImageIO.read(getClass().getResourceAsStream(nameFile));
        } catch (IOException ex) {
            Logger.getLogger(Scenary.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return new Animations(Animations.separateFrames(setFrames, coord.getHeight(), coord.getWidth(), coord.getRow(), coord.getCol()));
    
    }

    public void buildAnimations(){
        Map<String, Animations> list = new HashMap<String, Animations>();
        list.put("take", buildFrames("ClienteManoArriba.png", new CoordenatesCuter(192,147,3,6)));
        listAnimations = list;
    }

    public Consumer getConsumer() {
        // Define here the position of the ornament
        this.consumer = new Consumer(this.attributos, this.container);
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

    public Consumer createConsumer(Container container){
        consumerBuilder.buildAnimations();
        consumerBuilder.buildContainer(container);
        consumerBuilder.buildAttri(75, 210);
        return consumerBuilder.getConsumer();
    }
    
}
