package com.example.kmbru_000.skam;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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


public class stopInfo extends Activity {
    private static final String TAG = "LOGGED:::stopInfo";
    String rtid, stpid, estArrival;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_info);
        setTitle("Arrival Time");

        //initialize passed vars with error for debugging
        rtid = "error";
        stpid = "error";

        //grab passed vars from direction choice
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            rtid = extras.getString("rtid");
            stpid = extras.getString("stpid");
        }

        Log.e(TAG, "route found in bundle: " + rtid);
        Log.e(TAG, "stpid found in bundle: " + stpid);

        //creates a thread that executes an http request given the route and stopIds selected in the previous activities as arguments
        new Thread()
        {
            public void run()
            {
                HttpURLConnection connection = null;
                try
                {
                    URL myURL = new URL("http://bus-time.centro.org/bustime/api/v1/getpredictions?key=XJX3BB9kEgHFMGQJzJ7e2AN2q&rt=" + rtid + "&stpid=" + stpid);
                    connection = (HttpURLConnection) myURL.openConnection();

                    InputStream iStream = connection.getInputStream();

                    //string contains xml
                    final String fResponse = IOUtils.toString(iStream);

                    try {
                        //parse the string to get arrival time
                        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

                        DocumentBuilder db = dbf.newDocumentBuilder();
                        InputSource is = new InputSource();
                        is.setCharacterStream(new StringReader(fResponse));

                        Document doc = db.parse(is);
                        NodeList nodes = doc.getElementsByTagName("prdtm");
                        Element line = (Element) nodes.item(0);
                        final String time = getCharacterDataFromElement(line);
                        estArrival = time.substring(time.lastIndexOf(' ') + 1);
                    }
                    catch (Exception e) {
                        estArrival = "No Service Scheduled At This Time";
                        e.printStackTrace();
                    }

                    final TextView fView = (TextView)findViewById(R.id.main);

                    //set the arrival time on screen
                    fView.post(new Runnable(){

                        @Override
                        public void run(){
                            fView.setText(estArrival);
                        }
                    });

                }
                catch (MalformedURLException ex)
                {
                    Log.e(TAG, "Invalid URL", ex);
                }
                catch (IOException ex){
                    if(connection == null){
                        Log.e(TAG, "connection error", ex);
                    }
                }

            }

        }.start();
    }
    //extract characters from the given line of xml, in this case passed as a node element in a list
    public static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "?";
    }
}
