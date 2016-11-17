package eu.kulenski.android.ossmobui.activity.network;
// this is a test

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import eu.kulenski.android.ossmobui.R;
import eu.kulenski.android.ossmobui.adapters.MainMenuAdapter;
import eu.kulenski.android.ossmobui.managers.FlexibleGridLayoutManager;
import eu.kulenski.android.ossmobui.model.BaseItem;
import eu.kulenski.android.ossmobui.model.MainAppItem;
import eu.kulenski.android.ossmobui.model.NetworkAppItem;
import eu.kulenski.android.ossmobui.model.NetworkHeaderItem;

public class NetworkMainActivity extends AppCompatActivity {

    private ArrayList<BaseItem> mList = null;
    private MainMenuAdapter mAdapter = null;
    private FlexibleGridLayoutManager mLayoutManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_main);

        prepareAdapterItems();

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new FlexibleGridLayoutManager(this,getResources().getInteger(R.integer.recycler_subgrid_columns),R.integer.recycler_subgrid_columns);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MainMenuAdapter(getApplicationContext(), mRecyclerView, mList, R.layout.item_network_textheader, R.layout.item_network_appitem);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void generateHeaderItem(@NonNull String title) {
        if(mList == null) mList = new ArrayList<>();
        mList.add(new NetworkHeaderItem(title));
    }

    private void generatePlainItem(@NonNull String title, @NonNull String description, int iconResourceId, String action) {
        if(mList == null) mList = new ArrayList<>();
        mList.add(new MainAppItem(title, description, iconResourceId, action));
    }

    private void prepareAdapterItems() {
        generateHeaderItem("Нямате нови известия");
        generatePlainItem("Мрежата", "Приложения за работа в мрежата",0,"");
        generatePlainItem("История", "Последни действия",0,"");
    }
}
