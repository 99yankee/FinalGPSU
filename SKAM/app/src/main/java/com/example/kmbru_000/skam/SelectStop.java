package com.example.kmbru_000.skam;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class SelectStop extends Activity {
    private static final String TAG = "LOGGED:::SelectStop";
    ListView stops;
    String route, dir;
    String[] values, ids;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_stop);
        setTitle("Select Your Stop");

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SelectStop.this);
        route = preferences.getString("route","error");
        dir = preferences.getString("dir","error");

        Log.e(TAG, "route: " + route);
        Log.e(TAG, "dir: " + dir);

        //create reference to list view
        stops = (ListView) findViewById(R.id.stops);

        //creates a thread to populate the list view with stops based on users route & direction selection
        //this thread also creates an array of stop ids that directly corresponds to the list of stops
        //once a stop is selected it is the stop id that is passed on to the next activity
        Thread getstops = new Thread()
        {
            public void run()
            {
                HttpURLConnection connection = null;
                try
                {
                    Log.e(TAG, "entered http request");
                    URL myURL = new URL("http://bus-time.centro.org/bustime/api/v1/getstops?key=XJX3BB9kEgHFMGQJzJ7e2AN2q&rt=" + route + "&&dir=" + dir);
                    connection = (HttpURLConnection) myURL.openConnection();
                    Log.d(TAG, "opened the connection ");

                    InputStream iStream = connection.getInputStream();
                    Log.d(TAG, "got input stream");

                    //string contains xml
                    final String fResponse = IOUtils.toString(iStream);

                    Log.e(TAG, fResponse);

                    try {
                        //parse the string to get arrival time
                        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

                        DocumentBuilder db = dbf.newDocumentBuilder();
                        InputSource is = new InputSource();
                        is.setCharacterStream(new StringReader(fResponse));

                        Document doc = db.parse(is);

                        //generates linked list of stops on the selected route
                        NodeList nodes = doc.getElementsByTagName("stop");

                        //Initialize arrays for stop name & id storage
                        String[] stopNamesList = new String[nodes.getLength()];
                        String[] stopIDs =  new String[nodes.getLength()];

                        //populate the arrays
                        for (int i = 0; i < nodes.getLength(); i++) {

                            Element stop = (Element) nodes.item(i);

                            NodeList stopNames = stop.getElementsByTagName("stpnm");
                            NodeList stopIDNums = stop.getElementsByTagName("stpid");

                            Element stpnm = (Element) stopNames.item(0);
                            Element stpid = (Element) stopIDNums.item(0);

                            stopNamesList[i] = getCharacterDataFromElement(stpnm);
                            stopIDs[i] = getCharacterDataFromElement(stpid);

                            Log.e(TAG, "stopName = " + stopNamesList[i]);
                            Log.e(TAG, "stopid = " + stopIDs[i]);

                        }
                        values = stopNamesList;
                        ids = stopIDs;

                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }


                }
                catch (MalformedURLException ex)
                {
                    Log.e(TAG, "Invalid URL", ex);
                }
                catch (IOException ex){
                    if(connection == null){
                        //connection error
                        Log.e(TAG, "connection error", ex);
                    }
                }

            }

        };

        //start the thread to populate the array of stops based on the route and direction
        getstops.start();

        //wait here for getstops thread to finish running
        try{
            getstops.join();
        }catch(Exception e){
            //print error message
        }

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of stops

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        // Assign adapter to ListView
        stops.setAdapter(adapter);

        stops.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                //passes the route selected in the previous activity and passes the coorisponding stop id to the stop the user has selected,
                //in the populated list view, to the next activity
                Intent intent = new Intent(SelectStop.this, stopInfo.class);
                intent.putExtra("rtid", route);
                intent.putExtra("stpid", ids[position]);

                startActivity(intent);

            }
        });
    }
    //extracts character data from a given element, in our case a given line of xml
    public static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "?";
    }
}
