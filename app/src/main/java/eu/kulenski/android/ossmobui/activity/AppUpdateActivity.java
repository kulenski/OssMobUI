package eu.kulenski.android.ossmobui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import eu.kulenski.android.ossmobui.R;
import eu.kulenski.android.ossmobui.activity.network.*;

public class AppUpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appupdate);

        ImageView mUpdateIcon = (ImageView)findViewById(R.id.update_icon);
        mUpdateIcon.startAnimation(AnimationUtils.loadAnimation(this,R.anim.rotate_animation));

        final Context mContext = this;

        mUpdateIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, MainActivity.class));
            }
        });
    }
}
