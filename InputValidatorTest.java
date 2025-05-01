/*
 * These are the libraries from JUnit that allows you to test
 * Java applications. For more information check the complete tutorial
 * here: https://www.tutorialspoint.com/junit/index.htm
 */
import org.junit.Test;
import static org.junit.Assert.*;


public class InputValidatorTest {
    @Test
    public void testNameFieldIsNotEmpty() 
    {
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
   
    // Jair's Tests 

    public void testCases() // We are testing to ensure that the Last name has more than 2 characters and accepts Diacritic marks
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
        assertTrue(InputValidator.validateDescription("b")); //Makes sure it works when you have 1 character
        assertFalse(InputValidator.validateDescription("")); //Should fail because empty string
        assertFalse(InputValidator.validateDescription("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc,"));
         //should fail because too many characters (gotten off https://www.blindtextgenerator.com/lorem-ipsum)
        
         //True cases 
         assertTrue(InputValidator.isValidDateFormat("2004-12-21")); //Testing to make sure it date format
         assertTrue(InputValidator.isValidDateFormat("2025-04-30"));
         //False cases
         assertFalse(InputValidator.isValidDateFormat("'20041221'")); //testing for dates without the "-" 
         assertFalse(InputValidator.isValidDateFormat("12-21-2004")); //testing if has a diffferent formatting 
    }
}    