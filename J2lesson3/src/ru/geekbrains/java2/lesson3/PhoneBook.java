package ru.geekbrains.java2.lesson3;

public class PhoneBook {

    private String lastName;
    private long phoneNumber;

    public PhoneBook(String lastName, long phoneNumber){
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getLastName(){
        return lastName;
    }
    public long getPhoneNumber(){
        return phoneNumber;
    }

    @Override
    public String toString() {
        return lastName + " " + phoneNumber;
    }
}
