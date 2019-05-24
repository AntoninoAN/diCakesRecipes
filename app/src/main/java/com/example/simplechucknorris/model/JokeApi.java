package com.example.simplechucknorris.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JokeApi {
    @GET("jokes/random")
    Call<JokePojo> getJoke();
}
