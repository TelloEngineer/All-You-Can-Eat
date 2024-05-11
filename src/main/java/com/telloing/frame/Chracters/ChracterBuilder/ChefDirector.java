package com.telloing.frame.Chracters.ChracterBuilder;

import com.telloing.frame.Chracters.Chef;
import com.telloing.frame.Chracters.Elements.ChracterAttri;
import com.telloing.frame.Frames.Animations;
import com.telloing.frame.Scenary;
import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

class ChefBuilder {
    private Chef chef;
    private Container container;
    private ChracterAttri attributos;
    private Map<String, Animations> listAnimations;
    private static ChefBuilder chefBuilder;
    
    private ChefBuilder(){
        
    }
    
    public static ChefBuilder getInstance(){
        if(chefBuilder == null){
            chefBuilder = new ChefBuilder();
        }
        return chefBuilder;
    }
    
    public void buildContainer(Container container){
        this.container = container;
    }

    public void buildAttri(final int x, final int y){
        this.attributos = new ChracterAttri(x, y, 1, this.listAnimations);
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

    public void buildAnimations(){
        Map<String, Animations> list = new HashMap<String, Animations>();
        list.put("sleep", buildFrames("Cocinero/CocineroDormir.png", new CoordenatesCuter(192,102,2,6)));
        list.put("putSushi", buildFrames("Cocinero/CocineroDejaSushi.png", new CoordenatesCuter(192,102,1,6)));
        list.put("cutting", buildFrames("Cocinero/CocineroCorte.png", new CoordenatesCuter(192,102,3,6)));
        
        listAnimations = list;
    }
    
    public Chef getChef() {
        // Define here the position of the ornament
        this.chef = new Chef(this.attributos, this.container);
        return this.chef;
    }
    
}

public class ChefDirector{
    private ChefBuilder chefBuilder;
    private static ChefDirector chefDirector;

    private ChefDirector(){
        this.chefBuilder = ChefBuilder.getInstance();
    }

    public static ChefDirector getInstance(){
        if(chefDirector == null){
            chefDirector = new ChefDirector();
        }
        return chefDirector;
    }

    public Chef createChef(Container container){
        chefBuilder.buildAnimations();
        chefBuilder.buildContainer(container);
        chefBuilder.buildAttri(150, 60);
        return chefBuilder.getChef();
    }
}
