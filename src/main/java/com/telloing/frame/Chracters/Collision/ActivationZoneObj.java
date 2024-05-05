package com.telloing.frame.Chracters.Collision;

import com.telloing.frame.Chracters.Food;

public class ActivationZoneObj {
    private int objSymbol;
    private Food obj;

    public ActivationZoneObj() {
        this(0, null);
    }

    public ActivationZoneObj(int objSymbol, Food obj) {
        this.objSymbol = objSymbol;
        this.obj = obj;
    }

    public Food getObj() {
        return obj;
    }

    public void setObj(Food obj) {
        this.obj = obj;
    }

    public int getObjSymbol() {
        return objSymbol;
    }

    public void setObjSymbol(int objSymbol) {
        this.objSymbol = objSymbol;
    }

    @Override
    public String toString() {
        return "CollisionObj [objSymbol=" + objSymbol + ", obj=" + obj + "]";
    }

}
