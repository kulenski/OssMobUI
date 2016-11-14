package eu.kulenski.android.ossmobui.adapters;

import android.view.View;

/**
 * Created by kulenski on 4.11.2016 г..
 */

public class SectionSubItem {
    private final String NOT_INITIALIZED = "SectionSubItem constructor not properly initialized!";
    private int mId;
    private String mName;
    private String mAction;
    private String mDescription;
    private View mView;

    public SectionSubItem(String name, String action, String description) {
        if(name == null || action == null )
            throw  new IllegalArgumentException(this.NOT_INITIALIZED);
        this.mId = 0;
        this.mName = name;
        this.mAction = action;
        this.mDescription = description;

    }

    int getId() {return this.mId; }
    String getName() {return this.mName; }
    String getAction() { return this.mAction; }
    String getDescription() { return this.mDescription; }
}
