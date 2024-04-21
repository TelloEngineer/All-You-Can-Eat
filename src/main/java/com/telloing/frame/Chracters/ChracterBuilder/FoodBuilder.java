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
public class FoodBuilder {
    Toolkit tool;
    Food food;
    Animations anim;
    BufferedImage setFrames;
    private static FoodBuilder foodBuilder;
    
    private FoodBuilder(){
       tool = Toolkit.getDefaultToolkit();
    }
    
    public static FoodBuilder getInstance(){
        
        if(foodBuilder == null){
            foodBuilder = new FoodBuilder();
        } 
        return foodBuilder;
    }
    
   
    public void buildAtrri(){
        food.setAttributes(new ChracterAttri(0,0,5));
    }
    
    public void createInstance(Container container, MovCharact motion){
        food = new Food(anim, motion, container);
    }
    
    public Food getFood(){
        return food;
    }
    
    public void buildFrames(String nameFile){
        
        
        try {
            setFrames = ImageIO.read(getClass().getResourceAsStream(nameFile));

        } catch (IOException ex) {
            Logger.getLogger(Scenary.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        anim = new Animations(Animations.separateFrames(setFrames, 32, 32, 2, 2));
        food.setAnimation(anim);
    }
}
