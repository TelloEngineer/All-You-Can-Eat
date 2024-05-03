package com.telloing.frame.Chracters.ChracterBuilder;

import java.awt.Container;
import java.util.Random;

import com.telloing.frame.Scenary;
import com.telloing.frame.Chracters.Food;
import com.telloing.frame.Chracters.MovCharact;

public class SushisLineDirector {
    private final Random random = new Random();
    private final int range = 6;
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
        Scenary.sushis.add(getNewSushi(container, mov));
    }

    public Food getNewSushi(Container container, MovCharact mov) {
        int num = random.nextInt(range);
        Food charac = FoodDirector.getInstancia().createSushi1(container, mov);
        switch (num) {
            case 0:
                charac = FoodDirector.getInstancia().createSushi1(container, mov);
            break;
            case 1:
                charac = FoodDirector.getInstancia().createSushi2(container, mov);
            break;
            case 2:
                charac = FoodDirector.getInstancia().createSushi3(container, mov);
            break;
            case 3:
                charac = FoodDirector.getInstancia().createSushi4(container, mov);
            break;
            case 4:
                charac = FoodDirector.getInstancia().createSushi5(container, mov);
            break;
            case 5:
                charac = FoodDirector.getInstancia().createSushi6(container, mov);
            break;
            case 6:
                charac = FoodDirector.getInstancia().createSushi7(container, mov);
            break;
            case 7:
                charac = FoodDirector.getInstancia().createSushi8(container, mov);
            break;
        }
        return charac;
    }
}
