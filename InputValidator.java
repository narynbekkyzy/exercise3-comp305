/*
Author(s): Nailya, Maggie, Edith, Jair  
Assisted By: Maddie and Amara (CC)
 * This is the InputValidator class. Please complete this class with
 * appropiate JavaDoc comments, method and code comments, and the appropiate
 * methods to validate inputs from the user. 
 */

import java.io.File;
import java.text.BreakIterator; //found off google, input off github that helps take diacritic marks and takes letters from other languages off as well
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale; //helps with character definitions 
import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.List;
import java.util.Arrays;
import java.util.List;

public class InputValidator {
    //Jair's Part

    public static boolean validatelastNameField(String input) 
        { //This is our boolean that will return true if more than 2 letters 
        BreakIterator charIterator = BreakIterator.getCharacterInstance(Locale.getDefault()); //initialize  
        charIterator.setText(input); // 

          int letterCount = 0; 
          int start = charIterator.first();
          int end = charIterator.next();

        while (end != BreakIterator.DONE) {
         String Lastname = input.substring(start, end);
            int codePoint = Lastname.codePointAt(0);
            int type = Character.getType(codePoint);

            if (type == Character.UPPERCASE_LETTER || type == Character.LOWERCASE_LETTER || // Defining what were considering as letters as to not take special characters like "@ or $"
                type == Character.TITLECASE_LETTER || type == Character.MODIFIER_LETTER || 
                type == Character.OTHER_LETTER) {

                letterCount++; //increase letter count 
                if (letterCount >= 2) 
                { 
                    return true; //if greater than 2 than accepted 
                }
            }

            start = end;
            end = charIterator.next();
        }

        return false;
    }
 
    public static boolean validatePhonenumber(String phoneNumber) // started to use regular expression (Maddie in the CC helped)
     {
        //The following text is more for my own understanding but is also an explanation of each character
        //^ is the start of the string 
        //(? is an optional open parathesis as ? is making the symbol optional, then 3 digits then closing the optional paranthesis, more optional dash, 3 more digits and 
        //then optional last dash then 4 digits closing the string 

        return phoneNumber.matches("^\\(?\\d{3}\\)?[- ]?\\d{3}[- ]?\\d{4}$"); // returns phoneNumber that contain 
     }
            
    public static boolean validateDescription(String Descrip) // started to use regular expression (Maddie in the CC helped)
        {
        //The following text is more for my own understanding but is also an explanation of each character in RegEx
        //^ is the start of the string 
        //"." is any character with 1 to 1000 digits then $ closes the string 
            return Descrip.matches("^.{1,1000}$");
        }
    public static boolean isValidDateFormat(String input)  //Checking for a valid format of dates 
        {
           return input.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$"); //beings string, then 4 digits with a dash for year, 1 digit between 1&2 with a dash and then 
           //1 digits with a dash between 1-9 to get the second digit of month, lastly we do the same for day
        }
    
    //Nailia's part

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
    * Validates the password field. 
     * - Must not be empty
     * - At least 8 characters long
     * - At least one upper-case, lower-case and digit.
     * - Special characters are allowed    
     * @param password the password to validate
     * @return true if the password is not empty, has at least 8 characters,
     *         and contains upper-case, lower-case and digit, false otherwise
     */
    public static boolean validatePasswordField(String password) {
        // Check if the password is null or empty and has at least 8 characters
        if (password == null || password.length() < 8) return false;

        // Check if the password contains at least one upper-case letter,lower-case letter and digit.
        boolean hasUpper = password.chars().anyMatch(Character::isUpperCase);
        boolean hasLower = password.chars().anyMatch(Character::isLowerCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);

        return hasUpper && hasLower && hasDigit;
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

    // Accepted media list (dropdown values)
    private static final List<String> ACCEPTED_MEDIA = Arrays.asList
    ("Oil", "Acrylic", "Watercolor", "Pastel", "Ink", "Digital", "Mixed Media");

    /**
     * Validates the painting medium.
     * - Must not be null or empty
     * - Must match one of the accepted media
     * @param medium the input string
     * @return true if valid, false otherwise
     */
    public static boolean validateMediumField(String medium) {
        if (medium == null || medium.trim().isEmpty()) return false;
        return ACCEPTED_MEDIA.contains(medium.trim());
    }


    //Maggie's part

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
    return false;// Does not match then false 
    }

    //Edith's part

     /**
     * Validates an email adress
     * 
     * @param email The email string to validate
     * @return true if the email is valid (not empty and matches standard email format)
     * , other false
     * 
     */
   public static boolean validEmail (String email) 
    {
        //Chech for null or empty input
        if (email == null || email.trim().isEmpty())
        { 
            return false;
        }
        // Validate against email regex pattern
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }    
    
    /**
     * @param input The user inputs ie.email 
     * @param regex The regular expression pattern to match against
     * @return true if the input matches the regex pattern and non empty, other false
     */
    public static boolean matchesFormat (String input, String regex)
    {
        if (input == null || input.trim().isEmpty())
        {
            // Check for null or empty input
            return false;
        }
        // Validate against regex pattern
        return Pattern.matches(regex, input);
    }

    /**
     * Validates a date of birth string according to:
     * 1. Must be in yyyy-MM-dd format
     * 2. Must represent a valid calendar date
     * 3. Indicates if user is 18+ 
     * 
     * @param dateString The date string to validate
     * @return true if the date is valid and the user is 18+, false otherwise
     */
    public static boolean validateDOB (String dateString)
    {
        // Check if the input is empty or null
        if (dateString == null || dateString.trim().isEmpty())
        {
            return false;
        }

        // Validate the DOB format and parse
        LocalDate birthDate;

        try 
        {
            //Create a formatter with strict resolution to validate dates
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");//.withResolverStyle(ResolverStyle.STRICT);
            birthDate = LocalDate.parse(dateString, formatter);
        }
        catch (DateTimeParseException e)
        {
            return false; // returns false if invalid format
        }
        // Calculate age difference
        LocalDate today = LocalDate.now();

        // Check if user is 18+
        return Period.between(birthDate, today).getYears() >= 18;
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
    
        // Allow only JPG or PNG files
        if (!(fileName.endsWith(".jpg") || fileName.endsWith(".png"))) {
            return false;
        }
    
        // Check file size (example: max 4 MB)
        final long MAX_SIZE = 4 * 1024 * 1024; // 4 MB
        if (File.length() > MAX_SIZE) {
            return false;
        }
        return true;
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
    
