package eu.kulenski.android.ossmobui.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import eu.kulenski.android.ossmobui.R;

public class AppUpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appupdate);

        ImageView mUpdateIcon = (ImageView)findViewById(R.id.update_icon);
        mUpdateIcon.startAnimation(AnimationUtils.loadAnimation(this,R.anim.rotate_animation));
    }
}
