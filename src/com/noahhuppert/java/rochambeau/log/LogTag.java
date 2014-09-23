package com.noahhuppert.java.rochambeau.log;

/**
 * Created by Noah Huppert on 9/22/2014.
 */
public class LogTag {
    private String name;
    private boolean enabled;

    public LogTag(String name){
        this.name = name;
        this.enabled = true;
    }

    /* Getters */
    public String getName(){
        return this.name;
    }

    public boolean getEnabled(){
        return this.enabled;
    }

    /* Setters */
    public void setName(String name){
        this.name = name;
    }

    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }

    public void enable(){
        setEnabled(true);
    }

    public void disable(){
        setEnabled(false);
    }
}
