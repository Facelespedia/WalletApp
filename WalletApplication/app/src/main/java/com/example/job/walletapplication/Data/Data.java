package com.example.job.walletapplication.Data;

/**
 * Created by Job on 6/4/2017 AD.
 */

public abstract class Data {

    int money;
    String event;

    public Data(int money,String event) {
        this.money = money;
        this.event = event;
    }

    public abstract void calculateBalance(Wallet w);

}
