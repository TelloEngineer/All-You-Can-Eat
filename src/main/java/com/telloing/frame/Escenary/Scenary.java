/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Escenary;

import com.telloing.frame.Chracters.ChracterBuilder.ComidaDirector;
import com.telloing.frame.Chracters.Comida;
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
    Comida sushi1;

    public Scenary() {
        fps = 24;
        drawInterval = 1000 / fps;

        sushi1 = ComidaDirector.getInstancia().crearSushi1();
        
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

    }

}
