package com.example.assingment_2.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assingment_2.R;


public class MainActivity1_login extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private CheckBox checkBoxRemember;
    private Button buttonLogin;


    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "MyPrefs";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_REMEMBER = "remember";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        checkBoxRemember = findViewById(R.id.checkBox);
        buttonLogin = findViewById(R.id.buttonLogin);

        // ------------------------------------------------------------------
        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        // ------------------------------------------------------------------
        // Set saved data if remember checkbox is checked
        if (sharedPreferences.getBoolean(KEY_REMEMBER, false)) {
            editTextUsername.setText(sharedPreferences.getString(KEY_USERNAME, ""));
            editTextPassword.setText(sharedPreferences.getString(KEY_PASSWORD, ""));
            checkBoxRemember.setChecked(true);
        }

        // ------------------------------------------------------------------
        // Set click listener for the login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Save data if remember checkbox is checked
                if (checkBoxRemember.isChecked()) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_USERNAME, username);
                    editor.putString(KEY_PASSWORD, password);
                    editor.putBoolean(KEY_REMEMBER, true);
                    editor.apply();
                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.clear();
                    editor.apply();
                }

                Intent intent = new Intent(MainActivity1_login.this, MainActivity2_subject.class);
                startActivity(intent);

            }
        });



    }
}
