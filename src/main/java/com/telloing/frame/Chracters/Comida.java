/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters;

import com.telloing.frame.Escenary.Animations;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author josue
 */
public class Comida implements ActCharac{
    private Animations animation;
    private ChracterAttri atributos;

    public ChracterAttri getAtributos() {
        return atributos;
    }

    public void setAtributos(ChracterAttri atributos) {
        this.atributos = atributos;
    }

    public void setAnimation(Animations animation) {
        this.animation = animation;
    }
    
    
    public Animations getAnimation() {
        return animation;
    }

    public Comida(Animations animation) {
        this.animation = animation;
    }
    
    @Override
    public void draw(Graphics2D g) {
        g.drawImage(animation.getNextFrame(), this.atributos.getX(), this.atributos.getY(), null);
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
