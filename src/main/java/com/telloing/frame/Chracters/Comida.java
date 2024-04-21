/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters;

import com.telloing.frame.Frames.Animations;
import java.awt.Graphics2D;

/**
 *
 * @author josue
 */
public class Comida implements ActCharac{
    private Animations animation;
    private ChracterAttri atributos; //que quede claro, no cambiar.
    
    
    
    public Comida(Animations animation) {
        atributos = new ChracterAttri(0, 0, 0);
        this.animation = animation;
    }

    

    public void setAtributos(ChracterAttri atributos) {
        this.atributos = atributos;
    }

    
    
    public ChracterAttri getAtributos() {
        return atributos;
    }


    public void setAnimation(Animations animation) {
        this.animation = animation;
    }
    
    
    public Animations getAnimation() {
        return animation;
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
