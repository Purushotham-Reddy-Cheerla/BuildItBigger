package com.passion.poras.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

@RunWith(AndroidJUnit4.class)
public class EndPointAsyncTaskTest implements EndpointsAsyncTask.CallbackInterface {

    private final CountDownLatch mCount = new CountDownLatch(1);

    @Override
    public void onJokeLoaded(String joke) {
        assertTrue(joke != null);
        mCount.countDown();
    }

    @Test
    public void testIfJokeReceived() {
        new EndpointsAsyncTask(this).execute();
        try {
            boolean jokeReceived = mCount.await(8, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail("Did not receive a Joke");
        }
    }

}
