public class Main
{
    public static void main(String[] args)
    {
        Bufor buffer = new Bufor(2);
        Producent producentA = new Producent(buffer);
        Producent producentB = new Producent(buffer);
        Consumer consumerA = new Consumer(buffer);
        Consumer consumerB = new Consumer(buffer);

        producentA.start();
        producentB.start();
        consumerA.start();
        consumerB.start();
    }
}