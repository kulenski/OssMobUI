package eu.kulenski.android.ossmobui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


import eu.kulenski.android.ossmobui.model.BaseViewItem;
import eu.kulenski.android.ossmobui.model.MainAppViewItem;
import eu.kulenski.android.ossmobui.model.MainNotificationsViewItem;
import eu.kulenski.android.ossmobui.viewmodel.CardAppViewHolder;
import eu.kulenski.android.ossmobui.viewmodel.MainNotificationsViewHolder;

/**
 * Created by Tsvetan.Kulenski on 17.11.2016 г..
 */

public class MainMenuAdapter extends FlexibleGridRecyclerAdapter {

    private int mHeaderResourceId;
    private int mItemResourceId;
    private Context mContext;

    public MainMenuAdapter(@NonNull Context ctx, @NonNull RecyclerView recyclerView,
                           @NonNull ArrayList<BaseViewItem> itemsList, int headerResourceId, int itemResourceId) {
        super(ctx, recyclerView, itemsList, headerResourceId, itemResourceId);
        mHeaderResourceId = headerResourceId;
        mItemResourceId = itemResourceId;
        mContext = ctx;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == BaseViewItem.TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(mHeaderResourceId, parent, false);
            return new MainNotificationsViewHolder(v,mContext);
        } else {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(mItemResourceId, parent, false);
            return new CardAppViewHolder(v,mContext);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d("Bla","Bla");
        if(isHeaderItem(position)) {
            if(mList.get(position) instanceof MainNotificationsViewItem) {
                ((MainNotificationsViewHolder)holder).title.setText(((MainNotificationsViewItem) mList.get(position)).title);
            }
        } else {
            if(mList.get(position) instanceof MainAppViewItem) {
                ((CardAppViewHolder)holder).title.setText(((MainAppViewItem) mList.get(position)).title);
                ((CardAppViewHolder)holder).description.setText(((MainAppViewItem) mList.get(position)).description);
                //((CardAppViewHolder)holder).icon.setImageResource(((NetworkAppViewItem) mList.get(position)).iconResourceId);
            }
        }
    }
}
