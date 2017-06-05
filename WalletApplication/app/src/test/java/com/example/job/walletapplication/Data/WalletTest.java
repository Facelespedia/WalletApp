package com.example.job.walletapplication.Data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Job on 6/5/2017 AD.
 */

public class WalletTest {

    Wallet wallet;

    @Before
    public void setUp(){wallet = new Wallet();}

    @Test
    public void BeforeSetup() {
        //balance should equal = 0
        //all arrayList should size = 0
        assertEquals(0, wallet.getBalance());
        assertEquals(0,wallet.getDiary().size());
        assertEquals(0,wallet.getEvent().size());
        assertEquals(0,wallet.getExpenses().size());
        assertEquals(0,wallet.getIncome().size());
    }

    @Test
    public void testSetBalance() {
        //balance should equal setBalance
        wallet.setBalance(500);
        assertEquals(500,wallet.getBalance());
    }

    @Test
    public void testAddDiary() {
        //Array Diary should increase before add
        wallet.addDiary("+");
        assertEquals(1,wallet.getDiary().size());
        assertEquals("+",wallet.getDiary().get(0));
    }

    @Test
    public void testAddIncome() {
        //Array Income should increase before add
        wallet.addIncome(500);
        assertEquals(1,wallet.getIncome().size());
        int x = wallet.getIncome().get(0);
        assertEquals(500,x);
    }

    @Test
    public void testAddExpenses() {
        //Array Expenses should increase before add
        wallet.addExpenses(500);
        assertEquals(1,wallet.getExpenses().size());
        int x = wallet.getExpenses().get(0);
        assertEquals(500,x);
    }

    @Test
    public void testAddEvent() {
        //Array Event should increase before add
        wallet.addEvent("test");
        assertEquals(1,wallet.getEvent().size());
        String x = wallet.getEvent().get(0);
        assertEquals("test",x);
    }




}
