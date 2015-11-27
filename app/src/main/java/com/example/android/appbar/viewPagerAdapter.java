package com.example.android.appbar;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;




public class viewPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;

    // Tab Titles
    private String tabtitles[] = new String[] { "Cafe", "General", "Full Menu" };
    Context context;

    public viewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            // Open fragmentTab1.java
            // Return fragment_tab_1.xml
            case 0:
                fragmentTab1 cafe_details_tab_1 = new fragmentTab1();
                return cafe_details_tab_1;

            // Open fragmentTab2.java
            // Return fragment_tab_2.xml
            case 1:
                fragmentTab2 cafe_details_tab_2 = new fragmentTab2();
                return cafe_details_tab_2;

            // Open fragmentTab3.java
            // Return fragment_tab_3.xml
            case 2:
                fragmentTab3 cafe_details_tab_3 = new fragmentTab3();
                return cafe_details_tab_3;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}