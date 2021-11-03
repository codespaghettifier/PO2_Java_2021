public class RegularAccount extends BasicAccount
{
    private static final double MIN_BALANCE_VIOLATION_FEE = 10;
    private static final double MIN_BALANCE = 500;
    private boolean applyMinBalanceViolationFee = false;

    public RegularAccount(String ownerName, double balance, String pin)
    {
        super(ownerName, balance, pin);
    }

    public void withdraw(double amount)
    {
        super.withdraw(amount);

        applyMinBalanceViolationFee = balance < MIN_BALANCE || applyMinBalanceViolationFee;
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
        
        return fees;
    }

    public String toString()
    {
        return "type: regular account, owner: " + ownerName + ", balance: " + balance;
    }
}