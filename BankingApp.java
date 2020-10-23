package com.ruchika.banking;
import java.util.*;

import java.util.Scanner;

public class BankingApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account abc = new Account();
		boolean flag = true;
		//display menu of options
		while (flag) {
			int money;
			System.out.println("Welcome to your banking application!");
			System.out.println("Tell us what you'd like to do!");
			System.out.println("1. View Account balance");
			System.out.println("2. Withdraw money from account");
			System.out.println("3. Deposit money into the account");
			System.out.println("4. Bank Statement: View transaction history");
			System.out.println("5. Exit");
			int option = sc.nextInt();
			sc.nextLine();
			switch (option) {
			case 1:
				//balance inquiry
				abc.displayBalance();
				break;
			case 2:
				//withdraw
				System.out.println("How much money do you want to withdraw?");
				money = sc.nextInt();
				sc.nextLine();
				Withdraw w = new Withdraw(abc, money);
				break;
			case 3:
				//deposit
				System.out.println("How much money do you want to deposit?");
				money = sc.nextInt();
				sc.nextLine();
				Deposit d = new Deposit(abc, money);
				break;
			case 4:
				Statement s = new Statement(abc);
				break;
			case 5:
				flag = false;
				break;
			default:
				System.out.println("Please select a valid option!");

			}
		}
	}

}
