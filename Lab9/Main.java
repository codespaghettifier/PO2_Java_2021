import java.util.Scanner;

public class Main
{
    private static Board board;
    private static Scanner scanner;
    private static boolean playing;

    public static void main(String[] args) 
    {
        scanner = new Scanner(System.in);
 
        int boradSize = askUserForBoardSize();

        board = new Board(boradSize, boradSize, 0.3);

        playing = true;
        while(playing)
        {
            try
            {
                playNextRound();
            }
            catch(OptionNotRecognizedException exception)
            {
                System.out.println("Wait, that's illegal:\n\t" + exception);
            }
            catch(WallException exception)
            {
                System.out.println("Wait, that's illegal:\n\t" + exception);
            }   
        }
        scanner.close();

        board.print();
    }

    private static void playNextRound() throws OptionNotRecognizedException, WallException
    {
        board.print();

        System.out.println(Option.RESET);
        System.out.println(Option.UP);
        System.out.println(Option.RIGHT);
        System.out.println(Option.DOWN);
        System.out.println(Option.LEFT);
        System.out.println(Option.EXIT);

        System.out.print("Wybierz opcje: ");
        char input = scanner.next().charAt(0);

        if(input == Option.EXIT.getKey())
        {
            playing = false;
        }
        else if(input == Option.RESET.getKey())
        {
            board.reset();
        }
        else if(input == Option.UP.getKey())
        {
            board.move(Option.UP.getDirection());
        }
        else if(input == Option.RIGHT.getKey())
        {
            board.move(Option.RIGHT.getDirection());
        }
        else if(input == Option.DOWN.getKey())
        {
            board.move(Option.DOWN.getDirection());
        }
        else if(input == Option.LEFT.getKey())
        {
            board.move(Option.LEFT.getDirection());
        }
        else
        {
            throw new OptionNotRecognizedException("There is no option: " + input);
        }
    }

    private static int askUserForBoardSize()
    {
        int size = 0;
        boolean userIsRetarded = true;
        while(userIsRetarded)
        {
            System.out.println("Podaj rozmiar planszy:");
            String input = scanner.nextLine();

            try
            {
                size = Integer.parseInt(input);
            }
            catch(NumberFormatException exception)
            {
                System.out.println("BŁAD: Podaj liczbę calkowitą!\n");
                continue;
            }

            if(size < 2)
            {
                System.out.println("BŁAD: Zbyt mała wartość nx: " + size + "!\n");
                continue;
            }

            userIsRetarded = false;
        }

        return size;
    }
}