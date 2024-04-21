package com.telloing.frame.Frames;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import com.telloing.frame.Scenary;

import javax.imageio.ImageIO;

public class BackGroundDirector {
    private BufferedImage setFrames;
    private static BackGroundDirector backGroundDirector;
    public static BackGroundDirector getInstance(){
        
        if(backGroundDirector == null){
            backGroundDirector = new BackGroundDirector();
        } 
        return backGroundDirector;
    }
    private void buildFrames(String nameFile){
        
        
        try {
            setFrames = ImageIO.read(getClass().getResourceAsStream(nameFile));

        } catch (IOException ex) {
            Logger.getLogger(Scenary.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

    }
    public BufferedImage createBackGround(){
        this.buildFrames("Back sprite.png");
        return setFrames;
    }
    public BufferedImage createBackGroundFront(){
        this.buildFrames("Back sprite.png");
        return setFrames;
    }
}
