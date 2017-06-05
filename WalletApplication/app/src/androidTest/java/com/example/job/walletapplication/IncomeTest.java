package com.example.job.walletapplication;

import com.example.job.walletapplication.Data.Data;
import com.example.job.walletapplication.Data.Income;
import com.example.job.walletapplication.Data.Wallet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Job on 6/5/2017 AD.
 */

public class IncomeTest {

    Wallet w;
    Income data;
    @Before
    public void setUp(){w = new Wallet();data = new Income(500,"test");}

    @Test
    public void testCreateIncome() {
        Data x = (Data)data;
        assertEquals(data,x);
    }

    @Test
    public void testAddBalance() {
        //When add income balance should equals income
        data.calculateBalance(w);
        assertEquals(data.getMoney(),w.getBalance());
    }





}
