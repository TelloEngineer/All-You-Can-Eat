package com.telloing.frame.Chracters.ChracterBuilder;

import java.awt.Container;
import java.util.Random;

import com.telloing.frame.Chracters.Food;
import com.telloing.frame.Chracters.Elements.MovCharact;

public class SushisLineDirector {
    private final Random random = new Random();
    private final int range = 8;
    private final int lapse = 20;

    private static SushisLineDirector sushisLineDirector;
    private int timer = lapse;

    private SushisLineDirector(){
    }
    
    public static SushisLineDirector getInstance(){
        
        if(sushisLineDirector == null){
            sushisLineDirector = new SushisLineDirector();
        } 
        return sushisLineDirector;
    }

    public void testNewSushi(Container container, MovCharact mov){
        if (timer < lapse) {
            timer++;
            return;
        }
        timer = 0;
    }

    public Food getNewSushi(Container container) {
        int num = random.nextInt(range);
        Food charac = FoodDirector.getInstancia().createSushi1(container);
        switch (num) {
            case 0:
                charac = FoodDirector.getInstancia().createSushi1(container);
            break;
            case 1:
                charac = FoodDirector.getInstancia().createSushi2(container);
            break;
            case 2:
                charac = FoodDirector.getInstancia().createSushi3(container);
            break;
            case 3:
                charac = FoodDirector.getInstancia().createSushi4(container);
            break;
            case 4:
                charac = FoodDirector.getInstancia().createSushi5(container);
            break;
            case 5:
                charac = FoodDirector.getInstancia().createSushi6(container);
            break;
            case 6:
                charac = FoodDirector.getInstancia().createSushi7(container);
            break;
            case 7:
                charac = FoodDirector.getInstancia().createSushi8(container);
            break;
        }
        return charac;
    }
}
