package eu.kulenski.android.ossmobui.model;

/**
 * Created by Tsvetan.Kulenski on 18.11.2016 г..
 */

public  abstract class ViewItem {
    public static final int FULL_WIDTH = 0;
    public static final int FLEXIBLE = 1;

    public abstract int getItemType();
}
