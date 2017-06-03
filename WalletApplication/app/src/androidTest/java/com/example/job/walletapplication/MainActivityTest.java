package com.example.job.walletapplication;

import android.support.design.widget.TabLayout;
import android.support.test.filters.SmallTest;
import android.support.v7.widget.Toolbar;
import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by Job on 6/3/2017 AD.
 */

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity>{


    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testTab() {
        TabLayout tb = (TabLayout) getActivity().findViewById(R.id.tabs);
        assertNotNull(tb);
    }

    @SmallTest
    public void testToolBar() {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        assertNotNull(toolbar);
    }

}
