
import org.junit.Test;
import static org.junit.Assert.*;

public class InputValidatorTest {
    
    @Test
    public void testValidEmail() {
        //Valid Emails
        assertTrue(InputValidator.validEmail("test@example.com"));
        assertTrue(InputValidator.validEmail("johnP3@gmail.com"));
    }
        
    @Test
    public void testInvalidEmail() { 
        assertFalse(InputValidator.validEmail("")); // Empty string
        assertFalse(InputValidator.validEmail("pedroPascal.com"));// Missing @ symbol 
        assertFalse(InputValidator.validEmail("WilliamLevy@.org")); // Invalid domain format
    }
            
    @Test 
    public void testValidDOB() {
        // Calculate date exactly 18 years ago 
        assertTrue(InputValidator.validateDOB("2000-04-19"));
        assertTrue(InputValidator.validateDOB("2005-28-03"));
        assertTrue(InputValidator.validateDOB("1997-06-08"));
    }

    @Test
    public void testInvalidDOB() {
        assertFalse(InputValidator.validateDOB("")); // Empty String
        assertFalse(InputValidator.validateDOB("2023-02-30")); // Non-existent date
        assertFalse(InputValidator.validateDOB("2016-01-01"));  // Date indicating under 18 yrs old 
        assertFalse(InputValidator.validateDOB("01-01-2001")); // Wrong Date Format
    }    

    @Test
    public void testValidImageFile() throws Exception {
        assertTrue(InputValidator.isValidImageFile("maggie.jpg"));
        assertTrue(InputValidator.isValidImageFile("Leo.jpg"));
        assertTrue(InputValidator.isValidImageFile("Edith.jpg"));
    }

    @Test
    public void testInvalidImageFile () throws Exception {
        assertFalse(InputValidator.isValidImageFile("test.pdf")); // Wrong file extension
        assertFalse(InputValidator.isValidImageFile("7")); // File exceeding size limit
    }

    @Test 
    public void testValidCurrency() {
        assertTrue(InputValidator.validCurrency(""));
        assertTrue(InputValidator.validCurrency("USD 100.00"));
        assertTrue(InputValidator.validCurrency("CAD 1,000.50"));
        assertTrue(InputValidator.validCurrency("BTC 0.50"));
    }

    @Test 
    public void testInvalidCurrency() {
        assertFalse(InputValidator.validCurrency("JPY 100.00")); // Invalid currency code
        assertFalse(InputValidator.validCurrency("USD100.00")); // Missing space
    }
}