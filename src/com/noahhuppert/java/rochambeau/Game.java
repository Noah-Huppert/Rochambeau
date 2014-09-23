package com.noahhuppert.java.rochambeau;

import java.net.InetAddress;

/**
 * Created by Noah Huppert on 9/22/2014.
 */
public class Game {
    private String title;
    private InetAddress inetAddress;

    public Game(String title, InetAddress inetAddress){
        this.title = title;
        this.inetAddress = inetAddress;
    }

    /* Getters */
    public String getTitle() {
        return title;
    }

    public InetAddress getInetAddress() {
        return inetAddress;
    }

    /* Setters */
    public void setTitle(String title) {
        this.title = title;
    }

    public void setInetAddress(InetAddress inetAddress) {
        this.inetAddress = inetAddress;
    }
}
