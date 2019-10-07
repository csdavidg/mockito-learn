package com.david.learn.services;

import com.david.learn.entities.Person;
import org.springframework.stereotype.Component;

@Component
public class LocationService {

    public void createLocationByPerson(Person person) {
        System.out.println("Location has been created " + person);
    }

    public String updateLocationByPerson(Person person, String newLocation, int version) {
        System.out.println("Location updated " + newLocation + "[" + person + "]" + "Version " + version);
        return "SUCCESS";
    }

    public String createPerson(Person person) {
        System.out.println("Person Created " + person);
        person.setId(1L);
        return "CREATED";
    }

}
