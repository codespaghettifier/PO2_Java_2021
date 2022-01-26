import java.net.*;
import java.io.*;

public class Client
{
    private static class InHandler extends Thread
    {
        private Socket socket;

        public InHandler(Socket socket)
        {
            this.socket = socket;
        }

        public void run()
        {
            try
            {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line;
                while((line = in.readLine()) != null)
                {
                    System.out.println(line);
                }
            }
            catch(IOException exception)
            {

            }
        }
    }

    private static class OutHandler extends Thread
    {
        private Socket socket;

        public OutHandler(Socket socket)
        {
            this.socket = socket;
        }

        public void run()
        {
            try
            {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

                while(true)
                {
                    String input = stdin.readLine();
                    out.println(input);
                }
            }
            catch(IOException exception)
            {

            }
        }
    }

    public static void main(String[] args) throws Exception
    {   
        Socket socket = new Socket("127.0.0.1", 1234);

        InHandler inHandler = new InHandler(socket);
        OutHandler outHandler = new OutHandler(socket);
        inHandler.start();
        outHandler.start();
    }
}