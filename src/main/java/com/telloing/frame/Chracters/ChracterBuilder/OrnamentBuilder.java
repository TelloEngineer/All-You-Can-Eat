package com.telloing.frame.Chracters.ChracterBuilder;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.telloing.frame.Chracters.ChracterAttri;
import com.telloing.frame.Chracters.MovCharact;
import com.telloing.frame.Chracters.Ornament;
import com.telloing.frame.Frames.Animations;
import com.telloing.frame.Scenary;
import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author aleck
 */
public class OrnamentBuilder {
    Ornament ornament;
    Container container;
    private static OrnamentBuilder ornamentBuilder;
    Hashtable<String, Animations> listAnimations;
    
    private OrnamentBuilder() {
        listAnimations = new Hashtable<String, Animations>();
    }
    
    public static OrnamentBuilder getInstance() {
        if (ornamentBuilder == null)
            ornamentBuilder = new OrnamentBuilder();
        return ornamentBuilder;
    }

    public void buildContainer(Container container) {
        this.container = container;
    }
    
    public Ornament getOrnament(final int x, final int y) {
        // Define here the position of the ornament
        this.ornament = new Ornament(new ChracterAttri(x, y, 0, this.listAnimations), this.container);
        return this.ornament;
    }
    
    public void buildFrames(String nameFile) {
        BufferedImage setFrames;
        
        try {
            setFrames = ImageIO.read(getClass().getResourceAsStream(nameFile));
        } catch (IOException ex) {
            Logger.getLogger(Scenary.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        Animations anim;
        
        // Need to defien an image
        anim = new Animations(Animations.separateFrames(setFrames, 32, 32, 2, 2));
        listAnimations.clear();
        listAnimations.put("comer", anim);
    }
}
