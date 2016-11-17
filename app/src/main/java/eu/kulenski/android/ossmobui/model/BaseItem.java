package eu.kulenski.android.ossmobui.model;

import android.view.View;

/**
 * Created by Tsvetan.Kulenski on 17.11.2016 г..
 */

public abstract class BaseItem {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ITEM = 1;
    public abstract int getItemType();
}
