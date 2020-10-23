package com.ruchika.banking;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class Account{
	public int balance;
	public int accno;
	void displayBalance() {
		String s = "";
		//read from file and initialize
		try (FileInputStream fis = new FileInputStream("statement.txt");
				BufferedInputStream bis = new BufferedInputStream(fis)) {
			int i = 0;
			while((i = bis.read())!=-1){
				s = s + (char)i;		
			}
			this.balance = Integer.parseInt(s.substring(s.lastIndexOf('B')+9).trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Balance: " + balance);
	}
	
	void deposit(int amount) {
		this.balance += amount; 
		//file operations
		try (FileOutputStream fos = new FileOutputStream("statement.txt", true)) {
			String s = "Amount deposited" + amount + ". Balance: "+ this.balance + "\n";
			byte b[] = s.getBytes();
			fos.write(b);
			fos.close();
			System.out.println("Statement prepared.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Amount deposited: " + amount);
		displayBalance();
	}
	void withdraw(int amount) {
		if(this.balance-amount < 0) {
			System.out.println("Balance account is too low. Cannot withdraw "+ amount);
			displayBalance();
		}
		else {
			this.balance -= amount;
			//file operations
			try (FileOutputStream fos = new FileOutputStream("statement.txt", true)) {
				String s = "Amount withdrawn: " + amount + ". Balance: "+ this.balance + "\n";
				byte b[] = s.getBytes();
				fos.write(b);
				fos.close();
				System.out.println("Statement prepared");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Amount withdrawn: " + amount);
			displayBalance();
		}
	}
	
	synchronized void statement() {
		//file operations
		try (FileInputStream fis = new FileInputStream("statement.txt");
				BufferedInputStream bis = new BufferedInputStream(fis)) {
			int i = 0;
			while((i = bis.read())!=-1){
				System.out.print((char)i);			
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
