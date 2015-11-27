package com.example.android.appbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by alesiarazumova on 11/25/15.
 */
public class goToCafeListMain extends AppCompatActivity implements View.OnClickListener{
    private Toolbar mToolbar;

    Button cafes_button_1, cafes_button_2, cafes_button_3;


    // Original Sample
    /*@Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
            setContentView(R.layout.test_file);
    }*/


    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
            setContentView(R.layout.cafe_list_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        // Find the buttons on the screen

        cafes_button_1 = (Button) findViewById(R.id.cafes_button1);
        cafes_button_2 = (Button) findViewById(R.id.cafes_button2);
        cafes_button_3 = (Button) findViewById(R.id.cafes_button3);

        cafes_button_1.setOnClickListener(this);
        cafes_button_2.setOnClickListener(this);
        cafes_button_3.setOnClickListener(this);

    }


/*    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //http://www.androidbegin.com/tutorial/android-viewpagertabstrip-fragments-tutorial/
        // Get the view from activity_tabbed.xml
        setContentView(R.layout.activity_tabbed);
        // Locate the viewpager in activity_main.xml
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        // Set the ViewPagerAdapter into ViewPager
        viewPager.setAdapter(new viewPagerAdapter(getSupportFragmentManager()));
    }*/




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

    @Override
    public void onClick (View v){

        switch (v.getId()) {
            case R.id.cafes_button1:

                Intent intent1 = new Intent(goToCafeListMain.this, goToFoodCourt.class);
                startActivity(intent1);
                //finish();

                Log.d("UMDine", "Button 1 was clicked ");
                break;

            case R.id.cafes_button2:

                Intent intent2 = new Intent(goToCafeListMain.this, goToFoodCourt.class);
                startActivity(intent2);
                //finish();

                Log.d("UMDine", "Button 2 was clicked ");
                break;

            case R.id.cafes_button3:
                //Setting content view doesn't work as well as sending to a different class
                //setContentView(R.layout.cafe_list_main);


                // Do something in response to button
                // This is if you would like to take your activity to a different class
                Intent intent3 = new Intent(goToCafeListMain.this, goToFoodCourt.class);
                startActivity(intent3);
                //finish();

                Log.d("UMDine", "Button 3 was clicked ");
                break;

            default:
                break;
        }
    }


}
