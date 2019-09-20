package com.example.ovulationcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    private FirebaseAuth mAuth;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
       final EditText name = (EditText)findViewById(R.id.name);
        final EditText email = (EditText)findViewById(R.id.email);
        final EditText password = (EditText)findViewById(R.id.password);
        final EditText comformpassword = (EditText)findViewById(R.id.comfrompassword);
        final EditText dateofbirth = (EditText)findViewById(R.id.dateofbirth);
        final Button signup = (Button)findViewById(R.id.signup);
        final TextView signin = (TextView)findViewById(R.id.signin);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = name.getText().toString().trim();
                String useremail = email.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String confrimpass = comformpassword.getText().toString().trim();
                String birth = dateofbirth.getText().toString().trim();
                if ((username == null || username=="") && (pass == null || pass == "")) {
                    Toast.makeText(Register.this, "Enter All The Filed", Toast.LENGTH_SHORT).show();

                } else if ((username == null) || (username == "")) {
                    Toast.makeText(Register.this, "Enter user name", Toast.LENGTH_SHORT).show();
                } else if ((pass == null) || (pass == "")) {
                    Toast.makeText(Register.this, "Enter Pass Word", Toast.LENGTH_SHORT).show();
                } else {
                    firbaseauth(username,pass);
                }

            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objectName = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(objectName);
            }
        });

    }

    private void firbaseauth(String username, String pass) {
        mAuth.createUserWithEmailAndPassword(username, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(Register.this, "Authentication sucess.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            
                            Toast.makeText(Register.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        
                    }
                });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
    }
}
