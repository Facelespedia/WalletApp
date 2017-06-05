package com.example.job.walletapplication;

import com.example.job.walletapplication.Data.Data;
import com.example.job.walletapplication.Data.Expenses;
import com.example.job.walletapplication.Data.Wallet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Job on 6/5/2017 AD.
 */

public class ExpensesTest {

    Wallet wallet;
    Expenses expenses;
    @Before
    public void setUp() {wallet = new Wallet();expenses = new Expenses(500,"test");}

    @Test
    public void testCreateExpenses() {
        Data data = (Data)expenses;
        assertEquals(data,expenses);
    }

    @Test
    public void addCalculateBalance() {
        //when add Expenses balance should decrease follow expenses
        expenses.calculateBalance(wallet);
        assertEquals(expenses.getMoney(),(-1)*wallet.getBalance());
    }

}
