package eu.kulenski.android.ossmobui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import eu.kulenski.android.ossmobui.R;

/**
 * Created by kulenski on 15.11.2016 г..
 */

public class SectionedGridRecylerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<GridItem> mList;

    public SectionedGridRecylerAdapter(@NonNull ArrayList<GridItem> list, @NonNull RecyclerView recyclerView) {
        mList = list;

        final GridLayoutManager layoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mList.get(position).getType() == GridItem.TYPE_HEADER ? 1 : layoutManager.getSpanCount();
            }
        });
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {

        public TextView title;

        public HeaderViewHolder(View itemView, int titleId) {
            super(itemView);
            title = (TextView) itemView.findViewById(titleId);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public ImageView icon;
        public TextView title;
        public TextView description;

        public ItemViewHolder(View itemView, int titleId, int descId, int iconId) {
            super(itemView);
            title = (TextView) itemView.findViewById(titleId);
            description = (TextView) itemView.findViewById(descId);
            icon = (ImageView) itemView.findViewById(iconId);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == GridItem.TYPE_HEADER) {
            return new HeaderViewHolder(null,0);
        } else {
            return new ItemViewHolder(null,0,0,0);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return mList.get(position).getType();
    }
}
