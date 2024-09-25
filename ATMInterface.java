import java.util.Scanner; 
class BankAccount { 
  private double balance; 
  public BankAccount(double initialBalance) { 
    if (initialBalance >= 0) { 
      this.balance = initialBalance; 
    } 
    else { 
      this.balance = 0; 
    } 
  } 
  public double getBalance() { 
    return balance; 
  } 
  public void deposit(double amount) { 
    if (amount > 0) { 
      balance += amount; 
      System.out.println("Successfully deposited: $" + amount); 
    } 
    else { 
      System.out.println("Deposit amount must be positive."); 
    } 
  } 
  public boolean withdraw(double amount) { 
    if (amount > 0 && amount <= balance) { 
      balance -= amount; 
      System.out.println("Successfully withdrew: $" + amount); 
      return true; 
    } 
    else if (amount > balance) { 
      System.out.println("Insufficient balance for the transaction.");
      return false; 
    } 
    else { 
      System.out.println("Withdraw amount must be positive."); 
      return false; 
    } 
  } 
  public void checkBalance() { 
    System.out.println("Current balance: $" + balance); 
  } 
} 
class ATM { 
  private BankAccount account; 
  private Scanner scanner; 
  public ATM(BankAccount account) { 
    this.account = account; 
    this.scanner = new Scanner(System.in); 
  } 
  public void start() { 
    int option; 
    do {
      System.out.println("\n==== Welcome to the ATM ===="); 
      System.out.println("1. Check Balance"); 
      System.out.println("2. Deposit");
      System.out.println("3. Withdraw"); 
      System.out.println("4. Exit"); 
      System.out.print("Select an option (1-4): "); 
      option = scanner.nextInt(); 
      switch (option) { 
        case 1: 
          account.checkBalance(); 
          break; 
        case 2: 
          deposit(); 
          break; 
        case 3:
          withdraw(); 
          break; 
        case 4: 
          System.out.println("Thank you for using the ATM. Goodbye!"); 
          break; 
        default: 
          System.out.println("Invalid option. Please try again."); 
      } 
    } 
      while (option != 4); 
  } 
  private void deposit() { 
    System.out.print("Enter deposit amount: $"); 
    double amount = scanner.nextDouble(); 
    account.deposit(amount); 
  } 
  private void withdraw() { 
    System.out.print("Enter withdrawal amount: $"); 
    double amount = scanner.nextDouble(); 
    account.withdraw(amount);
  } 
} 
public class Main { 
  public static void main(String[] args) { 
    BankAccount account = new BankAccount(500); 
    // Initial balance of $500 
    ATM atm = new ATM(account); 
    atm.start(); 
  } 
}
