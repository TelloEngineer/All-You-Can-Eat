/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters.Tile;

import com.telloing.frame.Chracters.ChracterAttri;
import com.telloing.frame.Chracters.Food;
import java.awt.Container;
import java.awt.Graphics2D;

import com.telloing.frame.Chracters.Tile.Tile;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author aleck
 */
public class TileManager {
    private List<Tile> tiles;
    
    public TileManager(Container container) {
        tiles = new LinkedList<Tile>();
    }
    
    public void putTile(int x, int y) {
        tiles.add(new Tile(x, y));
    }
    
    
    // Check collisions with the food
    public void checkCollisionTile(Food food) {
        ChracterAttri attributes = food.getAttributes();
        int entityLeftWorldX = attributes.getX() + attributes.getSolidArea().x;
        int entityRightWorldX = attributes.getX() + attributes.getSolidArea().x + attributes.getSolidArea().width;
        int entityTopWorldY = attributes.getY() + attributes.getSolidArea().y;
        int entityBottonWorldY = attributes.getY() + attributes.getSolidArea().y + attributes.getSolidArea().height;
        
        
        // Checks if it is collisioning with something
        for (int i = 0; i < tiles.size(); i++) {
            
            if (tiles.get(i).getX() == entityRightWorldX) {
                
                attributes.setCollision(true);
                break;
            }
        }
        
    }
    
}
