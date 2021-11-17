public enum Option
{
    RESET ('r', "Reset planszy", null),
    UP ('w', "Przesuń w górę, wektor przesunięcia: [0,  1]", Direction.UP),
    RIGHT ('d', "Przesuń w prawo, wektor przesunięcia: [1,  0]", Direction.RIGHT),
    DOWN ('s', "Przesuń w dół, wektor przesunięcia: [0,  -1]", Direction.DOWN),
    LEFT ('a', "Przesuń w lewo, wektor przesunięcia: [-1,  0]", Direction.LEFT),
    EXIT ('q', "Zakończenie gry", null);

    private final char key;
    private final String description;
    private final Direction direction;

    Option(char key, String description, Direction direction)
    {
        this.key = key;
        this.description = description;
        this.direction = direction;
    }

    public char getKey()
    {
        return key;
    }

    public String getDescription()
    {
        return description;
    }

    public Direction getDirection()
    {
        return direction;
    }

    public String toString()
    {
        String str = "'" + key + "' ==> opcja ";
        switch(this)
        {
            case RESET:
                str += "DOWN";
                break;
            case UP:
                str += "UP";
                break;
            case RIGHT:
                str += "RIGHT";
                break;
            case DOWN:
                str += "DOWN";
                break;
            case LEFT:
                str += "LEFT";
                break;
            case EXIT:
                str += "EXIT";
                break;
        }
        str += ", opis: " + description;
        return str; 
    }
}