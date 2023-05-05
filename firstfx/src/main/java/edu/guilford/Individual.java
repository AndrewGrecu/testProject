package edu.guilford;

public class Individual {
    // instance variables
    private String name;
    private String phone;
    private String email;

    // constructor for Individual for default data
    public Individual() {
        name = "John Doe";
        phone = "555-555-5555";
        email = "jdoe@guilford";
    }

    // constructor that can build an indidual with data
    public Individual(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name.trim();
    }

    // getters and setters
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws IllegalArgumentException {
        if (!phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone number must contain only digits.");
        }
        this.phone = phone;
    }

    // getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IllegalArgumentException {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        // use from https://www.baeldung.com/java-email-validation-regex 
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email.trim();
    }

    // toString method
    public String toString() {
        return "name: " + name + " phone: " + phone + " email: " + email;
    }

}
