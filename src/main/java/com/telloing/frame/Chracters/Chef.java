package com.telloing.frame.Chracters;

import com.telloing.frame.Chracters.Elements.MovCharact;
import com.telloing.frame.Chracters.Elements.ChracterAttri;
import com.telloing.frame.Scenary;
import com.telloing.frame.Chracters.ChracterBuilder.SushisLineDirector;
import com.telloing.frame.Chracters.Elements.ActCharac;
import com.telloing.frame.Frames.Animations;
import com.telloing.frame.Frames.Delayer;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aleck
 */
public class Chef implements ActCharac {
    private final long DELAY = 50;
    public static final int wakeUpKey = KeyEvent.VK_R;

    private ChracterAttri attributes; //que quede claro, no cambiar.
    private Container container;
    private Delayer delay;
    public boolean isSleep;
    
    
    public Chef(ChracterAttri attributes, Container container) {
        this.attributes = attributes;
        this.container = container;
        this.attributes.setFrame(this.attributes.getListAnimations().get("cutting").getActualFrame());
        this.delay = new Delayer(DELAY);
        this.isSleep = false;
    }
    
    public void setAttributes(ChracterAttri atributos) {
        this.attributes = atributos;
    }
    
    public ChracterAttri getAttributes() {
        return attributes;
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

    public void cutting(){
        Animations animation = this.attributes.getListAnimations().get("cutting"); 
        if(animationRunning(animation, DELAY)){
            animation.setNextFrame(0);
        }
    }
    
    public void sleeping(){
        Animations animation = this.attributes.getListAnimations().get("sleep"); 
        if(animationRunning(animation, 300)){
            animation.setNextFrame(0);
        }
    }

    public boolean putSushi(){
        return animationRunning(this.attributes.getListAnimations().get("putSushi"), DELAY);
    }

    public void noAction(){
        Animations animation = this.attributes.getListAnimations().get("cutting");
        animation.setNextFrame(0);
        animation = this.attributes.getListAnimations().get("putSushi");
        animation.setNextFrame(0);
    }

    private boolean heIsSleep(){
        if(isSleep){
            return isSleep;
        }
        int isTimeToSleep = Scenary.random.nextInt(500);
        //int isTimeToSleep = 5;
        //System.out.println(isTimeToSleep);
        switch (isTimeToSleep) {
            case 258:
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
            case Chef.wakeUpKey:
                isSleep = false;
                isHeSleep = isSleep;
                break;
        }
        return !isHeSleep;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(this.attributes.getFrame(), this.getAttributes().getX(), this.getAttributes().getY(), container);
    }
    
    @Override
    public void update(){
        if(!isWaking()){
            this.sleeping();
            return;
        }
        if(!Scenary.sushis.isLimit() && putSushi()){
            Scenary.sushis.add(SushisLineDirector.getInstance().getNewSushi(null));
            noAction();
            return;
        }
        cutting();
        /*if(putSushi()){
            noAction();
        }*/
    }
}
