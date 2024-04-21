/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame;

import com.telloing.frame.Chracters.ChracterAttri;
import com.telloing.frame.Chracters.ChracterBuilder.FoodDirector;
import com.telloing.frame.Chracters.Food;
import com.telloing.frame.Chracters.MovCharact;
import com.telloing.frame.Frames.Animations;
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
    private Color colorG;
    private Animations anim;
    private final int fps;
    private final long drawInterval;
    private Food sushi1;

    public Scenary() {
        fps = 24;
        drawInterval = 1000 / fps;

        MovCharact listener = new MovCharact();
        sushi1 = FoodDirector.getInstancia().createSushi1(this, listener);
        
        this.addKeyListener(listener);
        this.setFocusable(true);
    }

    public void startGame() {
        gameTh = new Thread(this);
        gameTh.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        Graphics2D g2 = (Graphics2D) g;

        sushi1.draw(g2);
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
        sushi1.update();
    }

}