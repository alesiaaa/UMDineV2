package com.example.android.appbar;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;




public class viewPagerAdapterAtriumCafe extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;

    // Tab Titles
    private String tabtitles[] = new String[] { "Cafe", "General", "Full Menu" };
    Context context;

    public viewPagerAdapterAtriumCafe(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            // Open cafesAtriumCafeTab1.java
            // Return atrium_tab_1.xml
            case 0:
                cafesAtriumCafeTab1 atrium_details_tab_1 = new cafesAtriumCafeTab1();
                return atrium_details_tab_1;

            // Open cafesAtriumCafeTab2.java
            // Return atrium_tab_2.xml
            case 1:
                cafesAtriumCafeTab2 atrium_details_tab_2 = new cafesAtriumCafeTab2();
                return atrium_details_tab_2;

            // Open cafesAtriumCafeTab3.java
            // Return atrium_tab_3.xml
            case 2:
                cafesAtriumCafeTab3 atrium_details_tab_3 = new cafesAtriumCafeTab3();
                return atrium_details_tab_3;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}