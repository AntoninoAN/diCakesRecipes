package com.example.simplechucknorris.view;

public interface ViewContract {
    void populateJoke(String joke);
    void populateError(String message);
}
