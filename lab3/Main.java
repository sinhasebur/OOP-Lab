import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Account[] accounts = new Account[50];

        int accountCount = 0;
        boolean found = false;
        double balance;
        String id;

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1.Create account");
            System.out.println("2.Display account");
            System.out.println("3.Debit");
            System.out.println("4.Credit");
            System.out.println("5.Transfer");
            System.out.println("6. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    int type;
                    System.out.println("Enter account name");
                    String name = sc.nextLine();
                    System.out.println("Enter account id");
                    id = sc.nextLine();
                    System.out.println("Enter initial deposit amount");
                    balance = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("What type of account do you want to add?");
                    System.out.println("1. Current Account\n2. Savings Account\n3. Deposit Premium Account");

                    type = sc.nextInt();
                    sc.nextLine();

                    if (type == 1) {
                        accounts[accountCount++] = new CurrentAccount(id, name, balance);
                    } else if (type == 2) {
                        accounts[accountCount++] = new SavingsAccount(id, name, balance);
                    } else if (type ==3) {
                        accounts[accountCount++] = new PremiumDepositAccount(id, name, balance);
                    }
                    break;

                case 2:
                    found = false;
                    System.out.println("Enter account id: ");
                    id = sc.nextLine();

                    for (int i = 0; i < accountCount; i++) {
                        if (id.equals(accounts[i].getID())) {
                            System.out.println(accounts[i].toString());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found");
                    }
                    break;

                case 3:
                    found = false;
                    System.out.println("Enter account id: ");
                    id = sc.nextLine();
                    System.out.println("Enter balance to debit: ");
                    balance = sc.nextDouble();
                    sc.nextLine();
                    sc.nextLine();
                    for (int i = 0; i < accountCount; i++) {
                        if (id.equals(accounts[i].getID())) {
                            accounts[i].debit(balance);
                            double afterDebit = accounts[i].getBalance();
                            System.out.println("Current Balance: " + afterDebit);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found");
                    }
                    break;
                case 4:
                    found = false;
                    System.out.println("Enter account id: ");
                    id = sc.nextLine();
                    System.out.println("Enter amount to credit: ");
                    balance = sc.nextDouble();
                    sc.nextLine();
                    for (int i = 0; i < accountCount; i++) {
                        if (id.equals(accounts[i].getID())) {
                            accounts[i].credit(balance);
                            double afterCredit = accounts[i].getBalance();
                            System.out.println("Current Balance: " + afterCredit);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found");
                    }
                    break;

                case 5:
                    System.out.println("Enter your account id: ");
                    String id1 = sc.nextLine();
                    System.out.println("Enter your transfer destination id: ");
                    String id2 = sc.nextLine();
                    int index1 = 0;
                    int index2 = 0;
                    boolean found1 = false;
                    boolean found2 = false;

                    for (int i = 0; i < accountCount; i++) {
                        if (id1.equals(accounts[i].getID())) {
                            found1 = true;
                            index1 = i;
                            break;
                        }
                    }
                    for (int i = 0; i < accountCount; i++) {
                        if (id2.equals(accounts[i].getID())) {
                            found2 = true;
                            index2 = i;
                            break;
                        }
                    }

                    if (!found1) {
                        System.out.println("Source Account not found");
                    }
                    if (!found2) {
                        System.out.println("Destination Account not found");
                    }

                    if (found1 && found2) {
                        System.out.println("Enter amount to transfer: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();
                        accounts[index1].transferTo(accounts[index2], amount);
                        System.out.println("Transfer Successful");
                        System.out.println("Balance in your account after transfer: " + accounts[index1].getBalance());
                    }
                    break;
                case 6:
                    return;
            }

        }
    }

}