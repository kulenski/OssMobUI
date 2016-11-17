package eu.kulenski.android.ossmobui.viewmodel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import eu.kulenski.android.ossmobui.R;

/**
 * Created by Tsvetan.Kulenski on 17.11.2016 г..
 */

public class CardAppViewHolder extends BaseItemViewHolder {

    private Context mContext;

    public TextView title;
    public TextView description;
    public ImageView icon;
    public CardView wrapper;
    public View view;

    public CardAppViewHolder(View itemView, Context ctx) {
        super(itemView);
        mContext = ctx;

        view = itemView;

        title = (TextView) itemView.findViewById(R.id.title);
        description = (TextView) itemView.findViewById(R.id.description);
        icon = (ImageView) itemView.findViewById(R.id.icon);
        wrapper = (CardView) itemView.findViewById(R.id.wrapper);

    }
}
