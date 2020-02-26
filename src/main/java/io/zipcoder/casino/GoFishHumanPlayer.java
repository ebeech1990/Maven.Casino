package io.zipcoder.casino;

public class GoFishHumanPlayer extends CardPlayer {
    public Integer score = 0;

    public GoFishHumanPlayer(){

    }

    public Boolean fishing(Integer number){
        return false;
    }

    public Boolean takeSet(Integer number){
        //if player has set increase score by 1
        //remove sets from player hand?
        return false;
    }
}
