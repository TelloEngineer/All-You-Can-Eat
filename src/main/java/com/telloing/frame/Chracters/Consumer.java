/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters;


import com.telloing.frame.Frames.AnimationIterator;
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
    private AnimationIterator animationIter;


    
    public AnimationIterator getAnimationIter() {
        return animationIter;
    }

    public Consumer(ChracterAttri attributes, Container container) {
        this.container = container;
        this.attributes = attributes;
        this.attributes.setImage(this.attributes.getListAnimations().get("take").getFrames().get(0));
        this.animationIter = new AnimationIterator();
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
        return animationIter.untilLast(attributes);
    }

    public void downHand(){
        animationIter.setTakeIndex(0);
        this.attributes.setImage(this.attributes.getListAnimations().get("take").getFrames().get(animationIter.getTakeIndex()));
    }

    @Override
    public void update() {
        // Updates the information
    }
}
