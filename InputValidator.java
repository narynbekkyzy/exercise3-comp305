


public class InputValidator {
    public static boolean validateUsername(String username){
        // Left blank 
        if( username == null || username.isEmpty() ){
            return false;
        }
        // Greater than 20 
        if( username.length() > 20){
            return false;
        }
        return true;
        


    }
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

}