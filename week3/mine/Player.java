/*
set players

scan for inputs from command line. check it is a correct and input and throw fault if not.

check function that checks the board to see if it a valid move. this might have been done in board?

make function that calls the put character function for specific character

*/
import java.util.Scanner;


public class Player {
   int play_count = -1;
   Scanner input = new Scanner(System.in);
   int[] ret_val = {0,0,0}; // i then populate this with the character i need;
   private int[][] test_board = new int[3][3];


   public Player() {
      take_turn();
       // THIS IS A FILLER FOR WHEN I HAVE THE ACTUALL INPUT THING SET UP .

      // here we need the functions that return coordinates and scan. for now i will just return an int
   }

   public int[] take_turn() {
      if (play_count==-1) {  //skip the first call of Player
         play_count++;
         return ret_val;
      }
      if(play_count==0) {
         System.out.println("choose player");
         play_count = choose_player();  //set play count to odd (player 1) or even (player 2).
      }
      return input_coordinates();
   }

   private int choose_player(){
      int option=0;
      do{
         System.out.println("1. Player 1");
         System.out.println("2. Player 2\n");
         System.out.print("Option: ");
         option = input.nextInt();
         if(option != 1 && option != 2)
            System.out.println("Invalid Option! Try again");
      } while(option != 1 && option != 2);
      return option;
   }


   private int[] input_coordinates() { // i need to put on checks to make sure the correct things are input.
      int current_player;

      if(play_count%2==1) {
         current_player = 1;
      }
      else {
         current_player = 2;
      }
      ret_val[2] = current_player;
      do {
         System.out.format("Player %d 's go\n", current_player);
         System.out.println("Please input the row number (0-2) and press enter. Then input the column number and enter (0-2):");
         for(int i = 0; i < 2; i++) {
            ret_val[i] = input.nextInt();
            if(!(ret_val[i]==0||ret_val[i]==1||ret_val[i]==2)) {
               System.out.println("Inputted value incorrect. Please input a 0, a 1 or a 2");
               i--;
            }
         }
         if(check_character(ret_val)!=0) {
            System.out.println("That cell is already full. Please input again.");
         }
      } while (check_character(ret_val)!=0);


/*      if(check_character(ret_val)!=0) {
         temp = check_character(ret_val)
         play_count-=1; // change to --
      } */
      play_count++;
      fill_test(ret_val);
      return ret_val;

   }

   private int check_character(int[] xy) { // these take a int array with 2 coordinates as argument.
      return test_board[xy[0]][xy[1]];
   }

   private void fill_test(int[] xy) { // could i get rid of this input because it's already in the array?
      test_board[xy[0]][xy[1]]= xy[2]; // if player 1, place is 1. if player 2. it is 2.
   }

   private void print_board() { // get rid of this when i'm done with it
      for(int x=0; x < 3;x++) {
         for(int y=0; y < 3;y++) {
            System.out.print(" " + test_board[x][y]);
         }
         System.out.println();
      }
   System.out.println();
   }

}
   /*
   public boolean Move(){
      if(won() == 0 ){
           System.out.println("----------------------");
           System.out.println("\nTurn "+turn);
           System.out.println("It's turn of Player " + who() );

           if(who()==1)
               player1.move(board);
           else
               player2.move(board);


           if(board.fullBoard()){
               System.out.println("Full Board. Draw!");
               return false;
           }
           who++;
           turn++;

           return true;
      } else{
           if(won() == -1 )
               System.out.println("Player 1 won!");
           else
               System.out.println("Player 2 won!");

           return false;
      }

   }
   */
