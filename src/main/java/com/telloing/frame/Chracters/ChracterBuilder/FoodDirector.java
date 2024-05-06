/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters.ChracterBuilder;

import java.awt.Container;

import com.telloing.frame.Chracters.Food;
import com.telloing.frame.Chracters.ChracterAttri;
import com.telloing.frame.Frames.Animations;
import com.telloing.frame.Scenary;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author josue
 */
class FoodBuilder {
    private Container container;
    private static FoodBuilder foodBuilder;
    private Map<String, Animations> listAnimations;

    private FoodBuilder() {
    }

    public static FoodBuilder getInstance() {

        if (foodBuilder == null) {
            foodBuilder = new FoodBuilder();
        }
        return foodBuilder;
    }

    public void buildContainer(Container container) {
        this.container = container;
    }

    // diferencia entre bara y comida 32
    public Food getFood() {
        return new Food(new ChracterAttri(FoodDirector.SUSHI_POS_X, 203, 3, listAnimations), container);
    }

    

    private Animations buildFrames(String nameFile, CoordenatesCuter coord) {
        BufferedImage setFrames;
        
        try {
            setFrames = ImageIO.read(getClass().getResourceAsStream(nameFile));
        } catch (IOException ex) {
            Logger.getLogger(Scenary.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return new Animations(Animations.separateFrames(setFrames, coord.getHeight(), coord.getWidth(), coord.getRow(), coord.getCol()));
    
    }

    public void buildAnimations(String name, String nameGigant){
        Map<String, Animations> list = new HashMap<String, Animations>();
        list.put("show", buildFrames(name, new CoordenatesCuter(FoodDirector.SUSHI_SIZE, FoodDirector.SUSHI_SIZE, 2, 2)));
        list.put("comer", buildFrames(nameGigant, new CoordenatesCuter(FoodDirector.SUSHI_GIGANT_SIZE, FoodDirector.SUSHI_GIGANT_SIZE, 2, 2)));
        listAnimations = list;
    }
}

/**
 *
 * @author josue
 */
public class FoodDirector {
    public static final int SUSHI_SIZE = 32;
    public static final int SUSHI_GIGANT_SIZE = 192;
    public static final int SUSHI_POS_X = 72;
    private final FoodBuilder builder;
    private static FoodDirector foodDirector;

    private FoodDirector() {
        this.builder = FoodBuilder.getInstance();
    }

    public static FoodDirector getInstancia() {
        if (foodDirector == null) {
            foodDirector = new FoodDirector();
        }
        return foodDirector;
    }

    public Food createSushi1(Container container) {
        builder.buildAnimations("./Sushi/Sushi 1.png", "./Sushi/Gigant/Sushi 1 grande.png");
        builder.buildContainer(container);
        return builder.getFood();
    }

    public Food createSushi2(Container container) {
        builder.buildAnimations("./Sushi/Sushi 2.png", "./Sushi/Gigant/Sushi 2 grande.png");
        builder.buildContainer(container);

        return builder.getFood();
    }

    public Food createSushi3(Container container) {
        builder.buildAnimations("./Sushi/Sushi 3.png", "./Sushi/Gigant/Sushi 3 grande.png");
        builder.buildContainer(container);

        return builder.getFood();
    }

    public Food createSushi4(Container container) {
        builder.buildAnimations("./Sushi/Sushi 4.png", "./Sushi/Gigant/Sushi 4 grande.png");
        builder.buildContainer(container);

        return builder.getFood();
    }

    public Food createSushi5(Container container) {
        builder.buildAnimations("./Sushi/Sushi 5.png", "./Sushi/Gigant/Sushi 5 grande.png");
        builder.buildContainer(container);

        return builder.getFood();
    }

    public Food createSushi6(Container container) {
        builder.buildAnimations("./Sushi/Sushi 6.png", "./Sushi/Gigant/Sushi 6 grande.png");
        builder.buildContainer(container);

        return builder.getFood();
    }

    public Food createSushi7(Container container) {
        builder.buildAnimations("./Sushi/Sushi 7.png", "./Sushi/Gigant/Sushi 7 grande.png");
        builder.buildContainer(container);

        return builder.getFood();
    }

    public Food createSushi8(Container container) {
        builder.buildAnimations("./Sushi/Sushi 8.png", "./Sushi/Gigant/Sushi 8 grande.png");
        builder.buildContainer(container);

        return builder.getFood();
    }
}
