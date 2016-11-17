package eu.kulenski.android.ossmobui.managers;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

/**
 * Created by kulenski on 17.11.2016 г..
 *
 * When binding spanCount to a resource we can configure
 * our layout span from XML and have rich customization for
 * different device configurations.
 */

public class FlexibleGridLayoutManager extends GridLayoutManager {

    private static final String TAG = FlexibleGridLayoutManager.class.toString();
    private final boolean DEBUG = false;

    private int mSpanCountResourceId;
    private Context mContext;

    public FlexibleGridLayoutManager(Context context, int defaultSpanCount ,int spanCountResourceId) {
        super(context, defaultSpanCount);
        mContext = context;
        mSpanCountResourceId = spanCountResourceId;
    }

    @Override
    public int getSpanCount() {
        int spanCount = mContext.getResources().getInteger(mSpanCountResourceId);

        if(DEBUG) {
            Log.d(TAG, "spanCount: " + String.valueOf(spanCount));
        }
        return spanCount;
    }
}
