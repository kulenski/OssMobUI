package eu.kulenski.android.ossmobui.model;

import android.support.annotation.NonNull;

/**
 * Created by Tsvetan.Kulenski on 17.11.2016 г..
 */

public class ExampleCardViewPlainItem extends BasePlainItem {
    public String title;
    public String description;
    public int iconResourceId;

    public ExampleCardViewPlainItem(@NonNull String title, @NonNull String description, int iconResourceId) {
        if(iconResourceId < 0) iconResourceId = 0;
        this.title = title;
        this.description = description;
        this.iconResourceId = iconResourceId;
    }
}
