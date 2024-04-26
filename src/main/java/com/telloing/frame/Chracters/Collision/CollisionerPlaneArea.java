package com.telloing.frame.Chracters.Collision;

import java.util.Arrays;

/**
 * Collisioner
 */
/**
 * InnerCollisioner
 */ 


public class CollisionerPlaneArea{
    // Generic collisionZone
    public static final int[] collisionFood = new int[462];


    private int[] collisionZone;
    private int actualPosition;
    public void setActualPosition(int actualPosition) {
        this.actualPosition = actualPosition;
    }

    private int representationObj;

    public int getRepresentationObj() {
        return representationObj;
    }

    public void setNewCollisionerArea(int point, int dimension, int symbol){
        for(int i = 0; i < dimension; i++){
            collisionZone[point + i] = symbol;
        }
    }

    /**
     * No se permite el 0, si se pone el 0, se cambiara
     * al 1
     * @param representationObj1
     */
    public void setRepresentationObj(int representationObj1) {
        if(representationObj1 == 0){
            this.representationObj = 1;
        }
        this.representationObj = representationObj1;
    }

    public CollisionerPlaneArea(int[] collisionZone, int representationObj){
        this.collisionZone = collisionZone;
        this.representationObj = representationObj;
    } 

    public int updateCollision(int addPosition){
        int newPosition = this.actualPosition + addPosition;
        if(collisionZone[newPosition] == 0){
            collisionZone[this.actualPosition] = 0;
            collisionZone[newPosition] = 1;
            this.actualPosition = newPosition;
        }
        return collisionZone[newPosition];
    }
    public int getActualPosition() {
        return actualPosition;
    }

    public int[] getCollisionZone() {
        return collisionZone;
    }

    public void setCollisionZone(int[] collisionZone) {
        this.collisionZone = collisionZone;
    }

    @Override
    public String toString() {
        return "CollisionerPlaneArea [collisionZone=" + Arrays.toString(collisionZone) + ", actualPosition="
                + actualPosition + ", representationObj=" + representationObj + "]";
    }

}