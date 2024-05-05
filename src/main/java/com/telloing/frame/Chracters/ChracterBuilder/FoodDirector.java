/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters.ChracterBuilder;

import java.awt.Container;

import com.telloing.frame.Chracters.Food;
import com.telloing.frame.Chracters.MovCharact;
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

    public void buildFrames(String nameFile) {

        BufferedImage setFrames;
        try {
            setFrames = ImageIO.read(getClass().getResourceAsStream(nameFile));

        } catch (IOException ex) {
            Logger.getLogger(Scenary.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        Animations anim;
        Map<String, Animations> list = new HashMap<>();

        anim = new Animations(
                Animations.separateFrames(setFrames, FoodDirector.SUSHI_SIZE, FoodDirector.SUSHI_SIZE, 2, 2));
        list.put("comer", anim);
        listAnimations = list;
    }
}

/**
 *
 * @author josue
 */
public class FoodDirector {
    public static final int SUSHI_SIZE = 32;
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
        builder.buildFrames("./Sushi/Sushi 1.png");
        builder.buildContainer(container);
        return builder.getFood();
    }

    public Food createSushi2(Container container) {
        builder.buildFrames("./Sushi/Sushi 2.png");
        builder.buildContainer(container);

        return builder.getFood();
    }

    public Food createSushi3(Container container) {
        builder.buildFrames("./Sushi/Sushi 3.png");
        builder.buildContainer(container);

        return builder.getFood();
    }

    public Food createSushi4(Container container) {
        builder.buildFrames("./Sushi/Sushi 4.png");
        builder.buildContainer(container);

        return builder.getFood();
    }

    public Food createSushi5(Container container) {
        builder.buildFrames("./Sushi/Sushi 5.png");
        builder.buildContainer(container);

        return builder.getFood();
    }

    public Food createSushi6(Container container) {
        builder.buildFrames("./Sushi/Sushi 6.png");
        builder.buildContainer(container);

        return builder.getFood();
    }

    public Food createSushi7(Container container) {
        builder.buildFrames("./Sushi/Sushi 7.png");
        builder.buildContainer(container);

        return builder.getFood();
    }

    public Food createSushi8(Container container) {
        builder.buildFrames("./Sushi/Sushi 8.png");
        builder.buildContainer(container);

        return builder.getFood();
    }
}
