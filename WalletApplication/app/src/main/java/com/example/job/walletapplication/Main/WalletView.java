package com.example.job.walletapplication.Main;

import android.widget.ArrayAdapter;

/**
 * Created by Job on 6/3/2017 AD.
 */

public interface WalletView {
    void setBalanceResult(int balance);
    void setListViewResult(ArrayAdapter<String> arrayAdapter);
}
