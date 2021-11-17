import java.util.Scanner;

public class Main
{
    public static void main(String[] args) 
    {
        Board board = new Board(7, 7, 0.2);

        Scanner scanner = new Scanner(System.in);
        while(true)
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

            if(input == Option.EXIT.getKey()) break;
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
            
        }
        scanner.close();

        board.print();
    }
}