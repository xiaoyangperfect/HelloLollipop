package com.demo.hellolollipop;

import android.animation.Animator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

/**
 * Created by yang on 2015/4/15.
 */
public class AnimationShow extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aniamtion);

        final ImageView img = (ImageView) findViewById(R.id.animation_circle);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animator animator = ViewAnimationUtils.createCircularReveal(
                        img,
                        img.getWidth() / 2,
                        img.getHeight() / 2,
                        img.getWidth(),
                        0);
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.setDuration(2000);
                animator.start();
            }
        });

        final ImageView img2 = (ImageView) findViewById(R.id.animation_circle2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animator animator = ViewAnimationUtils.createCircularReveal(
                        img2,
                        0,
                        0,
                        0,
                        (float) Math.hypot(img2.getWidth(), img2.getHeight()));
                animator.setInterpolator(new AccelerateInterpolator());
                animator.setDuration(2000);
                animator.start();
            }
        });
    }
}
