/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters;

import com.telloing.frame.Chracters.Elements.ChracterAttri;
import com.telloing.frame.Scenary;
import com.telloing.frame.Chracters.Collision.ActivationZone1D;
import com.telloing.frame.Chracters.Compostion.SushiLine;
import com.telloing.frame.Chracters.Compostion.SushiTable;
import com.telloing.frame.Chracters.Elements.ActCharac;
import com.telloing.frame.Frames.Delayer;
import com.telloing.frame.Frames.Animations;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 *
 * @author aleck
 */

public class Consumer implements ActCharac {
    public static boolean isUpHand = false;

    private final long DELAY = 30;

    private ChracterAttri attributes; // que quede claro, no cambiar.
    private Container container;
    private Delayer delay;

    public Consumer(ChracterAttri attributes, Container container) {
        this.container = container;
        this.attributes = attributes;
        this.attributes.setFrame(this.attributes.getListAnimations().get("eat").getFrames().get(0));
        this.delay = new Delayer(DELAY);
    }

    public void setAttributes(ChracterAttri atributos) {
        this.attributes = atributos;
    }

    public ChracterAttri getAttributes() {
        return attributes;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(this.attributes.getFrame(), this.getAttributes().getX(), this.getAttributes().getY(), container);
    }

    private boolean animationRunning(Animations animation) {
        if (!delay.isTime()) {
            return false;
        }
        delay.startTimer();

        boolean isNext = animation.updateNextFrame();
        if (isNext) {
            attributes.setFrame(animation.getActualFrame());
            return false;
        }
        return true;
    }

    public boolean eating() {
        return animationRunning(this.attributes.getListAnimations().get("eat"));
    }

    public void noAction() {
        Animations animation = this.attributes.getListAnimations().get("eat");
        animation.setNextFrame(0);
        animation = this.attributes.getListAnimations().get("take");
        animation.setNextFrame(0);
        Consumer.isUpHand = false;
        this.attributes.setFrame(animation.getActualFrame());
    }

    public boolean upHand() {

        return animationRunning(this.attributes.getListAnimations().get("take"));
    }

    

    @Override
    public void update() {
        switch (Scenary.listener.getKeyCode()) {
            case SushiLine.upHandKey:
                Consumer.isUpHand = this.upHand();
                break;
            case SushiTable.eatKey:
                this.eating();
                break;
            default:
                this.noAction();
        }
        Scenary.listener.setKeyCode(-1);
    }
}
