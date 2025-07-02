public class SavingsAccount extends Account {

    public SavingsAccount() {}

    public SavingsAccount(String id, String name) {
        super(id, name, 0);
    }

    public SavingsAccount(String id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public double credit(double amount) {
        setBalance(getBalance() + amount + (getBalance() * (2.5F / 100)));
        return getBalance();
    }

    @Override
    public double debit(double amount) {
        if (getBalance() < 1000) {
            System.out.println("Must have atleast 1000 balance");
        } else if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Amount exceeds balance");
        }
        return getBalance();
    }



    @Override
    public String toString() {
        return "Account type: Savings Account\nAccount id= " + getID() + ", name= " + getName() + ", balance= " + getBalance();
    }
}