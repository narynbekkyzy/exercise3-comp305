/*
Author: Jair Delgado 
Assisted By: Maddie 
 * This is the InputValidator class. Please complete this class with
 * appropiate JavaDoc comments, method and code comments, and the appropiate
 * methods to validate inputs from the user. 
 */

    import java.text.BreakIterator; //found off google, input off github that helps take diacritic marks and takes letters from other languages off as well
    import java.util.Locale; //helps with character definitions 

    public class InputValidator 
{
    
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
            
    public static boolean isValidDateFormat(String input)  //Checking for a valid format of dates 
     {
        return input.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$"); //beings string, then 4 digits with a dash for year, 1 digit between 1&2 with a dash and then 
        //1 digits with a dash between 1-9 to get the second digit of month, lastly we do the same for day
     }
    }
