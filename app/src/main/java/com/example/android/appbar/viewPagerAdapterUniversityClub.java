package com.example.android.appbar;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;




public class viewPagerAdapterUniversityClub extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;

    // Tab Titles
    private String tabtitles[] = new String[] { "Cafe", "General", "Full Menu" };
    Context context;

    public viewPagerAdapterUniversityClub(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            // Open cafesUniversityClubTab1.java
            // Return university_club_details_tab_1.xml
            case 0:
                cafesUniversityClubTab1 university_club_details_tab_1 = new cafesUniversityClubTab1();
                return university_club_details_tab_1;

            // Open cafesUniversityClubTab2.java
            // Return university_club_details_tab_2.xml
            case 1:
                cafesUniversityClubTab2 university_club_details_tab_2 = new cafesUniversityClubTab2();
                return university_club_details_tab_2;

            // Open cafesUniversityClubTab3.java
            // Return university_club_details_tab_3.xml
            case 2:
                cafesUniversityClubTab3 university_club_details_tab_3 = new cafesUniversityClubTab3();
                return university_club_details_tab_3;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}