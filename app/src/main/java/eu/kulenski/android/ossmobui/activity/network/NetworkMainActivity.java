package eu.kulenski.android.ossmobui.activity.network;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

        SectionItem common = new SectionItem("Общи",null);
        common.add(new SectionSubItem("Дървовидно търсене","Дървовидно търсене"))
                .add(new SectionSubItem("Карта","eu.kulenski.android.ossmobui.activity.LoginActivity"))
                .add(new SectionSubItem("Сканирай","Сканирай"))
                .add(new SectionSubItem("Създаване на CI","Създаване на CI"))
                .add(new SectionSubItem("Бързо търсене","Бързо търсене"));

        SectionItem opticalNetwork = new SectionItem("Оптична мрежа",null);
        opticalNetwork.add(new SectionSubItem("Търсене","Търсене"))
                .add(new SectionSubItem("Създаване","Създаване"));

        SectionItem ductNetwork = new SectionItem("Канална мрежа",null);
        ductNetwork.add(new SectionSubItem("Търсене","Търсене"))
                .add(new SectionSubItem("Създаване","Създаване"));

        SectionItem locations = new SectionItem("Сгради",null);
        locations.add(new SectionSubItem("Търсене","Търсене"))
                .add(new SectionSubItem("Създаване","Създаване"));

        mDataSet.add(common);
        mDataSet.add(opticalNetwork);
        mDataSet.add(ductNetwork);
        mDataSet.add(locations);

        this.mAdapter = new NetworkMenuAdapter(this,mDataSet);
    }



}
