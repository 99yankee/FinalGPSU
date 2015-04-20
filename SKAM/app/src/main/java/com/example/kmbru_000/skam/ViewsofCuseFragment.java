package com.example.kmbru_000.skam;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ViewsofCuseFragment . OnfragIntList} interface
 * to handle interaction events.
 * Use the {@link ViewsofCuseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewsofCuseFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    public static final ViewsofCuseFragment newInstance(String section) {
        ViewsofCuseFragment frag = new ViewsofCuseFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString(ARG_SECTION_NUMBER, section);
        frag.setArguments(bdl);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String section = getArguments().getString(ARG_SECTION_NUMBER);
        int option = Integer.parseInt(section);
        View v;

        switch (option) {
            case 0:
                v = inflater.inflate(R.layout.fragment_viewsof_cuse1, container, false);
                break;
            case 1:
                v = inflater.inflate(R.layout.fragment_viewsof_cuse2, container, false);
                break;
            case 2:
                v = inflater.inflate(R.layout.fragment_viewsof_cuse3, container, false);
                break;
            case 3:
                v = inflater.inflate(R.layout.fragment_viewsof_cuse4, container, false);
                break;
            case 4:
                v = inflater.inflate(R.layout.fragment_viewsof_cuse5, container, false);
                break;
            case 5:
                v = inflater.inflate(R.layout.fragment_viewsof_cuse6, container, false);
                break;
            case 6:
                v = inflater.inflate(R.layout.fragment_viewsof_cuse7, container, false);
                break;
            case 7:
                v = inflater.inflate(R.layout.fragment_viewsof_cuse8, container, false);
                break;
            default:
                v = inflater.inflate(R.layout.fragment_viewsof_cuse9, container, false);
                break;
        }

        //View v = inflater.inflate(R.layout.fragment_viewsof_cuse1, container, false);
        //TextView messageTextView = (TextView)v.findViewById(R.id.textView);
        //messageTextView.setText(section);
        return v;

    }
}