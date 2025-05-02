/*
 * These are the libraries from JUnit that allows you to test
 * Java applications. For more information check the complete tutorial
 * here: https://www.tutorialspoint.com/junit/index.htm

 */
import org.junit.Test;
import static org.junit.Assert.*;

public class InputValidatorTest {
    
    /*
     * Example test method for a possible Name field(InputValidator method in your 
     * Inpu(InputValidator class.
     * For more information about assertion tests check: 
     * https://www.tutorialspoint.com/junit/junit_using_assertion.htm
     * 
     */     
    
    /* Documentaiton: This class tests the methods in Inputvalidator.java for username, postal code, and dimensions.
    * Tests for true and false exmaples. 
    * Maggie Zhu
    */
    @Test
    public void testUsernameNotEmpty() {
        assertFalse(InputValidator.validateUsername(""));
        assertFalse(InputValidator.validateUsername(null));
        assertTrue(InputValidator.validateUsername("maggie"));
    }
        
    public void testUsernameLength() {
        assertTrue(InputValidator.validateUsername("abcdefghijklmnopqrst"));
        assertFalse(InputValidator.validateUsername("abcdefghijklmnopqrstu"));
        assertTrue(InputValidator.validateUsername("abc"));
    }

    @Test
    public void testValidUSPostalCodes() {
        assertTrue(InputValidator.validatePostalCode("12345"));//"Standard 5-digit code",
        assertTrue(InputValidator.validatePostalCode("00000"));//"All zeros",
        
    }

    public void testInvalidUSPostalCodes() {
        // Length tests
        assertFalse(InputValidator.validatePostalCode("123345"));//No unit
        assertFalse(InputValidator.validatePostalCode(""));//Empty
        
    }
    @Test
    public void testValidateDimensions(){
        //Test valid cases 
        assertTrue(InputValidator.validateDimension("4x4cm"));
        assertTrue(InputValidator.validateDimension("30x10in"));
        assertTrue(InputValidator.validateDimension("600.3ft"));
    }
    public void testInvalidDimensions() {
            
        assertFalse(InputValidator.validateDimension("4x4"));//No unit
        assertFalse(InputValidator.validateDimension(""));//Empty
        assertFalse(InputValidator.validateDimension("meters 1") );// Not in correct format 
        
    }
    
}
