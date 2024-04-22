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

class CoordenatesCuter{
    private int height;
    private int width;
    private int row;
    private int col;

    

    public CoordenatesCuter(int height, int width, int row, int col) {
        this.height = height;
        this.width = width;
        this.row = row;
        this.col = col;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }

    
}

class OrnamentBuilder {
    private Ornament ornament;
    private Container container;
    private ChracterAttri attributos;
    private static OrnamentBuilder ornamentBuilder;
    private Hashtable<String, Animations> listAnimations;
    
    private OrnamentBuilder() {
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
    
    public void buildFrames(String nameFile, CoordenatesCuter coord) {
        BufferedImage setFrames;
        
        try {
            setFrames = ImageIO.read(getClass().getResourceAsStream(nameFile));
        } catch (IOException ex) {
            Logger.getLogger(Scenary.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        Animations anim;
        Hashtable<String, Animations> list = new Hashtable<String, Animations>();
        
        // Need to defien an image
        anim = new Animations(Animations.separateFrames(setFrames, coord.getHeight(), coord.getWidth(), coord.getRow(), coord.getCol()));
        
        list.put("Ondulamiento", anim);
        listAnimations = list;
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
    
    public Ornament createRibbon(Container container, final int x, final int y) {
        // Need to set the image
        builder.buildFrames("Listonn.png", new CoordenatesCuter(66,48,1,42));
        builder.buildContainer(container);
        builder.buildAttri(x, y);
        return builder.getOrnament();
    }
    
    public Ornament createPaper(Container container, final int x, final int y) {
        // Need to set the image
        builder.buildFrames("Paper.png", new CoordenatesCuter(66,48,1,42));
        builder.buildContainer(container);
        builder.buildAttri(x, y);
        return builder.getOrnament();
    }

    public Ornament createPunpun(Container container, final int x, final int y) {
        // Need to set the image
        builder.buildFrames("Punpun.png", new CoordenatesCuter(66,48,1,42));
        builder.buildContainer(container);
        builder.buildAttri(x, y);
        return builder.getOrnament();
    }
}
