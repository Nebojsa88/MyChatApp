package com.radanov.mychatapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.radanov.mychatapp.databinding.ActivityMyLoginBinding;

public class MyLoginActivity extends AppCompatActivity {


    private ActivityMyLoginBinding binding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMyLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();

        binding.buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.editTextEmail.getText().toString();
                String password = binding.editTextPassword.getText().toString();

                if(!email.equals("") && !password.equals("")){
                    signIn(email, password);
                }else {
                    Toast.makeText(MyLoginActivity.this, "Please enter email and password.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MyLoginActivity.this, SignUpActivity.class);
                startActivity(intent);

            }
        });

        binding.textViewForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MyLoginActivity.this, ForgetActivity.class);
                startActivity(intent);

            }
        });

    }
    public void signIn(String email, String password ){

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Intent intent =  new Intent(MyLoginActivity.this, MainActivity.class);
                    Toast.makeText(MyLoginActivity.this, "Sign in is successful.", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }else {
                    Toast.makeText(MyLoginActivity.this, "Sign in is unsuccessful.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}