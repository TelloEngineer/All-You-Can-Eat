package com.telloing.frame.Chracters.ChracterBuilder;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Hashtable;
import java.util.logging.Logger;
import java.util.logging.Level;

import javax.imageio.ImageIO;

import com.telloing.frame.Scenary;
import com.telloing.frame.Chracters.ChracterAttri;
import com.telloing.frame.Chracters.FoodBelt;
import com.telloing.frame.Frames.Animations;

public class FoodBeltDirector {
    FoodBelt belt;
    Container container; 
    private static FoodBeltDirector foodBuilder;
    Hashtable<String, Animations> listAnimations;
    

    private FoodBeltDirector(){
    }
    
    public static FoodBeltDirector getInstance(){
        
        if(foodBuilder == null){
            foodBuilder = new FoodBeltDirector();
        } 
        return foodBuilder;
    }
    
    

    private void buildContainer(Container container) {
        this.container = container;
    }

    // diferencia entre bara y comida 32
    private FoodBelt getFoodBelt(){
        this.belt = new FoodBelt(new ChracterAttri(72,235,5, listAnimations), container);
        return this.belt;
    }
    

    private void buildFrames(String nameFile){
        
        BufferedImage setFrames;
        try {
            setFrames = ImageIO.read(getClass().getResourceAsStream(nameFile));

        } catch (IOException ex) {
            Logger.getLogger(Scenary.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        
        Animations anim;
        Hashtable<String, Animations> list = new Hashtable<String, Animations>();

        anim = new Animations(Animations.separateFrames(setFrames, 21, 462, 12, 1));
        list.put("Avanzar", anim);
        listAnimations = list;
    }

    public FoodBelt createBelt(Container container){
        this.buildFrames("FoodBelt.png");
        this.buildContainer(container);
        return this.getFoodBelt();
    }
}
