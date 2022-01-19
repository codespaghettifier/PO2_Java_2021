import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.io.BufferedWriter;

public class Main
{
    private static BufferedReader stdinBuffer = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)
    {
        int x = 0;
        int depth = 0;

        String path = askForLine("path: ");
        try
        {
            int target = 0;
            BufferedReader fileReader = Files.newBufferedReader(Paths.get(path), Charset.forName("UTF-8"));
            String line;
            while((line = fileReader.readLine()) != null)
            {
                String[] words = line.split(" ");
                int value = Integer.valueOf(words[1]);

                switch(words[0])
                {
                    case "forward":
                        x += value;
                        depth += value * target;
                        break;
                    case "up":
                        target -= value;
                        break;
                    case "down":
                        target += value;
                        break;
                }
            }
        }
        catch(IOException exception)
        {
            System.err.println("IOException");
            return;
        }

        boolean pathOk = false;
            }
            else
            {
                pathOk = true;
            }
        }
        while(!pathOk)
        {
            path = askForLine("path: ");
            if(Files.exists(Paths.get(path)))
            {
                String overwriteStr = askForLine("Plik o tej nazwie już istnieje. Nadpisać? (tak/nie): ");
                if(overwriteStr.equals("tak"))
                {
                    pathOk = true;
                }
            }
            else
            {
                pathOk = true;
            }
        }
        
        try
        {
            BufferedWriter outputWriter = Files.newBufferedWriter(Paths.get(path));
            outputWriter.write(x + "\t" + depth);
            outputWriter.close();
        }
        catch(IOException exception)
        {
            System.err.println("IOException");
            return;
        }

        try
        {
            stdinBuffer.close();
        }
        catch(IOException exception)
        {
            System.err.println("IOException");
            return;
        }
    }

    private static String askForLine(String question)
    {
        String path = null;
        System.out.print(question);
        try
        {
            path = stdinBuffer.readLine();
        }
        catch(IOException exception)
        {
            System.err.println("IOException");
            return null;
        }
        return path;
    }
}