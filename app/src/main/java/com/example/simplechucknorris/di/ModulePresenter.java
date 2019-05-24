package com.example.simplechucknorris.di;

import com.example.simplechucknorris.presenter.Presenter;
import com.example.simplechucknorris.presenter.PresenterContract;

import dagger.Module;
import dagger.Provides;

@Module
public class ModulePresenter {

    @Provides
    PresenterContract getPresenter(Presenter presenter){
        return presenter;
    }
}
