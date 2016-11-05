package eu.kulenski.android.ossmobui.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import eu.kulenski.android.ossmobui.R;

/**
 * Created by kulenski on 4.11.2016 г..
 */

public class SectionSubItemAdapter extends BaseAdapter {
    private ArrayList<SectionSubItem> mList;
    private Context mContext;
    private final String ACTION_NOT_SUPPORTED = " функция не е налична!";

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
                                               performAction(mList.get(position).getAction(),mList.get(position).getName(), v);
                                           }
                                       }
        );

        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showHelperDialog(mList.get(position).getName(),mList.get(position).getDescription());
                return false;
            }
        });

        return convertView;
    }


    private void performAction(String actionClass,String name, View parentView) {
        try {
            Class mClass = Class.forName(actionClass);
            Intent mIntent = new Intent(mContext,mClass);
            mContext.startActivity(mIntent);
        } catch(ClassNotFoundException e) {
            String message = "'" +name+ "'" + this.ACTION_NOT_SUPPORTED;
            Snackbar.make(parentView,message,Snackbar.LENGTH_LONG).show();
        }

    }

    private void showHelperDialog(String title, String message) {
        String finalMessage = message != null ? message : "Няма допълнително описание за тази функция.";

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(finalMessage);

        alertDialogBuilder.setPositiveButton("ДОБРЕ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int arg1) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}
