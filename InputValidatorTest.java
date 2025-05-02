/*
 * These are the libraries from JUnit that allows you to test
 * Java applications. For more information check the complete tutorial
 * here: https://www.tutorialspoint.com/junit/index.htm

 */
import org.junit.Test;
import static org.junit.Assert.*;


public class InputValidatorTest {
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

    // Nailia's Tests

    /*
     * Tests for a Name field validator method in the 
     * InputValidator class.
     */

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
    
    /*
     * Tests for a Password field validator method in the 
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

     /*
     * Tests for a Title field validator method in the 
     * InputValidator class.
     */
 
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
 
     /*
     * Tests for a Medium field validator method in the 
     * InputValidator class.
     */

     @Test
     public void testValidMediums() {
         assertTrue(InputValidator.validateMediumField("Oil"));
         assertTrue(InputValidator.validateMediumField("Acrylic"));
         assertTrue(InputValidator.validateMediumField("Watercolor"));
     }
     
     @Test
     public void testInvalidMedium() {
         assertFalse(InputValidator.validateMediumField("Crayon"));  // Not in dropdown
         assertFalse(InputValidator.validateMediumField(""));         
         assertFalse(InputValidator.validateMediumField("   "));    
         assertFalse(InputValidator.validateMediumField(null));      
     }

     //Maggie's part

    /*
     * Tests for a Username field validator method in the 
     * InputValidator class.
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

    /*
     * Tests for a Postal Code validator method in the 
     * InputValidator class.
     */
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

    /*
     * Tests for Dimensions validator method in the 
     * InputValidator class.
     */

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

    //Edith's part
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
    public void testValidEmail() {
        //Valid Emails
        assertTrue(InputValidator.validEmail("test@example.com"));
        assertTrue(InputValidator.validEmail("johnP3@gmail.com"));
    }
    public void testInvalidEmail() { 
        assertFalse(InputValidator.validEmail("")); // Empty string
        assertFalse(InputValidator.validEmail("pedroPascal.com"));// Missing @ symbol 
        assertFalse(InputValidator.validEmail("WilliamLevy@.org")); // Invalid domain format
    }
    public void testValidDOB() {
        // Calculate date exactly 18 years ago 
        assertTrue(InputValidator.validateDOB("2000-04-19"));
        assertTrue(InputValidator.validateDOB("2005-28-03"));
        assertTrue(InputValidator.validateDOB("1997-06-08"));
    }

    public void testInvalidDOB() {
        assertFalse(InputValidator.validateDOB("")); // Empty String
        assertFalse(InputValidator.validateDOB("2023-02-30")); // Non-existent date
        assertFalse(InputValidator.validateDOB("2016-01-01"));  // Date indicating under 18 yrs old 
        assertFalse(InputValidator.validateDOB("01-01-2001")); // Wrong Date Format
    }  

    public void testValidImageFile() throws Exception {
        assertTrue(InputValidator.isValidImageFile("maggie.jpg"));
        assertTrue(InputValidator.isValidImageFile("Leo.jpg"));
        assertTrue(InputValidator.isValidImageFile("Edith.jpg"));
    }
}
    
