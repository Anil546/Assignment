package com.nztest.nz;

import java.util.Scanner;

public class Assignment {
	public static void main(String[] args) {
		try {

			Scanner myObj = new Scanner(System.in); // Create a Scanner object
			System.out.println("Enter CarrierName ::");
			System.out.println();
			String data = myObj.nextLine();

			System.out.println("Enter AccountNumber ::");
			System.out.println();
			String acc = myObj.nextLine();

			System.out.println("Enter Digits ::");
			System.out.println();
			int digit = myObj.nextInt();

			System.out.println("Enter LastIndexUsed ::");
			System.out.println();
			int lastIndex = myObj.nextInt();

			System.out.println("Enter RangeStart ::");
			System.out.println();
			int rangeStart = myObj.nextInt();

			System.out.println("Enter RangeStart ::");
			System.out.println();
			int rangeEnd = myObj.nextInt();
			String perfix = "";
			
			/**
			 * hardCoded Value for FreightmateCourierCo
			 * Assuming Carrier name must be more then 4 character
			 * Using First 4 character as perfix
			 * **/
			
			if (!data.equalsIgnoreCase("FreightmateCourierCo"))
				perfix = data.substring(0, 4).toUpperCase();
			else
				perfix = "FMCC";

			// Assuming we can get Carrier Perfix from a list of CarrierName
			String generateFunc = generateFunc(perfix, acc, digit, lastIndex, rangeStart, rangeEnd);
			System.out.println("OutPut :: " + generateFunc);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Please fill All the Field Properly");
		}

	}

	public static String generateFunc(String perfix, String acc, int digit, int lastIndex, int rangeStart,
			int rangeEnd) {

		lastIndex++;
		String newIndex = String.format("%0" + digit + "d", lastIndex);
		int checkSumVal = checkSumCal(newIndex);
		String con = perfix + acc + newIndex + Integer.toString(checkSumVal);
		return con;
	}

	public static int getSumValue(String num, int mode) {
		int sum = 0;
		for (int i = num.length() - mode; i >= 0; i--) {
			sum = sum + num.charAt(i) - '0';
			i--;
		}
		return sum;
	}

	public static int checkSumCal(String newNum) {

		int evenSum = getSumValue(newNum, 1) * 3;
		int oddSum = getSumValue(newNum, 2) * 7;
		int checkSumValue = evenSum + oddSum;
		int num = checkSumValue + (10 - checkSumValue % 10);

		return num - checkSumValue;
	}
}