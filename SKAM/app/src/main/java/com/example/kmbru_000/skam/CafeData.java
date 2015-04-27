package com.example.kmbru_000.skam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kmbru_000 on 4/14/2015.
 *
 * This class creates the hashmap containing the information about each cafe.
 * It references brand new updated pictures for each cafe.
 *
 */
public class CafeData {


    List<Map<String, ?>> cafesList;

    public List<Map<String, ?>> getCafesList() {
        return cafesList;
    }

    public int getSize() {
        return cafesList.size();
    }

    public HashMap getItem(int i) {
        if (i >= 0 && i < cafesList.size()) {
            return (HashMap) cafesList.get(i);
        } else return null;
    }

    public CafeData() {

        String building;
        String address;
        String phone;
        String[] hours = new String[48];
        String cafepic; //for picture

        cafesList = new ArrayList<Map<String, ?>>();
        /*
        1 Blinker Deli
        2 Brockway Food Court
        3 Eggers Cafe
        4 Food.com
        5 Freshens
        6 iCafe
        7 Junction Snack Bar
        8 Neoporent Cafe
        9 Olsten Cafe
        10 Pages
        11 Slocum Cafe
        12 The Warehouse Cafe
         */
        phone = "(315)443-4600";
        address = "";
        hours[0] = "Mon-Thurs: 8-2:30pm";
        hours[1] = "Fri: 8-2:30pm";
        hours[2] = "Sat: Closed";
        hours[3] = "Sun: Closed";
        building = "HBC, Atrium Level";
        cafesList.add(createCafe("Blinker Deli", R.drawable.one, building, phone, address, hours));

        phone = "(315)443-1636";
        address = "";
        hours[4] = "Mon-Thurs: 7:30-12am";
        hours[5] = "Fri: 7:30-12am";
        hours[6] = "Sat: 7:30-12am";
        hours[7] = "Sun: 7:30-12am";
        building = "Brockway Hall Basement";
        cafesList.add(createCafe("Brockway Food Court", R.drawable.two, building, phone, address, hours));

        phone = "(315)443-9381";
        address = "";
        hours[8] = "Mon-Thurs: 8am-4pm";
        hours[9] = "Fri: 8am-2:30pm";
        hours[10] = "Sat: Closed";
        hours[11] = "Sun: Closed";
        building = "Eggers Hall, Rm.300";
        cafesList.add(createCafe("Eggers Cafe", R.drawable.three, building, phone, address, hours));

        phone = "(315)443-4870";
        address = "";
        hours[12] = "Mon-Thurs: 8am-7pm";
        hours[13] = "Fri: 8am-2:30pm";
        hours[14] = "Sat: Closed";
        hours[15] = "Sun: Closed";
        building = "S.I.Newhouse School of Public Communications, Rm.244";
        cafesList.add(createCafe("Food.com", R.drawable.four, building, phone, address, hours));

        phone = "(315)443-8395";
        address = "";
        hours[28] = "Mon-Thurs: 8am-7pm";
        hours[29] = "Fri: 8am-2:30pm";
        hours[30] = "Sat: Closed";
        hours[31] = "Sun: Closed";
        building = "Life Sciences";
        cafesList.add(createCafe("Freshens", R.drawable.five, building, phone, address, hours));

        phone = "";
        address = "";
        hours[16] = "Mon-Thurs: 9am-7pm";
        hours[17] = "Fri: 10am-4pm";
        hours[18] = "Sat: Closed";
        hours[19] = "Sun: Closed";
        building = "Hinds Hall";
        cafesList.add(createCafe("iCafe", R.drawable.six, building, phone, address, hours));

        phone = "(315)443-4314";
        address = "";
        hours[20] = "Mon-Thurs: 7:30pm-12am";
        hours[21] = "Fri: 7:30pm-12am";
        hours[22] = "Sat: 7:30pm-12am";
        hours[23] = "Sun: 7:30pm-12am";
        building = "Flint&Day Hall";
        cafesList.add(createCafe("Junction Snack Bar", R.drawable.seven, building, phone, address, hours));

        phone = "(315)443-2870";
        address = "";
        hours[24] = "Mon-Thurs: 8am-7pm";
        hours[25] = "Fri: 8am-7pm";
        hours[26] = "Sat: Closed";
        hours[27] = "Sun: Closed";
        building = "Dineen Hall";
        cafesList.add(createCafe("Neoporent Cafe", R.drawable.eight, building, phone, address, hours));

        phone = "(315)443-3966";
        address = "";
        hours[32] = "Mon-Thurs: 8am-5pm";
        hours[33] = "Fri: Closed";
        hours[34] = "Sat: Closed";
        hours[35] = "Sun: Closed";
        building = "Whitman School of Management, Rm.211";
        cafesList.add(createCafe("Olsten Cafe", R.drawable.nine, building, phone, address, hours));

        phone = "(315)443-6201";
        address = "";
        hours[36] = "Mon-Thurs: 8am-11pm";
        hours[37] = "Fri: 8am-6pm";
        hours[38] = "Sat: 11am-6pm";
        hours[39] = "Sun: 11am-11pm";
        building = "Bird Library, Entrance Level";
        cafesList.add(createCafe("Pages", R.drawable.ten, building, phone, address, hours));

        phone = "(315)443-8422";
        address = "162 Slocum";
        hours[40] = "Mon-Thurs: 8am-10pm";
        hours[41] = "Fri: 8am-2:30pm";
        hours[42] = "Sat: Closed";
        hours[43] = "Sun: Closed";
        building = "Slocum Hall, Main Floor";
        cafesList.add(createCafe("Slocum Cafe", R.drawable.eleven, building, phone, address, hours));

        phone = "(315)443-6201";
        address = "350 W. Fayette St.";
        hours[44] = "Mon-Thurs: 8am-7:30pm";
        hours[45] = "Fri: 8am-6:30pm";
        hours[46] = "Sat: Closed";
        hours[47] = "Sun: Closed";
        building = "Warehouse";
        cafesList.add(createCafe("The Warehouse Cafe", R.drawable.twelve, building, phone, address, hours));

    }


    private HashMap createCafe(String name, int image, String building, String phone,
                               String address, String[] hours) {
        HashMap cafe = new HashMap();
        cafe.put("image", image);
        cafe.put("name", name);
        cafe.put("building", building);
        cafe.put("phone", phone);
        cafe.put("address", address);
        cafe.put("hours", hours);
        //cafe.put("cafepic", cafepic);

        return cafe;
    }
}
