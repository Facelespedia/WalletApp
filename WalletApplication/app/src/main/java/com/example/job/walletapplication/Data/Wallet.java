package com.example.job.walletapplication.Data;

import java.util.ArrayList;

/**
 * Created by Job on 6/3/2017 AD.
 */

public class Wallet {

    private int balance;
    private ArrayList <Integer>income;
    private ArrayList <Integer>expenses;
    private ArrayList <String>event;
    private ArrayList <String>diary;

    public Wallet() {
        balance = 0;
        income = new ArrayList<Integer>();
        expenses = new ArrayList<Integer>();
        event = new ArrayList<String>();
        diary = new ArrayList<String>();
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void addIncome(int in) {
        income.add(in);
    }
    public void addExpenses(int ex) {
        expenses.add(ex);
    }
    public void addEvent(String ev) { event.add(ev); }
    public void addDiary(String d){ diary.add(d); }
    public int getBalance() {
        return balance;
    }
    public ArrayList<String> getEvent(){ return event; }
    public ArrayList<String> getDiary() { return diary; }
    public ArrayList<Integer> getIncome() { return income; }
    public ArrayList<Integer> getExpenses() { return expenses; }

}
