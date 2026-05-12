import java.util.Scanner;

public class Game
{
    private Board board = new Board();
    private Judge judge = new Judge();
    private Player player1, player2, currPlayer;

    private Scanner info = new Scanner(System.in);

    public void getGameInfo() // constructor
    {
        System.out.println("\nEnter Player 1 Details: ");
        System.out.print("Name: ");
        String name1 = info.next();

        System.out.print("Country: ");
        String country1 = info.next();

//        System.out.print("Enter Player 1 Symbol: (X/O) ");
        System.out.print("Symbol: ");
        char symbol1 = info.next().charAt(0);

        player1 = new Player (name1, country1, symbol1);

        System.out.println("\nEnter Player 2 Details: ");
        System.out.print("Name: ");
        String name2 = info.next();
        System.out.print("Country: ");
        String country2 = info.next();

        System.out.print("Symbol: ");
        char symbol2 = info.next().charAt(0);

        while(symbol2 == symbol1)
        {
            System.out.println("You have entered the same symbol; try again ");
            System.out.print("Symbol: ");
            symbol2 = info.next().charAt(0);
        }

//        char symbol2 ;
//        if(symbol1 == 'X' || symbol1 == 'x') symbol2 = 'O';
//        else symbol2 = 'X';
//        System.out.println("Player 2's Symbol: " + symbol2 );

        player2 = new Player (name2, country2, symbol2);


        System.out.println("\nWho will play the first move? (1/2)");
        int tmp = info.nextInt();

        if(tmp%2 == 0) { currPlayer = player2; }
        else { currPlayer = player1; }
    }

    public void startGame()
    {
        board.useBoard();
        board.display();

        // game on the loop
        while (true)
        {
            System.out.println ("\n" + currPlayer.name + "(" + currPlayer.symbol + "): Enter row (space) column : ");
            int row = info.nextInt()-1;
            int col = info.nextInt()-1;

            boolean validMove = board.move(row, col, currPlayer.symbol);

            if (validMove)
            {
                board.display();

                boolean win = judge.checkWinner(board, currPlayer.symbol);
                boolean Draw = judge.chkDraw(board); // checks if board is full

                if (win)
                {
                    System.out.println ("\nCongratulations! " + currPlayer.name +"("+ currPlayer.country + ") " +"! You win!");
                    break;
                }
                else if (Draw)
                {
                    System.out.println ("It's a tie!");
                    break;
                }

                if(currPlayer == player1) currPlayer = player2;
                else currPlayer = player1;
            }
            else if(!validMove) System.out.println ("Invalid move! Try again.");
        }

    }
}