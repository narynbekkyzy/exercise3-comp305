/*
Author(s): Nailya, Maggie, Edith, Jair  
Assisted By: Maddie and Amara (CC)
 * This is the InputValidator class. Checks if different kinds of user input are valid.
 */

import java.io.File;
import java.text.BreakIterator; //found off google, input off github that helps take diacritic marks and takes letters from other languages off as well
import java.time.LocalDate; //for birthdate
import java.time.Period; //to calculate the difference between two dates
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale; //helps with character definitions 
import java.util.Arrays;
import java.util.List;

public class InputValidator {
    /**
    * Validates the name field.
     * - Must not be null or empty
     * - At least 2 characters (after trimming)
     * - Only letters and spaces (diacritics allowed)     *
     * @param name the name to validate
     * @return true if the name is not empty, has at least 2 characters,
     *         and contains only letters and spaces, false otherwise
     */
    public static boolean validateNameField(String name) {
        // Check if the name is null or empty
        if (name == null) return false;

        //Check if the name is more than 2 characters
        if (name.trim().length() < 2) return false;

        // Check if the name contains only letters and spaces
        if (!name.trim().matches("[\\p{L}\\s]+")) return false;
        return true;
    } 
    
    /**
     * Validates the last name field.
     * - Must contain at least 2 letters
     * - Accepts diacritic characters
     * - Must not consist only of special characters
     *
     * @param input the last name to validate
     * @return true if valid, false otherwise
     */
    public static boolean validatelastNameField(String input) {
        BreakIterator charIterator = BreakIterator.getCharacterInstance(Locale.getDefault());
        charIterator.setText(input);

        int letterCount = 0;
        int start = charIterator.first();
        int end = charIterator.next();

        while (end != BreakIterator.DONE) {
            String Lastname = input.substring(start, end);
            int codePoint = Lastname.codePointAt(0);
            int type = Character.getType(codePoint);

            if (type == Character.UPPERCASE_LETTER || type == Character.LOWERCASE_LETTER ||
                type == Character.TITLECASE_LETTER || type == Character.MODIFIER_LETTER ||
                type == Character.OTHER_LETTER) {

                letterCount++;
                if (letterCount >= 2) {
                    return true;
                }
            }
            start = end;
            end = charIterator.next();
        }
        return false;
    }

    /**
     * Validates an email address.
     * - Must not be empty
     * - Must follow valid email format
     *
     * @param email the email to validate
     * @return true if valid, false otherwise
     */
    public static boolean validEmail(String email) {
        if (email == null || email.trim().isEmpty()) return false;
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    /**
     * Validates the username.
     * - Must not be null or empty
     * - Can't be greater than 20 
     * @param username the input string
     * @return true if valid, false otherwise
     */
    public static boolean validateUsername(String username){
        // Left blank 
        if( username == null || username.isEmpty() ){
            return false;
        }
        // Must not be 20 
        if( username.length() > 20){
            return false;
        }
        return true;
    }

     /**
     * Validates the password field.
     * - Must not be empty
     * - At least 8 characters long
     * - At least one uppercase letter
     * - At least one lowercase letter
     * - At least one digit
     * - Can include !, -, *, .
     *
     * @param password the password to validate
     * @return true if valid, false otherwise
     */
    public static boolean validatePasswordField(String password) {
        if (password == null || password.length() < 8) return false;
        boolean hasUpper = password.chars().anyMatch(Character::isUpperCase);
        boolean hasLower = password.chars().anyMatch(Character::isLowerCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        return hasUpper && hasLower && hasDigit;
    }

    /**
     * Validates the phone number.
     * - Must not be null or empty
     * - Must follow valid phone number format
     *
     * @param phoneNumber the phone number to validate
     * @return true if valid, false otherwise
     */
    public static boolean validatePhonenumber(String phoneNumber) // started to use regular expression (Maddie in the CC helped)
     {
        return phoneNumber.matches("^\\(?\\d{3}\\)?[- ]?\\d{3}[- ]?\\d{4}$"); // returns phoneNumber that contain 
     }

     /**
     * Validates the date of birth.
     * - Must be in yyyy-MM-dd format
     * - Must represent a real date
     * - Must be 18 years or older
     *
     * @param dateString the birthdate to validate
     * @return true if valid, false otherwise
     */
    public static boolean validateDOB(String dateString) {
        if (dateString == null || dateString.trim().isEmpty()) return false;

        LocalDate birthDate;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            birthDate = LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            return false;
        }

        LocalDate today = LocalDate.now();
        return Period.between(birthDate, today).getYears() >= 18;
    }

     /**
     * Validates the Postal Code.
     * - Must not be null or empty
     * - Code may not be grater than 5. 
     * @param postalcode the input string
     * @return true if valid, false otherwise
     */
     public static boolean validatePostalCode(String postalcode){
        // Left empty/blank 
        if (postalcode == null) {
            return false;
        }
        // If greater than 5 
        if (postalcode.length() != 5) {
            return false;
        }
                return true;
    }

    /**
    * Validates the title field. 
     * - Must not be empty
     * - Less than 100 characters long   
     * @param title the title to validate
     * @return true if the title is not empty and less than 100 characters
     */
     public static boolean validateTitleField(String title) {
        if (title == null || title.trim().isEmpty()) {
            return false;
        }
        return title.length() <= 100;      
    }

    /**
     * Validates a description field.
     * - Must be between 1 and 1000 characters
     *
     * @param Descrip the description to validate
     * @return true if valid, false otherwise
     */     
    public static boolean validateDescription(String Descrip) 
        {
        //The following text is more for my own understanding but is also an explanation of each character in RegEx
        //^ is the start of the string 
        //"." is any character with 1 to 1000 digits then $ closes the string 
            return Descrip.matches("^.{1,1000}$");
        }

    /*
     * Validates a file according to:
     * 1. Must have a .jpg or .png extension
     * 2. Must not exceed 4MB in size
     * 
     * @param filePath the file that user inputs 
     * @return true if both conditions are met, false otherwise
     */
    public static boolean isValidImageFile(String filePath) {
        File File = new File(filePath);
        String fileName = File.getName().toLowerCase(Locale.ROOT);

        if (!(fileName.endsWith(".jpg") || fileName.endsWith(".png"))) return false;

        final long MAX_SIZE = 4 * 1024 * 1024; // 4 MB
        if (File.length() > MAX_SIZE) return false;

        return true;
    }

    /**
     * Validates the dimensions.
     * - Must not be null or empty
     * - Must match the format/pattern 
     * @param dimensions the input string
     * @return true if valid, false otherwise
     */
    
     public static boolean validateDimension(String dimensions) {
        if (dimensions == null || dimensions.trim().isEmpty()) {
            return false;// Left empty or not filled false
        }
    
        // List of valid units in both singular and plural
        String[] units = {
            "cm", "m", "in", "yd", "ft", "mm", 
            "meter", "meters", "centimeter", "centimeters",
            "millimeter", "millimeters", "inch", "inches",
            "foot", "feet", "yard", "yards"
        };
    
    String input = dimensions.trim().toLowerCase();

    for (String unit : units) {
        // Pattern for simple format: number + unit
        String simplePattern = "\\s*\\d+\\.?\\d*\\s*" + unit + "\\s*";
        
        // Pattern for dimension format: number x number + unit
        String dimensionPattern = "\\s*\\d+\\.?\\d*\\s*x\\s*\\d+\\.?\\d*\\s*" + unit + "\\s*";
        // Must contain ether to return true 
        if (input.matches(simplePattern) || input.matches(dimensionPattern)) {
            return true;
        }
    }
        return false;
    }

    // Accepted media list (dropdown values) - just for reference
    private static final List<String> ACCEPTED_MEDIA = Arrays.asList
    ("Oil", "Acrylic", "Watercolor", "Pastel", "Ink", "Digital", "Mixed Media");

    /**
     * Validates the painting medium.
     * - Must not be null or empty
     * - Must match one of the accepted media (that's above)
     * @param medium the input string
     * @return true if valid, false otherwise
     */
    public static boolean validateMediumField(String medium) {
        if (medium == null || medium.trim().isEmpty()) return false;
        return ACCEPTED_MEDIA.contains(medium.trim());
    }

    /**
     * Validates date format.
     * - Must be in yyyy-MM-dd format
     *
     * @param input the date string to validate
     * @return true if valid format, false otherwise
     */
    public static boolean isValidDateFormat(String input)  
        {
           return input.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$"); //beings string, then 4 digits with a dash for year, 1 digit between 1&2 with a dash and then 
           //1 digits with a dash between 1-9 to get the second digit of month, lastly we do the same for day
        }

    /**
     * Validates a currency string according to if:
     * 1. Can be empty
     * 2. If not empty must be in format: [Currency type] [Amount]
     *  - Valid currency types: USD, CAD, EUR, MXN, BTC
     *  - Amount must be in format 0.00 
     * 
     * @param currencyString The currency string to validate
     * @return true if valid according to the rules, other false
     */
    public static boolean validCurrency(String currencyString)
    {
        // Check for null input
        if (currencyString == null)
        {
            return false;
        }
        // Validate against currency regex pattern
    return currencyString.matches("^$|^(USD|CAD|EUR|MXN|BTC)\\s\\d{1,3}(,\\d{3})*(\\.\\d{2})?$");
    }
}
    
