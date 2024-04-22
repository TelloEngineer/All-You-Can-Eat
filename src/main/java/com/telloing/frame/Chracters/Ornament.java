/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters;

import com.telloing.frame.Frames.Animations;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author aleck
 */
public class Ornament implements ActCharac {
    private BufferedImage image;
    private ChracterAttri attributes; //que quede claro, no cambiar.
    private Container container;

    
    public Ornament(ChracterAttri attri, Container container) {
        this.attributes = attri;
        this.container = container;
        
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
    }
    
    @Override
    public void update() {
        // Updates the information
    }
}
