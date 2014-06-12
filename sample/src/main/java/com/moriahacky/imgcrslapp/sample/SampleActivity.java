package com.moriahacky.imgcrslapp.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.moriahacky.imgcrslapp.imgcrslmodule.ImageDataSource;
import com.moriahacky.imgcrslapp.imgcrslmodule.activities.ImageCarouselActivity;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class SampleActivity
    extends ActionBarActivity {

    ArrayList<ImageDataSource> _images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        ButterKnife.inject(this);

        addSampleImages();
        // build a list of imagedatasources
        // launch library with this list
    }


    @OnClick(R.id.btn_launch_carousel)
    public void onButtonPress() {
        Bundle extras = new Bundle();
        extras.putParcelableArrayList(ImageDataSource.KEY_IMGDS_LIST, _images);

        Intent openCarouselIntent = new Intent(SampleActivity.this, ImageCarouselActivity.class);
        openCarouselIntent.putExtras(extras);
        startActivity(openCarouselIntent);

    }

    @OnLongClick(R.id.btn_launch_carousel)
    public boolean onButtonLongPress() {
        Toast.makeText(SampleActivity.this, "Loooooooong", Toast.LENGTH_SHORT).show();
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sample, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void addSampleImages() {
        _images = new ArrayList<ImageDataSource>();
        ImageDataSource src = new ImageDataSource(ImageDataSource.ImageType.URL,
                                                  "https://lh3.googleusercontent.com/-tUnSh4hL1b0/AAAAAAAAAAI/AAAAAAAAjNI/QVV1JIzbIAo/photo.jpg",
                                                  "IMG 1 - Android");
        _images.add(src);
        src = new ImageDataSource(ImageDataSource.ImageType.URL,
                                  "http://chinesemartialstudies.files.wordpress.com/2013/07/bruce-lee-gloves.jpg",
                                  "IMG 2 - Bruce Lee");
        _images.add(src);
        src = new ImageDataSource(ImageDataSource.ImageType.URL,
                                  "http://devops.com/wp-content/uploads/2014/03/Chuck-Norris-Card-1.jpg",
                                  "IMG 3 - ChuckNorris");
        _images.add(src);
        src = new ImageDataSource(ImageDataSource.ImageType.DRAWABLE,
                                  R.drawable.rajni,
                                  "IMG 4 - Rajni");
        _images.add(src);
        src = new ImageDataSource(ImageDataSource.ImageType.URL,
                                  "http://chinesemartialstudies.files.wordpress.com/2013/07/bruce-lee-gloves.jpg",
                                  "IMG 2 - Bruce Lee");
        _images.add(src);
        src = new ImageDataSource(ImageDataSource.ImageType.URL,
                                  "http://devops.com/wp-content/uploads/2014/03/Chuck-Norris-Card-1.jpg",
                                  "IMG 3 - ChuckNorris");
        _images.add(src);
        src = new ImageDataSource(ImageDataSource.ImageType.DRAWABLE,
                                  R.drawable.rajni,
                                  "IMG 4 - Rajni");
        _images.add(src);
        src = new ImageDataSource(ImageDataSource.ImageType.URL,
                                  "http://chinesemartialstudies.files.wordpress.com/2013/07/bruce-lee-gloves.jpg",
                                  "IMG 2 - Bruce Lee");
        _images.add(src);
        src = new ImageDataSource(ImageDataSource.ImageType.URL,
                                  "http://devops.com/wp-content/uploads/2014/03/Chuck-Norris-Card-1.jpg",
                                  "IMG 3 - ChuckNorris");
        _images.add(src);
        src = new ImageDataSource(ImageDataSource.ImageType.DRAWABLE,
                                  R.drawable.rajni,
                                  "IMG 4 - Rajni");
        _images.add(src);
        src = new ImageDataSource(ImageDataSource.ImageType.URL,
                                  "http://chinesemartialstudies.files.wordpress.com/2013/07/bruce-lee-gloves.jpg",
                                  "IMG 2 - Bruce Lee");
        _images.add(src);
        src = new ImageDataSource(ImageDataSource.ImageType.URL,
                                  "http://devops.com/wp-content/uploads/2014/03/Chuck-Norris-Card-1.jpg",
                                  "IMG 3 - ChuckNorris");
        _images.add(src);
        src = new ImageDataSource(ImageDataSource.ImageType.DRAWABLE,
                                  R.drawable.rajni,
                                  "IMG 4 - Rajni");
        _images.add(src);
    }
}
