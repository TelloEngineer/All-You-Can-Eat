/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame;

import com.telloing.frame.Chracters.ChracterBuilder.FoodDirector;
import com.telloing.frame.Chracters.Food;
import com.telloing.frame.Chracters.MovCharact;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author josue
 */
public class Scenary extends JPanel implements Runnable {

    transient Thread gameTh;
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
