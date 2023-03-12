package com.example.contactdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button viewBtn = findViewById(R.id.viewBtn);
        viewBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            startActivity(intent);
            });

        Button saveBtn = findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(v -> saveDetails());
    }

    private void saveDetails() {
        try (DatabaseHelper dbHelper = new DatabaseHelper(this)){

        EditText nameText = findViewById(R.id.nameInput);
        EditText emailText = findViewById(R.id.emailInput);
        EditText dobText = findViewById(R.id.dobInput);
        EditText phoneText = findViewById(R.id.phoneInput);

        String name = nameText.getText().toString();
        String email = emailText.getText().toString();
        String dob = dobText.getText().toString();
        String phone = phoneText.getText().toString();

        Person p = new Person(name, dob, email, phone);

        long personId = dbHelper.insertDetails(p);

        Toast.makeText(this, "Person has been created with id: " + personId,
                Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

