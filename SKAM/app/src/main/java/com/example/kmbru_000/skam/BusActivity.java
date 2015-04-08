package com.example.kmbru_000.skam;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class BusActivity extends Activity {

    private static final String TAG = "LOGGED:::BusActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
        setTitle("Syracuse Buses");
    }

    public void launchSelectRoute(View view) {
        Intent intent = new Intent(this, SelectRoute.class);
        startActivity(intent);
    }
    public void launchRouteMap(View view) {
        Intent intent = new Intent(this, RouteMap.class);
        startActivity(intent);
    }
    public void launchHelp(View view) {
        for (int i=0; i < 2; i++)
        {
            Toast.makeText(getApplicationContext(), "Press View Routes Map to find your desired bus route, then use bus schedules or BusTracker to find a time.",
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void launchSchedules(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://centro.org/Schedules-Syracuse.aspx"));
        startActivity(intent);
    }

}