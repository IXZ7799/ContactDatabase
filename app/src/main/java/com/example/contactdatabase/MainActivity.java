package com.example.contactdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] images = {R.drawable.userimg, R.drawable.usersolid, R.drawable.usernurse, R.drawable.usersecret, R.drawable.usertie};

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

        Button selectBtn = findViewById(R.id.selectBtn);
        selectBtn.setOnClickListener(v -> {
            int randomIndex = (int) (Math.random() * images.length);
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageResource(images[randomIndex]);
        });
    }

    private void saveDetails() {
        try (DatabaseHelper dbHelper = new DatabaseHelper(this)){

        EditText nameText = findViewById(R.id.nameInput);
        EditText emailText = findViewById(R.id.emailInput);
        EditText dobText = findViewById(R.id.dobInput);
        EditText phoneText = findViewById(R.id.phoneInput);
        ImageView avatarImage = findViewById(R.id.imageView);

        String avatar = avatarImage.toString();
        String name = nameText.getText().toString();
        String email = emailText.getText().toString();
        String dob = dobText.getText().toString();
        String phone = phoneText.getText().toString();

            Person p = new Person(0, avatar, name, email, dob, phone);

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