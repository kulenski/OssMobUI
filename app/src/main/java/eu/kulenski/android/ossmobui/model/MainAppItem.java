package eu.kulenski.android.ossmobui.model;

import android.support.annotation.NonNull;

/**
 * Created by Tsvetan.Kulenski on 17.11.2016 г..
 */

public class MainAppItem extends BasePlainItem {
    public String title;
    public String description;
    public int iconResourceId;
    public String action;

    public MainAppItem(@NonNull String title, @NonNull String description, int iconResourceId, @NonNull String action) {
        if(iconResourceId < 0) iconResourceId = 0;
        this.title = title;
        this.description = description;
        this.iconResourceId = iconResourceId;
        this.action = action;
    }
}
