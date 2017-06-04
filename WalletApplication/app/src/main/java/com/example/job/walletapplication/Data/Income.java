package com.example.job.walletapplication.Data;

/**
 * Created by Job on 6/3/2017 AD.
 */

public class Income extends Wallet{

    public Income() {
        super();
    }

    @Override
    void calculateBalance(int value) {
        super.balance += value;
    }


}
