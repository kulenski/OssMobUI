package eu.kulenski.android.ossmobui.activity.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import eu.kulenski.android.ossmobui.R;

/**
 * Created by Tsvetan.Kulenski on 4.11.2016 г..
 */

public class NetworkMenuAdapter extends RecyclerView.Adapter<NetworkMenuAdapter.ViewHolder> {

    private ArrayList<SectionItem> mDataset;
    private Context mContext;

    public NetworkMenuAdapter(Context ctx) {
        ArrayList<SectionItem> dataset = new ArrayList<>();

        SectionItem common = new SectionItem("Общи",null);
        common.add(new SectionSubItem("Дървовидно търсене","Дървовидно търсене","ACTION"))
                .add(new SectionSubItem("Карта","Карта","ACTION"))
                .add(new SectionSubItem("Сканирай","Сканирай","ACTION"))
                .add(new SectionSubItem("Създаване на CI","Създаване на CI","ACTION"))
                .add(new SectionSubItem("Бързо търсене","Бързо търсене","ACTION"));

        SectionItem opticalNetwork = new SectionItem("Оптична мрежа",null);
        opticalNetwork.add(new SectionSubItem("Търсене","Търсене","ACTION"))
                .add(new SectionSubItem("Създаване","Създаване","ACTION"));

        SectionItem ductNetwork = new SectionItem("Канална мрежа",null);
        ductNetwork.add(new SectionSubItem("Търсене","Търсене","ACTION"))
                .add(new SectionSubItem("Създаване","Създаване","ACTION"));

        SectionItem locations = new SectionItem("Сгради",null);
        locations.add(new SectionSubItem("Търсене","Търсене","ACTION"))
                .add(new SectionSubItem("Създаване","Създаване","ACTION"));

        dataset.add(common);
        dataset.add(opticalNetwork);
        dataset.add(ductNetwork);
        dataset.add(locations);

        this.mDataset = dataset;
        this.mContext = ctx;
    }

    public NetworkMenuAdapter(ArrayList<SectionItem> dataset) {
        if(dataset == null) throw new IllegalArgumentException("");
        this.mDataset = dataset;
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
        ArrayList<SectionSubItem> mSubItems = mCurrentItem.GetSubItems();
        SectionSubItemAdapter mAdapter = new SectionSubItemAdapter(mSubItems,mContext);

        holder.mTitle.setText(mCurrentItem.getName());
        holder.mGrid.setAdapter(mAdapter);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    /*
     * Adapter model classes
     */

    private class SectionItem {
        private int mId;
        private String mName;
        private ArrayList<SectionSubItem> mSubItems = new ArrayList<>();

        public SectionItem(String name ,ArrayList<SectionSubItem> list) {
            if(list != null) {
                this.mSubItems = list;
            }

            if(name == null) {
                this.mName = "Untitled";
            } else {
                this.mName = name;
            }

        }

        public ArrayList<SectionSubItem> GetSubItems() { return this.mSubItems; }

//        public SectionSubItem GetSubItemByName(String name) {
//            if(this.mSubItems != null) {
//                for (int i = 0; i < this.mSubItems.size(); i++) {
//                    SectionSubItem mCurrent = this.mSubItems.get(i);
//                    if (mCurrent.getName().equals(name)) return mCurrent;
//                }
//            }
//
//            return null;
//        }
//
//        public int GetSubItemsCount() {
//            return this.mSubItems != null ? this.mSubItems.size() : 0;
//        }

        public SectionItem add(SectionSubItem item) {
            if( item != null ) this.mSubItems.add(item);
            return this;
        }

        public String getName() {return this.mName; }
    }

    private class SectionSubItem {
        private final String NOT_INITIALIZED = "SectionSubItem constructor not properly initialized!";
        private int mId;
        private String mName;
        private String mDescription;
        private String mAction;

        SectionSubItem(String name, String description, String action) {
            if(name == null || description == null || action == null )
                throw  new IllegalArgumentException(this.NOT_INITIALIZED);
            this.mId = 0;
            this.mName = name;
            this.mDescription = description;
            this.mAction = action;
        }

        int getId() {return this.mId; }
        String getName() {return this.mName; }
        String getDescription() {return this.mDescription; }
        String getAction() { return this.mAction; }
    }

    private class SectionSubItemAdapter extends BaseAdapter {

        private ArrayList<SectionSubItem> mList;
        private Context mContext;

        SectionSubItemAdapter(ArrayList<SectionSubItem> list, Context ctx) {
            this.mList = list;
            this.mContext = ctx;
        }

        @Override
        public int getCount() {
            return mList != null ? mList.size() : 0;
        }

        @Override
        public Object getItem(int position) {
            return  mList != null ? mList.get(position) : null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_grid_item_template, null);
            }

            TextView mTitle = (TextView) convertView.findViewById(R.id.title);
            mTitle.setText(mList.get(position).getName());

            convertView.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           Toast.makeText(mContext,"blabla", Toast.LENGTH_SHORT).show();
                       }
                   }
            );

            return convertView;
        }
    }

}
