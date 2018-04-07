package com.passion.poras.builditbigger;

import android.os.AsyncTask;

import com.example.purus.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {

    private static MyApi myApiService = null;
    private CallbackInterface mCallback;

    public interface CallbackInterface {
        void onJokeLoaded(String joke);
    }

    EndpointsAsyncTask(CallbackInterface mCallback) {
        this.mCallback = mCallback;
    }

    @Override
    protected String doInBackground(Void... voids) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-200317.appspot.com/_ah/api/");
            myApiService = builder.build();

            try {
                return myApiService.promptJoke().execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        } else {
            try {
                return myApiService.promptJoke().execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        super.onPostExecute(joke);
        mCallback.onJokeLoaded(joke);
    }
}
