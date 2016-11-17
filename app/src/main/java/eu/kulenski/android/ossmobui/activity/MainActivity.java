package eu.kulenski.android.ossmobui.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import eu.kulenski.android.ossmobui.R;
import eu.kulenski.android.ossmobui.adapters.MainMenuAdapter;
import eu.kulenski.android.ossmobui.managers.FlexibleGridLayoutManager;
import eu.kulenski.android.ossmobui.model.BaseViewItem;
import eu.kulenski.android.ossmobui.model.MainAppViewItem;
import eu.kulenski.android.ossmobui.model.MainNotificationsViewItem;
import eu.kulenski.android.ossmobui.model.NetworkAppViewItem;
import eu.kulenski.android.ossmobui.model.NetworkHeaderViewItem;

public class MainActivity extends AppCompatActivity {

    private ArrayList<BaseViewItem> mList = null;
    private MainMenuAdapter mAdapter = null;
    private FlexibleGridLayoutManager mLayoutManager = null;

    private Context mContext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareAdapterItems();

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new FlexibleGridLayoutManager(this,getResources().getInteger(R.integer.recycler_subgrid_columns),R.integer.recycler_subgrid_columns);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MainMenuAdapter(getApplicationContext(), mRecyclerView, mList, R.layout.item_main_notification_bar, R.layout.item_main_appcard);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void generateHeaderItem(@NonNull String title) {
        if(mList == null) mList = new ArrayList<>();
        mList.add(new MainNotificationsViewItem(title));
    }

    private void generatePlainItem(@NonNull String title, @NonNull String description, int iconResourceId, String action) {
        if(mList == null) mList = new ArrayList<>();
        mList.add(new MainAppViewItem(title, description, iconResourceId,action));
    }

    private void prepareAdapterItems() {
        generateHeaderItem("Нямате нови известия");
        generatePlainItem("Мрежата", "Приложения за работа в мрежата",0,"");
        generatePlainItem("История", "Последни действия",0,"");
    }



}
