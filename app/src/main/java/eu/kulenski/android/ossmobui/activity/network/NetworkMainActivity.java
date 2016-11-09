package eu.kulenski.android.ossmobui.activity.network;
// this is a test

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

import eu.kulenski.android.ossmobui.R;
import eu.kulenski.android.ossmobui.adapters.NetworkMenuAdapter;
import eu.kulenski.android.ossmobui.adapters.SectionItem;
import eu.kulenski.android.ossmobui.adapters.SectionSubItem;

public class NetworkMainActivity extends AppCompatActivity {

    private NetworkMenuAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        prepareAdapter();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(mAdapter);
    }


    private void prepareAdapter() {
        ArrayList<SectionItem> mDataSet = new ArrayList<>();

        /*
         * SectionItem is used as a wrapper for subitems.
         * SectionItem have 3 params: Name (title), Background (specified as resource's name) and List of subitems.
         *
         * SectionSubItem's are the icons inside a section. They have 3 params:
         * - Title, Action (specified with a class' name), Description - which is displayed on LongClick.
         */
        SectionItem common = new SectionItem("Общи","network_common_tile_background",null);
        common.add(new SectionSubItem("Дървовидно търсене","Дървовидно търсене","Използва се за търсене на елементи чрез разгъване от дърво."))
                .add(new SectionSubItem("Карта","eu.kulenski.android.ossmobui.activity.LoginActivity",null))
                .add(new SectionSubItem("Сканирай","Сканирай","Използва се за търсене на елемент чрез сканиране на баркод."))
                .add(new SectionSubItem("Създаване на CI","Създаване на CI", null))
                .add(new SectionSubItem("Бързо търсене","Бързо търсене", "Представлява подобна на Google търсачка."));

        SectionItem opticalNetwork = new SectionItem("Оптична мрежа","network_optical_network_tile_background",null);
        opticalNetwork.add(new SectionSubItem("Търсене","Търсене",null))
                .add(new SectionSubItem("Създаване","Създаване",null));

        SectionItem ductNetwork = new SectionItem("Канална мрежа","network_duct_network_tile_background",null);
        ductNetwork.add(new SectionSubItem("Търсене","Търсене",null))
                .add(new SectionSubItem("Създаване","Създаване",null));

        SectionItem locations = new SectionItem("Сгради","network_locations_tile_background",null);
        locations.add(new SectionSubItem("Търсене","Търсене",null))
                .add(new SectionSubItem("Създаване","Създаване",null));

        mDataSet.add(common);
        mDataSet.add(opticalNetwork);
        mDataSet.add(ductNetwork);
        mDataSet.add(locations);

        this.mAdapter = new NetworkMenuAdapter(this,mDataSet);
    }



}
