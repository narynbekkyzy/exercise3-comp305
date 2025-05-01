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

}