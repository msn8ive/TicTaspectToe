package mcCool.ticTaspectJoe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    static ArrayList<Integer> player1Positions = new ArrayList<Integer>();
    static ArrayList<Integer> player2Positions = new ArrayList<Integer>();

    public static void main(String[] args) {

    		
        System.out.println("Hey! Let's Play TicTacToe!");
        System.out.println();

        //board structures
        char[][] initialBoard = {{' ', '1', ' ', '|', ' ', '2', ' ', '|', ' ', '3' },
                {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-' },
                {' ', '4', ' ', '|', ' ', '5', ' ', '|', ' ', '6' },
                {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-' },
                {' ', '7', ' ', '|', ' ', '8', ' ', '|', ' ', '9' },};

        char[][] board = {{' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ' },
                {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-' },
                {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ' },
                {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-' },
                {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ' },};

        //get player names
        Scanner scanName = new Scanner(System.in);
        System.out.println("Player 1, enter your name:");
        String p1Name = scanName.nextLine();
         
        System.out.println("Player 2, enter your name:");
        String p2Name = scanName.nextLine();
        
        System.out.println("Thanks! Let's Play!");
        System.out.println();
        printInitialBoard(initialBoard);

        while(chkWinner() == 4) {
            Scanner scan = new Scanner(System.in);

//get player1 move and place on board
            System.out.println();

            //System.out.println(chkWinner());
            System.out.println(p1Name + ", enter your move (1-9):");
            int player1Pos = scan.nextInt();
            while (player1Positions.contains(player1Pos) || player2Positions.contains(player1Pos) 
            		|| player1Pos > 9 ) {
                System.out.println("Invalid choice! Try again:");
                player1Pos = scan.nextInt();
            }
            makeMove(board, player1Pos, "player1");
            //System.out.println(player1Pos);
            System.out.println("");
            printBoard(board);

//Was that the winning move?
		
            refCheck(p1Name, p2Name);  
            

//player2's turn
            System.out.println(p2Name + ", enter your move (1-9):");
            int player2Pos = scan.nextInt();
            while (player1Positions.contains(player2Pos) || player2Positions.contains(player2Pos) || player2Pos > 9) {
                System.out.println("Invalid choice! Try again:");
                player2Pos = scan.nextInt();
            }

            makeMove(board, player2Pos, "player2");
                //System.out.println(player2Pos);
                System.out.println("");
                printBoard(board);

//Was that the winning move?
                
            refCheck(p1Name, p2Name); 
				/*
				 * if (chkWinner() == 1){ System.out.println("");
				 * System.out.println("TIC-TAC-TOE!! " + p1Name + ", you won!"); break; } else
				 * if (chkWinner() == 2) { System.out.println("");
				 * System.out.println("TIC-TAC-TOE!! " + p2Name + ", you won!"); break; } else
				 * if (chkWinner() == 3) { System.out.println("");
				 * System.out.println("It's a tie! Try again!"); break; }
				 */
            
            }
                        
        }
        
    public static int chkWinner() {
    	//referee
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> lastRow = Arrays.asList(7, 8, 9);

        List<Integer> leftClmn = Arrays.asList(1, 4, 7);
        List<Integer> midClmn = Arrays.asList(2, 5, 8);
        List<Integer> rtClmn = Arrays.asList(3, 6, 9);

        List<Integer> diag1 = Arrays.asList(1, 5, 9);
        List<Integer> diag2 = Arrays.asList(3, 5, 7);

        List<List> winConditions = new ArrayList<List>();
        winConditions.add(topRow);
        winConditions.add(midRow);
        winConditions.add(lastRow);
        winConditions.add(leftClmn);
        winConditions.add(midClmn);
        winConditions.add(rtClmn);
        winConditions.add(diag1);
        winConditions.add(diag2);

        for(List<?> l : winConditions) {
            if(player1Positions.containsAll(l)) {
                return 1;
            } else if (player2Positions.containsAll(l)) {
                return 2;
            } 
        }
        if (player1Positions.size() + player2Positions.size() == 9) {
            return 3;
        }
     return 4;
    }

    public static void printBoard(char[][] board) {
            for (char[] row : board) {
                for (char c : row) {
                    System.out.print(c);
                }
                System.out.println();
            }
          }

    public static void printInitialBoard(char[][] initialBoard) {
        for (char[] row : initialBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void makeMove(char[][] board, int pos, String user){

            char playerPiece = ' ';

            if(user.equals("player1")) {
                playerPiece = 'X';
                player1Positions.add(pos);
            } else if(user.equals("player2")) {
                playerPiece = 'O';
                player2Positions.add(pos);
            }
        switch (pos) {
                case 1:
                    board[0][1] = playerPiece;
                    break;
                case 2:
                    board[0][5] = playerPiece;
                    break;
                case 3:
                    board[0][9] = playerPiece;
                    break;
                case 4:
                    board[2][1] = playerPiece;
                    break;
                case 5:
                    board[2][5] = playerPiece;
                    break;
                case 6:
                    board[2][9] = playerPiece;
                    break;
                case 7:
                    board[4][1] = playerPiece;
                    break;
                case 8:
                    board[4][5] = playerPiece;
                    break;
                case 9:
                    board[4][9] = playerPiece;
                    break;
            default:
                break;
            }
        
    }
    
    
    public static int refCheck(String p1Name, String p2Name) {
    	if (chkWinner() == 1){
            System.out.println("");
            System.out.println("TIC-TAC-TOE!!  " + p1Name + ", you won!");
            System.out.println("Game Over!");
            System.exit(0);
            return 1;

        } else if (chkWinner() == 2) {
            System.out.println("");
            System.out.println("TIC-TAC-TOE!!" + p2Name + ", you won!");
            System.out.println("Game Over!");
            System.exit(0);
            return 2;
        } else if (chkWinner() == 3) {
            System.out.println("");
            System.out.println("It's a tie! Try again!");
            System.out.println("Game Over!");
            System.exit(0);
            return 3;
        }
    	return 4;
    }

}



