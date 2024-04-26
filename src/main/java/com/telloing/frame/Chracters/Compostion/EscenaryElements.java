/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters.Compostion;

import com.telloing.frame.Chracters.ActCharac;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author josue
 */
public class EscenaryElements implements ActCharac{
    private List<ActCharac> characters;

    public EscenaryElements() {
        this.characters = new LinkedList<>();
    }

    public boolean add(ActCharac character){
        return this.characters.add(character);
    }
    public boolean remove(ActCharac character){
        return this.characters.remove(character);
    }
    
    public ActCharac getChild(ActCharac character){
        int index = this.characters.indexOf(character);
        if(index == -1){
            return null;
        }
        return this.characters.get(index);
    }
    
    @Override
    public void draw(Graphics2D g) {
        for(ActCharac element : characters){
            
            element.draw(g);
        }
        
    }

    @Override
    public void update() {
         for(ActCharac element : characters){
            element.update();
        }
    }
    
}
