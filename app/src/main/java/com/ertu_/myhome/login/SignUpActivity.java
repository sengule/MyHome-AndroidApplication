package com.ertu_.myhome.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ertu_.myhome.R;
import com.ertu_.myhome.databinding.ActivitySignInBinding;
import com.ertu_.myhome.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends MainActivity {

    private ActivitySignUpBinding binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();
    }

    public void sign_up_click(View view) {
        String fullname = binding.fullNameText.getText().toString();
        String age = binding.ageText.getText().toString();

        String email = binding.emailSignUpText.getText().toString();
        String password = binding.passwordSignUpText.getText().toString();

        if(email.equals("") || password.equals(""))
            Toast.makeText(SignUpActivity.this,"Enter email and password",Toast.LENGTH_SHORT).show();
        else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    reload(SignUpActivity.this);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(SignUpActivity.this,e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

}