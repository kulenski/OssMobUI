package eu.kulenski.android.ossmobui.adapters;

/**
 * Created by kulenski on 4.11.2016 г..
 */

public class SectionSubItem {
    private final String NOT_INITIALIZED = "SectionSubItem constructor not properly initialized!";
    private int mId;
    private String mName;
    private String mAction;

    public SectionSubItem(String name, String action) {
        if(name == null || action == null )
            throw  new IllegalArgumentException(this.NOT_INITIALIZED);
        this.mId = 0;
        this.mName = name;
        this.mAction = action;
    }

    int getId() {return this.mId; }
    String getName() {return this.mName; }
    String getAction() { return this.mAction; }
}
