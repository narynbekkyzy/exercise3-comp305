/*
Author: Jair Delgado 
Assisted By: Maddie 
 * This is the InputValidator class. Please complete this class with
 * appropiate JavaDoc comments, method and code comments, and the appropiate
 * methods to validate inputs from the user. 
 */

import java.text.BreakIterator;
import java.util.Locale;

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
        if (!name.trim().matches("[a-zA-Z\\s]+")) return false;
        return true;
    }    
    public static boolean validatelastNameField(String input) { //This is our boolean that will return true if more than 2 letters 
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
                if (letterCount >= 2) { 
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
            
}