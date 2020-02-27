package io.zipcoder.casino;

public class AccountData {

    private Wallet userWallet;
    private Integer id;
    //private Integer lastId = 0;

    public AccountData(){
        //userWallet = new Wallet(200);
        this.id = 1;



    }



    public Wallet getWallet() {
        return userWallet;
    }


    public Integer getId() {
        return id;
    }
}