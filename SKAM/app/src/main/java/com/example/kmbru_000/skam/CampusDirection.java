package com.example.kmbru_000.skam;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class CampusDirection extends Activity implements OnClickListener{
    Intent intent;
    boolean isCampus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_direction);
        setTitle("Select Direction");

        LinearLayout ll = (LinearLayout)findViewById(R.id.dir_layout);

        String route;

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(CampusDirection.this);
        route = preferences.getString("route","error");
        isCampus = preferences.getBoolean("isCampus", true);

        //Grab the route selection from previous activity



        //Dynamically add "TO+" button
        Button tb = new Button(this);
        if(isCampus)
            tb.setText("To Campus");
        else
            tb.setText("To Hub");
        tb.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        //noinspection ResourceType
        tb.setId(1);
        tb.setOnClickListener(this);
        ll.addView(tb);

        //Dynamically add "FROM+" button
        Button fb = new Button(this);
        if(isCampus)
            fb.setText("From Campus");
        else
            fb.setText("From Hub");
        fb.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        //noinspection ResourceType
        fb.setId(2);
        fb.setOnClickListener(this);
        ll.addView(fb);

        //Pass the route selection
        intent = new Intent(this, SelectStop.class);
        intent.putExtra("route", route);

    }
    public void onClick(View v){
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(CampusDirection.this);
        SharedPreferences.Editor editor = sharedPref.edit();
        switch (v.getId()) {
            case (1):
                if(isCampus) {
                    editor.putString("dir", "TO+CAMPUS");
                }else {
                    editor.putString("dir", "TO+HUB");
                }break;
            case (2):
                if(isCampus) {
                    editor.putString("dir", "FROM+CAMPUS");
                }else {
                    editor.putString("dir", "FROM+HUB");
                }break;

        }
        editor.apply();
        startActivity(intent);
    }
}
