package eu.kulenski.android.ossmobui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import eu.kulenski.android.ossmobui.R;

/**
 * Created by kulenski on 4.11.2016 г..
 */

public class SectionSubItemAdapter extends BaseAdapter {
    private ArrayList<SectionSubItem> mList;
    private Context mContext;
    private final String ACTION_NOT_SUPPORTED = "Тази функционалност не е налична!";

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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_grid_item_template, null);
        }

        TextView mTitle = (TextView) convertView.findViewById(R.id.title);
        mTitle.setText(mList.get(position).getName());

        convertView.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               performAction(mList.get(position).getAction(), v);
                                           }
                                       }
        );

        return convertView;
    }


    private void performAction(String actionClass, View parentView) {
        try {
            Class mClass = Class.forName(actionClass);
            Intent mIntent = new Intent(mContext,mClass);
            mContext.startActivity(mIntent);
        } catch(ClassNotFoundException e) {
            Snackbar.make(parentView,this.ACTION_NOT_SUPPORTED,Snackbar.LENGTH_SHORT).show();
            //Toast.makeText(mContext,this.ACTION_NOT_SUPPORTED,Toast.LENGTH_SHORT).show();
        }

    }
}
