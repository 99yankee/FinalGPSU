package com.example.kmbru_000.skam;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by kmbru_000 on 4/10/2015. RecyclerView.Adapter<RecyclerView.ViewHolder>
 */
public class MyBaseAdapter extends BaseAdapter {
    private final Context context;
    private final List<Map<String, ?>> cafeList;
    OnItemClickListener mItemClickListener;

    public MyBaseAdapter(Context context, List<Map<String, ?>> cafeList) {
        this.context = context;
        this.cafeList = cafeList;
    }

    @Override
    public boolean isEnabled(int position) {
        if (position < 0) {
            return false;
        }
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return cafeList.size();
    }

    @Override
    public Object getItem(int position) {
        return cafeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    class ViewHolder {
        TextView name;
        ImageView image;
        TextView building;
      //  ImageView cafepic;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View rowView;
        ViewHolder holder = null;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.cafe_card_view, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) rowView.findViewById(R.id.name);
            holder.image = (ImageView) rowView.findViewById(R.id.number);
            holder.building = (TextView) rowView.findViewById(R.id.building);
  //          holder.cafepic = (ImageView) rowView.findViewById(R.id.imageView);
            rowView.setTag(holder);
        } else {
            rowView = view;
            holder = (ViewHolder) view.getTag();
        }

        Map<String, ?> entry = cafeList.get(position);

        holder.image.setImageResource((Integer) entry.get("image"));
        holder.name.setText((String) entry.get("name"));
        holder.building.setText((String) entry.get("building"));
//        holder.cafepic.setImageResource((Integer) entry.get("cafepic"));

        TextView name = (TextView) rowView.findViewById(R.id.name);
        TextView building = (TextView) rowView.findViewById(R.id.building);
        ImageView number = (ImageView) rowView.findViewById(R.id.number);
        ImageView vmenu = (ImageView) rowView.findViewById(R.id.menu_list);
        //ImageView imageView = (ImageView) rowView.findViewById(R.id.ia)
        final int pos = position;
        name.setTextColor(Color.rgb(0, 39, 79));
        vmenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if( mItemClickListener != null){
                    mItemClickListener.onOverFlowMenuClick(v,pos);
                }
            }

        });


        return rowView;
    }

    public interface OnItemClickListener{
        public void onOverFlowMenuClick(View view, final int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener){
        this.mItemClickListener = mItemClickListener;
    }
}