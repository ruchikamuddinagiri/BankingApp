package com.ruchika.banking;

class Statement{

	Account acc;
	
	public Statement(Account acc) {
		this.acc = acc;
		acc.statement();
	}
	
}
