/*
 * These are the libraries from JUnit that allows you to test
 * Java applications. For more information check the complete tutorial
 * here: https://www.tutorialspoint.com/junit/index.htm
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class InputValidatorTest {
    
    /*
     * Test method for a Name field validator method in the 
     * InputValidator class.
     */
    @Test
    public void testNameFieldIsNotEmpty() {
        assertTrue(InputValidator.validateNameField("John"));
        assertFalse (InputValidator.validateNameField(""));
        assertFalse (InputValidator.validateNameField(" "));
    }

    @Test
    public void testNameMinLength() {
        assertFalse(InputValidator.validateNameField("A"));
        assertTrue(InputValidator.validateNameField("Al"));
    }

    @Test
    public void testNameWithSpaces() {
        assertTrue(InputValidator.validateNameField("Nailia Narynbek"));
    }

    @Test
    public void testNameWithDiacritics() {
        assertTrue(InputValidator.validateNameField("Zoë"));
        assertTrue(InputValidator.validateNameField("Björk"));
    }

    @Test
    public void testNameWithInvalidCharacters() {
        assertFalse(InputValidator.validateNameField("John123"));
        assertFalse(InputValidator.validateNameField("!@#"));
        assertFalse(InputValidator.validateNameField("Anna*"));
    }

    @Test
    public void testNameNull() {
        assertFalse(InputValidator.validateNameField(null));
    }

    /*
     * Test method for a Password field validator method in the 
     * InputValidator class.
     */

    @Test
    public void testPasswordFieldIsNotEmpty() {
        assertTrue(InputValidator.validatePasswordField("Password123"));
        assertFalse(InputValidator.validatePasswordField(""));
        assertFalse(InputValidator.validatePasswordField(" "));
    }

    @Test
    public void testPasswordMinLength() {
        assertFalse(InputValidator.validatePasswordField("Pass12"));
        assertTrue(InputValidator.validatePasswordField("Password123"));
    }
    
    @Test
    public void testPasswordWithUpperCase() {
        assertTrue(InputValidator.validatePasswordField("Password123"));
        assertFalse(InputValidator.validatePasswordField("password123"));
    }

    @Test 
    public void testPasswordWithLowerCase() {
        assertTrue(InputValidator.validatePasswordField("Password123"));
        assertFalse(InputValidator.validatePasswordField("PASSWORD123"));
    }

    @Test 
    public void testPasswordWithDigit() {
        assertTrue(InputValidator.validatePasswordField("Password123"));
        assertFalse(InputValidator.validatePasswordField("Password"));
    }

    @Test
    public void testPasswordWithSpecialCharacters() {
        assertTrue(InputValidator.validatePasswordField("P@ssw0rd!"));
        assertTrue(InputValidator.validatePasswordField("Password123!"));
    }

    @Test
    public void testTitleFieldIsNotEmpty() {
        assertTrue(InputValidator.validateTitleField("Some Title"));
        assertFalse(InputValidator.validateTitleField(""));
        assertFalse(InputValidator.validateTitleField(" "));
    }

    @Test 
    public void testTitleLength() {
        assertTrue(InputValidator.validateTitleField("Some Title"));
        assertFalse(InputValidator.validateTitleField("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aeneanejfefhefsdsk"));
    }
    
}