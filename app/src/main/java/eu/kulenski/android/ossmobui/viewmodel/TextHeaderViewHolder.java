package eu.kulenski.android.ossmobui.viewmodel;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import eu.kulenski.android.ossmobui.R;

/**
 * Created by Tsvetan.Kulenski on 17.11.2016 г..
 */

public class TextHeaderViewHolder extends BaseHeaderViewHolder {
    private Context mContext;
    public TextView title;
    public View view;

    public TextHeaderViewHolder(View itemView, Context ctx) {
        super(itemView);
        view = itemView;
        mContext = ctx;
        title = (TextView) itemView.findViewById(R.id.title);
    }
}
