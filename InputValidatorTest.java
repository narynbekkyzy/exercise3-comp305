/*
 * These are the libraries from JUnit that allows you to test
 * Java applications. For more information check the complete tutorial
 * here: https://www.tutorialspoint.com/junit/index.htm
 */
import org.junit.Test;
import static org.junit.Assert.*;


public class InputValidatorTest
 {
    @Test
    
    public void testLastnameFrieldIsnotEmpty() // We are testing to ensure that the Last name has more than 2 characters and accepts Diacritic marks
    {
        //True cases 
        assertTrue(InputValidator.validatelastNameField("García")); //Testing to make sure it takes Diacritic marks. 
        assertTrue(InputValidator.validatelastNameField("'Niyah'")); //testing for names beginning with "'"
        assertTrue(InputValidator.validatelastNameField("A Niyah")); //testing if it takes names with spaces
        //False cases 
        assertFalse(InputValidator.validatelastNameField("'  '")); //testing to ensure sure you cannot just input a " ' " 
        assertFalse(InputValidator.validatelastNameField("@&$")); //Makes sure that you cannot take a special character 
        assertFalse(InputValidator.validatelastNameField("A")); //Makes sure you have to have atleast 2 characters 
        //True cases 
        assertTrue(InputValidator.validatePhonenumber("(708)506-2612"));
        assertTrue(InputValidator.validatePhonenumber("708-506-2612"));
       //False cases 
        assertFalse(InputValidator.validatePhonenumber("01"));   

        //True cases 
        assertTrue(InputValidator.validateDescription("01"));   
        assertTrue(InputValidator.validateDescription("01"));   
        assertTrue(InputValidator.validateDescription("01"));   
        //False cases 
        assertFalse(InputValidator.validateDescription("1"));   
    }
    
}