/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author josue
 */

public class MovCharact implements KeyListener{
    private int keyCode;

    
    public MovCharact() {
        
    }
    
    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.keyCode = e.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e) {
       this.keyCode = -1;
    }
    
}
