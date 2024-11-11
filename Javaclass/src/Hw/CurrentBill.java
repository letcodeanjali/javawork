package Hw;

public class CurrentBill {
	public static double check(int units) {
		double total=0;
		if (units <=90) {
			total=units *1;
			
		}
		else if(units <= 150) {
			total=90 * 1 + (units - 90) * 1.5;
			
		}
		else if (units <= 200) {
            total = 90 * 1 + 60 * 1.5 + (units - 150) * 2;
	}
		else if (units <= 240) {
            total = 90 * 1 + 60 * 1.5 + 50 * 2 + (units - 200) * 2.5;
        } else {
            total = 90 * 1 + 60 * 1.5 + 50 * 2 + 40 * 2.5 + (units - 240) * 3;
        }
		 return total;
    }
    
    public static void main(String[] args) {
        int unitsConsumed = 290;
        double billAmount = check(unitsConsumed);
        System.out.println("The total bill amount  " + unitsConsumed + " is Rs. " + billAmount);
    }


	}

