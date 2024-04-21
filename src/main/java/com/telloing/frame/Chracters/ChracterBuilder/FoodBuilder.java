/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.telloing.frame.Chracters.ChracterBuilder;

import com.telloing.frame.Chracters.ChracterAttri;
import com.telloing.frame.Chracters.Food;
import com.telloing.frame.Chracters.MovCharact;
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
 * @author josue
 */
public class FoodBuilder {
    Food food;
    Container container; 
    MovCharact motion;
    private static FoodBuilder foodBuilder;
    Hashtable<String, Animations> listAnimations;
    

    private FoodBuilder(){
       listAnimations = new Hashtable<String, Animations>();
    }
    
    public static FoodBuilder getInstance(){
        
        if(foodBuilder == null){
            foodBuilder = new FoodBuilder();
        } 
        return foodBuilder;
    }
    
    
    public void buildMotion(MovCharact motion) {
        this.motion = motion;
    }

    public void buildContainer(Container container) {
        this.container = container;
    }

    // diferencia entre bara y comida 32
    public Food getFood(){
        this.food = new Food(new ChracterAttri(40,30,3, listAnimations), motion, container);
        return this.food;
    }
    

    public void buildFrames(String nameFile){
        
        BufferedImage setFrames;
        try {
            setFrames = ImageIO.read(getClass().getResourceAsStream(nameFile));

        } catch (IOException ex) {
            Logger.getLogger(Scenary.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        
        Animations anim;

        anim = new Animations(Animations.separateFrames(setFrames, 32, 32, 2, 2));
        listAnimations.clear();
        listAnimations.put("comer", anim);
    }
}
