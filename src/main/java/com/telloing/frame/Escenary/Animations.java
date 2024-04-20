/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Escenary;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.TimerTask;
import org.imgscalr.Scalr;

/**
 *
 * @author josue
 */
public class Animations {

    private List<BufferedImage> frames;
    private int numFrame;

    public Animations(List<BufferedImage> frames) {
        this.frames = frames;
        this.numFrame = 0;
    }

    private BufferedImage Rescale(BufferedImage original, int newHeight, int newWidth) {
        return Scalr.resize(original, newHeight,newWidth);
    }

    public void rescaleFrames(int porcentage) {
        ListIterator<BufferedImage> iterador = this.frames.listIterator();
        BufferedImage image;
        int index = 0;
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

    public BufferedImage getNextFrame() {
        if (numFrame >= frames.size()) {
            numFrame = 0;
        }
        return frames.get(numFrame++);
    }

}
