package com.passion.poras.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.displayjokeandroid.DisplayJokeActivity;

public class MainActivityFragment extends Fragment implements EndpointsAsyncTask.CallbackInterface {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button btn = root.findViewById(R.id.tellJokeButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayJoke();
            }
        });
        return root;
    }

    public void displayJoke() {
        new EndpointsAsyncTask(MainActivityFragment.this).execute();
    }

    @Override
    public void onJokeLoaded(String joke) {
        Intent intent = new Intent(getActivity(), DisplayJokeActivity.class);
        intent.putExtra(DisplayJokeActivity.JOKE_EXTRA, joke);
        startActivity(intent);
    }
}
