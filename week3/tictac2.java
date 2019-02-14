/* solution here

https://stackoverflow.com/questions/27778703/java-noughts-and-crosses-tic-tac-toe-game-winning-algorithm-not-working

*/

import java.util.Scanner;

public class NoughtsAndCrosses {

static int count[][] = new int[4][4];
static char board[][] = new char[4][4];
static String playerOneName;
static String playerTwoName;

static int xCoord;
static int yCoord;
static int noOfMoves;
static int checkO = 0;
static int checkX = 0;

static boolean validMove;
static boolean gameHasBeenWon;
static boolean gameHasBeenDrawn;

static char currentSymbol;

static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
    initialiseBoard();
    System.out.println("What is the name of player one? ");
    playerOneName = sc.next();
    System.out.println("What is the name of player two? ");
    playerTwoName = sc.next();

    currentSymbol = 'X';

    // Play a game
    noOfMoves = 0;
    gameHasBeenDrawn = false;
    gameHasBeenWon = false;

    System.out.println();
    displayBoard(board);
    System.out.println("\n" + playerOneName + " starts playing " + currentSymbol);
    System.out.println();

    do { //Play until a player wins or the game is drawn
        do { //Get a valid move

            xCoord = getX();
            yCoord = getY();
            System.out.println("");
            validMove = checkValidMove(xCoord, yCoord, board);
            if (!validMove) {
                System.out.println("Coordinates invalid, please try again");
            } // end if
        } while (!validMove);

        board[xCoord][yCoord] = currentSymbol;
        displayBoard(board);
        gameHasBeenWon = checkXOrOHasWon(board);
        noOfMoves++;

        if (!gameHasBeenWon) {
            // Check if maximum number of allowed moves has been reached
            if (noOfMoves == 9) {
                gameHasBeenDrawn = true;
            } else {
                if (currentSymbol == 'X') {
                    currentSymbol = 'O';
                    System.out.println(playerTwoName + "'s turn");
                } else {
                    currentSymbol = 'X';
                    System.out.println(playerOneName + "'s turn");
                } // end if/else
            } // end if/else
        } // end if
    } while (!gameHasBeenWon && !gameHasBeenDrawn);

    //Display result
    if (gameHasBeenWon) {
        if ('X' == currentSymbol) {
            System.out.println(playerOneName + " congratulations you win!");

        } else {
            System.out.println(playerTwoName + " congratulations you win!");

        }
    } else {
        System.out.println("A draw this time!");
    }
} //end method main

public static void initialiseBoard() {

}

public static void displayBoard(char[][] board) {
    int row;
    int column;
    System.out.println("  | 1 2 3 ");
    System.out.println("--+-------");

    for (row = 1; row <= 3; row++) {
        System.out.print(row + " | ");
        for (column = 1; column <= 3; column++) {
            System.out.print(board[column][row] + " ");
        } // end column
        System.out.println();
    } // end row
} // end method displayBoard

public static int getX() {
    System.out.println("Please enter an X coordinate");
    xCoord = sc.nextInt();

    return xCoord;
}

public static int getY() {
    System.out.println("Please enter an Y coordinate");
    yCoord = sc.nextInt();

    return yCoord;
}

public static boolean checkValidMove(int xCoordinate, int yCoordinate, char[][] board) {
    ////

    if (xCoordinate > board.length || yCoordinate > board.length || xCoordinate == 0 || yCoordinate == 0 || xCoordinate == 4 || yCoordinate == 4) {
        validMove = false;
    } else {
        validMove = true;
    }

    if (currentSymbol == 'O') {
        count[xCoordinate][yCoordinate] = -1;

    } else if (currentSymbol == 'X') {
        count[xCoordinate][yCoordinate] = 1;
    }

    return validMove;

} // end method checkValidMove

//THIS PART HERE IT SEEMS TO BE BROKEN FOR SOME REASON

public static boolean checkXOrOHasWon(char[][] board) {
    //ALL OF THE ROWS DON'T WORK
    //row 1
    for (int i = 1; i < 4; i++) {
        if (count[i][1] == -1) {
            checkO = checkO + 1;
        }
        if (count[i][1] == 1) {
            checkX = checkX + 1;
        }
    }

    if (checkO != 3) {
        checkO = 0;
    }
    if (checkX != 3) {
        checkX = 0;
    }
    //row 2

    for (int i = 1; i < 4; i++) {
        if (count[i][2] == -1) {
            checkO = checkO + 1;
        }
        if (count[i][2] == 1) {
            checkX = checkX + 1;
        }
    }

    if (checkO != 3) {
        checkO = 0;
    }
    if (checkX != 3) {
        checkX = 0;
    }
    //row 3
    for (int i = 1; i < 4; i++) {
        if (count[i][3] == -1) {
            checkO = checkO + 1;
        }
        if (count[i][3] == 1) {
            checkX = checkX + 1;
        }
    }

    if (checkO != 3) {
        checkO = 0;
    }
    if (checkX != 3) {
        checkX = 0;
    }

    //col 1
    for (int i = 1; i < 4; i++) {
        if (count[1][i] == -1) {
            checkO = checkO + 1;

        }
        if (count[1][i] == 1) {

            checkX = checkX + 1;
        }
    }

    if (checkO != 3) {
        checkO = 0;
    }

    if (checkX != 3) {
        checkX = 0;
    }

    //col 2
    for (int i = 1; i < 4; i++) {
        if (count[2][i] == -1) {
            checkO = checkO + 1;

        }
        if (count[2][i] == 1) {

            checkX = checkX + 1;
        }
    }

    if (checkO != 3) {
        checkO = 0;
    }

    if (checkX != 3) {
        checkX = 0;
    }

    //col 3
    for (int i = 1; i < 4; i++) {
        if (count[3][i] == -1) {
            checkO = checkO + 1;

        }
        if (count[3][i] == 1) {

            checkX = checkX + 1;
        }
    }

    if (checkO != 3) {
        checkO = 0;
    }

    if (checkX != 3) {
        checkX = 0;
    }

    //diag 1
    for (int i = 1; i < 4; i++) {
        if (count[i][i] == -1) {
            checkO = checkO + 1;
            break;
        }
        if (count[i][i] == 1) {

            checkX = checkX + 1;
            break;
        }

    }
    if (checkO != 3) {
        checkO = 0;
    }

    if (checkX != 3) {
        checkX = 0;
    }

    //diag 2
    for (int j = 2; j < 5; j++) {
        for (int i = 1; i < 4; i++) {
            if (count[i][j - 1] == -1) {
                checkO = checkO + 1;
                break;
            }
            if (count[i][j - 1] == 1) {

                checkX = checkX + 1;
                break;
            }
        }
    }

    if (checkO != 3) {
        checkO = 0;
    }

    if (checkX != 3) {
        checkX = 0;
    }

    if (checkX == 3 || checkO == 3) {
        gameHasBeenWon = true;
    } else {
        checkO = 0;
        checkX = 0;
        gameHasBeenWon = false;

    }

    return gameHasBeenWon;
  }

 }
