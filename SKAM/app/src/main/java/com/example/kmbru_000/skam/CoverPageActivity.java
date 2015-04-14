package com.example.kmbru_000.skam;

import android.app.AlertDialog;
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
import android.widget.RelativeLayout;

//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;

public class CoverPageActivity extends ActionBarActivity
        implements CoverPageFragment.OnButtonSelectedListener, ChooseLibFragment.OnButtonSelectedListener,
        LibCarnegie.OnFragmentInteractionListener, LibLaw.OnFragmentInteractionListener,
        LibMlk.OnFragmentInteractionListener, LibMoon.OnFragmentInteractionListener,
        LibArch.OnFragmentInteractionListener, LibBird.OnFragmentInteractionListener,
        ChooseDiningHallFragment.OnButtonSelectedListener,
        dining_brockway.OnFragmentInteractionListener,
        dining_ernie.OnFragmentInteractionListener, dining_goldstein.OnFragmentInteractionListener,
        dining_graham.OnFragmentInteractionListener, dining_sadler.OnFragmentInteractionListener,
        dining_shaw.OnFragmentInteractionListener {

    private RelativeLayout mDrawer;
    private DrawerLayout mDrawerLayout;
    private RecyclerView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private  MyDrawerRecyclerViewAdapter mDrawerRecyclerViewAdapter;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mPlanetTitles;

    public Button buttonred;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        buttonred = (Button) findViewById(R.id.mapbutton);
        if (savedInstanceState == null) {
            selectItem(0);
        }
    }

    // update the main content by replacing fragments
    private void selectItem(int position) {
        switch (position) {
            case 0://Home
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new CoverPageFragment())
                        .addToBackStack("Home")
                        .commit();
                break;
            case 1: // Libraries
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new ChooseLibFragment())
                        .addToBackStack("Libraries")
                        .commit();
                break;
            case 2: //Dining Halls
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new ChooseDiningHallFragment())
                        .addToBackStack("Dining")
                        .commit();
                break;
            case 3: // Border Line
                break;
         /*   case 4:  // Cafes
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new CoverPageFragment())
                        .commit();
                break;
           */ case 4: // Exit
                System.exit(1);
                break;

            default: //go to home page
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new ChooseLibFragment())
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
        //noinspection SimplifiableIfStatement
        //getSupportFragmentManager().beginTransaction()
          //      .replace(R.id.action_settings, PlaceholderFragment.newInstance(id))
            //    .commit();

        switch (item.getItemId())
        {
            case R.id.action_settings:
                settingsMenuItem();
                break;



        }


        //if (mDrawerToggle.onOptionsItemSelected(item)) {
        //    return true;
        //}



        return true;

    }


    private void settingsMenuItem() {
        new AlertDialog.Builder(this)
        .setTitle("About gpSU")
        .setMessage("gpSU is an app made by Syracuse students, for Syracuse students.  " +
                "Use it to find information about the campus and make all your hopes and dreams come true!")
        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();

    }

    @Override
    public void onButtonItemSelected(int id) {
        Intent intent;

        switch (id) {
            case R.id.mapbutton:
                intent = new Intent(this, MapsActivity.class);
                startActivity(intent);
                break;
            case R.id.busbutton:
                intent = new Intent(this, BusActivity.class);
                startActivity(intent);
                break;
            case R.id.weatherbutton:
                intent = new Intent(this, WeatherActivity.class);
                startActivity(intent);
                break;
            case R.id.settingsbutton:
                intent = new Intent(this, Directions.class);
                startActivity(intent);
                break;

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
/*
    @Override
    public void onFragmentInteraction(Uri uri) { ///////////////////////////////////////////////////////////

    } */

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }
        private static final String ARG_OPTION = "section_number";

        public static PlaceholderFragment newInstance(int sectionNumber)
        {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_OPTION, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_cover_page, container, false);

            return rootView;
        }
    }

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
        destination = "MartinLutherKingJRLibrarySyracuse";
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
        destination = "BrockwayHallSyracuse";
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
        destination = "GramDiningHallSyracuse";
        intent.putExtra(Directions.DESTINATION, destination);
        startActivity(intent);
    }

    public void directSadler (View view){
        Intent intent = new Intent(this, DirectionMaps.class);
        String starting = "LifeSciencesComplexSyracuse";
        intent.putExtra(Directions.START, starting);
        String destination = "";
        destination = "SadlerDiningHallSyracuse";
        intent.putExtra(Directions.DESTINATION, destination);
        startActivity(intent);
    }

    public void directShaw (View view){
        Intent intent = new Intent(this, DirectionMaps.class);
        String starting = "LifeSciencesComplexSyracuse";
        intent.putExtra(Directions.START, starting);
        String destination = "";
        destination = "ShawDiningHallSyracuse";
        intent.putExtra(Directions.DESTINATION, destination);
        startActivity(intent);
    }
}
