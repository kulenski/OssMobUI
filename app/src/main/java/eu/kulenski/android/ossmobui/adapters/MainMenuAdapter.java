package eu.kulenski.android.ossmobui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


import eu.kulenski.android.ossmobui.model.BaseItem;
import eu.kulenski.android.ossmobui.model.ExampleCardViewPlainItem;
import eu.kulenski.android.ossmobui.model.ExampleTextViewHeaderItem;
import eu.kulenski.android.ossmobui.viewmodel.CardItemViewHoler;
import eu.kulenski.android.ossmobui.viewmodel.TextHeaderViewHolder;

/**
 * Created by Tsvetan.Kulenski on 17.11.2016 г..
 */

public class MainMenuAdapter extends SectionedGridRecyclerAdapter {

    private int mHeaderResourceId;
    private int mItemResourceId;
    private Context mContext;

    public MainMenuAdapter(@NonNull Context ctx, @NonNull RecyclerView recyclerView,
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
            return new TextHeaderViewHolder(v,mContext);
        } else {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(mItemResourceId, parent, false);
            return new CardItemViewHoler(v,mContext);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(isHeaderItem(position)) {
            if(mList.get(position) instanceof ExampleTextViewHeaderItem) {
                ((TextHeaderViewHolder)holder).title.setText(((ExampleTextViewHeaderItem) mList.get(position)).title);
            }
        } else {
            if(mList.get(position) instanceof ExampleCardViewPlainItem) {
                ((CardItemViewHoler)holder).title.setText(((ExampleCardViewPlainItem) mList.get(position)).title);
                ((CardItemViewHoler)holder).description.setText(((ExampleCardViewPlainItem) mList.get(position)).description);
                ((CardItemViewHoler)holder).icon.setImageResource(((ExampleCardViewPlainItem) mList.get(position)).iconResourceId);
            }
        }
    }
}
