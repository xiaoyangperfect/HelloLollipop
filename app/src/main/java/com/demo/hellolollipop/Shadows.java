package com.demo.hellolollipop;

import android.app.Activity;
import android.graphics.Outline;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by yang on 2015/4/15.
 */
public class Shadows extends Activity implements View.OnTouchListener {
    private String TAG = "Shadows";

    private TextView tv;
    private ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadows);

        tv = (TextView) findViewById(R.id.shadows_show);
        img1 = (ImageView) findViewById(R.id.image1);
        img1.setOnTouchListener(this);

        ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int size = getResources().getDimensionPixelSize(R.dimen.fab_size);
                outline.setOval(0, 0, size, size);
            }
        };
        tv.setOutlineProvider(viewOutlineProvider);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:

                view.setTranslationZ(120);
                Log.d(TAG, "action down" + view.getTranslationZ());
                break;
            case MotionEvent.ACTION_UP:

                view.setTranslationZ(0);
                Log.d(TAG, "action up" + view.getTranslationZ());
                break;
            default:
                return false;
        }
        return true;
    }
}
