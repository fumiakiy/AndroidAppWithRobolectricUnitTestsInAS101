package com.luckypines.android.myapplication;


import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ApplicationTest {
    @Test
    public void shouldHaveApplicationName() throws Exception {
        String appName = Robolectric.getShadowApplication().getString(R.string.app_name);
        Assert.assertThat(appName, CoreMatchers.equalTo("My Application"));
    }
}