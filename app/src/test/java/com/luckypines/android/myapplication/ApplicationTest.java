package com.luckypines.android.myapplication;


import android.widget.TextView;

import org.assertj.android.api.Assertions;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk = 18)
public class ApplicationTest {
    @Test
    public void shouldHaveApplicationName() throws Exception {
        String appName = Robolectric.getShadowApplication().getString(R.string.app_name);
        Assert.assertThat(appName, CoreMatchers.equalTo("My Application"));
    }

    public void defaultTextViewHasHelloWorld() throws Exception {
        MainActivity mainActivity = Robolectric.buildActivity(MainActivity.class).create().start().resume().get();
        TextView textView1 = (TextView)mainActivity.findViewById(R.id.textView1);
        Assertions.assertThat(textView1).hasText(R.string.hello_world);
    }
}