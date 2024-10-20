import java.util.Scanner;

public class TicTacToe{

    private static final int BOARD_SIZE=3;
    private static char[][] gameBoard=new char[BOARD_SIZE][BOARD_SIZE];
    private static char currentPlayer='X';

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        boolean continuePlaying;

        do{
            setupBoard();
            playGame(input);
            System.out.println("Do you want to play again? (yes/no)");
            continuePlaying=input.next().equalsIgnoreCase("yes");
        } while (continuePlaying);

        System.out.println("Thanks for playing! Goodbye!");
        input.close();
    }

    private static void setupBoard(){
        for(int i=0;i<BOARD_SIZE;i++){
            for(int j=0;j<BOARD_SIZE;j++){
                gameBoard[i][j]=' ';
            }
        }
    }

    private static void playGame(Scanner input){
        boolean gameOver=false;

        while(!gameOver){
            displayBoard();
            makeMove(input);
            gameOver=checkForVictory() || checkForTie();
            if(!gameOver){
                switchTurn();
            }
        }

        displayBoard();
        if(checkForVictory()){
            System.out.println("Player " + currentPlayer + " has won the game!");
        } else {
            System.out.println("The game ended in a tie.");
        }
    }

    private static void displayBoard(){
        System.out.println("  1 2 3");
        for(int i=0;i<BOARD_SIZE;i++){
            System.out.print((i+1)+" ");
            for(int j=0;j<BOARD_SIZE;j++){
                System.out.print(gameBoard[i][j]);
                if (j<BOARD_SIZE-1) System.out.print("|");
            }
            System.out.println();
            if(i<BOARD_SIZE-1){
                System.out.println("  -----");
            }
        }
    }

    private static void makeMove(Scanner input){
        int row,col;
        boolean moveValid=false;

        while(!moveValid){
            System.out.println("Player "+currentPlayer+", enter your move (row and column):");
            row=input.nextInt()-1;
            col=input.nextInt()-1;

            if(row>=0 && row<BOARD_SIZE && col>=0 && col<BOARD_SIZE && gameBoard[row][col]==' '){
                gameBoard[row][col]=currentPlayer;
                moveValid=true;
            } else{
                System.out.println("Invalid move. Please try again.");
            }
        }
    }

    private static boolean checkForVictory(){
        for(int i=0;i<BOARD_SIZE;i++) {
            if (isLineComplete(gameBoard[i][0],gameBoard[i][1],gameBoard[i][2]) ||
                isLineComplete(gameBoard[0][i],gameBoard[1][i],gameBoard[2][i])) {
                return true;
            }
        }

        if(isLineComplete(gameBoard[0][0],gameBoard[1][1],gameBoard[2][2]) ||
            isLineComplete(gameBoard[0][2],gameBoard[1][1],gameBoard[2][0])){
            return true;
        }

        return false;
    }

    private static boolean isLineComplete(char a,char b,char c){
        return (a==b && b==c && a!=' ');
    }

    private static boolean checkForTie(){
        for(int i=0;i<BOARD_SIZE;i++){
            for(int j=0;j<BOARD_SIZE; j++){
                if(gameBoard[i][j]==' '){
                    return false;
                }
            }
        }
        return true;
    }

    private static void switchTurn(){
        currentPlayer=(currentPlayer=='X')?'O':'X';
    }
}
