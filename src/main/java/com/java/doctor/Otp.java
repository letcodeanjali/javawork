package com.java.doctor;

import java.util.SplittableRandom;

public class Otp {
	
	public static String genrateOtp() {

		StringBuilder generatedOTP = new StringBuilder();
		SplittableRandom splittableRandom = new SplittableRandom();

		for (int i = 0; i < 6; i++) {
				
			int randomNumber = splittableRandom.nextInt(0, 9);
			generatedOTP.append(randomNumber);
		}
		return generatedOTP.toString();
	}

}
