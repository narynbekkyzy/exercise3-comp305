
Authors: Jair, Edith, Maggie, Nailya
-

Descriptions of classes
-
Input Validator: The main class where most of our team’s validation logic is implemented. This class contains multiple static methods that check whether user input meets specific criteria. Each method corresponds to a different form field, such as name, password, phone number, description, and more. The validations cover various requirements that were requested.

Input Validator Test: Contains all the unit tests written using JUnit to ensure that the validation methods in InputValidator work correctly.


How to Use:
-
To use this code, before beginning to edit the code which I will refer to later, we first must ensure that you have J Unit installed beforehand. One of the easiest methods is using VS code and finding the extension. After verifying that Junit is installed you can begin your test. To test, inside of our class "inputValidatorTest" you are able to edit the code inside the quotation marks to anything you'd like and if they fit inside the criteria and you’re testing for the “assertTrue” then the tests should pass and if they do not meet the requirements inside of the “assert False” statements then the code should still pass as well.  


Reflection 
-
Our team faced some challenges during the merge process because much of our code was written on the same lines, which caused conflicts. We resolved these issues through a combination of committing, pulling, and carefully editing minor differences like spaces. What really helped was merging each person’s changes one at a time and addressing any conflicts as they came up, which made it easier to debug and ensure everything worked by the end.

When expanding or refactoring our validator, we could consider additional conventions, such as what should or shouldn’t be allowed in email formats and international phone number prefixes (e.g., +1 for the U.S. or +52 for Mexico). We also realized that there are likely several repeated commands within the InputValidator class that could be refactored into a single, more efficient function that we initially missed.

In general, we enjoyed coding in this format as it was a rewarding feeling once our code actually passed. the step-by-step approach helped save time by making debugging more manageable and efficient.  
