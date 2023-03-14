package com.example.contactdatabase;

import android.net.Uri;

public class Person {
    private final int id;
    private Uri avatar;
    private final String name;
    private final String email;
    private final String dob;
    private final String phone;

    public Person(int id, Uri avatar, String name, String email, String dob, String phone) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public Uri getAvatar() {
        return avatar;
    }

    public void setAvatar(Uri avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public String getPhone() {
        return phone;
    }
}
