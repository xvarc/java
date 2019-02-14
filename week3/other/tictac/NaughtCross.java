/* Notes


 Note that in a simple Java application like this, the result came out around 300 lines of code.

If you are Java programmer, click to see the full commented code and explanation about the Tic Tac Toe Java Play creation.

Yes, there is a strategy we can adopt (or the computer may adopt) to never lose a game of tic tac toe:
http://en.wikipedia.org/wiki/Tic-tac-toe

How to play our Tic Tac Toe game made in Java
First, as this version is simpler, you can only play Human vs Human. Soon we will teach how to program the computer to play.

So choice as Player 1 and Player 2 as humans.
After that, just select the line and column of the board where you want to play.
Recalling that Player 1 is always the 'X' and Player 2 is always the 'O'.

After that, just play normally. When the player complete a line, column or diagonal, the game stops.
O when the tray is full and a tie happens.

For Java programmers: How to create a Tic Tac Toe in Java

Our Tic Tac Toe game have over 300 lines of Java code, we will explain each class, method and idea in another post:
Code about how to create the Tic Tac Toe in Java


Code Java Tic Tac Toe, text mode Human x Human

Create a project named 'TicTacToe', and add the following 6 classes, run and be happy.




Vijender Meena said...

    Hey Man,
    Congo!!!!! u did a great job the code is quite simple and easy to understand for the beginner of java..
    but u have not added anything when when one want to compete against a computer..
    so here the code goes::::::::
    Features of the code.......
    1. one can against another human or a computer or even take experience by competing two computer players against each other :P :P :P
    2. when a Human competes against a computer he can choose difficulty level.
    if he/she choose easy level computer choose a number between 0 to 9.... if it choose less than 5 it will play wise game otherwise play random game
    if he/she choose medium level
    upto 7 it will play wise game, otherwise random game
    in hard level upto 8 computer will play wise game and for 9 it will play random game
    3.when computer choose to play wise game it can win in game or worst case is TIE of that game
    means a computer can never be beatable if he choose wise play
    4. if computer choose random game he will choose random square when ooponent have no chance of winning(means when sum of any row,column,diagonal is not 2 if opponent is player 1 or -2 when opponent is player2)
    5.also if one choose has first chance in a game and he is not able to win in that game opponent player will have 1st chance to go in next game
    6.one can play the number of matches with same player until he does not want


*/

public class NaughtCross {
    public static void main(String[] args) {
        Play game = new Play();
    }
}
