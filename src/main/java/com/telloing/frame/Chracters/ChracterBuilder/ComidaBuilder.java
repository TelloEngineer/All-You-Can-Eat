/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.telloing.frame.Chracters.ChracterBuilder;

import com.telloing.frame.Chracters.ChracterAttri;
import com.telloing.frame.Chracters.Comida;
import com.telloing.frame.Escenary.Animations;
import com.telloing.frame.Escenary.Scenary;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author josue
 */
public class ComidaBuilder {
    Toolkit tool;
    Comida comida;
    Animations anim;
    BufferedImage setFrames;
    private static ComidaBuilder comiBuilder;
    
    private ComidaBuilder(){
       tool = Toolkit.getDefaultToolkit();
    }
    
    public static ComidaBuilder getInstacia(){
        if(comiBuilder == null){
            comiBuilder = new ComidaBuilder();
        } 
        return comiBuilder;
    }
    
    public void buildAtrri(){
        comida.setAtributos(new ChracterAttri(0, 0, 4));
    }
    
    public void crearInstancia(){
        comida = new Comida(null);
    }
    
    public Comida getComida(){
        return comida;
    }
    
    public void buildFrames(String nameFile){
        
        
        try {
            setFrames = ImageIO.read(getClass().getResourceAsStream(nameFile));

        } catch (IOException ex) {
            Logger.getLogger(Scenary.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        anim = new Animations(Animations.separateFrames(setFrames, 32, 32, 2, 2));
        comida.setAnimation(anim);
    }
}
