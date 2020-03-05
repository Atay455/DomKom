package com.atay.kg.domkom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PlayGamesAuthProvider;

public class Verification extends Activity {


    private FirebaseAuth mAuth;
    private FirebaseUser clientCurrentUser;
    private TextInputEditText codeVerify;
    private Button buttonNext;
    private String mAuthVerificationId;
    private TextView codeFeedbacktext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verificatin);

        mAuth = FirebaseAuth.getInstance();
        clientCurrentUser = mAuth.getCurrentUser();

        mAuthVerificationId = getIntent().getStringExtra("AuthCredentials");


        codeVerify= findViewById(R.id.code_input);
        buttonNext = findViewById(R.id.button_next);
        codeFeedbacktext = findViewById(R.id.feedbacktext);


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String verify = codeVerify.getText().toString();

                if(verify.isEmpty()) {
                    codeFeedbacktext.setVisibility(View.VISIBLE);
                    codeFeedbacktext.setText("Пожалуйиста  введите код");

                }else {
                    PhoneAuthCredential credential  = PhoneAuthProvider.getCredential(mAuthVerificationId,verify);
                    signInWithPhoneAuthCredential(credential);

                }
            }
        });

    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(Verification.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            sendUserToHome();
                            // ...
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                codeFeedbacktext.setVisibility(View.VISIBLE);
                                codeFeedbacktext.setText("There was an error verifying OTP");
                            }
                        }

                        buttonNext.setEnabled(true);
                    }

                    private void sendUserToHome() {
                        Intent homeIntent = new Intent(Verification.this, MainActivity.class);
                        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(homeIntent);
                        finish();
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        sendUserToHome();

        }


    public void sendUserToHome() {
        Intent homeIntent = new Intent(Verification.this, MainActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(homeIntent);
        finish();
    }
}

