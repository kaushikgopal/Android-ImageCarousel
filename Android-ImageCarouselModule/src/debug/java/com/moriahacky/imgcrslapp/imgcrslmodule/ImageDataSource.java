package com.moriahacky.imgcrslapp.imgcrslmodule;

import android.os.Parcel;
import android.os.Parcelable;

public class ImageDataSource
    implements Parcelable {

    public static enum ImageType {DRAWABLE, URL}

    private String _title, _value;
    private ImageType _type;

    ImageDataSource(ImageType type, String value) {
        _type = type;
        _value = value;
        _title = "";
    }

    ImageDataSource(ImageType type, String value, String title) {
        _type = type;
        _value = value;
        _title = title;
    }

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

    // -----------------------------------------------------------------------
    // Parcellable impelementation

    public static final Parcelable.Creator<ImageDataSource> CREATOR = new Parcelable.Creator<ImageDataSource>() {

        public ImageDataSource createFromParcel(Parcel in) {
            return new ImageDataSource(in);
        }

        public ImageDataSource[] newArray(int size) {
            return new ImageDataSource[size];
        }
    };

    private ImageDataSource(Parcel in) {
        this._type = Enum.valueOf(ImageType.class, in.readString());
        this._value = in.readString();
        this._title = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(_type.toString());
        out.writeString(_value);
        out.writeString(_title);
    }
}
