package com.example.license_project_2;
import org.junit.Test;
import static org.junit.Assert.*;
public class AuthenticationTest {
    private boolean isUsernameValid(String username){
        return username != null && !username.trim().isEmpty();
    }

    private boolean isPasswordValid(String password){
        return password != null && !password.trim().isEmpty();
    }

    private boolean passwordsMatch(String passwordFromDatabase, String inputPassword){
        return passwordFromDatabase != null && passwordFromDatabase.equals(inputPassword);
    }

    @Test
    public void testValidateUsernameIsEmptyStringAndReturnsFalse(){
        assertFalse(isUsernameValid(""));
    }

    @Test
    public void testValidateUsernameIsValidStringAndReturnsTrue(){
        assertTrue(isUsernameValid("toni"));
    }

    @Test
    public void testValidatePasswordIsEmptyStringAndReturnsFalse(){
        assertFalse(isPasswordValid(""));
    }

    @Test
    public void testValidatePasswordWhetherCorrectPasswordAndReturnsTrue(){
        assertTrue(passwordsMatch("toni1234", "toni1234"));
    }

    @Test
    public void testValidatePasswordWhetherWrongPasswordAndReturnsFalse(){
        assertFalse(passwordsMatch("toni1234", "toni1304"));
    }
}
