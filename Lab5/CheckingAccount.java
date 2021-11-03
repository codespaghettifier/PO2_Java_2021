public class CheckingAccount extends InterestAccount
{
    private static final double MIN_BALANCE_VIOLATION_FEE = 10;
    private static final double MIN_BALANCE = 100;
    private static final double TRANSACTION_FFE = 0.5;
    private boolean applyMinBalanceViolationFee = false;
    private int thisMonthTransactionsCount = 0;

    public CheckingAccount(String ownerName, double balance, String pin)
    {
        super(ownerName, balance, pin);
    }

    public void withdraw(double amount)
    {
        super.withdraw(amount);
        
        thisMonthTransactionsCount++;

        applyMinBalanceViolationFee = balance < MIN_BALANCE;
    }

    public void deposit(double amount)
    {
        super.deposit(amount);
    
        thisMonthTransactionsCount++;
    }

    public void monthlyUpdate()
    {
        super.monthlyUpdate();
        
        applyMinBalanceViolationFee = false;
    }

    public double getMonthlyFees()
    {
        double fees = super.getMonthlyFees();
        fees += applyMinBalanceViolationFee ? MIN_BALANCE_VIOLATION_FEE : 0;
        fees += thisMonthTransactionsCount * TRANSACTION_FFE;

        return fees;
    }

    public String toString()
    {
        return "type: checking account, owner: " + ownerName + ", balance: " + balance;
    }
}