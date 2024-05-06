package com.telloing.frame.Frames;

import com.telloing.frame.Chracters.ChracterAttri;
import com.telloing.frame.Chracters.Compostion.LifeTime;

public class AnimationIterator {
    static public final long lapse = 30; // milisegundos
    private long startTime;

    private int takeIndex;
    
    public int getTakeIndex() {
        return takeIndex;
    }

    public void setTakeIndex(int takeIndex) {
        this.takeIndex = takeIndex;
    }

    public boolean untilLast(ChracterAttri attri , Animations animations){
        long difference = System.currentTimeMillis() - this.startTime;
        if (difference < lapse) {
            return false;
        }
        this.startTime = System.currentTimeMillis();

        if (takeIndex >= animations.getFrames().size()) {
            takeIndex = animations.getFrames().size();
            return true;
        }
        System.out.println(takeIndex);
        attri.setImage(animations.getFrames().get(takeIndex++));
        return false;
    }
}
