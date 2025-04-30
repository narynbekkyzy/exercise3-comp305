/*
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
     * @return true if the name is not empty, false otherwise
     */

    public static boolean validateNameField(String name) {
        if (name == null) return false;
        if (name.trim().length() < 2) return false;
        if (!name.matches("[a-zA-Z\\s]+")) return false;
        return true;
    }    

}