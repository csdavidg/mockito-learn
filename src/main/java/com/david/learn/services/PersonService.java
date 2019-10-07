package com.david.learn.services;

import com.david.learn.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private LocationService locationService;

    @Autowired
    public PersonService(LocationService locationService) {
        this.locationService = locationService;
    }

    public void createLocationService() {
        Person person = new Person();
        person.setFirstname("Cristian");
        person.setLastname("Sanchez");

        locationService.createLocationByPerson(person);
        System.out.println("Person Created " + person);
    }

    public int updateLocationByPerson() {
        Person person = new Person();
        person.setFirstname("Cristian");
        person.setLastname("Sanchez");

        String result = locationService.updateLocationByPerson(person, "Car 50B", 1);
        if (result != null && result.equals("SUCCESS")) {
            return 1;
        }
        return 0;
    }

    public String createPerson(Person person){
        try{
            Thread.sleep(11000);
        }catch (Exception e){

        }
        return locationService.createPerson(person);
    }

}
