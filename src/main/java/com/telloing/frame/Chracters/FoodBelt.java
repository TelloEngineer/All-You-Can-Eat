/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters;

import com.telloing.frame.Chracters.Elements.ChracterAttri;
import com.telloing.frame.Chracters.Elements.ActCharac;
import com.telloing.frame.Frames.Animations;
import java.awt.Container;
import java.awt.Graphics2D;

/**
 *
 * @author aleck
 */
public class FoodBelt implements ActCharac {
    private ChracterAttri attributes; //que quede claro, no cambiar.
    private Container container;

    
    public FoodBelt(ChracterAttri attri, Container container) {
        this.attributes = attri;
        this.container = container;
        this.attributes.setFrame(this.attributes.getListAnimations().get("Avanzar").getFrames().get(0));
    }
    
    public void setAttributes(ChracterAttri atributos) {
        this.attributes = atributos;
    }

    
    
    public ChracterAttri getAttributes() {
        return attributes;
    }


    
    @Override
    public void draw(Graphics2D g) {
        g.drawImage(this.attributes.getFrame(), this.attributes.getX(), this.attributes.getY(),this.container);
    }
    
    @Override
    public void update() {
        Animations animation = this.attributes.getListAnimations().get("Avanzar");
        if(!animation.updateNextFrame()){
            animation.setNextFrame(0);
        }
        this.attributes.setFrame(animation.getActualFrame());
    }
}
