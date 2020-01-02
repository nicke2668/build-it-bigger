package com.udacity.gradle.builditbigger;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest extends InstrumentationTestCase {

	@Rule
	public final ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

	@Test
	public void testNonEmptyJoke() throws Exception {

		final CountDownLatch signal = new CountDownLatch(1);
		final EndpointsAsyncTask task = new EndpointsAsyncTask() {
			@Override
			protected void onPostExecute(String result) {
				super.onPostExecute(result);
				signal.countDown();
			}

		};

		try {
			runTestOnUiThread(new Runnable() {

				@Override
				public void run() {
					task.execute(InstrumentationRegistry.getInstrumentation().getContext());
				}
			});
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		signal.await(5, TimeUnit.SECONDS);
		Assert.assertFalse(task.get().isEmpty());
	}

}
