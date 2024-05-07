package com.telloing.frame.Frames;



public class Delayer {
    private long lapse; // milisegundos
    private long startTime;

    public Delayer(long lapse) {
        this.lapse = lapse;
    }

    

    public boolean isTime(){
        long difference = System.currentTimeMillis() - this.startTime;
        return difference > lapse;
        
    }
    public void startTimer(){
        this.startTime = System.currentTimeMillis();
    }

    public long getLapse() {
        return lapse;
    }

    public void setLapse(long lapse) {
        this.lapse = lapse;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
    
}
