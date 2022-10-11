package com.greatlearning.iitr.dsa;

import java.util.Arrays;
import java.util.Scanner;

public class Denomination {
	public static void countCurrency(int amount, int length, int[] notes)
	{

		int[] noteCounter = new int[length];

		Arrays.sort(notes);
		for (int i = 0; i < length / 2; i++) {
			int temp = notes[i]; 
			notes[i] = notes[length - i - 1]; 
			notes[length - i - 1] = temp; 
		} 

		for (int i = 0; i < length; i++) {
			if (amount >= notes[i]) {
				noteCounter[i] = amount / notes[i];
				amount = amount % notes[i];
			}
		}

		System.out.println("Your payment approach in order to give min no of notes will be:");
		for (int i = 0; i < length; i++) {
			if (noteCounter[i] != 0) {
				System.out.println(notes[i] + " : "
						+ noteCounter[i]);
			}
		}

	}

	public static void main(String argc[]){

		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of currency denominations");
		int length = sc.nextInt();
		int[] notes = new int[length];
		System.out.println("enter the currency denominations value:");
		for (int i = 0; i < length; i++) {
			notes[i] = sc.nextInt();
		}
		System.out.println("enter the amount you want to pay:");
		int amount =sc.nextInt();
		countCurrency(amount,length,notes);



		sc.close();
	}


}
