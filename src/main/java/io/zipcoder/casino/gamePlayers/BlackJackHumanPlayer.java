package io.zipcoder.casino.gamePlayers;

import io.zipcoder.casino.*;

import java.util.ArrayList;

public class BlackJackHumanPlayer extends CardPlayer implements GamblingAction

{
    private ArrayList<Card> secondHand;

    public BlackJackHumanPlayer(String name, Wallet gamblingWallet) {
        super(name, gamblingWallet);
    }

    public Boolean doubleDown(){
        // TODO: if true double wager
        if(true){
            // double Wager / bet initial wager again and receive 1 final card
            this.receiveCard();
            this.bet(1);
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean split(){
        Card card1 = this.getHand().get(0);
        Card card2 = this.getHand().get(1);
        if(card1.compareTo(card2) == 0){
            secondHand.add(this.getHand().remove(0));
            return true;
        }
        return false;
    }

    public void bet(Integer wager){
        //place bet and add to pot
        // pot += wager

    }

    public void cashOut(Integer balance){

    }

}
