/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters;


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
    private ChracterAttri attributes; //que quede claro, no cambiar.
    private Container container;
    private int takeIndex;

    
    public Consumer(ChracterAttri attributes, Container container) {
        this.container = container;
        this.attributes = attributes;
        this.attributes.setImage(this.attributes.getListAnimations().get("take").getFrames().get(0));
        this.takeIndex = 0;
    }
    
    public void setAttributes(ChracterAttri atributos) {
        this.attributes = atributos;
    }

    
    
    public ChracterAttri getAttributes() {
        return attributes;
    }

    
    @Override
    public void draw(Graphics2D g) {
        g.drawImage(this.attributes.getImage(),this.getAttributes().getX(), this.getAttributes().getY(), container);
    }
    
    public boolean upHand(){
        Animations animations = this.attributes.getListAnimations().get("take");
        if (takeIndex >= animations.getFrames().size()) {
            takeIndex = animations.getFrames().size();
            return true;
        }
        System.out.println(takeIndex);
        this.attributes.setImage(animations.getFrames().get(takeIndex++));
        return false;
    }

    public void downHand(){
        takeIndex = 0;
        this.attributes.setImage(this.attributes.getListAnimations().get("take").getFrames().get(takeIndex));
    }

    @Override
    public void update() {
        // Updates the information
    }
}
