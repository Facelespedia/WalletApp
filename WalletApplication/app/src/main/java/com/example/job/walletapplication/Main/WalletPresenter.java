package com.example.job.walletapplication.Main;

import android.view.View;
import android.widget.ArrayAdapter;

import com.example.job.walletapplication.Data.Wallet;
import com.example.job.walletapplication.R;

/**
 * Created by Job on 6/3/2017 AD.
 */

public class WalletPresenter {

    Wallet w;
    View v;
    WalletView wv;
    String[] myItem;
    ArrayAdapter<String> arrayAdapter;

    public WalletPresenter(Wallet w, View v, WalletView wv) {
        this.w = w;
        this.v = v;
        this.wv = wv;
    }

    public View getView() {
        return v;
    }

    public void setBalanceResult() {

        wv.setBalanceResult(w.getBalance());

    }

    public String[] getMyDiary() {
        int indexIncome=0,indexExpenses=0;
        myItem = new String[w.getDiary().size()];
        for(int i = 0;i < myItem.length;i++) {
            if(w.getDiary().get(i).equalsIgnoreCase("+")) {
                myItem[i] = "Income Event : " +w.getEvent().get(i)+"        Money : "+w.getIncome().get(indexIncome) +" Bath";
                indexIncome++;
            }else if(w.getDiary().get(i).equalsIgnoreCase("-")) {
                myItem[i] = "Expenses Event : " +w.getEvent().get(i)+"        Money : "+w.getExpenses().get(indexExpenses) +" Bath";
                indexExpenses++;
            }
        }

        return  myItem;

    }

    public ArrayAdapter<String> getArrayAdapter(int layout,int id) {
        arrayAdapter = new ArrayAdapter<String>(v.getContext(), layout, id, getMyDiary());
        return arrayAdapter;
    }

    public void setArrayAdapter(int layout , int id) {
        wv.setListViewResult(getArrayAdapter(layout,id));
    }


}
