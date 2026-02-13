package atmMachine;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Optionmenu extends Account {

    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();
    int selection;

    /* Validate login information */
    public void getLogin() throws IOException {

        data.put(98765432, 9876);
        data.put(89897665, 1890);

        boolean authenticated = false;

        do {
            try {
                System.out.println("Welcome to the ATM Project");
                System.out.print("Enter your Customer Number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter your Pin Number: ");
                setPinNumber(menuInput.nextInt());

                for (Entry<Integer, Integer> entry : data.entrySet()) {
                    if (entry.getKey().equals(getCustomerNumber())
                            && entry.getValue().equals(getPinNumber())) {
                        authenticated = true;
                        getAccountType();
                        break;
                    }
                }

                if (!authenticated) {
                    System.out.println("\nWrong Customer Number or Pin Number.\n");
                }

            } catch (Exception e) {
                System.out.println("\nInvalid character(s). Only numbers.\n");
                menuInput.nextLine(); // clear buffer
            }
        } while (!authenticated);
    }

    /* Account type menu */
    public void getAccountType() {
        System.out.println("\nSelect the Account you want to access:");
        System.out.println("1 - Checking Account");
        System.out.println("2 - Saving Account");
        System.out.println("3 - Exit");
        System.out.print("Choice: ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> getChecking();
            case 2 -> getSaving();
            case 3 -> System.out.println("Thank you for using this ATM, bye.");
            default -> {
                System.out.println("\nInvalid Choice\n");
                getAccountType();
            }
        }
    }

    /* Checking account menu */
    public void getChecking() {
        System.out.println("\nChecking Account:");
        System.out.println("1 - View Balance");
        System.out.println("2 - Withdraw Funds");
        System.out.println("3 - Deposit Funds");
        System.out.println("4 - Exit");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> {
                System.out.println("Balance: " +
                        moneyFormat.format(getCheckingBalance()));
                getAccountType();
            }
            case 2 -> {
                getCheckingWithdrawInput();
                getAccountType();
            }
            case 3 -> {
                getCheckingDepositInput();
                getAccountType();
            }
            case 4 -> getAccountType();
            default -> {
                System.out.println("\nInvalid Choice\n");
                getChecking();
            }
        }
    }

    /* Saving account menu */
    public void getSaving() {
        System.out.println("\nSaving Account:");
        System.out.println("1 - View Balance");
        System.out.println("2 - Withdraw Funds");
        System.out.println("3 - Deposit Funds");
        System.out.println("4 - Exit");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> {
                System.out.println("Balance: " +
                        moneyFormat.format(getSavingBalance()));
                getAccountType();
            }
            case 2 -> {
                getSavingWithdrawInput();
                getAccountType();
            }
            case 3 -> {
                getSavingDepositInput();
                getAccountType();
            }
            case 4 -> System.out.println("Thank you for using this ATM, bye.");
            default -> {
                System.out.println("\nInvalid Choice\n");
                getSaving();
            }
        }
    }
}
