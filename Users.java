package Pk011_BankAccount;

import java.util.ArrayList;
import java.util.Scanner;

public class Users {

	Scanner input = new Scanner(System.in);
	ArrayList<String> n_ame = new ArrayList<String>();
	ArrayList<String> s_urname = new ArrayList<String>();
	ArrayList<Integer> accountnumber = new ArrayList<Integer>();

	private String name;
	private String surname;
	private int accnumber;
	BankAccount account;
	Withdrawal_limits limit;
	private int choice;
	private Double money;
	private String sign;

	// Users constructor
	public Users(Withdrawal_limits account) {
		this.account = account;
	}

	// Users Attribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAccnumber() {
		return accnumber;
	}

	public void setAccnumber(int accnumber) {
		this.accnumber = accnumber;
	}

	// User Methods

	public void Run() { // Starting Program

		while (true) {

			account.display.Message("\t<----| DEPOSIT TO MY BANK ACCOUNT | ---->");
			account.display.Message("");
			InsertName();
			InsertSurname();
			InsertAccountN();
			Running();
			break;
		}
	}

	public void Running() { // Check Users input Information

		while (true) {

			if (getAccnumber() == 0 || getAccnumber() <= 0) {
				break;

			} else if (getAccnumber() <= 100000 || getAccnumber() >= 999999999 || getAccnumber() <= 0) {
				account.display.Message("----->>> Error: Account Number is too Short!!");
				setAccnumber(0);
				account.display.Message(" ");
				Run();
				break;

			} else {

				// ArrayList Load
				n_ame.add(getName());
				s_urname.add(getSurname());
				accountnumber.add(getAccnumber());
				// Users Information view
				account.display.Message(toString());

				// Confirm data
				try {
					account.display.Message("");
					account.display.Message("------> If Correct Press [1], othewise Press [0] to insert again: ");
					choice = input.nextInt();
				} catch (Exception e) {
					account.display.Message("----->>> Error: Insert Only Number");
					continue;
				}
				if (choice == 1) {

					account.Menu(); // Menu View
					SelectMenu();
					break;

				} else if (choice == 0) {
					Run(); // Back to Run
					break;

				} else {
					account.display.Message("------>>>>>> WARNING: Wrong Number!!!!! <<<<<<------");
					account.display.Message("");
					Run();// Back to Run
					break;
				}
			}
		}
	}

	public void SelectMenu() { // Selection Menu

		while (true) {

			try {
				account.display.Message("");
				account.display.Message("---->>>> Select the Operation: ");
				choice = input.nextInt();
			} catch (Exception e) {
				account.display.Message("----->>> Error: Insert Only Number");
				continue;
			}

			if (choice == 1) { // Deposit cash money
				account.ChoiceMenu(choice);
				Money(choice);
				break;
			} else if (choice == 2) { // Deposit Checks
				account.ChoiceMenu(choice);
				Money(choice);
				break;

			} else if (choice == 3) { // Withdrawl Money
				account.ChoiceMenu(choice);
				Money(choice);
				break;

			} else if (choice == 4) { // Balance Information
				account.ChoiceMenu(choice);
				account.display.Message("Your Balance is:  " + account.Balance() + " $");
				account.display.Message("");
				account.Menu();
				SelectMenu();
				break;

			} else if (choice == 0) { // Exit
				account.ChoiceMenu(choice);
				Run();
				break;
			}

			else {
				account.display.Message("------>>>>>> WARNING: Wrong Number!!!!! <<<<<<------");
			}
		}
	}

	public void Money(int choice) { // Insert or Withdrawl Money

		while (true) {

			if (choice == 1) { // Deposit Money

				try {
					account.display.Message("\t---->>>> Deposit Money here $: ");
					money = input.nextDouble();
					account.display.Message("\tYou have deposited " + money + " $");
					account.display.Message("");
					choice = -1;
					account.display.Message("------> If Correct Press [1], othewise Press [0] to insert again: ");
					choice = input.nextInt();

				} catch (Exception e) {
					account.display.Message("----->>> Error: Insert Only Number");
					break;
				}

				if (choice == 1) { // Money Insert Control

					try {
						account.display.Message("------> [Deposit Made] <------");
						account.display.Message("");
						account.Deposit(money);
						account.Menu();
						SelectMenu();
						break;

					} catch (Exception e) {
						account.display.Message("----->>> Error: Insert Only Number");
						break;
					}

				} else { // Insert Cash Money Again
					Money(1);
				}

			} else if (choice == 2) { // Deposit Checks

				account.display.Message("\t-----> [Enter Check Details Here] <----- ");
				account.display.Message("");
				account.display.Message("\tName: ");
				account.checks.setName(input.next());
				account.display.Message("\tSurname: ");
				account.checks.setSurname(input.next());
				account.display.Message("Signature Appears?-----> [Y] or [N]: ");
				sign = input.next();
				account.checks.setSignature(sign);

				// Sign Control
				if (account.checks.getSignature().equals("y") || account.checks.getSignature().equals("Y")) {

					account.display.Message("\t-----> Name: " + account.checks.getName());
					account.display.Message("\t-----> Surname: " + account.checks.getSurname());
					account.display.Checksignature(account.checks.getSignature());
					choice = -1;

					try {
						account.display.Message("");
						account.display.Message("------> If Correct Press [1], othewise Press [0] to insert again: ");
						choice = input.nextInt();

					} catch (Exception e) {
						account.display.Message("----->>> Error: Insert Only Number");
						break;
					}

					if (choice == 1) { // Checks Deposit Control

						try {
							account.display.Message("\t---->>>> Insert Import Check here $: ");
							money = input.nextDouble();
							account.display.Message("\tYou have Insert " + money + " $");
							account.display.Message("");
							choice = -1;
							account.display
									.Message("------> If Correct Press [1], othewise Press [0] to insert again: ");
							choice = input.nextInt();

						} catch (Exception e) {
							account.display.Message("----->>> Error: Insert Only Number");
							break;
						}

						if (choice == 1) { // Check Deposit

							try {
								account.CheckDeposit(money);
								account.Menu();
								SelectMenu();
								break;

							} catch (Exception e) {
								account.display.Message("----->>> Error: Insert Only Number");
								break;
							}

						} else { // Check Insert Again
							Money(2);
						}

					} else { // Check Deposit Again
						Money(2);
					}
				}

				else { // Check Insert Sign Again
					account.Checksignature(sign);
					Money(2);
				}

			} else if (choice == 3) { // Withdrawl Money Control

				try {
					account.display.Message("\t---->>>> Withdrawl Money here $: ");
					money = input.nextDouble();
					account.display.Message("\tYou want to Withdrawl " + money + " $");
					account.display.Message("");
					choice = -1;
					account.display.Message("------> If Correct Press [1], othewise Press [0] to insert again: ");
					choice = input.nextInt();

				} catch (Exception e) {
					account.display.Message("----->>> Error: Insert Only Number");
					break;
				}

				if (choice == 1) { // Withdrawl Money

					try {
						account.Withdrawl(money);
						account.Menu();
						SelectMenu();
						break;

					} catch (Exception e) {
						account.display.Message("----->>> Error: Insert Only Number");
						break;
					}

				} else { // Withdrawl Money Again
					Money(3);
				}
			}
		}
	}

	public void InsertName() { // Insert Name

		while (true) {
			account.display.Message("\tInsert Name here:");
			setName(input.next());
			break;
		}
	}

	public void InsertSurname() { // Insert SurName

		while (true) {

			account.display.Message("\tInsert Surname here:");
			setSurname(input.next());
			break;
		}
	}

	public void InsertAccountN() { // Insert Account Number

		while (true) {

			try {
				account.display.Message("\tInsert Account Number here:");
				setAccnumber(input.nextInt());
				break;

			} catch (Exception e) {
				n_ame = null;
				s_urname = null;
				accountnumber = null;
				account.display.Message("----->>> Error: Insert Only Number");
				break;
			}
		}
	}

	// Print User information data
	@Override
	public String toString() {
		return "\tName: " + name + " \n\tSurname: " + surname + " \n\tAccount: " + accnumber + "";
	}
}


/************************************************************
* (C) Copyright 2021 by GinaCarlo, and All Rights Reserved. *
* Java development code with basic simple algorithms.       *
* There is no guarantee regarding the use of these codes,   *
* the author will not be responsible for any damage.        *
* Java Study Course 2021 (C) (R)                            *
************************************************************/



