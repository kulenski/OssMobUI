package eu.kulenski.android.ossmobui.activity.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

/**
 * Created by Tsvetan.Kulenski on 4.11.2016 г..
 */

public class NetworkMenuOnTouchListener implements RecyclerView.OnItemTouchListener {
    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
