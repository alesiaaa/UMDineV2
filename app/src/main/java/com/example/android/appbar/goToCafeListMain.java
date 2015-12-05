package com.example.android.appbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by alesiarazumova on 11/25/15.
 */
public class goToCafeListMain extends AppCompatActivity implements View.OnClickListener{
    private Toolbar mToolbar;

    Button cafes_button_1, cafes_button_2, cafes_button_3,cafes_button_4, cafes_button_5, cafes_button_6;

    private MenuItem mSearchAction;
    private boolean isSearchOpened = false;
    private TextView edtSeach;


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
        cafes_button_4 = (Button) findViewById(R.id.cafes_button4);
        cafes_button_5 = (Button) findViewById(R.id.cafes_button5);
        cafes_button_6 = (Button) findViewById(R.id.cafes_button6);

        cafes_button_1.setOnClickListener(this);
        cafes_button_2.setOnClickListener(this);
        cafes_button_3.setOnClickListener(this);
        cafes_button_4.setOnClickListener(this);
        cafes_button_5.setOnClickListener(this);
        cafes_button_6.setOnClickListener(this);


    }


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
                //doSearch();
                return true;
        }

        return super.onOptionsItemSelected(item1);
    }


    public boolean onNavigationItemSelected (MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            Intent intent = new Intent(goToCafeListMain.this, MainActivity.class);
            startActivity(intent);

            // leads to primary home page
        } else if (id == R.id.nav_restaurant_menu) {

            Intent intent = new Intent(goToCafeListMain.this, goToCafeListMain.class);
            startActivity(intent);

            // leads to cafe_list_main.xml
        } else if (id == R.id.nav_search) {
            //open search pane at the top of the screen
        } else if (id == R.id.nav_favorites) {
            //navigates to list of items
        } else if (id == R.id.nav_faq) {
            // navigates to FAQ page

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        mSearchAction = menu.findItem(R.id.action_search);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }


        if(isSearchOpened) {
            //doSearch();
        } else {
            super.onBackPressed();
        }


    }

    protected void handleMenuSearch() {
        ActionBar action = getSupportActionBar(); //get the actionbar

        if (isSearchOpened) { //test if the search is open

            action.setDisplayShowCustomEnabled(false); //disable a custom view inside the actionbar
            action.setDisplayShowTitleEnabled(true); //show the title in the action bar

            //hides the keyboard
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(edtSeach.getWindowToken(), 0);

            //add the search icon in the action bar
            mSearchAction.setIcon(getResources().getDrawable(R.drawable.ic_open_search));

            isSearchOpened = false;
        } else { //open the search entry

            action.setDisplayShowCustomEnabled(true); //enable it to display a
            // custom view in the action bar.
            action.setCustomView(R.layout.search_bar);//add the custom view
            action.setDisplayShowTitleEnabled(false); //hide the title

            edtSeach = (TextView) action.getCustomView().findViewById(R.id.edtSearch); //the text editor

            //this is a listener to do a search when the user clicks on search button
            edtSeach.setOnEditorActionListener(new TextView.OnEditorActionListener() {

                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        //
                        return true;
                    }
                    return false;
                }
            });


            edtSeach.requestFocus();

            //open the keyboard focused in the edtSearch
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(edtSeach, InputMethodManager.SHOW_IMPLICIT);


            //add the close icon
            mSearchAction.setIcon(getResources().getDrawable(R.drawable.ic_close_search));

            isSearchOpened = true;
        }

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

                Intent intent2 = new Intent(goToCafeListMain.this, goToAtriumCafe.class);
                startActivity(intent2);
                //finish();

                Log.d("UMDine", "Button 2 was clicked ");
                break;

            case R.id.cafes_button3:
                //Setting content view doesn't work as well as sending to a different class
                //setContentView(R.layout.cafe_list_main);


                // Do something in response to button
                // This is if you would like to take your activity to a different class
                Intent intent3 = new Intent(goToCafeListMain.this, goToUniversityClub.class);
                startActivity(intent3);
                //finish();

                Log.d("UMDine", "Button 3 was clicked ");
                break;

            case R.id.cafes_button4:

                Intent intent4 = new Intent(goToCafeListMain.this, goToHealeyLibrary.class);
                startActivity(intent4);
                //finish();

                Log.d("UMDine", "Button 4 was clicked ");
                break;

            case R.id.cafes_button5:

                Intent intent5 = new Intent(goToCafeListMain.this, goToMccormackExpress.class);
                startActivity(intent5);
                //finish();

                Log.d("UMDine", "Button 5 was clicked ");
                break;

            case R.id.cafes_button6:

                Intent intent6 = new Intent(goToCafeListMain.this, goToQuinnCafe.class);
                startActivity(intent6);
                //finish();

                Log.d("UMDine", "Button 6 was clicked ");
                break;



            default:
                break;
        }
    }


}
