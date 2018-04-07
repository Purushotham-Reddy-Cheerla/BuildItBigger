package com.passion.poras.builditbigger;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.displayjokeandroid.DisplayJokeActivity;
import com.example.javajoketeller.JokeTeller;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivityFragment extends Fragment implements EndpointsAsyncTask.CallbackInterface {

    public MainActivityFragment() {
    }

    private ProgressBar mPb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mPb = view.findViewById(R.id.pb);
        AdView mAdView = (AdView) view.findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        Button btn = view.findViewById(R.id.tellJokeButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPb.setVisibility(View.VISIBLE);
                displayJoke();
            }
        });
        return view;
    }

    public void displayJoke() {
        new EndpointsAsyncTask(MainActivityFragment.this).execute();
    }

    @Override
    public void onJokeLoaded(String joke) {
        mPb.setVisibility(View.GONE );
        Intent intent = new Intent(getActivity(), DisplayJokeActivity.class);
        intent.putExtra(DisplayJokeActivity.JOKE_EXTRA, joke);
        startActivity(intent);
    }
}
