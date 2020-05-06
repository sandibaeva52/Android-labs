package com.example.contactapp;

import java.util.ArrayList;

public class Contacts {

    private String name;
    private int phone;
    private String address;
    private ArrayList<Contacts> contacts=new ArrayList<>();

    public Contacts (String name, int phone, String address){
this.name=name;
this.phone=phone;
this.address=address;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getPhone(){
        return phone + "";
    }
    public void setPhone(int phone){
        this.phone=phone;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
}
