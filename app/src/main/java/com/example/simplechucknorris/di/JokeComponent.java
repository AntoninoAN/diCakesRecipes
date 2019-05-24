package com.example.simplechucknorris.di;

import com.example.simplechucknorris.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ModuleNetworkConnection.class,
                ModulePresenter.class
        }
)
public interface JokeComponent {
    void inject(MainActivity activity);
}
