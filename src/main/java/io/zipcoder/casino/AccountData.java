package io.zipcoder.casino;

import java.util.HashMap;
import java.util.List;

public class AccountData {

    private Wallet userWallet;
    private Integer id;


    public AccountData(){
       Integer highestID = Persistence.highestID();
        this.id = highestID+1;
        userWallet = new Wallet(200);

    }


    public Integer loadId(Integer id) {
        this.id = id;
        return id;
    }

    public void setChips(Integer chips) {
        this.userWallet.chipsBalance = chips;
    }

    public Wallet getWallet() {
        return userWallet;
    }


    public Integer getId() {
        return id;
    }


}

