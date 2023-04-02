import java.util.Arrays;
import java.util.Scanner;
public class TicTacToeGame {
    //Method to fill the board with ' ' ::
    private void initializeBoard(char[][]board)
    {
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }
    }
    //Method to print the board
    private void printBoard(char[][]board)
    {
        for(char[] chars:board)
        {
            for (char ch:chars)
                System.out.print(ch+ " |" );
            System.out.println();
        }
    }
    //Method to check whether the player has won or not:
    private boolean hasWon(char[][]board,char player)
    {
        // check for the row
        for(int row=0;row<board.length;row++)
        {
            if(board[row][0]==player&&board[row][1]==player&&board[row][2]==player)return true;
        }
        //check for the col
        for(int col=0;col<board[0].length;col++)
        {
            if(board[0][col]==player&&board[1][col]==player&&board[2][col]==player)return true;
        }
        //check diagonally
        if((board[0][0]==player&&board[1][1]==player&&board[2][2]==player)||
                (board[0][2]==player&&board[1][1]==player&&board[2][0]==player))return true;
        return false;
    }
    public void beginGame()
    {
        char[][]board=new char[3][3];//array of character
        initializeBoard(board);
        boolean gameOver=false;
        char player='X';
        while(!gameOver) {
            //print the board::
            printBoard(board);
            //Input the position
            Scanner in = new Scanner(System.in);
            System.out.print("Player " + player + " Enter::");
            int row = in.nextInt();
            int col = in.nextInt();
            //fill only if the  index are valid
            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = hasWon(board, player);
                if (gameOver) System.out.println("Player " + player + " has Won!!");
                else
                    player = player == 'X' ? 'O' : 'X';
            } else {
                System.out.println("Invalid Move. Try Again!");
            }
        }
        printBoard(board);
    }
}
