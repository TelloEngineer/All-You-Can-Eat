/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters;

import com.telloing.frame.Frames.Animations;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 *
 * @author josue
 */
public class Food implements ActCharac{
    private Animations animation;
    private ChracterAttri attributes; //que quede claro, no cambiar.
    private MovCharact listener;
    private Container container;
    
    
    public Food(Animations animation, MovCharact listener, Container container) {
        attributes = new ChracterAttri(0, 0, 0);
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
        g.drawImage(animation.getNextFrame(), this.attributes.getX(), this.attributes.getY(),this.container);
    }

    @Override
    public void update() {
        switch(this.listener.getKeyCode()){
            case KeyEvent.VK_S:
                attributes.setY(attributes.getY() + attributes.getSpeed());
                break;
            case KeyEvent.VK_W:
                attributes.setY(attributes.getY() - attributes.getSpeed());
                break;
            case KeyEvent.VK_A:
                attributes.setX(attributes.getX() - attributes.getSpeed());
                break;
            case KeyEvent.VK_D:
                attributes.setX(attributes.getX() + attributes.getSpeed());
                break;
            default:
                
        }
    }
    
}
