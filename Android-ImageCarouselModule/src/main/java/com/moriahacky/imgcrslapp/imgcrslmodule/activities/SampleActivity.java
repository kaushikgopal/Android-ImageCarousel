package com.moriahacky.imgcrslapp.imgcrslmodule.activities;

import android.os.Bundle;

import com.moriahacky.imgcrslapp.imgcrslmodule.BaseActivity;
import com.moriahacky.imgcrslapp.imgcrslmodule.R;
import com.moriahacky.imgcrslapp.imgcrslmodule.pojos.SamplePojo;

public class SampleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
    }

    private void someMethodToIncludeAPojo() {
        SamplePojo tester = new SamplePojo();
        tester.someMethod();
    }
}
