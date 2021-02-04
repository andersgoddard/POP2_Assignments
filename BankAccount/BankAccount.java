// 13184648
// agodda02@mail.bbk.ac.uk

public class BankAccount { 

    int balance;
	int minBalance;
	int maxBalance;

    BankAccount( int initialBalance )
    {
        balance = initialBalance;
		this.minBalance = initialBalance;
		this.maxBalance = initialBalance;
    }

    public int getBalance()
    {
        return balance;
    }

    public void updateBalance( int newBalance )
    {
		
		if (newBalance > maxBalance) this.maxBalance = newBalance;
		if (newBalance < minBalance) this.minBalance = newBalance;
		
        this.balance = newBalance;
    }

    public int getMin()
    {
        return this.minBalance;
    }

    public int getMax()
    {
        return this.maxBalance;
    }
   
}