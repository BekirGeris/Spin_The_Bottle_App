package com.begers.dongel;

public class Players {
    private String playerName;
    private int numberOfTrue;

    public Players(String playerName, int numberOfTrue){
        super();
        this.playerName = playerName;
        this.numberOfTrue = numberOfTrue;
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public int getNumberOfTrue(){
        return  this.numberOfTrue;
    }

    public void setNumberOfTrue(){
        this.numberOfTrue = numberOfTrue;
    }
}
