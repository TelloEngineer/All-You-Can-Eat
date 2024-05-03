package com.telloing.frame.Chracters.Compostion;

public class LifeTime{
    private boolean visible;
    private boolean alive;
    private int timer;
    private long delay;
    
    public LifeTime() {
        reset();
    }
    public final void reset(){
        this.visible = true;
        this.timer = 0;
        this.delay = 0;
        this.alive = true;
    }
    public boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public boolean isVisible() {
        return visible;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public void killObj(){
        this.alive = false;
    }

    public void startTimer(long delay){
        this.setDelay(delay);
        this.setVisible(false);
        this.setTimer(0);
    }

    public boolean isReady(){
        if (!this.alive){
            return this.alive;
        }
        if(this.visible){
            timer = 0;
            return this.visible;
        }
        this.visible = timer++ >= delay;
        return this.visible;
    }
    public int getTimer() {
        return timer;
    }
    public void setTimer(int timer) {
        this.timer = timer;
    }
    public long getDelay() {
        return delay;
    }
    public void setDelay(long delay) {
        this.delay = delay;
    }
}
