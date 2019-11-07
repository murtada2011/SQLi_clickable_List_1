package com.example.georgevio.sqlinew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class User {



    private String Name;
    private String Phone;
    private String Email;
    private String Place;
    private String Gender;



    //constructor
    public User(String name, String phone, String email, String place, String gender) {
        Name = name;
        Phone = phone;
        Email = email;
        Place = place;
        Gender = gender;
    }
        // setter & getter
        public void setName(String name) {
            Name = name;
        }

        public void setPhone(String phone) {
            Phone = phone;
        }

        public void setEmail(String email) {
            Email = email;
        }

        public void setPlace(String place) {
            Place = place;
        }

        public void setGender(String gender) {
            Gender = gender;
        }

        public String getName() {
        return Name;
        }

        public String getPhone() {
        return Phone;
        }

        public String getEmail() {
        return Email;
        }

        public String getPlace() {
        return Place;
        }

        public String getGender() {
        return Gender;
        }

}


