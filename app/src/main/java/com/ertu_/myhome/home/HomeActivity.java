package com.ertu_.myhome.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ertu_.myhome.databinding.ActivityHomeBinding;
import com.ertu_.myhome.databinding.ActivitySignInBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}