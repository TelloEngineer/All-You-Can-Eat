/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author josue
 */
public class Food implements ActCharac{
    private BufferedImage image;
    private ChracterAttri attributes; //que quede claro, no cambiar.
    private MovCharact listener;
    private Container container;
    
    
    public Food(ChracterAttri attri, MovCharact listener, Container container) {
        this.attributes = attri;
        this.listener = listener;
        this.container = container;
        this.image = this.attributes.getListAnimations().get("comer").getFrames().get(0);
    }

    public void setAttributes(ChracterAttri atributos) {
        this.attributes = atributos;
    }

    
    
    public ChracterAttri getAttributes() {
        return attributes;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(image, this.attributes.getX(), this.attributes.getY(),this.container);
    }

    @Override
    public void update() {
        switch(this.listener.getKeyCode()){
            case KeyEvent.VK_E:
                image = this.attributes.getListAnimations().get("comer").getNextFrame();
                break;
            default:
        }
        this.listener.setKeyCode(-1);
    }
    
}
