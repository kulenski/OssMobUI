package eu.kulenski.android.ossmobui.model;

import android.support.annotation.NonNull;

/**
 * Created by Tsvetan.Kulenski on 17.11.2016 г..
 */

public class NetworkHeaderViewItem extends BaseHeaderViewItem {
    public String title;

    public NetworkHeaderViewItem(@NonNull String title) {
        this.title = title;
    }
}
