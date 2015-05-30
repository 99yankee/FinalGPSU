package com.example.kmbru_000.skam;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.HashMap;

/*The CoverPageActivity contains links to every other fragment and activity in the app.
 * It implements MyDrawerRecyclerViewAdapter for the navigational drawer
 * and Toolbar so that we can have a custom toolbar
 *
 */

public class CoverPageActivity extends ActionBarActivity
        implements CoverPageFragment.OnButtonSelectedListener, ChooseLibFragment.OnButtonSelectedListener,
        LibCarnegie.OnFragmentInteractionListener, LibLaw.OnFragmentInteractionListener,
        LibMlk.OnFragmentInteractionListener, LibMoon.OnFragmentInteractionListener,
        LibArch.OnFragmentInteractionListener, LibBird.OnFragmentInteractionListener,
        ChooseDiningHallFragment.OnButtonSelectedListener,
        dining_brockway.OnFragmentInteractionListener,
        dining_ernie.OnFragmentInteractionListener, dining_goldstein.OnFragmentInteractionListener,
        dining_graham.OnFragmentInteractionListener, dining_sadler.OnFragmentInteractionListener,
        dining_shaw.OnFragmentInteractionListener,
        CafeRFragment.OnRecyclerViewItemSelectedListener
        {

    //Implement variables for navigation bar and toolbar
    private RelativeLayout mDrawer;
    private DrawerLayout mDrawerLayout;
    private RecyclerView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private  MyDrawerRecyclerViewAdapter mDrawerRecyclerViewAdapter;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mPlanetTitles;

    /*
    When creating the main activity/cover page, create the:
    -navigation bar & it's corresponding links
    -toolbar
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout ll;
        View rootView = inflater.inflate(R.layout.fragment_cover_page, null, false);
        setContentView(R.layout.activity_cover_page);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawer = (RelativeLayout) findViewById(R.id.drawer);
        mDrawerList = (RecyclerView) findViewById(R.id.drawer_list);
        mDrawerList.setLayoutManager(new LinearLayoutManager(this));
        mDrawerRecyclerViewAdapter = new MyDrawerRecyclerViewAdapter(this, (new Drawer_Data()).getDrawerList());
        mDrawerRecyclerViewAdapter.SetOnItemClickListener(new MyDrawerRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                selectItem(position);
            }

        });

        mDrawerList.setAdapter(mDrawerRecyclerViewAdapter);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                mToolbar,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }
    }

    // Using the navigation bar,
    // update the main content by replacing fragments
    private void selectItem(int position) {
        Intent intent;
        switch (position) {
            case 0://Home - new fragment
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new CoverPageFragment())
                        .addToBackStack("Home")
                        .commit();
                break;
            case 1: // Libraries - new fragment
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new ChooseLibFragment())
                        .addToBackStack("Libraries")
                        .commit();
                break;
            case 2: //Dining Halls - new fragment
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new ChooseDiningHallFragment())
                        .addToBackStack("Dining")
                        .commit();
                break;
            case 3: // Cafes - new fragment
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new CafeRFragment())
                                .addToBackStack("CafeRecycler")
                                .commitAllowingStateLoss();
               /* intent = new Intent(this, CafeRActivity.class);
                startActivity(intent);*/
                break;
            case 4:  // Border Line
                break;
            case 5: // Pictures of SU -new activity
                intent = new Intent(this, ViewsofCuseActivity.class);
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(this,Compass2Activity.class);
                startActivity(intent);
                break;
            case 7: // Exit
                System.exit(1);
                break;

            default: //go to home page - new activity
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new CoverPageFragment())
                        .commit();
                break;
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    //Create the overflow menu button for "settings"
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cover_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();
        super .onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case R.id.action_settings:
                settingsMenuItem();
                break;
        }
        return true;
    }

    //Create content of the overflow menu "settings" button
    private void settingsMenuItem() {
        new AlertDialog.Builder(this)
        .setTitle("About gpSU")
        .setMessage("gpSU is an app made by Syracuse students, for Syracuse students.  " +
                "Use it to find information about the campus and make all your hopes and dreams come true!")
        .setNeutralButton("OK!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();

    }

    //Create links for the main buttons on the cover page
    @Override
    public void onButtonItemSelected(int id) {
        Intent intent;

        switch (id) {
            case R.id.mapbutton: //Maps page - new activity
                intent = new Intent(this, MapsActivity.class);
                startActivity(intent);
                break;
            case R.id.busbutton: //Bus page - new activity
                intent = new Intent(this, BusActivity.class);
                startActivity(intent);
                break;
            case R.id.weatherbutton: //Weather page - new activity
                intent = new Intent(this, WeatherActivity.class);
                startActivity(intent);
                break;
            case R.id.settingsbutton: //Directions page - new activity
                intent = new Intent(this, Directions.class);
                startActivity(intent);
                break;

            //Buttons on ChooseLibFragment Page call a new fragment
            case R.id.bird:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new LibBird())
                        .addToBackStack("Bird Library")
                        .commit();
                break;
            case R.id.carnegie:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new LibCarnegie())
                        .addToBackStack("Carnegie Library")
                        .commit();
                break;
            case R.id.geology:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new LibGeology())
                        .addToBackStack("Geology Library")
                        .commit();
                break;
            case R.id.law:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new LibLaw())
                        .addToBackStack("Law Library")
                        .commit();
                break;
            case R.id.architecture:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new LibArch())
                        .addToBackStack("Architecture Reading Room")
                        .commit();
                break;
            case R.id.mlk:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new LibMlk())
                        .addToBackStack("MLK Jr. Library")
                        .commit();
                break;
            case R.id.moon:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new LibMoon())
                        .addToBackStack("Moon Library (ESF)")
                        .commit();
                break;

            //Buttons on ChooseDiningHallFragment page call a new fragment
            case R.id.brockway:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new dining_brockway())
                        .addToBackStack("Brockway Dining Hall")
                        .commit();
                break;
            case R.id.ernie:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new dining_ernie())
                        .addToBackStack("Ernie Davis Dining Hall")
                        .commit();
                break;
            case R.id.goldstein:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new dining_goldstein())
                        .addToBackStack("Goldstein Student Center")
                        .commit();
                break;
            case R.id.graham:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new dining_graham())
                        .addToBackStack("Graham Dining Hall")
                        .commit();
                break;
            case R.id.sadler:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new dining_sadler())
                        .addToBackStack("Sadler Dining Hall")
                        .commit();
                break;
            case R.id.shaw:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new dining_shaw())
                        .addToBackStack("Shaw Dining Hall")
                        .commit();
                break;
            default:
                break;
        }
    }

    //Add new pages to the BackStack so user can go to the previous page
    @Override
    public void onBackPressed(){
        if(getFragmentManager().getBackStackEntryCount()!=0){
            getFragmentManager().popBackStack();
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    //Create methods for "Go Here" buttons on library & dining hall pages
    public void directArch (View view){
        Intent intent = new Intent(this, DirectionMaps.class);
        String starting = "LifeSciencesComplexSyracuse";
        intent.putExtra(Directions.START, starting);
        String destination = "";
        destination = "LinkHallSyracuse";
        intent.putExtra(Directions.DESTINATION, destination);
        startActivity(intent);
    }

    public void directBird (View view){
        Intent intent = new Intent(this, DirectionMaps.class);
        String starting = "LifeSciencesComplexSyracuse";
        intent.putExtra(Directions.START, starting);
        String destination = "";
        destination = "BirdLibrarySyracuse";
        intent.putExtra(Directions.DESTINATION, destination);
        startActivity(intent);
    }

    public void directCarnegie (View view){
        Intent intent = new Intent(this, DirectionMaps.class);
        String starting = "LifeSciencesComplexSyracuse";
        intent.putExtra(Directions.START, starting);
        String destination = "";
        destination = "CarnegieLibrarySyracuse";
        intent.putExtra(Directions.DESTINATION, destination);
        startActivity(intent);
    }

    public void directHeroy (View view){
        Intent intent = new Intent(this, DirectionMaps.class);
        String starting = "LifeSciencesComplexSyracuse";
        intent.putExtra(Directions.START, starting);
        String destination = "";
        destination = "HeroySyracuse";
        intent.putExtra(Directions.DESTINATION, destination);
        startActivity(intent);
    }

    public void directLaw (View view){
        Intent intent = new Intent(this, DirectionMaps.class);
        String starting = "LifeSciencesComplexSyracuse";
        intent.putExtra(Directions.START, starting);
        String destination = "";
        destination = "CollegeOfLawSyracuse";
        intent.putExtra(Directions.DESTINATION, destination);
        startActivity(intent);
    }

    public void directMLK (View view){
        Intent intent = new Intent(this, DirectionMaps.class);
        String starting = "LifeSciencesComplexSyracuse";
        intent.putExtra(Directions.START, starting);
        String destination = "";
        destination = "SimsHallSyracuse";
        intent.putExtra(Directions.DESTINATION, destination);
        startActivity(intent);
    }

    public void directMoon (View view){
        Intent intent = new Intent(this, DirectionMaps.class);
        String starting = "LifeSciencesComplexSyracuse";
        intent.putExtra(Directions.START, starting);
        String destination = "";
        destination = "MoonLibrarySyracuse";
        intent.putExtra(Directions.DESTINATION, destination);
        startActivity(intent);
    }

    public void directBrockway (View view){
        Intent intent = new Intent(this, DirectionMaps.class);
        String starting = "LifeSciencesComplexSyracuse";
        intent.putExtra(Directions.START, starting);
        String destination = "";
        destination = "401VanBurenStSyracuse";
        intent.putExtra(Directions.DESTINATION, destination);
        startActivity(intent);
    }

    public void directErnie (View view){
        Intent intent = new Intent(this, DirectionMaps.class);
        String starting = "LifeSciencesComplexSyracuse";
        intent.putExtra(Directions.START, starting);
        String destination = "";
        destination = "ErnieHallSyracuse";
        intent.putExtra(Directions.DESTINATION, destination);
        startActivity(intent);
    }

    public void directGoldstein (View view){
        Intent intent = new Intent(this, DirectionMaps.class);
        String starting = "LifeSciencesComplexSyracuse";
        intent.putExtra(Directions.START, starting);
        String destination = "";
        destination = "GoldsteinStudentCenterSyracuse";
        intent.putExtra(Directions.DESTINATION, destination);
        startActivity(intent);
    }

    public void directGram (View view){
        Intent intent = new Intent(this, DirectionMaps.class);
        String starting = "LifeSciencesComplexSyracuse";
        intent.putExtra(Directions.START, starting);
        String destination = "";
        destination = "1Mt.OlympusDriveSyracuse";
        intent.putExtra(Directions.DESTINATION, destination);
        startActivity(intent);
    }

    public void directSadler (View view){
        Intent intent = new Intent(this, DirectionMaps.class);
        String starting = "LifeSciencesComplexSyracuse";
        intent.putExtra(Directions.START, starting);
        String destination = "";
        destination = "SadlerHallSyracuse";
        intent.putExtra(Directions.DESTINATION, destination);
        startActivity(intent);
    }

    public void directShaw (View view){
        Intent intent = new Intent(this, DirectionMaps.class);
        String starting = "LifeSciencesComplexSyracuse";
        intent.putExtra(Directions.START, starting);
        String destination = "";
        destination = "775ComstockAveSyracuse";
        intent.putExtra(Directions.DESTINATION, destination);
        startActivity(intent);
    }

            @Override
            public void onItemSelected(int position, HashMap<String, ?> movie) {

            }
        }
