package com.example.job.walletapplication.Main;

import android.provider.Settings;
import android.view.View;
import android.widget.RadioButton;

import com.example.job.walletapplication.Data.Wallet;

/**
 * Created by Job on 6/4/2017 AD.
 */

public class AddPresenter {

    private  Wallet w;
    public   View v;

    public AddPresenter(Wallet w , View v) {
        this.w = w;
        this.v = v;
    }


    public void onClickRadioButton(RadioButton rbI,RadioButton rbE) {


    }

    public View getView(){
        return v;
    }


}
