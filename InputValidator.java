/*
Author(s): Nailya, Maggie, Edith, Jair  
Assisted By: Maddie and Amara (CC)
 * This is the InputValidator class. Please complete this class with
 * appropiate JavaDoc comments, method and code comments, and the appropiate
 * methods to validate inputs from the user. 
 */

import java.text.BreakIterator; //found off google, input off github that helps take diacritic marks and takes letters from other languages off as well
import java.util.Locale; //helps with character definitions 
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
}
    
