package com.example.kmbru_000.skam;

import android.app.Activity;
import android.app.AlertDialog;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by kmbru_000 on 4/21/2015.
 *
 * CafeFragment uses MyRecyclerViewAdapter to display a list of cafes.
 * Once the overflow menu button at the end of a list item is selected,
 * it calls an alertDialog that has the cafe's number, hours, and updated picture.
 *
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.example.kmbru_000.skam.CafeRFragment.OnRecyclerViewItemSelectedListener} interface
 * to handle interaction events.
 * Use the {@link CafeRFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CafeRFragment extends Fragment implements TextView.OnEditorActionListener {

    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter mRecyclerViewAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private OnRecyclerViewItemSelectedListener mListener;
    //  private OnFragmentInteractionListener mListener;
    private CafeData cafeData;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static CafeRFragment newInstance(String param1, String param2) {
        CafeRFragment fragment = new CafeRFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public CafeRFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        cafeData = new CafeData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.cardList);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerViewAdapter = new MyRecyclerViewAdapter(getActivity(), cafeData.getCafesList());

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerViewAdapter.SetOnItemClickListener(new MyRecyclerViewAdapter.OnItemClickListener(){
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

                            default:
                                return false;
                        }
                    }
                });
                inflater.inflate(R.menu.cafe_list_menu, popup.getMenu());
                popup.show();
            }

        });
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        return rootView;
    }
    private void hoursMenuItem(int position) {
        String title = "";
        String[] message;
        String phone;
        //  String url;
        int hourX = position*4;

        HashMap<String, ?> map = new HashMap(cafeData.getItem(position));
        System.out.println("MAP: " + map.toString());
        title = map.get("name").toString();
        message = (String[]) map.get("hours");
        phone = (String) map.get("phone");
        //  url = (String) map.get("url");

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
                ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_freshens, null, false);
                break;
            case 5:
                ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_icafe, null, false);
                break;
            case 6:
                ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_junction, null, false);
                break;
            case 7:
                ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_neo, null, false);
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
        Log.d("Message", "Phone: " + phone + "  " + title);
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

    /*  public void onButtonPressed(Uri uri) {
          if (mListener != null) {
              mListener.onOverFlowMenuClick(uri);
          }
      }
  */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnRecyclerViewItemSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnRecyclerViewItemSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        return false;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnRecyclerViewItemSelectedListener {
        // TODO: Update argument type and name
        public void onItemSelected(int position, HashMap<String,?> movie);

    }

    class ActionBarCallBack implements ActionMode.Callback{
        int position;
        public ActionBarCallBack(int position){ this.position = position; }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.menu_cafe_recycle, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            HashMap hm = (HashMap) cafeData.getItem(position);
            mode.setTitle((String) hm.get("name"));
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            int id = item.getItemId();
            switch(id) {
                case R.id.item_hours:
                    hoursMenuItem(position);
                    mRecyclerViewAdapter.notifyItemRemoved(position);
                    mode.finish();
                    break;

                default:
                    break;
            }
            return false;
        }
        private void hoursMenuItem(int position) {
            String title = "";
            String[] message;
            String phone;
            //  String url;
            int hourX = position*4;

            HashMap<String, ?> map = new HashMap(cafeData.getItem(position));
            System.out.println("MAP: " + map.toString());
            title = map.get("name").toString();
            message = (String[]) map.get("hours");
            phone = (String) map.get("phone");
            //  url = (String) map.get("url");

            //  AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout ll;
            View rootView;
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
                    ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_freshens, null, false);
                    break;
                case 5:
                    ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_icafe, null, false);
                    break;
                case 6:
                    ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_junction, null, false);
                    break;
                case 7:
                    ll = (LinearLayout) inflater.inflate(R.layout.fragment_cafe_neo, null, false);
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
            rootView = ll;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
            imageView.animate().setDuration(1000)
                     .alpha(1f);
            Log.d("Message", "Phone: " + phone + "  " + title);
            new AlertDialog.Builder(getActivity(), R.style.MyThemeGrow)
                    .setTitle(title)
                    .setView(ll)
                    .setMessage(message[hourX] +"\n"+ message[hourX+1] +"\n" +message[hourX+2] +"\n"+ message[hourX+3]
                            + "\nPhone: " + phone)
                    .setNeutralButton("Back", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getExitTransition();
                        }
                    })
                    .show();
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }

    }
    public interface OnListItemSelectedListener{
        public void onListItemSelected (int position, HashMap<String, ?> movie);
    }

}
