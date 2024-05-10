/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame;

import com.telloing.frame.Chracters.ChracterBuilder.ChefDirector;
import com.telloing.frame.Chracters.ChracterBuilder.ConsumerDirector;
import com.telloing.frame.Chracters.ChracterBuilder.FoodBeltDirector;
import com.telloing.frame.Chracters.ChracterBuilder.OrnamentDirector;
import com.telloing.frame.Chracters.Compostion.EscenaryElements;
import com.telloing.frame.Chracters.Compostion.SushiLine;
import com.telloing.frame.Chracters.Compostion.SushiTable;
import com.telloing.frame.Frames.BackGroundDirector;
import com.telloing.frame.Chracters.Consumer;
import com.telloing.frame.Chracters.Elements.MovCharact;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/* To have music into the game we need to import */
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


/**
 *
 * @author josue
 */
public class Scenary extends JPanel implements Runnable {

    transient Thread gameTh, beltTh;
    private static final int fps = 24;
    public static final long drawInterval = 1000 / fps;
    
    public static final EscenaryElements elements = new EscenaryElements();
    public static final SushiLine sushis = new SushiLine();
    public static final SushiTable sushisToEat = new SushiTable();
    public static final Random random = new Random();
    public static final MovCharact listener = new MovCharact();
    private AudioInputStream audioInputStream;
    private Clip clip;

    public static Consumer consumer;


    public Scenary() {
        
        consumer = ConsumerDirector.getInstance().createConsumer(this);
        
        Scenary.elements.add(ChefDirector.getInstance().createChef(this));
        Scenary.elements.add(Scenary.sushis);
        Scenary.elements.add(FoodBeltDirector.getInstance().createBelt(this));
        Scenary.elements.add(OrnamentDirector.getInstance().createRibbon(this, 60, 80));
        Scenary.elements.add(OrnamentDirector.getInstance().createPaper(this, 90, 80));
        Scenary.elements.add(OrnamentDirector.getInstance().createPunpun(this, 115,80));
        Scenary.elements.add(Scenary.sushisToEat);
        Scenary.elements.add(consumer);

        this.addKeyListener(listener);
        this.setFocusable(true);
        
        
        
    }

    public void startGame() {
        /* Add the music */
        
        // Ruta del archivo MP3
        String path = "/home/aleck/Documents/projects/all-you-can-eat/src/main/resources/com/telloing/frame/sunshine.wav";
        try {
            // Crear un objeto File con la ruta del archivo MP3
            File file = new File(path);

            // Crear un AudioInputStream a partir del archivo
            audioInputStream = AudioSystem.getAudioInputStream(file);

            // Obtener un Clip de audio
            clip = AudioSystem.getClip();

            // Abrir el Clip con el AudioInputStream
            clip.open(audioInputStream);
            
            // Obtener el Control de Volumen del Clip
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            // Aumentar el volumen en 6 decibeles (por ejemplo)
            gainControl.setValue(2.0f);

            // Reproducir el audio
            clip.start();
            
             // Mostrar un mensaje cuando el audio comienza a reproducirse
            System.out.println("Reproduciendo audio...");

            // Esperar hasta que el audio termine de reproducirse
            // while (!clip.isRunning()) Thread.sleep(10);
            // while (clip.isRunning()) Thread.sleep(10);

            // Cerrar el Clip y el AudioInputStream
            // clip.close();
            // audioInputStream.close();

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException  e) {
            e.printStackTrace();
        }
        
        
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
            
            /* restart the music */ 
            if (!clip.isRunning()) {
                clip.setFramePosition(0); // Establece la posición al inicio
                clip.start(); // Inicia la reproducción desde el principio
            }
            
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
