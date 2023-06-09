package com.example.contactdatabase;

public class Person {
    private int id;
    private final int avatar;
    private final String name, email, dob, phone;

    public Person(int id, int avatar, String name, String email, String dob, String phone) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.phone = phone;
    }

    public Person(int avatar, String name, String email, String dob, String phone) {
        this.avatar = avatar;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.phone = phone;
    }

    @SuppressWarnings("unused")
    public int getId() {return id;}

    public int getAvatar() {return avatar;}

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