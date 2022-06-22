package com.example.larios;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    ImageView img;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Intent que tarda 2000 milis para hacer el efecto de que está cargando la pantalla.*/
        img = findViewById(R.id.larios);
        img.animate().alpha(4000).setDuration(0);

        handler = new Handler();
        handler.postDelayed(() -> {
            Intent dap = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(dap);
            finish();
        },2000);
    }
}