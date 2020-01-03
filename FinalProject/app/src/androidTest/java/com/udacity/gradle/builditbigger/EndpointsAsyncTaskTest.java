package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest extends InstrumentationTestCase {

	@Rule
	public final ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

	@Test
	public void testNonEmptyJoke() {

		String result = null;
		EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask() {
			@Override
			protected void onPostExecute(String result) {
				//do nothing
			}
		};
		endpointsAsyncTask.execute(InstrumentationRegistry.getContext());
		try {
			result = endpointsAsyncTask.get();
			Log.d("EndpointsAsyncTaskTest", "Retrieved a non-empty string successfully: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(result);
	}

}
