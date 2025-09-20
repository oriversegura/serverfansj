package com.ejemplo.serverfansj;
public class Config {   
    private String user; 
    private String password;
    private String ip;
    private int speed; 

    public String getUser() {
        return this.user;
    }
    
    public String getPassword() {
        return this.password;
    }

    public String getIp() {
        return this.ip;
    }
    
    public int getSpeed() {
        return this.speed;
    }

    public void setUser(String user) {
        this.user = user;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}    

