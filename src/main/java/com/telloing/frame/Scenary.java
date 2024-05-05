/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame;

import com.telloing.frame.Chracters.ChracterBuilder.FoodBeltDirector;
import com.telloing.frame.Chracters.ChracterBuilder.OrnamentDirector;
import com.telloing.frame.Chracters.ChracterBuilder.SushisLineDirector;
import com.telloing.frame.Chracters.Compostion.EscenaryElements;
import com.telloing.frame.Chracters.Compostion.SushiLine;
import com.telloing.frame.Chracters.Compostion.SushiTable;
import com.telloing.frame.Frames.BackGroundDirector;
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

    transient Thread gameTh, beltTh;
    private static final int fps = 24;
    public static final long drawInterval = 1000 / fps;
    
    public static final EscenaryElements elements = new EscenaryElements();;
    public static final SushiLine sushis = new SushiLine();
    public static final SushiTable sushisToEat = new SushiTable();
    public static MovCharact listener;


    public Scenary() {
        

        listener = new MovCharact();
        for(int i = 0; i<33; i++){
            Scenary.sushis.add(SushisLineDirector.getInstance().getNewSushi(this));
        }
        
        Scenary.elements.add(OrnamentDirector.getInstance().createChef(this, 150, 60));
        Scenary.elements.add(Scenary.sushis);
        Scenary.elements.add(FoodBeltDirector.getInstance().createBelt(this));
        Scenary.elements.add(OrnamentDirector.getInstance().createCliente(this, 412, 210));
        Scenary.elements.add(OrnamentDirector.getInstance().createRibbon(this, 60, 80));
        Scenary.elements.add(OrnamentDirector.getInstance().createPaper(this, 90, 80));
        Scenary.elements.add(OrnamentDirector.getInstance().createPunpun(this, 115,80));
        Scenary.elements.add(Scenary.sushisToEat);

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
        Scenary.elements.draw(g2);
        
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
        Scenary.elements.update(); 
    }

}
