package eu.kulenski.android.ossmobui.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import eu.kulenski.android.ossmobui.model.BaseViewItem;
import eu.kulenski.android.ossmobui.model.NetworkAppViewItem;
import eu.kulenski.android.ossmobui.model.NetworkHeaderViewItem;
import eu.kulenski.android.ossmobui.viewmodel.CardAppViewHolder;
import eu.kulenski.android.ossmobui.viewmodel.TextHeaderViewHolder;

/**
 * Created by kulenski on 17.11.2016 г..
 */

public class NetworkMainMenuAdapter extends FlexibleGridRecyclerAdapter {
    private static final String ACTION_NOT_SUPPORTED = " функция не е достъпна";
    private int mHeaderResourceId;
    private int mItemResourceId;
    private Context mContext;

    public NetworkMainMenuAdapter(@NonNull Context ctx, @NonNull RecyclerView recyclerView,
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
            return new TextHeaderViewHolder(v,mContext);
        } else {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(mItemResourceId, parent, false);
            return new CardAppViewHolder(v,mContext);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Log.d("Bla","Bla");
        if(isHeaderItem(position)) {
            if(mList.get(position) instanceof NetworkHeaderViewItem) {
                ((TextHeaderViewHolder)holder).title.setText(((NetworkHeaderViewItem) mList.get(position)).title);
            }
        } else {
            if(mList.get(position) instanceof NetworkAppViewItem) {
                ((CardAppViewHolder)holder).title.setText(((NetworkAppViewItem) mList.get(position)).title);
                ((CardAppViewHolder)holder).description.setText(((NetworkAppViewItem) mList.get(position)).description);
                //((CardAppViewHolder)holder).icon.setImageResource(((NetworkAppViewItem) mList.get(position)).iconResourceId);

                ((CardAppViewHolder)holder).view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String action = ((NetworkAppViewItem) mList.get(position)).action;
                        String title = ((NetworkAppViewItem) mList.get(position)).title;
                        performAction(action,title,v);
                    }
                });
            }
        }
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
