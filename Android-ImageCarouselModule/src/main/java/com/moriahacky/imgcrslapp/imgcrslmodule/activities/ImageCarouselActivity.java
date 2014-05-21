package com.moriahacky.imgcrslapp.imgcrslmodule.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.GridView;

import com.moriahacky.imgcrslapp.imgcrslmodule.ImageDataSource;
import com.moriahacky.imgcrslapp.imgcrslmodule.R;

import java.util.List;

public class ImageCarouselActivity
    extends FragmentActivity {

    private List<ImageDataSource> _suppliedImages;
    private GridView _grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_carousel);

        _suppliedImages = getIntent().getParcelableArrayListExtra(ImageDataSource.KEY_IMGDS_LIST);

        _grid = (GridView) findViewById(R.id.com_moriahacky_imgcrslapp_imgcrslmodule_grid);
        _grid.setAdapter(new ImageAdapter(ImageCarouselActivity.this, _suppliedImages));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
