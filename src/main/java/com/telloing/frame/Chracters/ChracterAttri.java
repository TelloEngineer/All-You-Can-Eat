/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters;

import java.util.Hashtable;

import com.telloing.frame.Frames.Animations;
import java.awt.image.BufferedImage;

/**
 *
 * @author josue
 */
public class ChracterAttri {
    private int x;
    private int y;
    private int speed;
    
    private BufferedImage image;
    private Hashtable<String, Animations> listAnimations;
    private boolean visible;
    private int timer;
    private int delay;
    

    
   

    public ChracterAttri(int x, int y, int speed, Hashtable<String, Animations> listAnimations) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.listAnimations = listAnimations;

        this.visible = true;
    }

    public void setChracterAttri(ChracterAttri attri){
        this.speed = attri.getSpeed();
        this.x = attri.getX();
        this.y = attri.getY();
        this.listAnimations.clear();
        this.visible = attri.isVisible();
        this.listAnimations.putAll(attri.getListAnimations());
    }
    public Hashtable<String, Animations> getListAnimations() {
        return listAnimations;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int delay){
        this.delay = delay;
        this.visible = false;
        this.timer = 0;
    }

    public boolean isReady(){
        if(this.visible){
            timer = 0;
            return this.visible;
        }
        this.visible = timer++ >= delay;
        return this.visible;
    }

    public boolean isVisible() {
        
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    
    
    @Override
    public String toString() {
        return "ChracterAttri{" + "x=" + x + ", y=" + y + ", speed=" + speed + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.x;
        hash = 19 * hash + this.y;
        hash = 19 * hash + this.speed;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChracterAttri other = (ChracterAttri) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return this.speed == other.speed;
    }
}
