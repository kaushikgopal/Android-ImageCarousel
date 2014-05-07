package com.moriahacky.imgcrslapp.imgcrslmodule;

public class ImageDataSource {

    public static enum ImageType {DRAWABLE, URL}

    private String _title, _value;
    private ImageType _type;

    public void setTitle(String title) {
        _title = title;
    }

    public void setValue(String value) {
        _value = value;
    }

    public void setType(ImageType type) {
        _type = type;
    }

    public String getTitle() {
        return _title;
    }

    public String getValue() {
        return _value;
    }

    public ImageType getType() {
        return _type;
    }
}
