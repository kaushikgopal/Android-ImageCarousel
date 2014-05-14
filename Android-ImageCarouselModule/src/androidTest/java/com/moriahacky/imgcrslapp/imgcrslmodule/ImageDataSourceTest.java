package com.moriahacky.imgcrslapp.imgcrslmodule;

import android.content.Intent;
import android.os.Bundle;
import android.test.AndroidTestCase;

import static org.fest.assertions.api.Assertions.assertThat;

public class ImageDataSourceTest
    extends AndroidTestCase {

    public void test_ThatImageDataSourceForUrl_IsParcelable() {

        Bundle testBundle = new Bundle();
        testBundle.putParcelable("imageDataSource1",
                                 new ImageDataSource(ImageDataSource.ImageType.URL,
                                                     "https://lh3.googleusercontent.com/-tUnSh4hL1b0/AAAAAAAAAAI/AAAAAAAAjNI/QVV1JIzbIAo/photo.jpg",
                                                     "Test Title")
                                );

        Intent testIntent = new Intent("someAction");
        testIntent.putExtras(testBundle);

        ImageDataSource testSource = testIntent.getParcelableExtra("imageDataSource1");

        assertThat(testSource.getTitle()).isEqualTo("Test Title");
        assertThat(testSource.getValue()).isEqualTo("https://lh3.googleusercontent.com/-tUnSh4hL1b0/AAAAAAAAAAI/AAAAAAAAjNI/QVV1JIzbIAo/photo.jpg");
        assertThat(testSource.getType()).isEqualTo(ImageDataSource.ImageType.URL);
    }

    public void test_ThatImageDataSourceForDrawable_IsParcelable() {

        Bundle testBundle = new Bundle();
        testBundle.putParcelable("imageDataSource1",
                                 new ImageDataSource(ImageDataSource.ImageType.DRAWABLE,
                                                     999,
                                                     "Test Title")
                                );

        Intent testIntent = new Intent("someAction");
        testIntent.putExtras(testBundle);

        ImageDataSource testSource = testIntent.getParcelableExtra("imageDataSource1");

        assertThat(testSource.getTitle()).isEqualTo("Test Title");
        assertThat(testSource.getDrawableValue()).isEqualTo(999);
        assertThat(testSource.getType()).isEqualTo(ImageDataSource.ImageType.DRAWABLE);
    }
}
