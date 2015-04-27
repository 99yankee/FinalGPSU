package com.example.kmbru_000.skam;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kmbru_000 on 4/20/2015.
 *
 * Depending on the instance passed in to this fragment from ViewsOfCuseActivity, it will display different
 * xml files and titles.
 * It also uses a bitmap canvas to add colorful decorations to each view.
 *
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
        final ImageView imageView = (ImageView) v.findViewById(R.id.backgrnd);
        int w = v.getWidth();


        Bitmap bitmap = Bitmap.createBitmap(1100, 2000, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#FF6C00"));
        paint.setStyle(Paint.Style.FILL);

        canvas.drawRect(0, 80, 1100, 90, paint);
        canvas.drawRect(0, 160, 1100, 170, paint);
        canvas.drawRect(0, 240, 1100, 250, paint);
        canvas.drawRect(0, 320, 1100, 330, paint);
        canvas.drawRect(0, 400, 1100, 410, paint);

        canvas.drawRect(0, 1500, 1100, 1510, paint);
        canvas.drawRect(0, 1600, 1100, 1610, paint);
        canvas.drawRect(0, 1700, 1100, 1710, paint);
        canvas.drawRect(0, 1800, 1100, 1810, paint);
        canvas.drawRect(0, 1900, 1100, 1910, paint);

        imageView.setImageBitmap(bitmap);

        return v;
    }
}