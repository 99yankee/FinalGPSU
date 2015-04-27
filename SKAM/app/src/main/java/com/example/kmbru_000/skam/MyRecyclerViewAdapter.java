package com.example.kmbru_000.skam;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by kmbru_000 on 4/21/2015.
 *
 * MyRecyclerViewAdapter sets up a list of the cafes on campus, along with the name, number, and building info.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context mcontext;

    private final List<Map<String, ?>> mCafeList;
    OnItemClickListener mItemClickListener;

    public MyRecyclerViewAdapter(Context mycontext, List<Map<String, ?>> myCafeList) {
        mcontext = mycontext;
        mCafeList = myCafeList;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        public TextView vTitle;
        public ImageView vIcon;
        public TextView vDescription;
        public ImageView vMenu;

        public ListViewHolder(View v){
            super(v);
            vTitle = (TextView)v.findViewById(R.id.name);
            vIcon = (ImageView)v.findViewById(R.id.number);
            vDescription = (TextView)v.findViewById(R.id.building);
            vMenu = (ImageView)v.findViewById(R.id.menu_list);

            vMenu.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if( mItemClickListener != null){
                        mItemClickListener.onOverFlowMenuClick(v,getPosition());
                    }
                }
            });
        }

        public void bindCafeData(Map<String, ?> cafe){
            vTitle.setText((String) cafe.get("name"));
            vDescription.setText((String) cafe.get("building"));
            vIcon.setImageResource((Integer) cafe.get("image"));
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View v;
        RecyclerView.ViewHolder vh;
        v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cafe_card_view, parent, false);
        vh = new ListViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Map<String, ?>cafe = mCafeList.get(position);
        ListViewHolder listviewholder = (ListViewHolder) holder;
        listviewholder.bindCafeData(cafe);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mCafeList.size();
    }

    public interface OnItemClickListener{
        public void onOverFlowMenuClick(View view, final int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener){
        this.mItemClickListener = mItemClickListener;
    }
}
