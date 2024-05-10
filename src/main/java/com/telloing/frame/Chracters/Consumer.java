/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters;

import com.telloing.frame.Chracters.Elements.ChracterAttri;
import com.telloing.frame.Scenary;
import com.telloing.frame.Chracters.ChracterBuilder.OrnamentDirector;
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

    private final long DELAY = 50;
    public static final int wakeUpKey = KeyEvent.VK_W;
    
    private ChracterAttri attributes; // que quede claro, no cambiar.
    private Container container;
    private Delayer delay;
    public static boolean isSleep;
    public Ornament sleepAnimation;

    public Consumer(ChracterAttri attributes, Container container) {
        this.container = container;
        this.attributes = attributes;
        this.attributes.setFrame(this.attributes.getListAnimations().get("take").getFrames().get(0));
        this.delay = new Delayer(DELAY);
        isSleep = false;
        int animationX = attributes.getX() + 80;
        int animationY = attributes.getY() - 50;
        sleepAnimation = OrnamentDirector.getInstance().createSleep("ParticulaDormir.png", container, animationX, animationY);
    }

    public void setAttributes(ChracterAttri atributos) {
        this.attributes = atributos;
    }

    public ChracterAttri getAttributes() {
        return attributes;
    }

    @Override
    public void draw(Graphics2D g) {
        if(isSleep){
            sleepAnimation.draw(g);
        }
        g.drawImage(this.attributes.getFrame(), this.getAttributes().getX(), this.getAttributes().getY(), container);
    }

    private boolean animationRunning(Animations animation, long delayTime) {
        delay.setLapse(delayTime);
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
        return animationRunning(this.attributes.getListAnimations().get("eat"), DELAY);
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

        return animationRunning(this.attributes.getListAnimations().get("take"), DELAY);
    }

    public void sleeping(){
        Animations animation = this.attributes.getListAnimations().get("sleep");
        if(animationRunning(animation, 300)){
            animation.setNextFrame(0);
        }
    }

    private boolean heIsSleep(){
        if(isSleep){
            return isSleep;
        }
        int isTimeToSleep = Scenary.random.nextInt(300);
        //int isTimeToSleep = 5;
        //System.out.println(isTimeToSleep);
        switch (isTimeToSleep) {
            case 154:
                isSleep = true;
                break;
            default:
                isSleep = false;
        }
        return isSleep;
    }

    private boolean isWaking(){
        boolean isHeSleep = heIsSleep();
        switch (Scenary.listener.getKeyCode()) {
            case Consumer.wakeUpKey:
                isSleep = false;
                isHeSleep = isSleep;
                break;
        }
        return !isHeSleep;
    }

    @Override
    public void update() {
        if(!isWaking()){
            this.sleeping();
            sleepAnimation.update();
            return;
        }
        switch (Scenary.listener.getKeyCode()) {
            case SushiLine.upHandKey:
                //System.out.println("up");
                Consumer.isUpHand = this.upHand();
                break;
            case SushiTable.eatKey:
                //System.out.println("eat");
                this.eating();
                Scenary.listener.setKeyCode(-1);
                break;
            default:
                //System.out.println("no action");
                this.noAction();
        }
        
    }
}
