package com.example.kmbru_000.skam;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;

import java.util.HashMap;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private  MyBaseAdapter myBaseAdapter;
    private static final String ARG_OPTION = "argument_option";
    private CafeData cafeData= new CafeData();
    private OnButtonSelectedListener mListener;

    public static PlaceholderFragment newInstance(int option) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_OPTION, option);
        fragment.setArguments(args);
        return fragment;
    }

    public PlaceholderFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_cafe_list_view, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listView);

        final CafeData cafeData = new CafeData();
        final MyBaseAdapter myBaseAdapter = new MyBaseAdapter(getActivity(), cafeData.getCafesList());

        listView.setAdapter(myBaseAdapter);
        myBaseAdapter.SetOnItemClickListener(new MyBaseAdapter.OnItemClickListener() {

            @Override
            public void onOverFlowMenuClick(View v, final int position) {
                PopupMenu popup = new PopupMenu(getActivity(), v);
                MenuInflater inflater = popup.getMenuInflater();

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_hours:
                                //Log.d("Messages", "Container: " + container);
                                /*getActivity().getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container, CafeBlinker.newInstance(position))
                                        .addToBackStack("Cafes")
                                        .commit();
                                Log.d("MyMessageS", "PF");*/
                                hoursMenuItem(position);
                                return true;
                            /*case R.id.item_showmap:
                                return true;*/
                            default:
                                return false;
                        }
                    }
                });
                inflater.inflate(R.menu.cafe_list_menu, popup.getMenu());
                popup.show();
            }

        });
        return rootView;
    }
    private void hoursMenuItem(int position) {
        String title = "";
        String[] message;
        String phone;
        String url;
        int hourX = position*4;

        HashMap<String, ?> map = new HashMap(cafeData.getItem(position));
        System.out.println("MAP: " + map.toString());
        title = map.get("name").toString();
        message = (String[]) map.get("hours");
        phone = (String) map.get("phone");
        url = (String) map.get("url");

        //  AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout ll;
        switch(position) {
            case 0:
                ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_blinker, null, false);
                break;
            case 1:
                ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_brockway, null, false);
                break;
            case 2:
                ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_eggers, null, false);
                break;
            case 3:
                ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_food, null, false);
                break;
            case 4:
                ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_icafe, null, false);
                break;
            case 5:
                ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_junction, null, false);
                break;
            case 6:
                ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_neo, null, false);
                break;
            case 7:
                ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_freshens, null, false);
                break;
            case 8:
                ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_olsten, null, false);
                break;
            case 9:
                ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_pages, null, false);
                break;
            case 10:
                ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_slocum, null, false);
                break;
            case 11:
                ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_warehouse, null, false);
                break;
            default:
                ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_blinker, null, false);
                break;
        }
        new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setView(ll)
                .setMessage(message[hourX] +"\n"+ message[hourX+1] +"\n" +message[hourX+2] +"\n"+ message[hourX+3]
                        + "\nPhone: " + phone)
                .setNeutralButton("Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnButtonSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnButtonSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnButtonSelectedListener {
        public void onButtonItemSelected(int position);
    }
}

