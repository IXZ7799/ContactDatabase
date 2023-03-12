package com.example.contactdatabase;

public class Person {
    private final String name, email, dob, phone;
    private int id;

    public Person(String name, String email, String dob, String phone) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.phone = phone;
    }
    public Person(int id, String name, String email, String dob, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.phone = phone;
    }

    public int getId(){return id;}
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getDob(){
        return dob;
    }
    public String getPhone(){return phone;}
}
