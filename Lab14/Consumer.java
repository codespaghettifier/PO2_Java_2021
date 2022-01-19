public class Consumer extends Thread
{
    private Bufor buffer;
    
    public Consumer(Bufor buffer)
    {
        this.buffer = buffer;
    }

    public void run()
    {
        while(true)
        {
            buffer.get();

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