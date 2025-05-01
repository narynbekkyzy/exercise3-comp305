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
}