/*
 * This class tests all the validation methods in the InputValidator class.
 * Each test checks if the input is accepted or rejected correctly based on the rules.
 */
import org.junit.Test;
import static org.junit.Assert.*;


public class InputValidatorTest {
    /*
     * Tests for a Name field validator method in the 
     * InputValidator class.
     */
    @Test
    public void testNameFieldIsNotEmpty() {
        assertTrue(InputValidator.validateNameField("John"));
        assertFalse(InputValidator.validateNameField(""));
        assertFalse(InputValidator.validateNameField(" "));
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
     * Tests for a Last Name field validator method in the 
     * InputValidator class.
     */
    public void testCases() {
        assertTrue(InputValidator.validatelastNameField("García"));
        assertTrue(InputValidator.validatelastNameField("'Niyah'"));
        assertTrue(InputValidator.validatelastNameField("A Niyah"));

        assertFalse(InputValidator.validatelastNameField("'  '"));
        assertFalse(InputValidator.validatelastNameField("@&$"));
        assertFalse(InputValidator.validatelastNameField("A"));
    }

    /*
     * Tests for an Email field validator method in the 
     * InputValidator class.
     */
    public void testValidEmail() {
        assertTrue(InputValidator.validEmail("test@example.com"));
        assertTrue(InputValidator.validEmail("johnP3@gmail.com"));
    }

    public void testInvalidEmail() {
        assertFalse(InputValidator.validEmail(""));
        assertFalse(InputValidator.validEmail("pedroPascal.com"));
        assertFalse(InputValidator.validEmail("WilliamLevy@.org"));
    }

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
     * Tests for a Phone Number field validator method in the 
     * InputValidator class.
     */
    public void testCases_phoneNumber() {
        assertTrue(InputValidator.validatePhonenumber("(708)506-2612"));
        assertTrue(InputValidator.validatePhonenumber("708-506-2612"));
        assertFalse(InputValidator.validatePhonenumber("01"));
    }

    /*
     * Tests for a Date of Birth field validator method in the 
     * InputValidator class.
     */
    public void testValidDOB() {
        assertTrue(InputValidator.validateDOB("2000-04-19"));
        assertTrue(InputValidator.validateDOB("2005-28-03"));
        assertTrue(InputValidator.validateDOB("1997-06-08"));
    }

    public void testInvalidDOB() {
        assertFalse(InputValidator.validateDOB(""));
        assertFalse(InputValidator.validateDOB("2023-02-30"));
        assertFalse(InputValidator.validateDOB("2016-01-01"));
        assertFalse(InputValidator.validateDOB("01-01-2001"));
    }

    /*
     * Tests for a Postal Code field validator method in the 
     * InputValidator class.
     */
    @Test
    public void testValidUSPostalCodes() {
        assertTrue(InputValidator.validatePostalCode("12345"));
        assertTrue(InputValidator.validatePostalCode("00000"));
    }

    public void testInvalidUSPostalCodes() {
        assertFalse(InputValidator.validatePostalCode("123345"));
        assertFalse(InputValidator.validatePostalCode(""));
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
     * Tests for a Description field validator method in the 
     * InputValidator class.
     */
    public void testCases_description() {
        assertTrue(InputValidator.validateDescription("01"));
        assertTrue(InputValidator.validateDescription("01"));
        assertTrue(InputValidator.validateDescription("01"));
        assertTrue(InputValidator.validateDescription("b"));
        assertFalse(InputValidator.validateDescription(""));
        assertFalse(InputValidator.validateDescription("Lorem ipsum dolor sit amet..."));
    }

    /*
     * Tests for an Image field validator method in the 
     * InputValidator class.
     */
    @Test
    public void testInvalidImageFile() throws Exception {
        assertFalse(InputValidator.isValidImageFile("test.pdf"));
        assertFalse(InputValidator.isValidImageFile("7"));
    }

    public void testValidImageFile() throws Exception {
        assertTrue(InputValidator.isValidImageFile("maggie.jpg"));
        assertTrue(InputValidator.isValidImageFile("Leo.jpg"));
        assertTrue(InputValidator.isValidImageFile("Edith.jpg"));
    }

    /*
     * Tests for a Dimensions field validator method in the 
     * InputValidator class.
     */
    @Test
    public void testValidateDimensions() {
        assertTrue(InputValidator.validateDimension("4x4cm"));
        assertTrue(InputValidator.validateDimension("30x10in"));
        assertTrue(InputValidator.validateDimension("600.3ft"));
    }

    public void testInvalidDimensions() {
        assertFalse(InputValidator.validateDimension("4x4"));
        assertFalse(InputValidator.validateDimension(""));
        assertFalse(InputValidator.validateDimension("meters 1"));
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
        assertFalse(InputValidator.validateMediumField("Crayon"));
        assertFalse(InputValidator.validateMediumField(""));
        assertFalse(InputValidator.validateMediumField("   "));
        assertFalse(InputValidator.validateMediumField(null));
    }

    /*
     * Tests for a Creation Date format validator method in the 
     * InputValidator class.
     */
    public void testCases_dateFormat() {
        assertTrue(InputValidator.isValidDateFormat("2004-12-21"));
        assertTrue(InputValidator.isValidDateFormat("2025-04-30"));
        assertFalse(InputValidator.isValidDateFormat("'20041221'"));
        assertFalse(InputValidator.isValidDateFormat("12-21-2004"));
    }

    /*
     * Tests for a Price/Currency field validator method in the 
     * InputValidator class.
     */
    @Test
    public void testValidCurrency() {
        assertTrue(InputValidator.validCurrency(""));
        assertTrue(InputValidator.validCurrency("USD 100.00"));
        assertTrue(InputValidator.validCurrency("CAD 1,000.50"));
        assertTrue(InputValidator.validCurrency("BTC 0.50"));
    }

    @Test
    public void testInvalidCurrency() {
        assertFalse(InputValidator.validCurrency("JPY 100.00"));
        assertFalse(InputValidator.validCurrency("USD100.00"));
    }
}
    
