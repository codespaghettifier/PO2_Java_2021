import java.util.Random;

public class Board
{
    private char[][] fields;
    private int sizeX;
    private int sizeY;
    private int playerPosX = 1;
    private int playerPosY = 1;
    private double blockedProbability;

    public Board(int sizeX, int sizeY, double blockedProbability)
    {
        fields = new char[sizeX][sizeY];
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.blockedProbability = blockedProbability;

        fillStart();
    }

    private void fillStart()
    {
        for(int x = 0; x < sizeX; x++)
        {
            fields[x][0] = 'X';
            fields[x][sizeY - 1] = 'X';
        }

        for(int y = 0; y < sizeY; y++)
        {
            fields[0][y] = 'X';
            fields[sizeX - 1][y] = 'X';
        }

        fields[sizeX / 2][sizeY - 1] = ' ';

        for(int x = 1; x < sizeX - 1; x++)
        {
            for(int y = 1; y < sizeY - 1; y++)
            {
                fields[x][y] = Math.random() < blockedProbability ? 'X' : ' ';
            }
        }

        fields[playerPosX][playerPosY] = 'o';
    }

    public void reset()
    {
        fillStart();    
    }

    public void move(Direction direction)
    {
        int nextPosX = playerPosX + direction.getDirectionX();
        int nextPosY = playerPosY + direction.getDirectionY();

        if(fields[nextPosX][nextPosY] == 'X')
        {
            System.out.println("NIE UDALO SIE WYKONAC TAKIEGO RUCHU.");
            return;
        }

        fields[playerPosX][playerPosY] = ' ';
        fields[nextPosX][nextPosY] = 'o';
        playerPosX = nextPosX;
        playerPosY = nextPosY;
    }

    public void print()
    {
        System.out.print("\n");
        for(int y = sizeY - 1; y >= 0; y--)
        {
            for(int x = 0; x < sizeX; x++)
            {
                System.out.print(fields[x][y]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}