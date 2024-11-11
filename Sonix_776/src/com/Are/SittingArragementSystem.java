package com.Are;

public class SittingArragementSystem 
{
    public static double calculateSeatCost(int seatNumber) {
        double baseCost = 100.0; 
        
        if (seatNumber >= 0 && seatNumber <= 50) {
            return baseCost;
        } else if (seatNumber >= 51 && seatNumber <= 70) {
            return baseCost * 1.12; 
        } else if (seatNumber >= 71 && seatNumber <= 90) {
            return baseCost * 1.19; 
        } else if (seatNumber >= 91 && seatNumber <= 100) {
            return baseCost * 1.25; 
        } else {
            return -1.0; 
        }
    }

    public static void main(String[] args) {
        int totalSeats = 100;
        int[] seatsTaken = {45, 51,76, 93}; 

        double totalCost = 0.0;

        for (int seat : seatsTaken) {
            double cost = calculateSeatCost(seat);
            if (cost != -1.0) {
                totalCost += cost;
            }
        }

        System.out.print("Total Cost for "+seatsTaken.length+" seats: "+totalCost+" rupees");
    }
}
