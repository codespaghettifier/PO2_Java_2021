public enum Direction
{
    UP (0, 1),
    RIGHT (1, 0),
    DOWN (0, -1),
    LEFT (-1, 0);

    private final int directionX;
    private final int directionY;

    Direction(int directionX, int directionY)
    {
        this.directionX = directionX;
        this.directionY = directionY;
    }

    public int getDirectionX()
    {
        return directionX;
    }
    
    public int getDirectionY()
    {
        return directionY;
    }

    public String toString()
    {
        return "[" + directionX + ", " + directionY + "]";
    }
}
