/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Frames;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.imgscalr.Scalr;

/**
 *
 * @author josue
 */
public class Animations {

    private List<BufferedImage> frames;
    private ListIterator<BufferedImage> iterator;
    private BufferedImage actualFrame;

    public Animations(List<BufferedImage> frames) {
        this.frames = frames;
        this.iterator = frames.listIterator();
    }
    
    private BufferedImage Rescale(BufferedImage original, int newHeight, int newWidth) {

        return Scalr.resize(original, newHeight, newWidth);
    }

    public void rescaleFrames(int porcentage, int start) {
        ListIterator<BufferedImage> iterador = this.frames.listIterator(start);
        BufferedImage image;
        while (iterador.hasNext()) {
            image = iterador.next();
            iterador.remove();
            iterador.add(this.Rescale(image, image.getHeight() * porcentage,
                    image.getWidth() * porcentage));
        }
    }

    public static List<BufferedImage> separateFrames(BufferedImage image,
            final int height, final int width,
            final int rows, final int cols) {
        List<BufferedImage> sprites = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                sprites.add((i * cols) + j, image.getSubimage(
                        j * width,
                        i * height,
                        width,
                        height));

            }
        }
        return sprites;
    }

    public List<BufferedImage> getFrames() {
        return frames;
    }

    public void setFrames(List<BufferedImage> frames) {
        this.frames.clear();
        this.frames.addAll(frames);
    }

    /**
     * this method update actualFrame attribute
     * and return if it was the last frame,
     * when its the last frame, we restart our frames counter
     * @return if its last frame
     */
    public boolean updateNextFrame() {
        if (!iterator.hasNext()) {
            return false;
            
        }
        this.actualFrame = iterator.next();
        return true;
    }

    public boolean setNextFrame(int numberFrame){
        if(numberFrame > frames.size() -1){
            return false;
        }
        iterator = frames.listIterator(numberFrame);
        this.actualFrame = frames.get(numberFrame);
        return true;
    }
    

    public BufferedImage getActualFrame() {
        return actualFrame;
    }
}
