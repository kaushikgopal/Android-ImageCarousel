package com.moriahacky.imgcrslapp.imgcrslmodule.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.moriahacky.imgcrslapp.imgcrslmodule.ImageDataSource;
import com.moriahacky.imgcrslapp.imgcrslmodule.R;
import com.moriahacky.imgcrslapp.imgcrslmodule.SquareImageView;
import com.squareup.picasso.Picasso;

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
            convertView = LayoutInflater.from(_context).inflate(R.layout.grid_item, parent, false);
        }
        _populateContent(getItem(position), (SquareImageView) convertView);
        return convertView;
    }

    private void _populateContent(ImageDataSource imgDs, SquareImageView thumbnail) {
        switch (imgDs.getType()) {
            case URL:
                Picasso.with(_context).load(imgDs.getValue()).into(thumbnail);
                break;

            case URI:
                break;

            case DRAWABLE:
                Picasso.with(_context).load(imgDs.getDrawableValue()).into(thumbnail);
                break;
        }
    }
}
