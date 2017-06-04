package com.example.job.walletapplication.Main;

import android.provider.Settings;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.job.walletapplication.Data.Wallet;
import com.example.job.walletapplication.R;

/**
 * Created by Job on 6/4/2017 AD.
 */

public class AddPresenter {

    private  Wallet w;
    private    View v;
    private String type = "Income";

    public AddPresenter(Wallet w , View v) {
        this.w = w;
        this.v = v;
    }


    public void onClickRadioButton(RadioGroup rdg) {

        rdg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton rb=(RadioButton) v.findViewById(checkedId);
                type = String.valueOf(rb.getText());
            }
        });



    }

    public View getView(){
        return v;
    }

    public void onClickSubmit(Button b) {
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(type);
            }
        });
    }

    public void test() {

    }


}
