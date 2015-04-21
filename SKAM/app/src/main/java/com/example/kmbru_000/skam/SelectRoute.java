package com.example.kmbru_000.skam;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SelectRoute extends Activity {
    ListView listView;
    boolean campus = true;
    private static final String TAG = "LOGGED::FUCK-SHIT-STACK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_route);
        setTitle("Select Desired Route");

        final SharedPreferences sharedPref;
        final SharedPreferences.Editor editor;

        sharedPref = PreferenceManager.getDefaultSharedPreferences(SelectRoute.this);
        editor = sharedPref.edit();

        listView = (ListView) findViewById(R.id.listView);

        // Defined Array values to show in ListView
        String[] values = new String[] {
                "344 - South Campus",
                "443 - Connective Corridor",
                "444 - Small Road",
                "45  - SU - Destiny USA",
                "11  - Whitesboro",
                "111 - New York Mills",
                "114 - Mohawk - Consumer Sq",
                "12  - Bleecker Street",
                "143 - Quad Shuttle",
                "15  - James Street",
                "20  - Lenox",
                "22  - South Street",
                "24  - Genesee - Sangertown",
                "224 - Slocum Heights",
                "28  - Herkimer Road",
                "244 - Slocum Heights",
                "29  - Riverside",
                "30  - Genesee - Clinton",
                "31  - Oneida Street",
                "U12 - Bleecker Street",
                "43  - Sadler-Brewster-Boland",
                "44  - Manley"
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data/*

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String route = "error";

                switch (position) {
                    case 0:
                        route = "344";
                        break;
                    case 19:
                        route = "43";
                        break;
                    case 20:
                        route = "44";
                        break;
                    case 1:
                        route = "443";
                        break;
                    case 2:
                        route = "444";
                        break;
                    case 3:
                        route = "45";
                        break;
                    case 4:
                        route = "15";
                        break;
                    case 5:
                        route = "20";
                        break;
                    case 6:
                        route = "22";
                        break;
                    case 7:
                        route = "24";
                        break;
                    case 8:
                        route = "28";
                        break;
                    case 9:
                        route = "244";
                        break;
                    case 10:
                        route = "29";
                        break;
                    case 11:
                        route = "30";
                        break;
                    case 12:
                        route = "31";
                        break;
                    case 13:
                        route = "11";
                        break;
                    case 14:
                        route = "111";
                        break;
                    case 15:
                        route = "114";
                        break;
                    case 16:
                        route = "12";
                        break;
                    case 17:
                        route = "143";
                        break;
                    case 18:
                        route = "U12";
                        break;
                    default:
                        break;
                }
                //Change dir buttons
                if (position > 3 && position < 19){
                    campus = false;
                    Log.e(TAG, "inside if:::iscampus value set to false");
                }else{
                    campus = true;
                    Log.e(TAG, "inside if:::iscampus value set to true");
                }
                //Save selection

                editor.putString("route", route);
                editor.putBoolean("isCampus", campus);
                editor.apply();

                Log.e(TAG, "iscampus value = " + campus);

                //Move to direction selection
                Intent intent = new Intent(SelectRoute.this, CampusDirection.class);
                startActivity(intent);
            }
        });
    }
}
