package com.example.rohit.retrofitdemoandroid.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.rohit.retrofitdemoandroid.R;
import com.example.rohit.retrofitdemoandroid.adapter.MoviesAdapter;
import com.example.rohit.retrofitdemoandroid.model.Movie;
import com.example.rohit.retrofitdemoandroid.model.MoviesResponse;
import com.example.rohit.retrofitdemoandroid.rest.ApiClient;
import com.example.rohit.retrofitdemoandroid.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = MainActivity.class.getSimpleName();

    // TODO - insert your themoviedb.org API KEY here
    private final static String API_KEY = "2ba007ba2b79dc96fd2e0a2150bdd3ed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
            return;
        }
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MoviesResponse> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse>call, Response<MoviesResponse> response) {

                int statusCode = response.code();
                List<Movie> movies = response.body().getResults();
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
                Log.d(TAG, "Number of movies received: " + movies.size());
            }

            @Override
            public void onFailure(Call<MoviesResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }

}
