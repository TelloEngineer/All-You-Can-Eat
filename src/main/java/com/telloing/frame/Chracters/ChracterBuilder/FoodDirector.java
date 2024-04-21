/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters.ChracterBuilder;

import java.awt.Container;

import com.telloing.frame.Chracters.Food;
import com.telloing.frame.Chracters.MovCharact;

/**
 *
 * @author josue
 */
public class FoodDirector {
    private FoodBuilder builder;
    private static FoodDirector foodDirector;

    private FoodDirector() {
        this.builder = FoodBuilder.getInstance();
    }
    
    public static FoodDirector getInstancia(){
        if(foodDirector == null){
            foodDirector = new FoodDirector();
        } 
        return foodDirector;
    }
    
     public Food createSushi1(Container container, MovCharact listener){
         builder.buildFrames("sushi1.jpg");
         builder.buildContainer(container);
         builder.buildMotion(listener);
         return builder.getFood();
     }
     
}
