package com.example.simplechucknorris.di;

import com.example.simplechucknorris.model.NetworkConnection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ModuleNetworkConnection {

    @Provides
    @Singleton
    NetworkConnection getNetworkConnection(Retrofit retrofit){
        return new NetworkConnection(retrofit);
    }

    @Provides
    @Singleton
    Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("http://api.icndb.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
