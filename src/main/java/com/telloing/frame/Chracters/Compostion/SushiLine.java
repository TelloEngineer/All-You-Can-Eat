/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters.Compostion;

import com.telloing.frame.Chracters.ActCharac;
import com.telloing.frame.Chracters.Food;

import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author josue
 */
public class SushiLine implements ActCharac{
    private List<Food> sushis;

    public SushiLine() {
        this.sushis = new LinkedList<>();
        
    }

    public boolean add(ActCharac character){
        if(this.sushis.size() >= 32){
            return false;
        }
        
        return this.sushis.add((Food)character);
    }
    public boolean remove(ActCharac character){
        return this.sushis.remove(character);
    }
    
    public ActCharac getChild(ActCharac character){
        int index = this.sushis.indexOf(character);
        if(index == -1){
            return null;
        }
        return this.sushis.get(index);
    }
    
    @Override
    public void draw(Graphics2D g) {
      for(ActCharac element : sushis){
            element.draw(g);
            
      }
    }

    @Override
    public void update() {
        for(ActCharac element : sushis){
            element.update();
        }
    }
}
