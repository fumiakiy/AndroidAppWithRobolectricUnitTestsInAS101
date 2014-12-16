package com.luckypines.android.myapplication.test;


import android.widget.Button;
import android.widget.TextView;

import com.luckypines.android.myapplication.MainActivity;
import com.luckypines.android.myapplication.R;

import org.assertj.core.api.Assertions;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk = 18, libraries = {"../../build/intermediates/exploded-aar/com.android.support/appcompat-v7/21.0.3"}, manifest = "../app/src/main/AndroidManifest.xml")
public class ApplicationTest {
    @Test
    public void shouldHaveApplicationName() throws Exception {
        String appName = Robolectric.getShadowApplication().getString(R.string.app_name);
        Assert.assertThat(appName, CoreMatchers.equalTo("My Application"));
    }

    public void defaultTextViewHasHelloWorld() throws Exception {
        MainActivity mainActivity = Robolectric.buildActivity(MainActivity.class).create().start().resume().get();
        TextView textView1 = (TextView)mainActivity.findViewById(R.id.textView1);
        Assertions.assertThat(textView1.getText()).isEqualTo(mainActivity.getString(R.string.hello_world));
    }

    public void clickingButtonChangesText() throws Exception {
        MainActivity mainActivity = Robolectric.buildActivity(MainActivity.class).create().start().resume().get();
        Button button1 = (Button)mainActivity.findViewById(R.id.button1);
        button1.performClick();
        TextView textView1 = (TextView)mainActivity.findViewById(R.id.textView1);
        Assertions.assertThat(textView1.getText()).isEqualTo(mainActivity.getString(R.string.nice_click));
    }
}