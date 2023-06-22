package com.example.assingment_2.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assingment_2.R;

public class MainActivity1_login extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private ImageView error_image1;
    private ImageView error_image2;
    private TextView error_message;
    private CheckBox checkBoxRemember;
    private Button buttonLogin;

    String uname = "yousef";
    String pass = "123";

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
        error_image1 = findViewById(R.id.error_image1);
        error_image2 = findViewById(R.id.error_image2);
        error_image1.setVisibility(View.GONE);
        error_image2.setVisibility(View.GONE);
        error_message = findViewById(R.id.error_message);
        checkBoxRemember = findViewById(R.id.checkBox);
        buttonLogin = findViewById(R.id.buttonLogin);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        // Set saved data if remember checkbox is checked
        if (sharedPreferences.getBoolean(KEY_REMEMBER, false)) {
            editTextUsername.setText(sharedPreferences.getString(KEY_USERNAME, ""));
            editTextPassword.setText(sharedPreferences.getString(KEY_PASSWORD, ""));
            checkBoxRemember.setChecked(true);
        }

        // Set click listener for the login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            // Set click listener for the login button
                @Override
                public void onClick(View v) {
                    String username = editTextUsername.getText().toString();
                    String password = editTextPassword.getText().toString();

                    if (username.isEmpty() || password.isEmpty()) {
                        error_message.setText("Please fill in all fields");
                    } else {
                        // Check if username is incorrect
                        if (!username.equals(uname)) {
                            error_image1.setVisibility(View.VISIBLE);
                            error_image2.setVisibility(View.VISIBLE);
                            error_message.setText("Invalid username or password");
                        }
                        // Check if password is incorrect
                        else if (!password.equals(pass)) {
                            error_image1.setVisibility(View.GONE);
                            error_image2.setVisibility(View.VISIBLE);
                            error_message.setText("Incorrect password");
                        }
                        // Username and password are correct
                        else {
                            error_image1.setVisibility(View.GONE);
                            error_image2.setVisibility(View.GONE);
                            error_message.setText("");

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
                    }
                }
            });

        }
}
