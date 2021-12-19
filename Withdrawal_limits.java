package Pk011_BankAccount;

public class Withdrawal_limits extends BankAccount {

	private final Double limit = 200.00;

	// Withdrawl constructor

	@Override
	public void Withdrawl(Double amount) { // Withdrawl Control limit

		if (amount <= limit) { // Withdrawl Control limit

			if (amount <= getBalance()) { // Withdrawl Balance Control
				super.Withdrawl(amount);
				display.Message("------> [Withdrawl Made] <------");
				display.Message("");

			} else {
				display.Message("------> [Withdrawal not Available, Your Balance is:  " + super.getBalance() + "$");
				display.Message("");
			}

		} else {
			display.Message("------> [Decline Withdrawal]");
			display.Message("");
		}
	}
}


/************************************************************
* (C) Copyright 2021 by GinaCarlo, and All Rights Reserved. *
* Java development code with basic simple algorithms.       *
* There is no guarantee regarding the use of these codes,   *
* the author will not be responsible for any damage.        *
* Java Study Course 2021 (C) (R)                            *
************************************************************/