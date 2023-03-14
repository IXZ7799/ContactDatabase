package com.example.contactdatabase;

public class Person {
    private final String name, email, dob, phone;
    private int id, avatarId;

    public Person(String name, String email, String dob, String phone) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.phone = phone;
    }
    public Person(int id, int avatarId, String name, String email, String dob, String phone) {
        this.avatarId = avatarId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.phone = phone;
    }

    public int getId(){return id;}
    public int getAvatarId() {return avatarId;}
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
