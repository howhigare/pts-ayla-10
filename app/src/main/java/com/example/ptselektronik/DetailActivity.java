package com.example.ptselektronik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.ptselektronik.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        String title = intent.getStringExtra("things_name");
        String harga = intent.getStringExtra("things_price");
        int poster = intent.getIntExtra("things_poster", R.drawable.airfryer);
        String desc = intent.getStringExtra("things_description");

        Log.d("DESC", desc);
        binding.thingsName.setText(title);
        binding.thingsPrice.setText(harga);
        binding.thingsPoster.setImageResource(poster);
        binding.thingsDescription.setText(desc);
    }
}