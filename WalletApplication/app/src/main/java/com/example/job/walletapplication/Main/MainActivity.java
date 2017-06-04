package com.example.job.walletapplication.Main;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.job.walletapplication.Data.Wallet;
import com.example.job.walletapplication.R;

public class MainActivity extends AppCompatActivity implements WalletView{


    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

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

    public void clickRadio(View view) {

    }


    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";
        View rootView;
        AddPresenter addPresenter = null;

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

                rootView = inflater.inflate(R.layout.note_main, container, false);

            }else if(getArguments().getInt(ARG_SECTION_NUMBER) == 2) {

                rootView = inflater.inflate(R.layout.account_main,container,false);

            }else if(getArguments().getInt(ARG_SECTION_NUMBER) == 3) {

                if(addPresenter == null) {
                    Wallet w = new Wallet();
                    addPresenter = new AddPresenter(w,inflater.inflate(R.layout.add_main,container,false));
                    rootView = addPresenter.getView();
                    RadioButton rbI = (RadioButton) rootView.findViewById(R.id.radioButton_income);
                    RadioButton rbE = (RadioButton) rootView.findViewById(R.id.radioButton_expenses);
                    addPresenter.onClickRadioButton(rbI,rbE);


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
                    return "Note";
                case 1:
                    return "Today";
                case 2:
                    return "ADD";
            }
            return null;
        }
    }
}
