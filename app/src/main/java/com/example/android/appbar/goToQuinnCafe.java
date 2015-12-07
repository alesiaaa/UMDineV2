package com.example.android.appbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

/**
 * Created by alesiarazumova on 11/25/15.
 */
public class goToQuinnCafe extends AppCompatActivity {

    private Toolbar mToolbar;

    private MenuItem mSearchAction;
    private boolean isSearchOpened = false;
    private TextView edtSearch;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //http://www.androidbegin.com/tutorial/android-viewpagertabstrip-fragments-tutorial/
        // Get the view from activity_tabbed_healey_library.xml
        setContentView(R.layout.activity_tabbed_quinn_cafe);
        // Locate the viewpager in activity_main.xml
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager_quinn_cafe);
        // Set the ViewPagerAdapter into ViewPager
        viewPager.setAdapter(new viewPagerAdapterQuinnCafe(getSupportFragmentManager()));


        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        // Bring Drawer layout to front
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
                            case R.id.nav_home:
                                Intent intent = new Intent(goToQuinnCafe.this, MainActivity.class);
                                startActivity(intent);
                                Log.d("UMDine", "Home was clicked ");
                                break;

                            case R.id.nav_restaurant_menu:
                                Intent intent1 = new Intent(goToQuinnCafe.this, goToCafeListMain.class);
                                startActivity(intent1);
                                Log.d("UMDine", "Cafes was clicked ");
                                break;

                            case R.id.nav_search:
                                Intent intent2 = new Intent(goToQuinnCafe.this, MainActivity.class);
                                startActivity(intent2);
                                Log.d("UMDine", "Search was clicked ");
                                break;

                            case R.id.nav_favorites:
                                Intent intent3 = new Intent(goToQuinnCafe.this, MainActivity.class);
                                startActivity(intent3);
                                Log.d("UMDine", "Favorites was clicked ");
                                break;

                            case R.id.nav_faq:
                                Intent intent4 = new Intent(goToQuinnCafe.this, goToFAQ.class);
                                startActivity(intent4);
                                Log.d("UMDine", "FAQ was clicked ");
                                break;

                        }
                        return true;
                    }
                });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

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
                //doSearch();
                return true;
        }

        return super.onOptionsItemSelected(item1);
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
            imm.hideSoftInputFromWindow(edtSearch.getWindowToken(), 0);

            //add the search icon in the action bar
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
                        //
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


}
