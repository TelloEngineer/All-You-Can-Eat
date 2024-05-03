package com.telloing.frame.Frames.Threads;

import com.telloing.frame.Scenary;
import com.telloing.frame.Frames.BackGroundDirector;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FoodBelt implements Runnable {
    transient Thread gameTh;

    public void draw(){

    }
    public void update(){

    }

    @Override
    public void run() {
        while (gameTh != null) {

            update();

            draw();

            try {
                Thread.sleep(Scenary.drawInterval);
            } catch (InterruptedException ex) {
                Logger.getLogger(Scenary.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }
}
