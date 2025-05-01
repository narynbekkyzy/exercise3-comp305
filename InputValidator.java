/*
Author: Jair Delgado 
Assisted By: Maddie 
 * This is the InputValidator class. Please complete this class with
 * appropiate JavaDoc comments, method and code comments, and the appropiate
 * methods to validate inputs from the user. 
 */

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
}