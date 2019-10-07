package com.david.learn.services;

import com.david.learn.entities.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    private PersonService personService;

    private LocationService locationService;

    @Before
    public void setUp() {
        locationService = mock(LocationService.class);
        personService = new PersonService(locationService);
    }

    @Test(expected = IllegalArgumentException.class)
    public void locationTest() {
        doThrow(new IllegalArgumentException()).when(locationService).createLocationByPerson(any(Person.class));
        personService.createLocationService();
    }

    @Test
    public void successUpdate() {
        when(locationService.updateLocationByPerson(any(Person.class), anyString(), anyInt())).thenReturn("SUCCESS");
        assertEquals(1, personService.updateLocationByPerson());
    }

    @Test
    public void errorUpdate() {
        when(locationService.updateLocationByPerson(any(Person.class), eq("SASA"), anyInt())).thenReturn("ERROR");
        assertEquals(0, personService.updateLocationByPerson());
    }

    @Test
    public void createPersonTest() {
        Person person = new Person.PersonBuilder()
                .setId(1L)
                .setFirstName("David")
                .setLastName("Sanchez")
                .build();

        Person person2 = new Person.PersonBuilder()
                .setId(2L)
                .setFirstName("Cristian")
                .setLastName("Gonzalez")
                .build();

        when(locationService.createPerson(person)).thenReturn("CREATED");
        assertEquals("CREATED", locationService.createPerson(person));
        assertNotEquals("CREATED", locationService.createPerson(person2));
    }

    @Test
    public void answerTest() {
        Person person2 = new Person.PersonBuilder()
                .setId(2L)
                .setFirstName("Cristian")
                .setLastName("Gonzalez")
                .build();

        when(locationService.createPerson(person2)).thenAnswer((invocationOnMock) -> {
            Person personToSave = (Person) invocationOnMock.getArguments()[0];
            if (personToSave.getId().equals(2L)) {
                return "SUCCESS";
            }
            return "ERROR";
        });

        assertEquals("SUCCESS", locationService.createPerson(person2));

    }

    @Test
    public void answerSuccessUpdate() {
        when(locationService.updateLocationByPerson(any(Person.class), anyString(), anyInt())).thenAnswer(invocation -> {
            Person personToUpdate = (Person) invocation.getArguments()[0];
            String dir = (String) invocation.getArguments()[1];
            int version = (int) invocation.getArguments()[2];
            System.out.print("##VERSiON " + version);
            if (dir.equals("Car 50B")) {
                return "SUCCESS";
            }
            return "ERROR";
        });
        assertEquals(1, personService.updateLocationByPerson());
    }


    @Test
    public void usingVerifyExecution() {
        Person person2 = new Person.PersonBuilder()
                .setId(2L)
                .setFirstName("Cristian")
                .setLastName("Gonzalez")
                .build();
        verify(locationService, timeout(10000)).createPerson(any(Person.class));
        personService.createPerson(person2);
    }

}
