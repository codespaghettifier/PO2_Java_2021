public class InterestAccount extends BasicAccount
{
    private static final double INTEREST_PERCENT = 2;

    public InterestAccount(String ownerName, double balance, String pin)
    {
        super(ownerName, balance, pin);
    }

    public double getMonthlyInterest()
    {
        return balance * INTEREST_PERCENT * 0.01;
    }

    public String toString()
    {
        return "type: interest account, owner: " + ownerName + ", balance: " + balance;
    }
}