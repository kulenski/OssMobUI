package eu.kulenski.android.ossmobui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import eu.kulenski.android.ossmobui.managers.FlexibleGridLayoutManager;
import eu.kulenski.android.ossmobui.model.BaseViewItem;

/**
 * Created by Tsvetan.Kulenski on 17.11.2016 г..
 */

public abstract class FlexibleGridRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected ArrayList<BaseViewItem> mList;

    public FlexibleGridRecyclerAdapter(@NonNull Context ctx,
                                       @NonNull RecyclerView recyclerView,
                                       @NonNull ArrayList<BaseViewItem> itemsList,
                                       int headerResourceId,
                                       int itemResourceId) {

        // Lay out headerItem full width, otherwise use the default spanCount.
        final FlexibleGridLayoutManager layoutManager = (FlexibleGridLayoutManager) recyclerView.getLayoutManager();
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return isHeaderItem(position) ? layoutManager.getSpanCount() : 1;
            }
        });

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
        return mList.get(position).getItemType() == BaseViewItem.TYPE_HEADER;
    }
}
