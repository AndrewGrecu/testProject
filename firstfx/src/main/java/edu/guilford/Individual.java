package edu.guilford;

public class Individual {
    //instance variables
    private String name;
    private String phone;
    private String email;

    //constructor for Individual for default data
    public Individual() {
        name = "John Doe";
        phone = "555-555-5555";
        email = "jdoe@guilford";
    }

    //constructor that can build an indidual with data
    public Individual(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    //getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //getters and setters
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    //getters and setters
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    //toString method
    public String toString() {
        return "name: " + name + " phone: " + phone + " email: " + email;
    }
    
}
