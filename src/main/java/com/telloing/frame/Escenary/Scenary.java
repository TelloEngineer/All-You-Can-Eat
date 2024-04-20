/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Escenary;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author josue
 */
public class Scenary extends JPanel implements Runnable {

    transient Thread gameTh;
    Color colorG;
    Animations anim;
    final int fps;
    final long drawInterval;

    public Scenary() {
        fps = 24;
        drawInterval = 1000/fps;
        
        
        
        Toolkit h = Toolkit.getDefaultToolkit();
        BufferedImage image;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("banda_transportadora.jpg"));
            
            anim = new Animations(Animations.separateFrames(image, 32, 64, 3, 4));
            anim.rescaleFrames(9);
        } catch (IOException ex) {
            Logger.getLogger(Scenary.class.getName()).log(Level.SEVERE, null, ex);
        }
        colorG = Color.red;
    }

    public void startGame() {
        gameTh = new Thread(this);
        gameTh.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        Graphics2D g2 = (Graphics2D) g;

        /*this.colorG = this.colorG == Color.red ? Color.white : Color.red;
        
        g2.setColor(this.colorG);
        
        g2.fill3DRect(5, 5, 15, 15, true);*/
        g2.drawImage(anim.getNextFrame(), 0, 0, this);

    }

    @Override
    public void run() {
        while (gameTh != null) {
            
            update();

            repaint();

            try {
                Thread.sleep(drawInterval);
            } catch (InterruptedException ex) {
                Logger.getLogger(Scenary.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

    public void update() {

    }

}
