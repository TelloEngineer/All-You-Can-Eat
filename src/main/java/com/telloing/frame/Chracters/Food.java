/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters;

import java.awt.Container;

/**
 *
 * @author josue
 */
public class Food {

    private ChracterAttri attributes; // que quede claro, no cambiar.
    private Container container;

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public Food(ChracterAttri attri, Container container) {
        this.attributes = attri;
        this.container = container;
        this.attributes.setFrame(this.attributes.getListAnimations().get("comer").getFrames().get(0));
    }

    public void setAttributes(ChracterAttri atributos) {
        this.attributes = atributos;
    }

    public ChracterAttri getAttributes() {
        return attributes;
    }

    @Override
    public String toString() {
        return "Food [attributes=" + attributes + "]";
    }

    

}
