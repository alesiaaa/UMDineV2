package com.example.android.appbar;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;




public class viewPagerAdapterHealeyLibrary extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;

    // Tab Titles
    private String tabtitles[] = new String[] { "Cafe", "General", "Full Menu" };
    Context context;

    public viewPagerAdapterHealeyLibrary(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            // Open cafesHealeyLibraryTab1.java
            // Return healey_library_details_tab_1.xml
            case 0:
                cafesHealeyLibraryTab1 healey_library_details_tab_1 = new cafesHealeyLibraryTab1();
                return healey_library_details_tab_1;

            // Open cafesHealeyLibraryTab2.java
            // Return healey_library_details_tab_2.xml
            case 1:
                cafesHealeyLibraryTab2 healey_library_details_tab_2 = new cafesHealeyLibraryTab2();
                return healey_library_details_tab_2;

            // Open cafesHealeyLibraryTab3.java
            // Return university_club_details_tab_3.xml
            case 2:
                cafesHealeyLibraryTab3 healey_library_details_tab_3 = new cafesHealeyLibraryTab3();
                return healey_library_details_tab_3;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}