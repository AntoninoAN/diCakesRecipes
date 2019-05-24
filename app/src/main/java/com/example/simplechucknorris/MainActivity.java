package com.example.simplechucknorris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simplechucknorris.di.CustomApp;
import com.example.simplechucknorris.presenter.PresenterContract;
import com.example.simplechucknorris.view.ViewContract;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
    implements ViewContract {

    @Inject
    PresenterContract presenter;
    @BindView(R.id.btn_new_joke)
    Button btn_new_joke;
    @BindView(R.id.tv_jokes)
    TextView tv_joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        ((CustomApp)this.getApplicationContext()).getComponent().inject(this);

        presenter.bind(this);
        presenter.getMeAJoke();
    }

    @Override
    public void populateJoke(String joke) {
        tv_joke.setText(joke);
    }

    @Override
    public void populateError(String message) {
        Toast.makeText(this, message,
                Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_new_joke)
    public void getMeAJoke(){
        presenter.getMeAJoke();
    }
}
