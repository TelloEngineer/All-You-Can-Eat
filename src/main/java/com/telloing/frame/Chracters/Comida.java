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
public class Comida implements ActCharac{
    private Animations animation;
    private ChracterAttri atributos; //que quede claro, no cambiar.
    private MovCharact listener;
    private Container container;
    
    
    public Comida(Animations animation, MovCharact listener, Container container) {
        atributos = new ChracterAttri(0, 0, 0);
        this.animation = animation;
        this.listener = listener;
        this.container = container;
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
        g.drawImage(animation.getNextFrame(), this.atributos.getX(), this.atributos.getY(),this.container);
    }

    @Override
    public void update() {
        switch(this.listener.getKeyCode()){
            case KeyEvent.VK_S:
                atributos.setY(atributos.getY() + atributos.getSpeed());
                break;
            case KeyEvent.VK_W:
                atributos.setY(atributos.getY() - atributos.getSpeed());
                break;
            case KeyEvent.VK_A:
                atributos.setX(atributos.getX() - atributos.getSpeed());
                break;
            case KeyEvent.VK_D:
                atributos.setX(atributos.getX() + atributos.getSpeed());
                break;
            default:
                
        }
    }
    
}
