package com.example.kmbru_000.skam;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* Created by kmbru_000 on 3/11/2015
 *
 * This fragment is called from ChooseLibFragment.
 * It displays the contents of the info about the geology library.
*/
public class LibGeology extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    // private OnFragmentInteractionListener mListener;
    private OnButtonSelectedListener mListener;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LibBird.
     */
    public static LibGeology newInstance(String param1, String param2) {
        LibGeology fragment = new LibGeology();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public LibGeology() {
        // Required empty public constructor
    }

    //called for initial creation of the fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    //creates and returns the view hierarchy  associated with the fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lib_geology, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    /*public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
*/
    //called when the fragment is associated with the activity (coverpageactivity)
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
      /*  try {
            mListener = (OnButtonSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    //called right before the fragment is no longer associated with coverpageactivity
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
