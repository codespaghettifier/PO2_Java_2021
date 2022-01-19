public class Producent extends Thread
{
    private Bufor buffer;

    Producent(Bufor buffer)
    {
        this.buffer = buffer;
    }

    public void run()
    {
        while(true)
        {
            buffer.put();

            try
            {
                Thread.sleep((int)(Math.random() * 10000));
            }
            catch(InterruptedException exception)
            {
                System.out.println("InterruptionException");
            }
        }
    }
}