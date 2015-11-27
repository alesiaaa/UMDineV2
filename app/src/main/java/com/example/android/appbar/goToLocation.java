package com.example.android.appbar;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by alesiarazumova on 11/25/15.
 */
public class goToLocation extends AppCompatActivity {



    // Original Sample
    /*@Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
            setContentView(R.layout.test_file);
    }*/


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //http://www.androidbegin.com/tutorial/android-viewpagertabstrip-fragments-tutorial/
        // Get the view from activity_tabbed.xml
        setContentView(R.layout.activity_tabbed);
        // Locate the viewpager in activity_main.xml
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        // Set the ViewPagerAdapter into ViewPager
        viewPager.setAdapter(new viewPagerAdapter(getSupportFragmentManager()));
    }





// Code from original file for the app bar - doesn't render for some reason
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.app_bar_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item1) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item1.getItemId();

        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_search:
                //handleMenuSearch();
                return true;
        }

        return super.onOptionsItemSelected(item1);
    }

    // Enter search call

    private void doSearch() {

    }

}
