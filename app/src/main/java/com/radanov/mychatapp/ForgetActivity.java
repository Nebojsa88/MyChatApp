package com.radanov.mychatapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.radanov.mychatapp.databinding.ActivityForgetBinding;


public class ForgetActivity extends AppCompatActivity {

    ActivityForgetBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityForgetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}