package com.telloing.frame.Chracters.Collision;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;



public class ActivationZone1D {
    public static final int[] collisionFood = new int[462];

    private int[] activationZone;

    private List<ActivationZoneObj> activatedObjs;

    public ActivationZone1D(int[] activationZone) {
        this.activationZone = activationZone;
        this.activatedObjs = new LinkedList<>();
    }

    public List<ActivationZoneObj> getActivatedObjs() {
        return activatedObjs;
    }

    public void setActivatedObjs(List<ActivationZoneObj> activatedObjs) {
        this.activatedObjs = activatedObjs;
    }

    public int[] getCollisionZone() {
        return activationZone;
    }

    public void setCollisionZone(int[] activationZone) {
        this.activationZone = activationZone;
    }

    public int checkCollision(int pos) {
        if (pos > activationZone.length - 1) {
            return -1; // esta mas alla del mapa
        }
        return activationZone[pos];
    }

    public int checkArea(int pos, int area){
        int activationCode;
        //System.out.println("pos: "+ pos + " " + (pos + area));
        for (int i = (pos + area); i > pos; i--) {
            activationCode = checkCollision(i);
            if(activationCode !=0){
                return activationCode;
            } 
        }
        return 0;
    }

    public static boolean fillArea(int point, int symbol, int[] array, int zone) {
        for (int i = 0; i < zone; i++) {
            array[point + i] = symbol;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CollisionOneD [collisionZone=" + Arrays.toString(activationZone) + ", mapObj=" + activatedObjs + "]";
    }
}
