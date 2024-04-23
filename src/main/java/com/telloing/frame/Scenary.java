/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame;

import com.telloing.frame.Chracters.ChracterBuilder.FoodBeltDirector;
import com.telloing.frame.Chracters.ChracterBuilder.FoodDirector;
import com.telloing.frame.Chracters.ChracterBuilder.OrnamentDirector;
import com.telloing.frame.Chracters.Collision.Collisioner;
import com.telloing.frame.Frames.BackGroundDirector;
import com.telloing.frame.Chracters.Food;
import com.telloing.frame.Chracters.FoodBelt;
import com.telloing.frame.Chracters.MovCharact;
import com.telloing.frame.Chracters.Ornament;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

import com.telloing.frame.Chracters.Tile.TileManager;
import com.telloing.frame.Chracters.Tile.Tile;

/**
 *
 * @author josue
 */
public class Scenary extends JPanel implements Runnable {

    transient Thread gameTh;
    private final int fps;
    private final long drawInterval;
    private Food sushi1, sushi2;
    private FoodBelt belt;
    private Ornament ornament1, ornament2, punpun;

    private TileManager tileManager;

    public Scenary() {
        fps = 24;
        drawInterval = 1000 / fps;

        MovCharact listener = new MovCharact();
        this.tileManager = new TileManager(this);
        this.tileManager.putTile(521, 203);
        
        sushi1 = FoodDirector.getInstancia().createSushi1(this, listener, this.tileManager);
        // sushi2 = FoodDirector.getInstancia().createSushi2(this, listener, this.tileManager);
        belt = FoodBeltDirector.getInstance().createBelt(this);
        ornament1 = OrnamentDirector.getInstance().createRibbon(this, 60, 80);
        ornament2 = OrnamentDirector.getInstance().createPaper(this, 90, 80);
        punpun = OrnamentDirector.getInstance().createPunpun(this, 115,80);
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

        g2.drawImage(BackGroundDirector.getInstance().createBackGround(), 0,0, this);
        g2.drawImage(BackGroundDirector.getInstance().createBackGroundFront(), 0,0, this);
        belt.draw(g2);
        sushi1.draw(g2);
        g2.draw(new Collisioner().getRectangle(sushi1.getAttributes(), (float)0.5));
        // sushi2.draw(g2);
        ornament1.draw(g2);
        ornament2.draw(g2);
        punpun.draw(g2);
        
        
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
        belt.update();
        sushi1.update();
        ornament1.update();
        ornament2.update();
        punpun.update();
    }

}
