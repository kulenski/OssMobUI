package eu.kulenski.android.ossmobui.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Timer;

import eu.kulenski.android.ossmobui.R;

public class StartupActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView mLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        mLogo = (ImageView) findViewById(R.id.icon);
        mLogo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.icon) {
            // go to next activity on logo click
            Intent mIntent = new Intent(this,AppUpdateActivity.class);
            startActivity(mIntent);
        }
    }
}
