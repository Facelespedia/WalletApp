package com.example.job.walletapplication.Data;

/**
 * Created by Job on 6/3/2017 AD.
 */

public class Expenses extends Data{


    public Expenses(int m,String e) {
        super(m,e);
    }

    @Override
    public void calculateBalance(Wallet w) {
        w.setBalance(w.getBalance()-super.getMoney());
    }
}
