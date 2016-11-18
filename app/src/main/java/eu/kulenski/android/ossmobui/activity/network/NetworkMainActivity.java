package eu.kulenski.android.ossmobui.activity.network;
// this is a test

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import eu.kulenski.android.ossmobui.R;
import eu.kulenski.android.ossmobui.adapters.NetworkMainMenuAdapter;
import eu.kulenski.android.ossmobui.managers.FlexibleGridLayoutManager;
import eu.kulenski.android.ossmobui.model.NetworkAppViewItem;
import eu.kulenski.android.ossmobui.model.NetworkHeaderViewItem;
import eu.kulenski.android.ossmobui.model.ViewItem;

public class NetworkMainActivity extends AppCompatActivity {

    private static final String TAG = NetworkMainActivity.class.getName();
    private ArrayList<ViewItem> mList = null;
    private NetworkMainMenuAdapter mAdapter = null;
    private FlexibleGridLayoutManager mLayoutManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_main);

        prepareAdapterItems();

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new FlexibleGridLayoutManager(this,getResources().getInteger(R.integer.recycler_subgrid_columns),R.integer.recycler_subgrid_columns);

        try{
            mRecyclerView.setLayoutManager(mLayoutManager);
            mAdapter = new NetworkMainMenuAdapter(getApplicationContext(), mRecyclerView, mList, R.layout.item_network_textheader, R.layout.item_network_appitem);
            mRecyclerView.setAdapter(mAdapter);
        } catch (Exception e) {
            Log.d(TAG, "Error setting LayoutManager");
            e.printStackTrace();
        }

    }

    private void generateHeaderItem(@NonNull String title) {
        if(mList == null) mList = new ArrayList<>();
        mList.add(new NetworkHeaderViewItem(title));
    }

    private void generatePlainItem(@NonNull String title, @NonNull String description, int iconResourceId, String action) {
        if(mList == null) mList = new ArrayList<>();
        mList.add(new NetworkAppViewItem(title, description, iconResourceId, action));
    }

    private void prepareAdapterItems() {
        generateHeaderItem("Общи");
        generatePlainItem("Дървовидно търсене", "Описание",0,"");
        generatePlainItem("Карта","Описание",0,"");
        generatePlainItem("Бързо търсене", "Описание",0,"");
        generatePlainItem("Сканирай баркод", "Описание",0,"");
        generatePlainItem("Създаване на CI", "Описание",0,"");
        generateHeaderItem("Оптична мрежа");
        generatePlainItem("Търсене", "",0,"");
        generatePlainItem("Създаване", "",0,"");
        generateHeaderItem("Канална мрежа");
        generatePlainItem("Търсене", "",0,"");
        generatePlainItem("Създаване", "",0,"");
        generateHeaderItem("Локации");
        generatePlainItem("Търсене", "",0,"");
        generatePlainItem("Създаване", "",0,"");
    }
}
