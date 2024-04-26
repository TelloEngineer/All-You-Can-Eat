/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame;

import com.telloing.frame.Chracters.ChracterBuilder.FoodBeltDirector;
import com.telloing.frame.Chracters.ChracterBuilder.FoodDirector;
import com.telloing.frame.Chracters.ChracterBuilder.OrnamentDirector;
import com.telloing.frame.Chracters.Compostion.EscenaryElements;
import com.telloing.frame.Chracters.Compostion.SushiLine;
import com.telloing.frame.Frames.BackGroundDirector;
import com.telloing.frame.Chracters.Food;
import com.telloing.frame.Chracters.FoodBelt;
import com.telloing.frame.Chracters.MovCharact;
import com.telloing.frame.Chracters.Ornament;

import java.awt.Color;
import java.awt.Dimension;
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
    
    private final EscenaryElements elements;
    private final SushiLine sushis;


    public Scenary() {
        
        fps = 24;
        drawInterval = 1000 / fps;

        MovCharact listener = new MovCharact();
        this.elements = new EscenaryElements();
        this.sushis = new SushiLine();
        this.sushis.add(FoodDirector.getInstancia().createSushi1(this, listener));
        this.elements.add(this.sushis);
        this.elements.add(FoodBeltDirector.getInstance().createBelt(this));
        this.elements.add(OrnamentDirector.getInstance().createRibbon(this, 60, 80));
        this.elements.add(OrnamentDirector.getInstance().createPaper(this, 90, 80));
        this.elements.add(OrnamentDirector.getInstance().createPunpun(this, 115,80));

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
        this.elements.draw(g2);
        
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
        this.elements.update();
        
    }

}
