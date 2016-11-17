package eu.kulenski.android.ossmobui.model;

import android.support.annotation.NonNull;

/**
 * Created by Tsvetan.Kulenski on 17.11.2016 г..
 */

public class NetworkHeaderItem extends BaseHeaderItem {
    public String title;

    public NetworkHeaderItem(@NonNull String title) {
        this.title = title;
    }
}
