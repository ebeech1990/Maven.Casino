package io.zipcoder.casino;

import java.util.HashMap;
import java.util.List;

public class AccountData {

    private Wallet userWallet;
    private static Integer nextId = 3;
    private Integer id;

    //private Integer lastId = 0;

    public AccountData(){
        userWallet = new Wallet(200);

    }

    public void setId() {
        id = nextId;
        nextId++;
    }

    public Wallet getWallet() {
        return userWallet;
    }


    public Integer getId() {
        return id;
    }


}

