package pkgTicTacToe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        MainGame game = new MainGame();
        game.initializeBoard();
        System.out.println("Tic-Tac-Toe!");
        do
        {
            System.out.println("Current board layout:");
            game.printBoard();
            int row;
            int col;
            do
            {
                System.out.println("Player " + game.getCurrentPlayer() + ", enter an empty row and column to place your mark!");
                row = scan.nextInt()-1;
                col = scan.nextInt()-1;
            }
            while (!game.placeMark(row, col));
            game.changePlayer();
        }
        while(!game.isWinner() && !game.isBoardFull());
        if (game.isBoardFull() && !game.isWinner())
        {
            System.out.println("The game was a tie!");
        }
        else
        {
            System.out.println("Current board layout:");
            game.printBoard();
            game.changePlayer();
            System.out.println(Character.toUpperCase(game.getCurrentPlayer()) + " Wins!");
        }
    }
}
