package org.itstep.myWebApp.model;


public class User extends Entity {

    private String lastname;

    private String city;

    private String email;

    public User() {
    }

    public User(String name, String lastname, String city, String email) {
        this.name = name;
        this.lastname = lastname;
        this.city = city;
        this.email = email;
    }

    public User(Integer id, String name, String lastname, String city, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.city = city;
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "lastname='" + lastname + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
