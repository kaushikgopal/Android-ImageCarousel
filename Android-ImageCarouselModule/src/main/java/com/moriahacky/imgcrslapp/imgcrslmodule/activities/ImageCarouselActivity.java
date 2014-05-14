package com.moriahacky.imgcrslapp.imgcrslmodule.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.moriahacky.imgcrslapp.imgcrslmodule.R;

public class ImageCarouselActivity
    extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_carousel);
    }
}
