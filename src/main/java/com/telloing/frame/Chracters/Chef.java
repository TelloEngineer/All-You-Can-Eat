package com.telloing.frame.Chracters;

import com.telloing.frame.Frames.Animations;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aleck
 */
public class Chef implements ActCharac {
    private Animations animation;
    private ChracterAttri attributes; //que quede claro, no cambiar.
    private MovCharact listener;
    private Container container;
    
    
    public Chef(Animations animation, MovCharact listener, Container container) {
        this.animation = animation;
        this.listener = listener;
        this.container = container;
    }
    
    public void setAttributes(ChracterAttri atributos) {
        this.attributes = atributos;
    }
    
    public ChracterAttri getAttributes() {
        return attributes;
    }


    public void setAnimation(Animations animation) {
        this.animation = animation;
    }
    
    
    public Animations getAnimation() {
        return animation;
    }
    
    @Override
    public void draw(Graphics2D g) {
        // Move to the next animation
    }
    
    @Override
    public void update() {
        // Updates the information
    }
}
