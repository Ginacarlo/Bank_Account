package Pk011_BankAccount;

public class Main_StartSoftware {

	public static void main(String[] args) {

		// BankAccount account;
		Users user;
		Withdrawal_limits account;

		account = new Withdrawal_limits();
		user = new Users(account);

		// Start Program
		user.Run();
	}

}


/************************************************************
* (C) Copyright 2021 by GinaCarlo, and All Rights Reserved. *
* Java development code with basic simple algorithms.       *
* There is no guarantee regarding the use of these codes,   *
* the author will not be responsible for any damage.        *
* Java Study Course 2021 (C) (R)                            *
************************************************************/