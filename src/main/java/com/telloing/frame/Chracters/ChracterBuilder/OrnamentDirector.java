/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters.ChracterBuilder;


import com.telloing.frame.Chracters.ChracterBuilder.OrnamentBuilder;
import com.telloing.frame.Chracters.MovCharact;
import com.telloing.frame.Chracters.Ornament;
import java.awt.Container;


/**
 *
 * @author aleck
 */
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
