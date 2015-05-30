package com.example.kmbru_000.skam;

import android.app.Activity;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CoverPageFragment .On Fragment Interaction Listener} interface
 * to handle interaction events.
 * Use the {@link CoverPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CoverPageFragment extends Fragment {

    private OnButtonSelectedListener mListener;

    public static CoverPageFragment newInstance(String param1, String param2) {
        CoverPageFragment fragment = new CoverPageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public CoverPageFragment() {
        // Required empty public constructor
    }

    //initial creation of the fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //Inflate layout for cover page and listeners for buttons
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cover_page, container, false);
        View.OnClickListener onClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int id = view.getId();
                mListener.onButtonItemSelected(id);

            }
        };

        //Set up onclicklisteners for buttons on cover page
        (rootView.findViewById(R.id.mapbutton)).setOnClickListener(onClickListener);
        (rootView.findViewById(R.id.busbutton)).setOnClickListener(onClickListener);
        (rootView.findViewById(R.id.weatherbutton)).setOnClickListener(onClickListener);
        (rootView.findViewById(R.id.settingsbutton)).setOnClickListener(onClickListener);
        return rootView;

    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnButtonSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    //called right before the fragment is no longer associated with coverpageactivity
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /*
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnButtonSelectedListener {
        public void onButtonItemSelected(int position);
    }

}
