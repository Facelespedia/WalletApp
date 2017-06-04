package com.example.job.walletapplication.Data;

/**
 * Created by Job on 6/4/2017 AD.
 */

public abstract class Data {

    private int money;
    private  String event;

    public Data(int money,String event) {
        this.money = money;
        this.event = event;
    }

    abstract void calculateBalance(Wallet w);

}
