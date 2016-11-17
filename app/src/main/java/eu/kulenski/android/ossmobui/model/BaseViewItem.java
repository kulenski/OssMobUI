package eu.kulenski.android.ossmobui.model;

/**
 * Created by Tsvetan.Kulenski on 17.11.2016 г..
 */

public abstract class BaseViewItem {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ITEM = 1;
    public abstract int getItemType();
    //public abstract int getLayoutId();
}
