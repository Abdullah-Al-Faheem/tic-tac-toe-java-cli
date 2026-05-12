public class Board
{
    private char[][] myBoard = new char[3][3];

    public void useBoard ()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++) myBoard[i][j] = ' ';
        }
    }

    public void display ()
    {
        System.out.println ("\n [1] [2] [3]    ← c");
        System.out.println ("|---|---|---|     ↓r");
        for (int i = 0; i < 3; i++)
        {
            System.out.print ("| ");

            for (int j = 0; j < 3; j++) System.out.print (myBoard[i][j] + " | ");

            System.out.print("["+ (i+1) +"]");
            System.out.println ("\n|---|---|---|");

        }
    }

    public boolean move(int row, int col, char symbol)
    {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && myBoard[row][col] == ' ')
        {
            myBoard[row][col] = symbol;
            return true;
        }
        return false;
    }

    public char[][] getGrid ()
    {
        return myBoard;
    }


}