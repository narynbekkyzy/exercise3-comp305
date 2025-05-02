import java.util.Locale;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class InputValidator {

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