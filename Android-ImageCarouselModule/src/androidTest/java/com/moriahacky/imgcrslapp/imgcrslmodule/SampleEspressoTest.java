package com.moriahacky.imgcrslapp.imgcrslmodule;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.moriahacky.imgcrslapp.imgcrslmodule.R;
import com.moriahacky.imgcrslapp.imgcrslmodule.activities.SampleActivity;

import static android.test.ViewAsserts.assertOnScreen;
import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

public class SampleEspressoTest
        extends ActivityInstrumentationTestCase2<SampleActivity> {

    private SampleActivity mActivity;
    private TextView mHelloWorldTextView;

    public SampleEspressoTest() {
        super(SampleActivity.class);
        // The class passed here in the constructor, is the one that the test
        // will start.
    }

    protected void setUp() throws Exception {
        super.setUp();

        // if you want to prep/pass data to the activity, you can do it by
        // the usual intent mechanism.
        // setActivityIntent(new Intent());


        mActivity = getActivity();

        // getActivity() basically launches the activity
        // which in-turn will call it's OnCreate



        mHelloWorldTextView = (TextView) mActivity.findViewById(R.id.txt_sample);
    }

    public void testTextView() {
        assertOnScreen(mActivity.getWindow().getDecorView(), mHelloWorldTextView);
    }

    public void testLabel() {
        onView(withId(R.id.txt_sample)).check(matches(withText("Hello world!")));
    }

    public void testFalseLabel() {
        onView(withId(R.id.txt_sample)).check(matches(withText("What a label!")));
    }
}
