package com.example.jokeviews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

public class JokesActivity extends AppCompatActivity {

	public static final String JOKE = "JOKE";

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jokes_activity);
		String joke = getIntent().getStringExtra(JOKE);
		Snackbar.make(findViewById(R.id.frameLayout), TextUtils.isEmpty(joke) ? "derp" : joke, BaseTransientBottomBar.LENGTH_LONG).show();
	}
}
