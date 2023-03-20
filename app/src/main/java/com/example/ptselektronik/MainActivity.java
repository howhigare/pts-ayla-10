package com.example.ptselektronik;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.ptselektronik.databinding.ActivityMainBinding;

import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {
        private ActivityMainBinding binding;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            View view = binding.getRoot();
            setContentView(view);

            ArrayList<Electronic> electronics = getListElectronic();
            ElectronicAdapter adapter = new ElectronicAdapter(electronics);
            binding.rvMenu.setLayoutManager(new GridLayoutManager(this, 2));
            binding.rvMenu.setAdapter(adapter);
        }

        private ArrayList<Electronic> getListElectronic(){
            String[] name = getResources().getStringArray(R.array.electronic_name);
            String[]harga = getResources().getStringArray(R.array.electronic_harga);
            TypedArray poster = getResources().obtainTypedArray(R.array.electronics_poster);
            String[]desc = getResources().getStringArray(R.array.electronic_description);

            ArrayList<Electronic> electronics = new ArrayList<>();

            for(int i = 0; i < name.length; i++) {
                //buat objek baru
                Electronic electronic = new Electronic();
                electronic.setName(name[i]);
                electronic.setHarga(harga[i]);
                electronic.setDesc(desc[i]);
                electronic.setPoster(poster.getResourceId(i, -1));

                //add objek baru
                electronics.add(electronic);

            }

            return electronics;

        }
}
