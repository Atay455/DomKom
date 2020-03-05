package com.atay.kg.domkom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Authetification extends  Activity {
    private FirebaseAuth mAuth;
    private FirebaseUser clientCurrentUser;
    private TextInputEditText userPhoneNumber;
    private Button getCode;
    private TextView mLoginFeedbackText;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentification);


        userPhoneNumber = findViewById(R.id.phoneNumber);
        getCode = findViewById(R.id.buttonGetCode);
        mAuth = FirebaseAuth.getInstance();
        clientCurrentUser = mAuth.getCurrentUser();

        mLoginFeedbackText = findViewById(R.id.login_form_feedback);

        getCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone_number = userPhoneNumber.getText().toString();

                if (phone_number.isEmpty()) {
                    mLoginFeedbackText.setText("Пожалуийста введите свой номер");
                    mLoginFeedbackText.setVisibility(View.VISIBLE);
                } else {

                    getCode.setEnabled(false);

                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            phone_number,
                            60,
                            TimeUnit.SECONDS,
                            Authetification.this,
                            mCallback
                    );

                }
            }
        });
        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                mLoginFeedbackText.setText("Что-то пошло не так повторите пожалуйиста.");
                mLoginFeedbackText.setVisibility(View.VISIBLE);
                getCode.setEnabled(true);
            }

            @Override
            public void onCodeSent(final String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);

                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                Intent verifyIntent = new Intent(Authetification.this, Verification.class);
                                verifyIntent.putExtra("AuthCredentials", s);
                                startActivity(verifyIntent);
                            }
                        },
                        10000);
            }
        };


    }


    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(Authetification.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            sendUserToHome();
                            // ...
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                mLoginFeedbackText.setVisibility(View.VISIBLE);
                                mLoginFeedbackText.setText("There was an error verifying OTP");
                            }
                        }

                        getCode.setEnabled(true);
                    }
                });
    }

    private void sendUserToHome() {
        Intent homeIntent = new Intent(Authetification.this, MainActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(homeIntent);
        finish();
    }


}





