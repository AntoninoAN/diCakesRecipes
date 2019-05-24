package com.example.simplechucknorris.model;


import com.example.simplechucknorris.presenter.PresenterContract;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NetworkConnection {
    private PresenterContract presenterContract;
    private Retrofit retrofit;

    @Inject
    public NetworkConnection(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    private Callback<JokePojo> callback = new Callback<JokePojo>() {
        @Override
        public void onResponse(Call<JokePojo> call, Response<JokePojo> response) {
            if(response.isSuccessful() && response != null)
                presenterContract.sendJoke(response.body().value.joke);
        }

        @Override
        public void onFailure(Call<JokePojo> call, Throwable t) {
            presenterContract.onError(t.getMessage());
        }
    };

    public void initNetworkCall() {
        retrofit
                .create(JokeApi.class)
                .getJoke()
                .enqueue(callback);
    }

    public void initPresenterContract(PresenterContract presenterContract) {
        this.presenterContract = presenterContract;
    }
}
