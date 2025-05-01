/*
 * These are the libraries from JUnit that allows you to test
 * Java applications. For more information check the complete tutorial
 * here: https://www.tutorialspoint.com/junit/index.htm
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class InputValidatorTest {
    
    /*
     * Example test method for a possible Name field validator method in your 
     * InputValidator class.
     * For more information about assertion tests check: 
     * https://www.tutorialspoint.com/junit/junit_using_assertion.htm
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
    
    // CREATE MORE TESTS HERE
    
}