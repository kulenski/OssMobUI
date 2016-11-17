package eu.kulenski.android.ossmobui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import eu.kulenski.android.ossmobui.model.BaseItem;
import eu.kulenski.android.ossmobui.model.NetworkAppItem;
import eu.kulenski.android.ossmobui.model.NetworkHeaderItem;
import eu.kulenski.android.ossmobui.viewmodel.CardItemViewHoler;
import eu.kulenski.android.ossmobui.viewmodel.MainNotificationsViewHolder;
import eu.kulenski.android.ossmobui.viewmodel.TextHeaderViewHolder;

/**
 * Created by kulenski on 17.11.2016 г..
 */

public class NetworkMainMenuAdapter extends FlexibleGridRecyclerAdapter {
    private int mHeaderResourceId;
    private int mItemResourceId;
    private Context mContext;

    public NetworkMainMenuAdapter(@NonNull Context ctx, @NonNull RecyclerView recyclerView,
                           @NonNull ArrayList<BaseItem> itemsList, int headerResourceId, int itemResourceId) {
        super(ctx, recyclerView, itemsList, headerResourceId, itemResourceId);
        mHeaderResourceId = headerResourceId;
        mItemResourceId = itemResourceId;
        mContext = ctx;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == BaseItem.TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(mHeaderResourceId, parent, false);
            return new MainNotificationsViewHolder(v,mContext);
        } else {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(mItemResourceId, parent, false);
            return new CardItemViewHoler(v,mContext);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d("Bla","Bla");
        if(isHeaderItem(position)) {
            if(mList.get(position) instanceof NetworkHeaderItem) {
                ((TextHeaderViewHolder)holder).title.setText(((NetworkHeaderItem) mList.get(position)).title);
            }
        } else {
            if(mList.get(position) instanceof NetworkAppItem) {
                ((CardItemViewHoler)holder).title.setText(((NetworkAppItem) mList.get(position)).title);
                ((CardItemViewHoler)holder).description.setText(((NetworkAppItem) mList.get(position)).description);
                //((CardItemViewHoler)holder).icon.setImageResource(((NetworkAppItem) mList.get(position)).iconResourceId);
            }
        }
    }
}
