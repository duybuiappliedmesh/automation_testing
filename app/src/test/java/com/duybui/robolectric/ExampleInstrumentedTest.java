package com.duybui.robolectric;

import android.content.Context;
import android.os.Build;
import android.widget.TextView;

import androidx.test.platform.app.InstrumentationRegistry;

import com.duybui.appium.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.O_MR1)
public class ExampleInstrumentedTest {
    MainActivity activity;

    @Before
    public void setUp() {
        activity = Robolectric.buildActivity(MainActivity.class).create().resume().get();
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.duybui.robolectric", appContext.getPackageName());
    }

    @Test
    public void checkingTextView() {
        TextView tvText = activity.findViewById(R.id.tvText);

        assertEquals("Hello World!", tvText.getText().toString());
    }
}
