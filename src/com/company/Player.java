package com.company;

import java.util.ArrayList;

public class Player {
    String marker;
    boolean isTurn;

    public static void flipTurn(ArrayList<Player> players){
        for(Player plyr : players){
            if(!plyr.isTurn()){
                plyr.setTurn(true);
            }
        }
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    boolean won;

    public Player(String marker, boolean isTurn, boolean won) {
        this.marker = marker;
        this.isTurn = isTurn;
        this.won = won;
    }

    public Player(){

    }

    public static Player whosTurn(ArrayList<Player> players){
        for(Player plyr : players){
            if(plyr.isTurn()){
                return plyr;
            }
        }
        return null;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }
}
