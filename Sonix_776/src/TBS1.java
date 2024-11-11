import java.util.Random;
	import java.util.Scanner;
	import java.time.LocalDate;
	import java.time.Period;

public class TBS1 {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int passengerId = generateRandomPassengerId();
	        System.out.println("Generated Passenger ID: " + passengerId);
	        System.out.print("Enter your name: ");
	        String name = scanner.nextLine();

	       
	        System.out.print("Enter the base fare for each seat: ");
	        double baseFare = scanner.nextDouble();
	        
	        System.out.print("Enter Gender (m/f): ");
	        String gender = scanner.nextLine();


	        System.out.print("Enter Date of Birth (DOB) in the format YYYYMMDD: ");
	        int dob = scanner.nextInt();
	        int age = calculateAge(dob);

	      
	        System.out.println("Age: " + age);
	        System.out.println("Senior Citizen: " + (age >= 60 ? "Yes" : "No"));

	       
	        scanner.nextLine();

	       

	        System.out.print("Enter Total Seats: ");
	        int totalSeats = scanner.nextInt();

	        System.out.print("Enter Seats Booked: ");
	        int seatsBooked = scanner.nextInt();

	        System.out.print("Enter Seats Blocked: ");
	        int seatsBlocked = scanner.nextInt();

	        int remainingSeatsPassenger1 = calculateRemainingSeats(seatsBooked, seatsBlocked, totalSeats);
	        double totalCostPassenger1 = calculateTotalCost(seatsBooked, seatsBlocked, totalSeats, age, baseFare);

	        System.out.println("Remaining Seats Passenger 1: " + remainingSeatsPassenger1);
	        System.out.println("Total Cost Passenger 1: " + totalCostPassenger1);

	        // Calculate total cost for all passengers
	        double totalCostAllPassengers = totalCostPassenger1;

	        System.out.println("\nTotal Cost for all Passengers: " + totalCostAllPassengers);

	        scanner.close();
	    }

	    private static int generateRandomPassengerId() {
	        Random random = new Random();
	        return random.nextInt(700);
	    }

	    private static int calculateRemainingSeats(int seatsBooked, int seatsBlocked, int totalSeats) {
	        return totalSeats - seatsBooked - seatsBlocked;
	    }

	    private static double calculateTotalCost(int seatsBooked, int seatsBlocked, int totalSeats, int age, double baseFare) {
	        int remainingSeats = calculateRemainingSeats(seatsBooked, seatsBlocked, totalSeats);

	        double totalCost = (seatsBooked + seatsBlocked) * baseFare;

	        if (age >= 60) {
	            totalCost *= 0.9; // 10% discount for senior citizens
	        }

	        if (remainingSeats > totalSeats * 0.5) {
	            totalCost *= 1.18; // 18% increment for more than 50% seats available
	        }

	        if (remainingSeats > totalSeats * 0.75) {
	            totalCost *= 1.32; // 32% increment for more than 75% seats available
	        }

	        return totalCost;
	    }

	    private static int calculateAge(int dob) {
	        LocalDate birthdate = LocalDate.of(dob / 10000, (dob / 100) % 100, dob % 100);
	        LocalDate currentDate = LocalDate.now();
	        return Period.between(birthdate, currentDate).getYears();
	    }
	}




