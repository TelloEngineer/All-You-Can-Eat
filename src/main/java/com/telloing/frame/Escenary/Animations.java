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
import java.util.LinkedList;
import java.util.List;
import java.util.TimerTask;

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

    private BufferedImage Rescale(BufferedImage original, int newWidth, int newHeight) {
        BufferedImage resized = new BufferedImage(newWidth, newHeight, original.getType());
        Graphics2D g = resized.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(original, 0, 0, newWidth, newHeight, 0, 0, original.getWidth(),
                original.getHeight(), null);
        g.dispose();
        return resized;
    }

    public void rescaleFrames (int porcentage){
        
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
