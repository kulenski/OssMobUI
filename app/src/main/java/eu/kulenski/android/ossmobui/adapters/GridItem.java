package eu.kulenski.android.ossmobui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * Created by kulenski on 14.11.2016 г..
 */

public class GridItem {
    public static final int TYPE_HEADER = 1;
    public static final int TYPE_ITEM = 0;
    private static final String TAG = GridItem.class.toString();

    private int mItemType;
    private View mView = null;
    private Context mContext;
    private AttributeSet mAttrSet;

    public GridItem(@NonNull Context ctx, int type, int itemView, @NonNull AttributeSet attrSet) {
        mContext = ctx;
        mItemType = type > 0 ? TYPE_HEADER : TYPE_ITEM;

        if(attrSet.size() <= 0) {
            throw new InvalidParameterException();
        }

        mAttrSet = attrSet;
        inflateLayout(itemView);
    }

    public int getType() {
        return mItemType;
    }

    public View getView() {
        return mView;
    }

    public Attribute getAttribute(String key) {
        return mAttrSet.get(key);
    }

    private void inflateLayout(int resourceId) {
        try {
            mView = LayoutInflater.from(mContext).inflate(resourceId,null);
        } catch (Exception e) {
            Log.d(TAG,"inflateLayout: resourceId is invalid: " + resourceId);
        }
    }

    public class AttributeSet {
        private ArrayList<Attribute> mList;

        public AttributeSet() {
            mList = new ArrayList<>();
        }

        public AttributeSet add(@NonNull String key, @NonNull Object value, int resourceId) {
            Attribute attr = new Attribute();
            attr.key = key;
            attr.value = value;
            attr.resourceId = resourceId;

            mList.add(attr);
            return this;
        }

        public Attribute get(@NonNull String key) {
            if(mList.size() > 0) {
                for (Attribute attr: mList) {
                    if(attr.key.equals(key)) {
                        return attr;
                    }
                }
            }
            return null;
        }

        public int size() {
            return mList.size();
        }
    }

    public class Attribute {
        public String key;
        public Object value;
        public int resourceId;

        public Attribute() {
        }
    }

}
