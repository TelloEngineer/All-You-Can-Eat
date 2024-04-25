/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import com.telloing.frame.Chracters.Collision.CollisionerPlaneArea;

/**
 *
 * @author josue
 */
public class Food implements ActCharac {
    private ChracterAttri attributes; // que quede claro, no cambiar.
    private MovCharact listener;
    private Container container;
    private CollisionerPlaneArea collisionChecker;

    public Food(ChracterAttri attri, MovCharact listener, Container container) {
        this.attributes = attri;
        this.listener = listener;
        this.container = container;
        this.attributes.setImage(this.attributes.getListAnimations().get("comer").getFrames().get(0));
        collisionChecker = new CollisionerPlaneArea(462, 1);
        addCollisions(0);
    }

    private void addCollisions(int event) {
        this.collisionChecker.setNewCollisionerArea(430, 5, 2);
        switch (event) {
            case KeyEvent.VK_E:
                this.collisionChecker.setNewCollisionerArea(420, 5, 3);
                break;
            default:
                this.collisionChecker.setNewCollisionerArea(420, 5, 0);
        }
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
                this.addCollisions(KeyEvent.VK_E);
                break;
            default:
        }
        this.listener.setKeyCode(-1);

        switch (this.collisionChecker.updateCollision(this.attributes.getSpeed())) {
            case 2:
                this.attributes.setX(72);
                this.collisionChecker.getCollisionZone()[this.collisionChecker.getActualPosition()] = 0;
                this.collisionChecker.setActualPosition(0);
                break;
            case 3:
                this.attributes.setX(109);
                this.attributes.setY(256);
                break;
            default:
                this.attributes.setX(this.attributes.getX() + this.attributes.getSpeed());
        }

        
    }

}
