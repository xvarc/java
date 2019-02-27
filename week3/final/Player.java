/*
set players
*/
import java.util.Scanner;


public class Player {
   int play_count = -1;
   Scanner input = new Scanner(System.in);
   int[] ret_val = {0,0,0}; // These will be [0] x-coordinate, [1] y coordinate, and [2] player number
   private int[][] test_board = new int[3][3];

   public Player() {
      take_turn();
   }

   public int[] take_turn() {
      if (play_count==-1) {  //this skips the first call of Player made by the constructor.
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


   private int[] input_coordinates() {
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
      play_count++;
      fill_test(ret_val);
      return ret_val;
   }

   private int check_character(int[] xy) { // using for checking characters in my board that avoids repeats .
      return test_board[xy[0]][xy[1]];
   }

   private void fill_test(int[] xy) {
      test_board[xy[0]][xy[1]]= xy[2]; // used for filling my boards that checks for repeats.
   }
}
