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
            for(int y = 0; y < sizeY; y++)
            {
                fields[x][y] = Math.random() < blockedProbability ? 'X' : ' ';
            }
        }

        // Change to random empty field
        fields[playerPosX][playerPosY] = 'o';
    }

    public void reset()
    {
        fillStart();    
    }

    public void move(Direction direction) throws WallException
    {
        int nextPosX = playerPosX + direction.getDirectionX();
        int nextPosY = playerPosY + direction.getDirectionY();

        if(nextPosX < 0 || nextPosX >= sizeX || nextPosY < 0 || nextPosY >= sizeY)
        {
            throw new WallException("I'll stop you right there. Moving outside the board is forbidden!");
        }

        if(fields[nextPosX][nextPosY] == 'X')
        {
            throw new WallException("There is a wall (X). You cannot walk through walls...");
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