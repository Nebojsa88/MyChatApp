package com.radanov.mychatapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.radanov.mychatapp.databinding.ActivityForgetBinding;


public class ForgetActivity extends AppCompatActivity {

    ActivityForgetBinding binding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityForgetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.editTextForget.getText().toString();
                if(!email.equals("")){
                    passwordReset(email);
                }
            }
        });

        auth = FirebaseAuth.getInstance();
    }
    public void passwordReset(String email){
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgetActivity.this, "Please check your email !", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ForgetActivity.this, "There is a problem !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}