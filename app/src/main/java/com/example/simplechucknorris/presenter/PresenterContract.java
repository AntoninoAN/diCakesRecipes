package com.example.simplechucknorris.presenter;

import com.example.simplechucknorris.view.ViewContract;

public interface PresenterContract {
    void bind(ViewContract view);
    void unBind();
    void sendJoke(String joke);
    void onError(String message);
    void getMeAJoke();
}
