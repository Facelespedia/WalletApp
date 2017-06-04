package com.example.job.walletapplication.Main;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.job.walletapplication.Data.Wallet;
import com.example.job.walletapplication.R;

public class MainActivity extends AppCompatActivity implements WalletView{


    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;
    public static Wallet w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        w = new Wallet();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setPage(int page) {

    }


    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";
        View rootView;
        AddPresenter addPresenter = null;
        WalletPresenter walletPresenter = null;
        String[] myItem;

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            if(getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                System.out.println(w.getBalance());
                rootView = inflater.inflate(R.layout.account_main,container,false);
                TextView textBalance = (TextView) rootView.findViewById(R.id.account_balance);
                textBalance.setText(""+w.getBalance());
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
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(rootView.getContext(), R.layout.activity_listview, R.id.textView, myItem);
                ListView listView = (ListView) rootView.findViewById(R.id.listView_main);
                listView.setAdapter(arrayAdapter);

            }
            if(getArguments().getInt(ARG_SECTION_NUMBER) == 3) {
                if(addPresenter == null) {
                    addPresenter = new AddPresenter(w,inflater.inflate(R.layout.add_main,container,false));
                    rootView = addPresenter.getView();
                    RadioGroup rdg = (RadioGroup) rootView.findViewById(R.id.radioGroup);
                    addPresenter.onClickRadioButton(rdg);
                    addPresenter.setID(R.id.editText_event,R.id.editText_money);
                    Button submit = (Button) rootView.findViewById(R.id.button_submit);
                    addPresenter.onClickSubmit(submit);
                }

            }

            return rootView;
        }



    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Account";
                case 2:
                    return "ADD";
            }
            return null;
        }
    }
}
