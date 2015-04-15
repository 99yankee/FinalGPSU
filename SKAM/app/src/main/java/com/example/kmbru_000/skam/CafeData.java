package com.example.kmbru_000.skam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kmbru_000 on 4/10/2015.
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
        //name
        //String[] hours;
        //String building;
        //String address;
        //String phone;

        String building;
        String address;
        String phone;
        String[] hours = new String[48];
        String url; //for picture

        cafesList = new ArrayList<Map<String, ?>>();
        /*
        1 Blinker Deli
        2 Brockway Food Court
        3 Eggers Cafe
        4 Food.com
         */
        phone = "(315)443-4600";
        address = "";
        hours[0] = "Mon-Thurs: 8-2:30pm";
        hours[1] = "Fri: ";
        hours[2] = "Sat: Closed";
        hours[3] = "Sun: Closed";
        url = "fragment_cafe_blinker";
        building = "HBC, Atrium Level";
        cafesList.add(createCafe("Blinker Deli", R.drawable.one, building, phone, address, hours, url));

        phone = "(315)443-1636";
        address = "";
        hours[4] = "Mon-Thurs: 7:30-12am";
        hours[5] = "Fri: 7:30-12am";
        hours[6] = "Sat: 7:30-12am";
        hours[7] = "Sun: 7:30-12am";
        url = "http://ia.media-imdb.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SY317_CR0,0,214,317_AL_.jpg";
        building = "Brockway Hall Basement";
        cafesList.add(createCafe("Brockway Food Court", R.drawable.one, building, phone, address, hours, url));

        phone = "(315)443-9381";
        address = "";
        hours[8] = "Mon-Thurs: 8am-4pm";
        hours[9] = "Fri: 8am-2:30pm";
        hours[10] = "Sat: Closed";
        hours[11] = "Sun: Closed";
        url = "http://ia.media-imdb.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SY317_CR0,0,214,317_AL_.jpg";
        building = "Eggers Hall, Rm.300";
        cafesList.add(createCafe("Eggers Cafe", R.drawable.one, building, phone, address, hours, url));

        phone = "(315)443-4870";
        address = "";
        hours[12] = "Mon-Thurs: ";
        hours[13] = "Fri: ";
        hours[14] = "Sat: ";
        hours[15] = "Sun: ";
        url = "http://ia.media-imdb.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SY317_CR0,0,214,317_AL_.jpg";
        building = "S.I.Newhouse School of Public Communications, Rm.244";
        cafesList.add(createCafe("Food.com", R.drawable.one, building, phone, address, hours, url));

        phone = "";
        address = "";
        hours[16] = "Mon-Thurs: 9am-7pm";
        hours[17] = "Fri: 10am-4pm";
        hours[18] = "Sat: Closed";
        hours[19] = "Sun: Closed";
        url = "http://ia.media-imdb.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SY317_CR0,0,214,317_AL_.jpg";
        building = "Hinds Hall";
        cafesList.add(createCafe("iCafe", R.drawable.one, building, phone, address, hours, url));

        phone = "(315)443-4314";
        address = "";
        hours[20] = "Mon-Thurs: 7:30pm-12am";
        hours[21] = "Fri: 7:30pm-12am";
        hours[22] = "Sat: 7:30pm-12am";
        hours[23] = "Sun: 7:30pm-12am";
        url = "http://ia.media-imdb.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SY317_CR0,0,214,317_AL_.jpg";
        building = "Flint&Day Hall";
        cafesList.add(createCafe("Junction Snack Bar", R.drawable.one, building, phone, address, hours, url));

        phone = "(315)443-2870";
        address = "";
        hours[24] = "Mon-Thurs: 8am-7pm";
        hours[25] = "Fri: 8am-7pm";
        hours[26] = "Sat: Closed";
        hours[27] = "Sun: Closed";
        url = "http://ia.media-imdb.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SY317_CR0,0,214,317_AL_.jpg";
        building = "Dineen Hall";
        cafesList.add(createCafe("Neoporent Cafe", R.drawable.one, building, phone, address, hours, url));

        phone = "(315)443-8395";
        address = "";
        hours[28] = "Mon-Thurs: 8am-7pm";
        hours[29] = "Fri: 8am-2:30pm";
        hours[30] = "Sat: Closed";
        hours[31] = "Sun: Closed";
        url = "http://ia.media-imdb.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SY317_CR0,0,214,317_AL_.jpg";
        building = "Life Sciences";
        cafesList.add(createCafe("Freshens", R.drawable.one, building, phone, address, hours, url));

        phone = "(315)443-3966";
        address = "";
        hours[32] = "Mon-Thurs: 8am-5pm";
        hours[33] = "Fri: Closed";
        hours[34] = "Sat: Closed";
        hours[35] = "Sun: Closed";
        url = "http://ia.media-imdb.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SY317_CR0,0,214,317_AL_.jpg";
        building = "Whitman School of Management, Rm.211";
        cafesList.add(createCafe("Olsten Cafe", R.drawable.one, building, phone, address, hours, url));

        phone = "(315)443-6201";
        address = "";
        hours[36] = "Mon-Thurs: 8am-11pm";
        hours[37] = "Fri: 8am-6pm";
        hours[38] = "Sat: 11am-6pm";
        hours[39] = "Sun: 11am-11pm";
        url = "http://ia.media-imdb.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SY317_CR0,0,214,317_AL_.jpg";
        building = "Bird Library, Entrance Level";
        cafesList.add(createCafe("Pages", R.drawable.one, building, phone, address, hours, url));

        phone = "(315)443-8422";
        address = "162 Slocum";
        hours[40] = "Mon-Thurs: 8am-10pm";
        hours[41] = "Fri: 8am-2:30pm";
        hours[42] = "Sat: Closed";
        hours[43] = "Sun: Closed";
        url = "http://ia.media-imdb.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SY317_CR0,0,214,317_AL_.jpg";
        building = "Slocum Hall, Main Floor";
        cafesList.add(createCafe("Slocum Cafe", R.drawable.one, building, phone, address, hours, url));

        phone = "(315)443-6201";
        address = "350 W. Fayette St.";
        hours[44] = "Mon-Thurs: 8am-7:30pm";
        hours[45] = "Fri: 8am-6:30pm";
        hours[46] = "Sat: Closed";
        hours[47] = "Sun: Closed";
        url = "http://ia.media-imdb.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SY317_CR0,0,214,317_AL_.jpg";
        building = "Warehouse";
        cafesList.add(createCafe("The Warehouse Cafe", R.drawable.one, building, phone, address, hours, url));

    }


    private HashMap createCafe(String name, int image, String building, String phone,
                               String address, String[] hours, String url) {
        HashMap cafe = new HashMap();
        cafe.put("image", image);
        cafe.put("name", name);
        cafe.put("building", building);
        cafe.put("phone", phone);
        cafe.put("address", address);
        cafe.put("hours", hours);
        cafe.put("url", url);

        return cafe;
    }
}
