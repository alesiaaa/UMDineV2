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

            // Open cafesFoodCourtTab1.java
            // Return fragment_tab_1.xml
            case 0:
                cafesFoodCourtTab1 cafe_details_tab_1 = new cafesFoodCourtTab1();
                return cafe_details_tab_1;

            // Open cafesFoodCourtTab2.java
            // Return fragment_tab_2.xml
            case 1:
                cafesFoodCourtTab2 cafe_details_tab_2 = new cafesFoodCourtTab2();
                return cafe_details_tab_2;

            // Open cafesFoodCourtTab3.java
            // Return fragment_tab_3.xml
            case 2:
                cafesFoodCourtTab3 cafe_details_tab_3 = new cafesFoodCourtTab3();
                return cafe_details_tab_3;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}