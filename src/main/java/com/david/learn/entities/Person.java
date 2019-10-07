package com.david.learn.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String lastname;

    @Column
    private String firstname;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private LocalDateTime birthday;

    public Person() {
    }

    public Person(Long id, String lastname, String firstname, String address, String city, LocalDateTime birthday) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.city = city;
        this.birthday = birthday;
    }

    public static class PersonBuilder {

        private Long id;
        private String lastName;
        private String firstName;
        private String address;
        private String city;
        private LocalDateTime birthDay;

        public PersonBuilder() {
        }

        public Person build() {
            return new Person(id, lastName, firstName, address, city, birthDay);
        }

        public PersonBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public PersonBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public PersonBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public PersonBuilder setBirthDay(LocalDateTime birthDay) {
            this.birthDay = birthDay;
            return this;
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(lastname, person.lastname) &&
                Objects.equals(firstname, person.firstname) &&
                Objects.equals(address, person.address) &&
                Objects.equals(city, person.city) &&
                Objects.equals(birthday, person.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastname, firstname, address, city, birthday);
    }
}
