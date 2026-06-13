package com.example.license_project_2;
import org.junit.Test;
import static org.junit.Assert.*;

public class HelperClassTest {
    @Test
    public void testHelperClassConstructorIfAllFieldsAreSetCorrectly(){
        HelperClass user = new HelperClass("Duncan", "Donuts", "donatlord",
                                    "dunan@gmail.com", "donuts");
        assertEquals("Duncan", user.getName());
        assertEquals("Donuts", user.getSurname());
        assertEquals("donatlord", user.getUsername());
        assertEquals("dunan@gmail.com", user.getEmail());
        assertEquals("donuts", user.getPassword());
    }
    @Test
    public void testHelperClassSettersIfAllFieldsAreUpdatedCorrectly(){
        HelperClass user = new HelperClass();
        user.setName("John");
        user.setSurname("Washington");
        user.setUsername("johnnywash");
        user.setEmail("johnwashington@gmail.com");
        user.setPassword("firstpresident");

        assertEquals("John", user.getName());
        assertEquals("Washington", user.getSurname());
        assertEquals("johnnywash", user.getUsername());
        assertEquals("johnwashington@gmail.com", user.getEmail());
        assertEquals("firstpresident", user.getPassword());
    }
}
