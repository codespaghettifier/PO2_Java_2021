import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Server
{
    private static int clientNum = 0;
    private static ArrayList<ClientHandler> clientHandlers = new ArrayList<ClientHandler>();

    private static class ClientHandler extends Thread
    {
        private Socket socket;
        private String clientName;
        private PrintWriter out;

        public ClientHandler(Socket socket, String clientName) throws Exception
        {
            this.socket = socket;
            this.clientName = clientName;
            out = new PrintWriter(socket.getOutputStream(), true);
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

                    StringTokenizer tokenizer = new StringTokenizer(line, "#");
                    String message = tokenizer.nextToken();
                    String receiverName = tokenizer.nextToken();

                    ClientHandler receiver = null;
                    for(int i = 0; i < clientHandlers.size(); i++)
                    {
                        if(receiverName.equals(clientHandlers.get(i).clientName))
                        {
                            receiver = clientHandlers.get(i);
                            break;
                        }
                    }
                    if(receiver == null) continue;
                    
                    receiver.out.println(clientName + ": " + message);
                }
            }
            catch(IOException exception)
            {

            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        ServerSocket serverSocket = new ServerSocket(1234);

        while(true)
        {
            Socket clientSocket = serverSocket.accept();

            System.out.println("New client request received: " + clientSocket);

            ClientHandler handler = new ClientHandler(clientSocket, "client " + clientNum++);
            clientHandlers.add(handler);
            handler.start();
        }
    }
}