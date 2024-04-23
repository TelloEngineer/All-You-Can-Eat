/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import com.telloing.frame.Chracters.Tile.TileManager;

/**
 *
 * @author josue
 */
public class Food implements ActCharac {
    private ChracterAttri attributes; // que quede claro, no cambiar.
    private MovCharact listener;
    private Container container;
    
    private TileManager tileManager;

    public Food(ChracterAttri attri, MovCharact listener, Container container, TileManager tileManager) {
        this.attributes = attri;
        this.listener = listener;
        this.container = container;
        this.tileManager = tileManager;
        this.attributes.setImage( this.attributes.getListAnimations().get("comer").getFrames().get(0) );
       
    }

    public void setAttributes(ChracterAttri atributos) {
        this.attributes = atributos;
    }

    public ChracterAttri getAttributes() {
        return attributes;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(this.attributes.getImage(), this.attributes.getX(), this.attributes.getY(), this.container);
    }

    @Override
    public void update() {

        switch (this.listener.getKeyCode()) {
            case KeyEvent.VK_E:
                this.attributes.setImage(this.attributes.getListAnimations().get("comer").getNextFrame());
                break;
            default:
        }
        this.listener.setKeyCode(-1);
        this.attributes.setX(this.attributes.getX() + this.attributes.getSpeed());

        // Here check the collision
        this.attributes.setCollision(false);
        tileManager.checkCollisionTile(this);

        if (this.attributes.getCollision()) {
            this.attributes.setX(72);
            this.attributes.setY(203);
 
        }
    }

}
