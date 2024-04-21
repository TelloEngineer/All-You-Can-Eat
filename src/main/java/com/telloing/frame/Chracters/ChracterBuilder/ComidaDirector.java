/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telloing.frame.Chracters.ChracterBuilder;

import com.telloing.frame.Chracters.Comida;

/**
 *
 * @author josue
 */
public class ComidaDirector {
    private ComidaBuilder builder;
    private static ComidaDirector comiDirector;

    private ComidaDirector() {
        this.builder = ComidaBuilder.getInstacia();
    }
    
    public static ComidaDirector getInstancia(){
        if(comiDirector == null){
            comiDirector = new ComidaDirector();
        } 
        return comiDirector;
    }
    
     public Comida crearSushi1(){
         builder.crearInstancia();
         builder.buildAtrri();
         builder.buildFrames("sushi1.jpg");
         return builder.getComida();
     }
     
}
