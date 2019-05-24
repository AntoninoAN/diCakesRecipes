package com.example.simplechucknorris.presenter;

import com.example.simplechucknorris.model.NetworkConnection;
import com.example.simplechucknorris.view.ViewContract;

import javax.inject.Inject;

public class Presenter implements PresenterContract {

    ViewContract view;
    NetworkConnection networkConnection;

    @Inject
    public Presenter(NetworkConnection networkConnection){
        this.networkConnection = networkConnection;
    }

    @Override
    public void bind(ViewContract view) {
        this.view = view;
        networkConnection.initPresenterContract(this);
    }

    @Override
    public void unBind() {
        view = null;
    }

    @Override
    public void sendJoke(String joke) {
        view.populateJoke(joke);
    }

    @Override
    public void onError(String message) {
        view.populateError(message);
    }

    @Override
    public void getMeAJoke() {
        networkConnection.initNetworkCall();
    }
}
