package com.example.displayjokeandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    public static final String JOKE_EXTRA = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        String mJoke = getIntent().getStringExtra(JOKE_EXTRA);
        TextView mJokeTv = findViewById(R.id.tvJoke);

        if (getIntent() != null && mJoke != null) {
            mJokeTv.setText(mJoke);
        } else {
            mJokeTv.setText("Ahh No Jokes yet!!. Gotta find a joke :)");
        }
    }
}
