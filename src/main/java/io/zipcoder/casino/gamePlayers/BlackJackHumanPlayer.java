package io.zipcoder.casino.gamePlayers;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardPlayer;
import io.zipcoder.casino.Deck;
import io.zipcoder.casino.Wallet;

import java.util.ArrayList;

public class BlackJackHumanPlayer extends CardPlayer

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

}
