package com.moriahacky.imgcrslapp.imgcrslmodule.activities;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.moriahacky.imgcrslapp.imgcrslmodule.ImageDataSource;
import com.moriahacky.imgcrslapp.imgcrslmodule.R;

import java.util.List;

public class ImageAdapter
    extends BaseAdapter {

    private List<ImageDataSource> _suppliedImages;
    private Context _context;

    ImageAdapter(Context context, List<ImageDataSource> suppliedImages) {
        _suppliedImages = suppliedImages;
        _context = context;
    }

    @Override
    public int getCount() {
        return _suppliedImages.size();
    }

    @Override
    public ImageDataSource getItem(int position) {
        return _suppliedImages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) _context).getLayoutInflater()
                                               .inflate(R.layout.grid_item, parent, false);
        }

        return convertView;
    }
}
