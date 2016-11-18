package eu.kulenski.android.ossmobui.model;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * Created by Tsvetan.Kulenski on 17.11.2016 г..
 */

public class MainNotificationsViewItem extends ViewItem {
    public String title;

    public MainNotificationsViewItem(@NonNull String title) {
        this.title = title;
    }

    @Override
    public int getItemType() {
        return ViewItem.FULL_WIDTH;
    }
}
