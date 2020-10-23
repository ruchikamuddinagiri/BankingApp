package com.ruchika.banking;

class Withdraw{
	int amount;
	Account acc;
	public Withdraw(Account acc, int amount) {
		this.acc = acc;
		this.amount = amount;
		acc.withdraw(amount);
	}
//	public void run() {
//		acc.withdraw(amount);
//		
//	}
}