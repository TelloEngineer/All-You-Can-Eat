package com.telloing.frame.Chracters.Collision;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.lang.module.ModuleDescriptor.Builder;

import com.telloing.frame.Chracters.ChracterAttri;

/**
 * Collisioner
 */
/**
 * InnerCollisioner
 */
class CollisionerCreator {
    static public Rectangle create(ChracterAttri attri, float scale){
        int scalinX = Math.round(scale * attri.getImage().getWidth());
        int scalinY = Math.round((scale * attri.getImage().getHeight()));

        int lessX = (attri.getImage().getWidth()/2) - (scalinX/2);
        int lessY = (attri.getImage().getHeight()/2) - (scalinY/2);

        int coordinateX = lessX + attri.getX();
        int coordinateY = lessY + attri.getY();


        Rectangle collision = new Rectangle(
            coordinateX, 
            coordinateY, 
            scalinX, 
            scalinY);
        System.out.println(collision);
        System.out.println(lessX);
        System.out.println(attri.getX());
        return collision;
    }
    
}
public class Collisioner {

    public Rectangle getRectangle(ChracterAttri attri, float scale){
        return CollisionerCreator.create(attri, scale);
    }
}