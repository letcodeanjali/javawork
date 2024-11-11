package Test;
import java.util.Scanner;



public class Email {
	
	
	
	

    public void checkEmail(String email) throws InvalidEmailException, InvalidUserException {
	        if (!email.contains("@")) {
	            throw new InvalidEmailException("Email must contain '@' symbol");
	        }

	        String[] parts = email.split("@");
	        String username = parts[0];

	        if (username.length() < 8 || username.length() > 17) {
	            throw new InvalidUserException("Username length should be between 8 to 17 characters");
	        }

	        System.out.println("Email: " + email);
	    }

	    public static void main(String[] args) {
	        String email;
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter Email: ");
	        email = sc.nextLine();
	        Email obj = new Email();
	        try {
	            obj.checkEmail(email);
	        } catch (InvalidEmailException | InvalidUserException e) {
	            System.out.println("Invalid Input: " + e.getMessage());
	        }
	    }
	}
class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

class InvalidUserException extends Exception {
    public InvalidUserException(String message) {
        super(message);
    }
}
