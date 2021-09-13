package Model;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name, address, email;
    private String phoneNumber;

    public Contact(String name, String address, String email, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Model.Contact: " +
                "Name: '" + name + '\'' +
                ", address: '" + address + '\'' +
                ", email: '" + email + '\'' +
                ", phoneNumber: " + phoneNumber;
    }
}
