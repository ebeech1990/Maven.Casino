package io.zipcoder.casino;

import java.util.HashMap;
import java.util.List;

public class AccountData {

    private Wallet userWallet;
    private static Integer nextId = 5;
    private Integer id;

    //private Integer lastId = 0;

    public AccountData(){

        userWallet = new Wallet(200);

    }

    public void setId() {
        this.id = 4;
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

