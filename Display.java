package Pk011_BankAccount;

public class Display {

	private final int DEPOSIT = 1;
	private final int CHECKS = 2;
	private final int WITHDRAWL = 3;
	private final int BALANCE = 4;
	private final int EXIT = 0;

	// Display Methods

	public void Message(String message) { // Display for all message

		System.out.println();
		System.out.print(message);
		System.out.print(" ");

	}

	public void Menu() { // Display Menu View

		System.out.println();
		System.out.println("\t<----| MENU'| ---->");
		System.out.println("\t<----------------->");
		System.out.println();
		System.out.println("\t[1] - 'DEPOSIT' ");
		System.out.println("\t[2] - 'DEPOSIT CHECKS' ");
		System.out.println("\t[3] - 'WITHDRAWL' ");
		System.out.println("\t[4] - 'BALANCE' ");
		System.out.println("\t[0] - 'EXIT' ");

	}

	public void Choice(int choice) { // Display Menu Choice view

		switch (choice)

		{

		case DEPOSIT:
			System.out.println();
			System.out.println("\t<----| DEPOSIT | ---->");
			break;

		case CHECKS:
			System.out.println();
			System.out.println("\t<----| DEPOSIT CHECKS | ---->");
			break;

		case WITHDRAWL:
			System.out.println();
			System.out.println("\t<----| WITHDRAWL | ---->");
			break;

		case BALANCE:
			System.out.println();
			System.out.println("\t<----| BALANCE | ---->");
			break;

		case EXIT:
			System.out.println();
			System.out.println("\t<----| EXIT | ---->");
			break;

		}
	}

	public void Checksignature(String signature) { // Display sign Check

		if (signature.equals("y") || signature.equals("Y")) {

			System.out.println();
			System.out.println("\t<----| Sign --> YES | ---->");

		} else {

			System.out.println();
			System.out.println("\t<----| Sign --> NO | ---->");
			System.out.println();
			System.out.println("\t-----> Please Sign the Check");
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


