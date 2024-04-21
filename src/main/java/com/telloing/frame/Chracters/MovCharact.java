/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 *
 * @author josue
 */
public class MovCharact implements KeyListener{
    private  ChracterAttri atributos; 
    private BufferedImage actualMov;

    public MovCharact(ChracterAttri atributos) {
        this.atributos = atributos;
    }

    public void setAtributos(ChracterAttri atributos) {
        this.atributos = atributos;
    }

    public ChracterAttri getAtributos() {
        return atributos;
    }
   
    
    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
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
        }
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_S:
                atributos.setY(atributos.getY());
                break;
            case KeyEvent.VK_W:
                atributos.setY(atributos.getY());
                break;
            case KeyEvent.VK_A:
                atributos.setX(atributos.getX());
                break;
            case KeyEvent.VK_D:
                atributos.setX(atributos.getX());
                break;
        }
    }
    
}
