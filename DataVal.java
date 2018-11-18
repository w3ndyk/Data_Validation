import java.io.*;
import java.util.*;

// arrange classes according to order of input
// every input should be a while loop until input is correct
public class DataVal
{                                               
    public static void main(String args[]) { 
        boolean fNameCheck, lNameCheck, zipCheck, yearCheck, phoneCheck, passCheck1, passCheck2;
       
        Scanner scan = new Scanner(System.in);
        
        // // first name
        // System.out.print("Enter your first name: ");
        // String firstName = scan.nextLine();
        // fNameCheck = validName(firstName);
        
        // // last name
        // System.out.print("\nEnter your last name: ");
        // String lastName = scan.nextLine();
        // lNameCheck = validName(lastName);
        
        // // zip code
        // System.out.print("\nEnter your zip code: ");
        // String zipString = scan.nextLine();
        // zipCheck = validZipCode(zipString);
        // int zipCode;
        // if (zipCheck) {
            // zipCode = Integer.parseInt(zipString);
        // }
        
        // // year of birth (XXXX) ---> 1928 - 2017
        // System.out.print("\nEnter your year of birth: ");
        // String birthString = scan.nextLine();
        // yearCheck = validBirthYear(birthString);
        // int birthYear;
        // if (yearCheck) {
            // birthYear = Integer.parseInt(birthString);
        // }
        
        // // phone number (XXX-XXX-XXXX)                                                 
        // System.out.print("\nEnter your phone number (XXX-XXX-XXXX): ");
        // String phoneNum = scan.nextLine();
        // phoneCheck = validPhoneNum(phoneNum);
        
        // email address                                                                            ----- yooooooo!
        System.out.print("\nEnter your email address: ");
        String email = scan.nextLine();
        
        
        // username
        // idk so --> 8-30 characters; only alphanumeric and underscores (_); first must be letter
        
        // password
        // System.out.print("\nEnter your password: ");
        // String password1 = scan.nextLine();
        // passCheck1 = validPassword(password1);
        
        // // re-enter password                                          -- still need to be worked on --
        // System.out.print("\nRe-enter your password: ");
        // String password2 = scan.nextLine();
        // passCheck2 = password2.equals(password1);
            //if !passCheck2 --> do password1 again and say it has to match
    }
    
    public static boolean allAlpha(String str) {
        boolean condition = true;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i)) == false){
                condition = false;
            }
        }
        return condition;
    }
    
    public static boolean isNumString(String str) {
        boolean condition = true;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) == false){
                condition = false;
            }
        }
        return condition;
    }
    
    public static boolean validName(String str) {
        boolean letters = allAlpha(str);
        boolean length2 = str.length() >= 2;

        if(letters && length2) {
            System.out.println("\nName successfully documented");
            return true;
        }
        else {
            System.out.println("\nInvalid name:");
            if(!letters) {
                System.out.println("\tMust contain letters only");
            }
            if(!length2) {
                System.out.println("\tMust contain at least 2 letters");
            }
            return false;
        }
    }
    
    public static boolean validZipCode(String str) {
        if (isNumString(str) && str.length() == 5) {
            System.out.println("\nZip code successfully documented");
            return true;
        }
        else {
            System.out.println("\nInvalid zip code: ");
            if (!isNumString(str)) {
                System.out.println("\tMust contain integers only");
                if (str.length() == 5) {
                    System.out.println("\tMust contain 5 digits only");
                }
            }
            if(str.length() != 5) {
                System.out.println("\tMust contain 5 digits only");
            }
            return false;
        }
    }
    
    public static boolean validBirthYear(String str) {
        boolean reasonableYear = false;
        if (isNumString(str) && str.length() == 4) {
            int min = 1928, max = 2017;
            boolean withinRange = true;
            int year = Integer.parseInt(str);
            
            if ((year > min && year < max) || (year == min) || (year == max)) {
                System.out.println("\nBirth year successfully documented");
                reasonableYear = true;
            }
            else if (year < min || year > max) {
                System.out.println("\nInvalid year of birth:");
                System.out.println("\tMust be within reasonable range (1928-2017)");
            }
        }
        else if (!isNumString(str)) {
            System.out.println("\nInvalid year of birth:");
            System.out.println("\tMust contain integers only");
        }
        
        if (reasonableYear) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public static boolean validPhoneNum(String str) {
        boolean num = false, dash = false;
        if (str.length() == 12) {
            if (isNumString(str.substring(0,3)) && isNumString(str.substring(4,7)) && isNumString(str.substring(8,12))) {
                num = true;
            }
            if (str.charAt(3) == '-' && str.charAt(7) == '-') {
                dash = true;
            }
        }
        if (num && dash) {
            System.out.println("\nPhone number successfully documented");
            return true;
        }
        else {
            System.out.println("\nInvalid phone number:");
            if (str.length() == 12) {
                if (!num) {
                    System.out.println("\tMust contain numbers");
                }
                if (!dash) {
                    System.out.println("\tMust follow the format: XXX-XXX-XXXX");
                }
            }
            else {
                System.out.println("\tMust follow the format (XXX-XXX-XXXX) using numbers");
            }
            return false;
        }
    }
    
    public static boolean validEmail(String str) {                                               ///////////////////////
        // https://help.returnpath.com/hc/en-us/articles/220560587-What-are-the-rules-for-email-address-syntax-
        // local name (max 64) --> letters, numbers, special characters
            // special characters can't be first or last and can't appear consecutively 2 or more times
            // most common --> period (.), underscore (_), hyphen (-), plus (+)
        // @ symbol
        // domain name (2-63 before punctuation) --> letters, numbers, hyphen (-), 1 period (.)
            // top-level domain --> .com | .net | .org | .co
            // not case sensitive
            // don't include "www."
           
        // checks for '@'
        int atCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '@') {
                atCount += 1;
            }
        }
        
        if (atCount == 1) {
            int atSymbol = str.indexOf('@');
            String localName = str.substring(0, atSymbol);
            boolean localNameLength = (str.length() >= 2) && (str.length() <= 64);
        }
        else {
            System.out.println("Invalid email address:");
        }
        return false;
    }
    
    public static boolean validPassword(String str) {
        boolean isLength8, hasUpperCase, hasLowerCase, isNum2; 
        while (true) {
            // checks for at least 2 numbers
            int numCount = 0;
            for (int i = 0; i < str.length(); i++) {
                char[] array = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
                for (int j = 0; j < 10; j++) {
                    if (str.charAt(i) == array[j]) {
                        numCount += 1;
                    }
                }
            }
            
            isLength8 = str.length() >= 8; // at least 8 characters
            hasUpperCase = !str.equals(str.toLowerCase()); // at least 1 uppercase
            hasLowerCase = !str.equals(str.toUpperCase()); // at least 1 lowercase
            isNum2 = numCount >= 2; // at least 2 numbers

            break;
        }
        if (isLength8 && hasUpperCase && hasLowerCase && isNum2) {
            System.out.println("\nPassword successfully created");
            return true;
        }
        else {
            System.out.println("\nInvalid password:");
            if(!isLength8) {
                System.out.println("\tMust contain at least 8 characters");
            }
            if(!hasUpperCase) {
                System.out.println("\tMust contain at least 1 uppercase letter");
            }
            if(!hasLowerCase) {
                System.out.println("\tMust contain at least 1 lowercase letter");
            }
            if(!isNum2) {
                System.out.println("\tMust contain at least 2 numbers");
            }
            return false;
        }
    }
}
