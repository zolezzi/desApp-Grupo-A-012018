package edu.unq.desapp.grupo_a.backend.model;

public class CreditAccount {
	
	private Double currentAmount;
	
	public CreditAccount() {
		this.currentAmount = (double) 0;
	}

	public Double getCurrentAmount() {
		return this.currentAmount;
	}

	public void addAmount(Double amount) {
		this.currentAmount += amount;
	}
	
	public void loseAmount(Double amount) {
		this.currentAmount -= amount;
	}
}
