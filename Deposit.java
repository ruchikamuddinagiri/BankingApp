package com.ruchika.banking;
class Deposit{
	int amount;
	Account acc;
	public Deposit(Account acc, int amount) {
		this.acc = acc;
		this.amount = amount;
		acc.deposit(amount);
	}

//	public void run() {
//		acc.deposit(amount);
//		
//	}
	
}
