/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import com.telloing.frame.Chracters.Collision.CollisionerPlaneArea;

/**
 *
 * @author josue
 */
public class Food{
    private ChracterAttri attributes; // que quede claro, no cambiar.
    private MovCharact listener;
    private Container container;
    private CollisionerPlaneArea collisionChecker;
    
    public Container getContainer() {
        return container;
    }


    public void setContainer(Container container) {
        this.container = container;
    }

    public Food(ChracterAttri attri, MovCharact listener, Container container) {
        this.attributes = attri;
        this.listener = listener;
        this.container = container;
        this.attributes.setImage(this.attributes.getListAnimations().get("comer").getFrames().get(0));
        this.collisionChecker = new CollisionerPlaneArea(CollisionerPlaneArea.collisionFood, 1);
    }

    
    public CollisionerPlaneArea getCollisionChecker() {
        return collisionChecker;
    }

    public void setCollisionChecker(CollisionerPlaneArea collisionChecker) {
        this.collisionChecker = collisionChecker;
    }

    public void setAttributes(ChracterAttri atributos) {
        this.attributes = atributos;
    }

    public ChracterAttri getAttributes() {
        return attributes;
    }

}
