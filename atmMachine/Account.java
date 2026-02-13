package atmMachine;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account{
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	// Set the Customer Account Number
	public int setCustomerNumber(int customerNumber){
		this.customerNumber = customerNumber;
		return customerNumber;
	}

	// Get the Customer Account Number
	public int getCustomerNumber(){
		return customerNumber;
	}

	//Set Pin Number
	public int setPinNumber(int pinNumber){
		this.pinNumber = pinNumber;
		return pinNumber;
	}
	//Get the pin number
	public int getPinNumber(){
		return pinNumber;
	}
	// Calculate checking account Balance
	public double getCheckingBalance(){
		return checkingBalance;
	}

	//Calculate saving account Balance
	public double getSavingBalance(){
		return savingBalance;
	}

	//Calculate checking account withdrawal
	public double calcCheckingWithdraw(double amount){
		checkingBalance = (checkingBalance - amount);
		return checkingBalance;
	}

	//Calculate Saving Account withdrawal
	public double calcSavingWithdraw(double amount){
		savingBalance = (savingBalance - amount);
		return savingBalance;
	}

	//Calculate Checking account Deposit
	public double calcCheckingDeposit(double amount){
		checkingBalance=(checkingBalance + amount);
		return checkingBalance;
	}

	// Caclculate Saving Account Deposit
	public double calcSavingDeposit(double amount){
		savingBalance = (savingBalance + amount);
		return savingBalance;
	}

	//Calculate Checking account withdraw input
	public void getCheckingWithdrawInput(){
		System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
		System.out.println("Amount you want to withdraw from checking account: ");
		double amount = input.nextDouble();
		if((checkingBalance - amount) >= 0){
		   calcCheckingWithdraw(amount);
		   System.out.println("New Checking Account Balance: "+moneyFormat.format(checkingBalance));
		}else{
			System.out.println("Balance cannot be negative" + "\n");
		}
	}

	// Calculate saving account withdraw input
	public void getSavingWithdrawInput(){
		System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
		System.out.println("Amount you want to withdraw from saving account: ");
		double amount = input.nextDouble();
		if((savingBalance - amount) >= 0){
		   calcSavingWithdraw(amount);
		   System.out.println("New Saving Account Balance: "+moneyFormat.format(savingBalance));
		}else{
			System.out.println("Balance cannot be negative" + "\n");
		}
	}

	//Calculate checking account deposit input
	public void getCheckingDepositInput(){
		System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
		System.out.println("Amount you want to Deposit from checking account: ");
		double amount = input.nextDouble();
		if((checkingBalance + amount) >= 0){
		   calcCheckingDeposit(amount);
		   System.out.println("New Checking Account Balance: "+moneyFormat.format(checkingBalance));
		}else{
			System.out.println("Balance cannot be negative" + "\n");
		}
	}

	// Calculate Saving Account withdraw input
	public void getSavingDepositInput(){
		System.out.println("Checking Account Balance: " + moneyFormat.format(savingBalance));
		System.out.println("Amount you want to Deposit from checking account: ");
		double amount = input.nextDouble();
		if((savingBalance + amount) >= 0){
		   calcSavingDeposit(amount);
		   System.out.println("New Saving Account Balance: "+moneyFormat.format(savingBalance));
		}else{
			System.out.println("Balance cannot be negative" + "\n");
		}
	}
	private int customerNumber;
	private int pinNumber;
	private double checkingBalance = 0;
	private double savingBalance = 0;
}	

