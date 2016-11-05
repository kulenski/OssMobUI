package eu.kulenski.android.ossmobui.adapters;

import java.util.ArrayList;

/**
 * Created by kulenski on 4.11.2016 г..
 */

public class SectionItem {

    private String mName;
    private String mBackground;
    private ArrayList<SectionSubItem> mSubItems = new ArrayList<>();

    public SectionItem(String name ,String background ,ArrayList<SectionSubItem> list) {
        if(list != null) {
            this.mSubItems = list;
        }

        this.mName = name;
        this.mBackground = background;
    }

    public ArrayList<SectionSubItem> getSubItems() { return this.mSubItems; }

    public SectionItem add(SectionSubItem item) {
        if( item != null ) this.mSubItems.add(item);
        return this;
    }

    public String getName() {return this.mName; }
    public String getBackground() { return this.mBackground; }
}
