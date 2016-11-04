package eu.kulenski.android.ossmobui.activity.network;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import eu.kulenski.android.ossmobui.R;
import eu.kulenski.android.ossmobui.activity.adapters.NetworkMenuAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        NetworkMenuAdapter mAdapter = new NetworkMenuAdapter(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View v) {

    }
}
