package com.example.kmbru_000.skam;

/**
 * Created by kmbru_000 on 3/21/2015.
 *
 * Drawer_Data contains a list/hashmap of the items in the navigation drawer.
 * Each hashmap item includes the type of formatting, and the specified text.
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drawer_Data {

    //create the different types of items in the list
    List<Map<String,?>> drawerList;
    public static final int TYPE0 = 0;
    public static final int TYPE1 = 1;
    public static final int TYPE2 = 2;
    public static final int TYPE3 = 3;

    //return the list with the data when called
    public List<Map<String, ?>> getDrawerList() {
        return drawerList;
    }

    //return the size of the list
    public int getSize(){
        return drawerList.size();
    }

    //access a specific item in the list
    public HashMap getItem(int i){
        return (HashMap) drawerList.get(i);
    }

    //put information into the list/hashmap
    public Drawer_Data(){
        HashMap item;
        drawerList =new ArrayList<Map<String,?>>();

        //This list item is in a bigger sized font
        item = new HashMap();
        item.put("type",TYPE0); item.put("title", "Home");
        drawerList.add(item);

////////////
        //This part has a a small icon with the words next to it

        item = new HashMap();
        item.put("type",TYPE1); item.put("icon", R.drawable.book); item.put("title", "Libraries");
        drawerList.add(item);
        item = new HashMap();
        item.put("type",TYPE1); item.put("icon", R.drawable.fork); item.put("title", "Dining Halls");
        drawerList.add(item);

        item = new HashMap();
        item.put("type",TYPE1); item.put("icon", R.drawable.flower); item.put("title", "Cafes");
        drawerList.add(item);

/////////////
        //This part is just an image

        item = new HashMap();
        item.put("type",TYPE2); item.put("icon", R.drawable.simple_line);
        drawerList.add(item);

/////////////

        //This part is just words, but in a normal font
        item = new HashMap();
        item.put("type",TYPE3);  item.put("title", "Views of 'Cuse");
        drawerList.add(item);

        item = new HashMap();
        item.put("type",TYPE3);  item.put("title", "Compass");
        drawerList.add(item);

        item = new HashMap();
        item.put("type",TYPE3);  item.put("title", "Exit gpSU");
        drawerList.add(item);
    }
}
