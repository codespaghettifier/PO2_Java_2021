public abstract class BasicAccount
{
    private static final double MAX_MONTHLY_FEE = 10;
    private static final double MONTHLY_FEE_PERCENT = 10;

    protected String ownerName;
    protected double balance;
    private String pin;

    public BasicAccount(String ownerName, double balance, String pin)
    {
        this.ownerName = ownerName;
        this.balance = balance;
        this.pin = pin;
    }

    public void withdraw(double amount)
    {
        if(amount < 0)
        {
            System.out.println("Cannot withdraw negative amount!");
            return;
        }

        if(balance < amount)
        {
            System.out.println("Cannot withdraw funds. Balance is not big enough!");
            return;
        }

        balance -= amount;
    }

    public void deposit(double amount)
    {
        if(amount < 0)
        {
            System.out.println("Cannot deposit negative amount!");
            return;
        }

        balance += amount;
    }

    public double getBalance()
    {
        return balance;
    }

    public String getOwnerName()
    {
        return ownerName;
    }

    public boolean checkPin(String pin)
    {
        return this.pin.equals(pin);
    }

    public void monthlyUpdate()
    {
        balance += getMonthlyInterest() - getMonthlyFees();
    }

    public double getMonthlyFees()
    {
        double monthlyFee = MONTHLY_FEE_PERCENT * balance * 0.01;
        return MAX_MONTHLY_FEE < monthlyFee ? MAX_MONTHLY_FEE : monthlyFee;
    }

    public double getMonthlyInterest()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if(obj == null) return false;
        if(obj == this) return true;
        if(!obj.getClass().equals(this.getClass())) return false;

        BasicAccount other = (BasicAccount)obj;
        if(!ownerName.equals(other.ownerName)) return false;
        if(balance != other.balance) return false;
        if(!pin.equals(other.pin)) return false;

        return true;
    }
}