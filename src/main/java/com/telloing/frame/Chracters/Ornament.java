/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author aleck
 */
public class Ornament implements ActCharac {
    private ChracterAttri attributes; //que quede claro, no cambiar.
    private Container container;

    
    public Ornament(ChracterAttri attri, Container container) {
        this.attributes = attri;
        this.container = container;
        this.attributes.setImage(this.attributes.getListAnimations().get("Ondulamiento").getFrames().get(0));
        // needs an image 
        
    }
    
    public void setAttributes(ChracterAttri atributos) {
        this.attributes = atributos;
    }

    public ChracterAttri getAttributes() {
        return attributes;
    }
    
    @Override
    public void draw(Graphics2D g) {
        // Moves to the next frame
        g.drawImage(this.attributes.getImage(), this.attributes.getX(), this.attributes.getY(),this.container);
    }
    
    @Override
    public void update() {
        // Updates the information
        this.attributes.setImage(this.attributes.getListAnimations().get("Ondulamiento").getNextFrame());
    }
}
