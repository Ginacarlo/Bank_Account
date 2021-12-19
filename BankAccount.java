package Pk011_BankAccount;

public class BankAccount {

	private Double balance = 0.0;
	private Double amount;
	Display display;
	DepositChecks checks;

	// Account constructor

	public BankAccount() {
		display = new Display();
		checks = new DepositChecks();
	}

	// Account Attribute

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	// Account Methods

	public void Deposit(Double amount) { // Insert Money

		balance += amount;
	}

	public void Withdrawl(Double amount) { // Withdrawl Money

		balance -= amount;
	}

	public Double Balance() { // Account Balance

		return balance;
	}

	public void Menu() { // Menu View

		display.Menu();
	}

	public void ChoiceMenu(int choice) { // Menu Choice

		if (choice == 1) { // Check the choice

			display.Choice(choice);

		} else if (choice == 2) {

			display.Choice(choice);

		} else if (choice == 3) {

			display.Choice(choice);

		} else if (choice == 4) {

			display.Choice(choice);

		} else if (choice == 0) {

			display.Choice(choice);

		} else {
			display.Message("------>>>>>> WARNING: Wrong Number!!!!! <<<<<<------");
			Menu();
		}
	}

	public void CheckDeposit(Double amount) { // Check Deposit

		checks.setImport(amount);
		balance += amount;
		display.Message("------> [Check Paid] <------");
		display.Message("");
	}

	public void Checksignature(String Signature) { // Check Signature Message
		display.Checksignature(Signature);
	}
}


/************************************************************
* (C) Copyright 2021 by GinaCarlo, and All Rights Reserved. *
* Java development code with basic simple algorithms.       *
* There is no guarantee regarding the use of these codes,   *
* the author will not be responsible for any damage.        *
* Java Study Course 2021 (C) (R)                            *
************************************************************/



