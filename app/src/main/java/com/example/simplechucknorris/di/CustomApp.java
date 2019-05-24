package com.example.simplechucknorris.di;

import android.app.Application;

public class CustomApp extends Application {
    public JokeComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerJokeComponent.builder()
                .build();
    }

    public JokeComponent getComponent(){
        return component;
    }
}
