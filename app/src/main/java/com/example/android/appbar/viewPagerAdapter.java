package com.example.android.appbar;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by alesiarazumova on 11/14/15.
 */

// An adapter to handle rendering 3 tabs for the Food Court information
// on the screen

public class viewPagerAdapter extends FragmentPagerAdapter {

    // Number of tab pages available for the user to view

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

            // Open cafesFoodCourtTab1.java
            // Return fragment_tab_1.xml, renders the first tab on the screen
            case 0:
                cafesFoodCourtTab1 cafe_details_tab_1 = new cafesFoodCourtTab1();
                return cafe_details_tab_1;

            // Open cafesFoodCourtTab2.java
            // Return fragment_tab_2.xml, renders the second tab on the screen
            case 1:
                cafesFoodCourtTab2 cafe_details_tab_2 = new cafesFoodCourtTab2();
                return cafe_details_tab_2;

            // Open cafesFoodCourtTab3.java
            // Return fragment_tab_3.xml, renders the third tab on the screen
            case 2:
                cafesFoodCourtTab3 cafe_details_tab_3 = new cafesFoodCourtTab3();
                return cafe_details_tab_3;
        }
        return null;
    }

// Handle the position of the tabs and titles on the screen

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}