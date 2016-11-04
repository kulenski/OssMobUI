package eu.kulenski.android.ossmobui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;


import java.util.ArrayList;

import eu.kulenski.android.ossmobui.R;

/**
 * Created by Tsvetan.Kulenski on 4.11.2016 г..
 */

public class NetworkMenuAdapter extends RecyclerView.Adapter<NetworkMenuAdapter.ViewHolder> {

    private ArrayList<SectionItem> mDataset;
    private Context mContext;

    public NetworkMenuAdapter(Context ctx,ArrayList<SectionItem> dataset) {
        if(dataset == null) throw new IllegalArgumentException("");
        this.mDataset = dataset;
        this.mContext = ctx;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTitle;
        public GridView mGrid;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mGrid = (GridView) itemView.findViewById(R.id.list);
        }
    }

    @Override
    public NetworkMenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_network_main_recycler_item, parent, false);
      return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SectionItem mCurrentItem = mDataset.get(position);
        ArrayList<SectionSubItem> mSubItems = mCurrentItem.getSubItems();
        SectionSubItemAdapter mAdapter = new SectionSubItemAdapter(mSubItems,mContext);

        holder.mTitle.setText(mCurrentItem.getName());
        holder.mGrid.setAdapter(mAdapter);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
