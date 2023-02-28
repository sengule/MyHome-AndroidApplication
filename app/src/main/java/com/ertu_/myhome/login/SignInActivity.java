package com.ertu_.myhome.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ertu_.myhome.databinding.ActivitySignInBinding;
import com.ertu_.myhome.home.HomeActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends MainActivity {

    private ActivitySignInBinding binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();

    }

    public void enter(View view) {
        String email = binding.emailText.getText().toString();
        String password = binding.passwordText.getText().toString();

        if(email.equals("") || password.equals(""))
            Toast.makeText(SignInActivity.this,"Enter email and password",Toast.LENGTH_SHORT).show();
        else{
            mAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    reload(SignInActivity.this);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(SignInActivity.this,e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


}