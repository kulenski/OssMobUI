package eu.kulenski.android.ossmobui.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

import eu.kulenski.android.ossmobui.R;
import eu.kulenski.android.ossmobui.adapters.MainMenuAdapter;
import eu.kulenski.android.ossmobui.model.BaseHeaderItem;
import eu.kulenski.android.ossmobui.model.BaseItem;
import eu.kulenski.android.ossmobui.model.ExampleCardViewPlainItem;
import eu.kulenski.android.ossmobui.model.ExampleTextViewHeaderItem;

public class MainActivity extends AppCompatActivity {

    private ArrayList<BaseItem> mList = null;
    private MainMenuAdapter mAdapter = null;
    private Context mContext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareAdapterItems();

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager( new GridLayoutManager(this,3));

        mAdapter = new MainMenuAdapter(getApplicationContext(), mRecyclerView, mList, R.layout.sample_textheader, R.layout.sample_carditem);

        mRecyclerView.setAdapter(mAdapter);

    }

    private void generateHeaderItem(@NonNull String title) {
        if(mList == null) mList = new ArrayList<>();
        mList.add(new ExampleTextViewHeaderItem(title));
    }

    private void generatePlainItem(@NonNull String title, @NonNull String description, int iconResourceId) {
        if(mList == null) mList = new ArrayList<>();
        mList.add(new ExampleCardViewPlainItem(title, description, iconResourceId));
    }

    private void prepareAdapterItems() {
        generateHeaderItem("Мрежата");
        generatePlainItem("Карта","Бла бла",0);
        generatePlainItem("Бързо търсене", "дъра бъра",0);
        generateHeaderItem("Услуги");
        generatePlainItem("Управление","...",0);
    }
}
