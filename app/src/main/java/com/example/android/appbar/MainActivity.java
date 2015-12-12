package com.example.android.appbar;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
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
 * Created by alesiarazumova on 11/14/15.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Create variables for the toolbar, buttons on the main screen, search action,
    // to detect when search is initiated, and when the search field is being edited.

    private Toolbar mToolbar;
    Button home_button_1, home_button_2, home_button_3;
    private MenuItem mSearchAction;
    private boolean isSearchOpened = false;
    private TextView edtSearch;


    // On create view method is the most important method because it renders a view
    // (an instance of an image of action) on the screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the main window to the activity_main.xml page
        setContentView(R.layout.activity_main);

        // Set the toolbar at the top to display
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);


        // Bring menu drawer layout to front
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.bringToFront();

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_drawer_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        drawer.closeDrawers();
                        switch (menuItem.getItemId()) {

                            // Go to MainActivity.class when home button is clicked
                            case R.id.nav_home:
                                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                                startActivity(intent);
                                Log.d("UMDine", "Home was clicked ");
                                break;

                            // Go to goToCafesListMain.class when cafes button is clicked
                            case R.id.nav_restaurant_menu:
                                Intent intent1 = new Intent(MainActivity.this, goToCafeListMain.class);
                                startActivity(intent1);
                                Log.d("UMDine", "Cafes was clicked ");
                                break;

                            //Go to goToFavorites.class when the heart button is clicked
                            case R.id.nav_favorites:
                                Intent intent3 = new Intent(MainActivity.this, goToFavorites.class);
                                startActivity(intent3);
                                Log.d("UMDine", "Favorites was clicked ");
                                break;

                            // Go to the goToFAQ.class when the dialog button is clicked
                            case R.id.nav_faq:
                                Intent intent4 = new Intent(MainActivity.this, goToFAQ.class);
                                startActivity(intent4);
                                Log.d("UMDine", "FAQ was clicked ");
                                break;

                        }

                        // Once the click is recognized, return true
                        return true;

                    }
                });

        // Code to enable the toggle on the menu  drawer when an option in the drawer menu is
        // seleced

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        // Find the buttons on the screen by locating the XML ID assigned to them

        home_button_1 = (Button) findViewById(R.id.home_button1);
        home_button_2 = (Button) findViewById(R.id.home_button2);
        home_button_3 = (Button) findViewById(R.id.home_button3);

        // Set on click listener to detect when a button has been clicked

        home_button_1.setOnClickListener(this);
        home_button_2.setOnClickListener(this);
        home_button_3.setOnClickListener(this);


    }

    // Create a share intent so that when the user clicks on the "share" icon
    // in the overflow menu, the icon sends a signal to the operating system
    // to allow the user to select an application to share content.
    // Android emulator only allows the user to send a "txt"

    private void shareIntent()
    {
        Intent sendIntent = new Intent(android.content.Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        String shareBody = "For more information on UMass Dining please visit our webpage at " +
                "https://umb.sodexomyway.com/ or download our application, UMDine.";
        sendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "UMDine: The UMass Dining Experience");
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sendIntent, "Share via"));

    }

    // Create a search intent so that when the user clicks on the "search" icon
    // in the toolbar menu, the icon sends a signal to the operating system
    // to allow search to the internet via proffered browser

    private void searchIntent()
    {

        Intent searchIntent = new Intent(Intent.ACTION_WEB_SEARCH);
        String keyword= "umass boston dining";
        searchIntent.putExtra(SearchManager.QUERY, keyword);
        startActivity(searchIntent);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the toolbar menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.app_bar_main, menu);

        // Return true to display toolbar menu at the top
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // The toolbar at the top will handle clicks here.
        int id = item.getItemId();

        switch (id) {

            // When user selects the settings option in the overflow menu
            // it will navigate the user to the goToSettings.class
            case R.id.action_settings:

                Intent intent = new Intent(MainActivity.this, goToSettings.class);
                startActivity(intent);
                Log.d("UMDine", "Settings button was clicked ");
                return true;

            // When user selects the share option in the overflow menu
            // it will start the shareIntent() function
            case R.id.action_share:
                shareIntent();
                Log.d("UMDine", "Share button was clicked ");
                return true;

            // When user selects the search option in the toolbar menu
            // it will start the handleMenuSearch() function
            case R.id.action_search:

                handleMenuSearch();

                Log.d("UMDine", "Search button was clicked ");
                return true;

        }

        return super.onOptionsItemSelected(item);
    }


    // Recognize the search option in the toolbar by locating
    // the action_search ID

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        mSearchAction = menu.findItem(R.id.action_search);
        return super.onPrepareOptionsMenu(menu);
    }

    // Handle the views when the navigation drawer is opened/ closed
    // Hnadle the views when the search is initiated

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }


        if(isSearchOpened) {
           handleMenuSearch();
        } else {
            super.onBackPressed();
        }


    }

    // Handle search actions here

    protected void handleMenuSearch() {
        ActionBar action = getSupportActionBar(); //get the actionbar

        if (isSearchOpened) { //test if the search is open

            action.setDisplayShowCustomEnabled(false); //disable a custom view inside the actionbar
            action.setDisplayShowTitleEnabled(true); //show the title in the action bar

            //hide the keyboard
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(edtSearch.getWindowToken(), 0);

            //add the search icon in the toolabr bar
            mSearchAction.setIcon(getResources().getDrawable(R.drawable.ic_open_search));

            isSearchOpened = false;
        } else { //open the search entry

            action.setDisplayShowCustomEnabled(true); //enable it to display a
            // custom view in the action bar.
            action.setCustomView(R.layout.search_bar);//add the custom view
            action.setDisplayShowTitleEnabled(false); //hide the title

            edtSearch = (TextView) action.getCustomView().findViewById(R.id.edtSearch); //the text editor

            //this is a listener to do a search when the user clicks on search button
            edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {

                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                        // execute the search
                        // search will only execute with one string (see function above)
                        searchIntent();

                        return true;
                    }
                    return false;
                }
            });


            edtSearch.requestFocus();

            //open the keyboard focused in the edtSearch
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(edtSearch, InputMethodManager.SHOW_IMPLICIT);


            //add the close icon
            mSearchAction.setIcon(getResources().getDrawable(R.drawable.ic_close_search));

            isSearchOpened = true;
        }

    }


    //Handle user clicks on the main page

    @Override
    public void onClick (View v){

        switch (v.getId()) {


            case R.id.home_button1:

                // Clicking the button will take the user to the What's Open Now page
                Intent intent1 = new Intent(MainActivity.this, goToWhatsOpenNow.class);
                startActivity(intent1);

                Log.d("UMDine", "What's Open Now was clicked ");
                break;

            case R.id.home_button2:

                // Clicking the button will take the user to the Favorites page
                Intent intent2 = new Intent(MainActivity.this, goToFavorites.class);
                startActivity(intent2);

                Log.d("UMDine", "Favorites was clicked ");
                break;

            case R.id.home_button3:

                Intent intent3 = new Intent(MainActivity.this, goToCafeListMain.class);
                startActivity(intent3);

                // Clicking the button will take the user to the list of cafes page
                Log.d("UMDine", "Cafes was clicked ");
                break;

            default:
                break;
        }
    }




}













