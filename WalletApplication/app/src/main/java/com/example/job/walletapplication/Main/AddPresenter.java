package com.example.job.walletapplication.Main;

import android.content.Context;
import android.provider.Settings;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.job.walletapplication.Data.Data;
import com.example.job.walletapplication.Data.Expenses;
import com.example.job.walletapplication.Data.Income;
import com.example.job.walletapplication.Data.Wallet;
import com.example.job.walletapplication.R;

/**
 * Created by Job on 6/4/2017 AD.
 */

public class AddPresenter {

    private  Wallet w;
    private    View v;
    private String type;
    int eventID,moneyID;
    Data data;


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

    public View getView() {
        return v;
    }

    public void setID(int eventID,int moneyID) {
        this.eventID = eventID;
        this.moneyID = moneyID;
    }

    public void onClickSubmit(Button b) {
        b.setOnClickListener(new View.OnClickListener() {
            EditText Eevent = (EditText) v.findViewById(eventID);
            EditText Emoney = (EditText) v.findViewById(moneyID);
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            @Override
            public void onClick(View v) {
                builder.setMessage("Confirm ?");
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    int money = Integer.parseInt(Emoney.getText().toString());
                    String event = Eevent.getText().toString();
                    public void onClick(DialogInterface dialog, int id) {
                        if(type.equalsIgnoreCase("Income")) {
                            data = new Income(money,event);
                            data.calculateBalance(w);
                            w.addIncome(data.getMoney());
                            w.addEvent(data.getEvent());
                        }else if(type.equalsIgnoreCase("Expenses")) {
                            data = new Expenses(money,event);
                            data.calculateBalance(w);
                            w.addExpenses(data.getMoney());
                            w.addEvent(data.getEvent());
                        }
                        System.out.println(w.getBalance());
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });
    }




}
