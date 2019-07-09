package com.example.retrofirtdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofirtdemo.api.MyRetroClient;
import com.example.retrofirtdemo.model.Sirfollowers;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt);
        getFollwers();
    }

    private void getFollwers(){
        MyRetroClient.api.getFollowers("cmpundhir").enqueue(new Callback<List<Sirfollowers>>() {
            @Override
            public void onResponse(Call<List<Sirfollowers>> call, Response<List<Sirfollowers>> response) {
                List<Sirfollowers> list = response.body();
                Log.d("list_size", list+"");
                txt.setText(list.size()+"");
                Toast.makeText(MainActivity.this, list.size()+"", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Sirfollowers>> call, Throwable t) {
                txt.setText("error : "+t.getMessage());
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
