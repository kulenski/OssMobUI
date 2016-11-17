package eu.kulenski.android.ossmobui.viewmodel;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import eu.kulenski.android.ossmobui.R;
import eu.kulenski.android.ossmobui.model.BaseHeaderItem;

/**
 * Created by kulenski on 17.11.2016 г..
 */

public class MainNotificationsViewHolder extends BaseHeaderViewHolder {
    public ImageView icon;
    public TextView title;
    private Context mContext;

    public MainNotificationsViewHolder(View itemView, Context ctx ) {
        super(itemView);
        mContext = ctx;
        icon = (ImageView) itemView.findViewById(R.id.icon);
        title = (TextView) itemView.findViewById(R.id.title);
    }
}
