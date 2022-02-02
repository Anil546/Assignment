package com.nztest.nz.services;

import org.springframework.stereotype.Service;

import com.nztest.nz.pojo.Account;

@Service
public class BussService {

	
	public String generateFunc(Account accountData) {
		
		int lastIndex = accountData.getLastUsedIndex()+1;
		
		/**
		 * hardCoded Value for FreightmateCourierCo
		 * Assuming Carrier name must be more then 4 character
		 * Using First 4 character as perfix
		 * **/
		
		if(lastIndex < accountData.getRangeStart() || lastIndex > accountData.getRangeEnd())
			return "Index Range Error";
		String perfix=""; 			
		
		if (!accountData.getCarrierName().equalsIgnoreCase("FreightmateCourierCo"))
			perfix = accountData.getCarrierName().substring(0, 4).toUpperCase();
		else
			perfix = "FMCC";
	
			
		String newIndex = String.format("%0" + accountData.getDigits() + "d", lastIndex);
		int checkSumVal = checkSumCal(newIndex);
		String con = perfix + accountData.getAccountNumber() + newIndex + Integer.toString(checkSumVal);
		return con;
	}

	public  int getSumValue(String num, int mode) {
		int sum = 0;
		for (int i = num.length() - mode; i >= 0; i--) {
			sum = sum + num.charAt(i) - '0';
			i--;
		}
		return sum;
	}

	public  int checkSumCal(String newNum) {

		int evenSum = getSumValue(newNum, 1) * 3;
		int oddSum = getSumValue(newNum, 2) * 7;

		int checkSumValue = evenSum + oddSum;
		int num = checkSumValue + (10 - checkSumValue % 10);

		return num - checkSumValue;
	}

}
