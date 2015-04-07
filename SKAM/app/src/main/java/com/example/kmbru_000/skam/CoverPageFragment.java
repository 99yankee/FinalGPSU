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

    //private OnFragmentInteractionListener mListener;
    private OnButtonSelectedListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_CoverPage.
     */
    // TODO: Rename and change types and number of parameters
    public static CoverPageFragment newInstance(String param1, String param2) {
        CoverPageFragment fragment = new CoverPageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public CoverPageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

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

        (rootView.findViewById(R.id.mapbutton)).setOnClickListener(onClickListener);
        (rootView.findViewById(R.id.busbutton)).setOnClickListener(onClickListener);
        (rootView.findViewById(R.id.weatherbutton)).setOnClickListener(onClickListener);
        (rootView.findViewById(R.id.settingsbutton)).setOnClickListener(onClickListener);
        return rootView;

    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
       /* if (menu.findItem(R.id.action_search) == null) {
            inflater.inflate(R.menu.menu_activity_action_bar, menu);
        }*/
    /*
        // TODO: Rename method, update argument and hook method into UI event
        public void onButtonPressed(Uri uri) {
            if (mListener != null) {
                mListener.onFragmentInteraction(uri);
            }
        }
    */
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
  /*  public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }
    */
    public interface OnButtonSelectedListener {
        // TODO: Update argument type and name
        public void onButtonItemSelected(int position);

    }

}
