package com.cysd.pricecontrol;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.cysd.pricecontrol.util.ActivityManager;

public class ImageActivity extends AppCompatActivity {

    private ImageView iv;
    private RelativeLayout rootView;

    private String mImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        iv = findViewById(R.id.iv);
        rootView = findViewById(R.id.rootView);
        mImg = getIntent().getStringExtra("img");
        Glide.with(this).load(mImg).into(iv);
        ActivityManager.addActivity(this);

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
