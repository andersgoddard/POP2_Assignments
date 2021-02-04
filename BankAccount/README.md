Bank account (BankAccount.java).

The given class BankAccount.java allows the balance of a bank account (in pence!) to be stored, accessed, and updated. Observe that the method updateBalance overwrites the balance with whatever it is passed.

Modify this class so that the methods

public int getMin() and public int getMax()

return the minimum balance and the maximum balance (respectively) over the history of the account. You should in particular fill out these methods; in addition to filling out these methods, you may add member variables and you may modify the other given methods. (You should not assume that the balance fall into any particular range, other than that it is always represented by an int; do not assume, for example, that the balance is always positive.)

As examples, when s is a String, the code fragment

BankAccount c = new BankAccount( -10 );
c.updateBalance( -2 );
c.updateBalance( -5 );
s = "Min: " + c.getMin() + ", Max: " + c.getMax();
should result in s being textually equal to “Min: -10, Max: -2”.

And, the code fragment

BankAccount c = new BankAccount( 10 );
c.updateBalance( 20 );
c.updateBalance( 5 );
s = "Min: " + c.getMin() + ", Max: " + c.getMax();
should result in s being textually equal to “Min: 5, Max: 20”.