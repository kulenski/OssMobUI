package eu.kulenski.android.ossmobui.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import eu.kulenski.android.ossmobui.R;
import eu.kulenski.android.ossmobui.activity.network.NetworkMainActivity;

/**
 * Created by kulenski on 17.11.2016 г..
 */

public class MainNotificationsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public ImageView icon;
    public TextView title;
    private Context mContext;


    public MainNotificationsViewHolder(View itemView, Context ctx ) {
        super(itemView);
        mContext = ctx;
        icon = (ImageView) itemView.findViewById(R.id.icon);
        title = (TextView) itemView.findViewById(R.id.title);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent mIntent = new Intent(mContext, NetworkMainActivity.class);
        mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(mIntent);
    }
}
