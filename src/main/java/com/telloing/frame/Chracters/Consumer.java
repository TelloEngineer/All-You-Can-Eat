/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters;


import com.telloing.frame.Frames.Delayer;
import com.telloing.frame.Frames.Animations;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ListIterator;


/**
 *
 * @author aleck
 */
public class Consumer implements ActCharac {
    private final long DELAY = 30;
    
    private ChracterAttri attributes; //que quede claro, no cambiar.
    private Container container;
    private Delayer delay;



    public Consumer(ChracterAttri attributes, Container container) {
        this.container = container;
        this.attributes = attributes;
        this.attributes.setFrame(this.attributes.getListAnimations().get("take").getFrames().get(0));
        this.delay= new Delayer(DELAY);
    }
    
    public void setAttributes(ChracterAttri atributos) {
        this.attributes = atributos;
    }

    
    
    public ChracterAttri getAttributes() {
        return attributes;
    }

    
    @Override
    public void draw(Graphics2D g) {
        g.drawImage(this.attributes.getFrame(),this.getAttributes().getX(), this.getAttributes().getY(), container);
    }
    
    public boolean upHand(){
        if(!delay.isTime()){
            return false;
        }
        delay.startTimer();
        
        Animations take = this.attributes.getListAnimations().get("take");
        
        boolean isNext = take.updateNextFrame();
        if(isNext){
            attributes.setFrame(take.getActualFrame());
            return false;
        }
        return isNext;
    }

    public void downHand(){
        Animations take = this.attributes.getListAnimations().get("take");
        take.setNextFrame(0);
        this.attributes.setFrame(take.getActualFrame());
    }

    @Override
    public void update() {
        // Updates the information
    }
}
