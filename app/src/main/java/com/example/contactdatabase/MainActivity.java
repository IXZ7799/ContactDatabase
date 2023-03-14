package com.example.contactdatabase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;

public class MainActivity extends AppCompatActivity {

    ImageView image;

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
        selectBtn.setOnClickListener(view -> ImagePicker.with(MainActivity.this)
                .crop()
                .maxResultSize(150,150)
                .start());

        image = findViewById(R.id.imageView);
        image.setBackgroundResource(R.drawable.userimg);

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

            Person p = new Person(0, Uri.parse(avatar), name, email, dob, phone);

            long personId = dbHelper.insertDetails(p);

        Toast.makeText(this, "Person has been created with id: " + personId,
                Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        assert data != null;
        Uri uri = data.getData();
        image.setImageURI(uri);
        image.setBackgroundResource(0);
    }
}