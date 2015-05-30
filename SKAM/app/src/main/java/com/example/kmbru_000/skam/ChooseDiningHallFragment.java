package com.example.kmbru_000.skam;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 *
 * This class is a fragment within the CoverPageActivity and can be accessed from the navigation drawer.
 * It contains links to all the different dining halls that it has buttons for.
 *
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.example.kmbru_000.skam.ChooseDiningHallFragment.OnButtonSelectedListener} interface
 * to handle interaction events.
 * Use the {@link ChooseDiningHallFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChooseDiningHallFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnButtonSelectedListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChooseDiningHallFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChooseDiningHallFragment newInstance(String param1, String param2) {
        ChooseDiningHallFragment fragment = new ChooseDiningHallFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ChooseDiningHallFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    //Each dining hall button has an onclicklistener so it can change to a different fragment when pressed
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_choose_dining_hall, container, false);
        View.OnClickListener onClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int id = view.getId();
                mListener.onButtonItemSelected(id);

            }
        };

        (rootView.findViewById(R.id.brockway)).setOnClickListener(onClickListener);
        (rootView.findViewById(R.id.ernie)).setOnClickListener(onClickListener);
        (rootView.findViewById(R.id.goldstein)).setOnClickListener(onClickListener);
        (rootView.findViewById(R.id.graham)).setOnClickListener(onClickListener);
        (rootView.findViewById(R.id.sadler)).setOnClickListener(onClickListener);
        (rootView.findViewById(R.id.shaw)).setOnClickListener(onClickListener);

        View.OnClickListener handler = new View.OnClickListener(){
            public void onClick(View v) {
            }
        };

        return rootView;
    }


    //The CoverPageActivity must implement the onbuttonselectedlistener for this
    //fragment so it knows when to change the fragment.
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


    @Override
    public void onClick(View view) {

    }

    public interface OnButtonSelectedListener {
        public void onButtonItemSelected(int position);
    }

}
