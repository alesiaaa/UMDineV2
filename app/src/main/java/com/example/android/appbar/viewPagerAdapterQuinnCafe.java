package com.example.android.appbar;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;




public class viewPagerAdapterQuinnCafe extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;

    // Tab Titles
    private String tabtitles[] = new String[] { "Cafe", "General", "Full Menu" };
    Context context;

    public viewPagerAdapterQuinnCafe (FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            // Open cafesQuinnCafeTab1.java
            // Return healey_library_details_tab_1.xml
            case 0:
                cafesQuinnCafeTab1 quinn_cafe_details_tab_1 = new cafesQuinnCafeTab1();
                return quinn_cafe_details_tab_1;

            // Open cafesHealeyLibraryTab2.java
            // Return healey_library_details_tab_2.xml
            case 1:
                cafesQuinnCafeTab2 quinn_cafe_details_tab_2 = new cafesQuinnCafeTab2();
                return quinn_cafe_details_tab_2;

            // Open cafesHealeyLibraryTab3.java
            // Return university_club_details_tab_3.xml
            case 2:
                cafesQuinnCafeTab3 quinn_cafe_details_tab_3 = new cafesQuinnCafeTab3();
                return quinn_cafe_details_tab_3;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}