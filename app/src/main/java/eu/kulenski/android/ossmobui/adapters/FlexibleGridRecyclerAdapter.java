package eu.kulenski.android.ossmobui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import eu.kulenski.android.ossmobui.managers.FlexibleGridLayoutManager;
import eu.kulenski.android.ossmobui.model.BaseItem;

/**
 * Created by Tsvetan.Kulenski on 17.11.2016 г..
 */

public abstract class FlexibleGridRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //protected Context mContext;
    protected ArrayList<BaseItem> mList;

    public FlexibleGridRecyclerAdapter(@NonNull Context ctx,
                                       @NonNull RecyclerView recyclerView,
                                       @NonNull ArrayList<BaseItem> itemsList,
                                       int headerResourceId,
                                       int itemResourceId) {

        // Lay out headerItem full width, otherwise use the default spanCount.
        final FlexibleGridLayoutManager layoutManager = (FlexibleGridLayoutManager) recyclerView.getLayoutManager();
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                //Log.d("BlaBla",(mList.get(position) instanceof NetworkHeaderItem) ?
                //        ((NetworkHeaderItem)mList.get(position)).title : ((NetworkAppItem)mList.get(position)).title
                //        + " " +String.valueOf(isHeaderItem(position)));
                return isHeaderItem(position) ? layoutManager.getSpanCount() : 1;
            }
        });

        //mContext = ctx;
        mList = itemsList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {}

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getItemType();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    protected boolean isHeaderItem(int position) {
        return mList.get(position).getItemType() == BaseItem.TYPE_HEADER;
    }
}
