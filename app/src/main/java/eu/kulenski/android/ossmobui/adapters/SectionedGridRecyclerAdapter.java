package eu.kulenski.android.ossmobui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;

import eu.kulenski.android.ossmobui.model.BaseItem;

/**
 * Created by Tsvetan.Kulenski on 17.11.2016 г..
 */

public abstract class SectionedGridRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //protected Context mContext;
    protected ArrayList<BaseItem> mList;

    public SectionedGridRecyclerAdapter(@NonNull Context ctx,
                                        @NonNull RecyclerView recyclerView,
                                        @NonNull ArrayList<BaseItem> itemsList,
                                        int headerResourceId,
                                        int itemResourceId) {

        // Lay out headerItem full width, otherwise use the default spanCount.
        final GridLayoutManager layoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Log.d("BlaBla",mList.get(position).toString());
                return isHeaderItem(position) ? 1 : 3;
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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

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
