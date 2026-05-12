public class Judge
{
    public boolean checkWinner (Board board, char symbol)
    {
        char[][] g = board.getGrid ();
        int cnt;

        for (int i = 0; i < 3; i++) // checking rows and columns
        {
            cnt = 0; // checking ith row
            for (int j = 0; j < 3; j++) if(g[i][j] == symbol) cnt++;
            if(cnt == 3) return true;

            cnt = 0; //checking ith column
            for (int j = 0; j < 3; j++) if(g[j][i] == symbol) cnt++;
            if(cnt == 3) return true;

        }

        // checking diagonal 1
        cnt = 0;
        for (int i = 0; i < 3; i++) if(g[i][i] == symbol) cnt++;
        if(cnt == 3) return true;

        // checking diagonal 2
        cnt = 0;
        for (int i = 0; i < 3; i++) if(g[i][2-i] == symbol) cnt++;
        if(cnt == 3) return true;

        return false;

    }

    public boolean chkDraw (Board board)
    {
        char[][] g = board.getGrid ();

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++) if(g[i][j] == ' ') return false;
        }

        return true;
    }
}