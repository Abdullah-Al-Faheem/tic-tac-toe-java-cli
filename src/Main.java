public class Main
{
    public static void main (String[] args)
    {
//        System.out.println ("\nWelcome to Tic-Tac-Toe game!");

        Game myGame;
        myGame = new Game();

        myGame.getGameInfo();

        System.out.println("\n[ Game Started! ]");

        myGame.startGame();

        System.out.println("\nGame Over!\n");
    }
}