package com.telloing.frame.Chracters.Collision;

import java.util.Arrays;

/**
 * Collisioner
 */
/**
 * InnerCollisioner
 */
class CollisionZone{

}

public class CollisionerPlaneArea {
    // Generic collisionZone
    public static final int[] collisionFood = new int[462];

    private int representationObj;
    private int[] collisionZone;
    private int actualPosition;

    public CollisionerPlaneArea(int[] collisionZone, int representationObj) {
        this.collisionZone = collisionZone;
        this.representationObj = representationObj;
    }

    public void setActualPosition(int actualPosition) {
        this.actualPosition = actualPosition;
    }

    public int getRepresentationObj() {
        return representationObj;
    }

    /**
     * No se permite el 0, si se pone el 0, se cambiara
     * al 1
     * 
     * @param representationObj1
     */
    public void setRepresentationObj(int representationObj1) {

        if (representationObj1 == 0) {
            this.representationObj = 1;
        }
        this.representationObj = representationObj1;
    }

    public boolean updatePos(int actualPos) {
        if (actualPos > collisionZone.length - 1) {
            return false; // esta mas alla del mapa
        }
        collisionZone[this.actualPosition] = 0;
        collisionZone[actualPos] = 1;
        this.actualPosition = actualPos;
        return true;
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

    public static void fillArea(int point, int symbol, int[] array, int zone) {
        for (int i = 0; i < zone; i++) {
            array[point + i] = symbol;
        }
    }

    public static void checkArea(int point, int symbol, int[] array, int zone) {
        for (int i = 0; i < zone; i++) {
            array[point + i] = symbol;
        }
    }

    @Override
    public String toString() {
        return "CollisionerPlaneArea [collisionZone=" + Arrays.toString(collisionZone) + ", actualPosition="
                + actualPosition + ", representationObj=" + representationObj + "]";
    }

}