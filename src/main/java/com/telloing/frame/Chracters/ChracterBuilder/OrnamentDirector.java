/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters.ChracterBuilder;


import com.telloing.frame.Chracters.ChracterBuilder.OrnamentBuilder;
import com.telloing.frame.Frames.Animations;
import com.telloing.frame.Chracters.ChracterAttri;
import com.telloing.frame.Chracters.Ornament;
import java.awt.Container;

import com.telloing.frame.Scenary;
import java.awt.image.BufferedImage;
import java.util.Hashtable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author aleck
 */

class OrnamentBuilder {
    Ornament ornament;
    Container container;
    ChracterAttri attributos;
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
    
    public void buildAttri(final int x, final int y){
        this.attributos = new ChracterAttri(x, y, 1, this.listAnimations);
    }

    public Ornament getOrnament() {
        // Define here the position of the ornament
        this.ornament = new Ornament(this.attributos, this.container);
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
        anim = new Animations(Animations.separateFrames(setFrames, 66, 48, 1, 12));
        listAnimations.clear();
        listAnimations.put("Ondulamiento", anim);
    }
}

public class OrnamentDirector {
    private OrnamentBuilder builder;
    private static OrnamentDirector ornamentDirector;
    
    private OrnamentDirector() {
        this.builder = OrnamentBuilder.getInstance();
    }
    
    public static OrnamentDirector getInstance() {
        if (ornamentDirector == null)
            ornamentDirector = new OrnamentDirector();
        return ornamentDirector;
    }
    
    public Ornament createOrnament(Container container, final int x, final int y) {
        // Need to set the image
        builder.buildFrames("Listonn.png");
        builder.buildContainer(container);
        builder.buildAttri(x, y);
        return builder.getOrnament();
    }
    
}
