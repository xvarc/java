/*
- check functions. rows/ columns/diagonals.
   - are there 3 in a row of either naughts or crosses.
   - is the board full?

*/
public class Board {
   private int[][] board = new int[3][3];
   private int[] board_input;
   private Player player = new Player();

   public Board() {
      test_all();
      clear_board();

// i guess i will need a while loop in here at some point to make it all go - GAME WHILE LOOP
      while(true) { //don't do infinite loops
         if(check_win()>0) { // at the moment it is only checking for two in a row. and it includes 0.
            return;
         }
         if (check_full()) {
            return;
         }
         board_input = player.take_turn();
         put_character(board_input,board_input[2]);
         print_board();
      }
   }

// if it is neither a win nor full. then we call player.
// make an instance of player and then run the functions from player here
// if counter is 0 then player will request who is playing and make the counter that. if it is 1 then odd goes first and its p1.
   // if it is 2 then even goes first and its 2.
// player will ask for an input and then spit out a coordinate and a character,
   //it will be an array with 3 characters 1-3 a-c and 1 or 2 depending on players. if counter is odd, spit out 1. if it is even spit out player 2.
// based on the output from player, board will then check if it is a valid output. if it is not then then an input will be requested again
   // if it is correct the while loop will continue.

   private void clear_board() {
      for(int x=0; x < 3;x++) {
         for(int y=0; y < 3;y++) {
            board[x][y] = 0;
         }
      }
   }

   private void print_board() {
      for(int x=0; x < 3;x++) {
         for(int y=0; y < 3;y++) {
            System.out.print(" " + board[x][y]);
         }
         System.out.println();
      }
   System.out.println();
   }

   private int get_character(int[] xy) { // these take a int array with 2 coordinates as argument.
      return board[xy[0]][xy[1]];
   }

   private void put_character(int[] xy, int player) { // could i get rid of this input because it's already in the array?
      board[xy[0]][xy[1]]= player; // if player 1, place is 1. if player 2. it is 2.
   }

   private int check_win() {
      for(int x=0;x<3;x++) { //check rows
         if(board[x][0] == board[x][1] && board[x][0] == board[x][2]) {
            // && (board[x][0]!= 0)
            if(board[x][0]>0) {
               System.out.println("Game won by Player " + board[x][1]);
               return board[x][0]; // it returns the player number.
            }
         }
      }

      for(int y=0;y<3;y++) { //check columns
         if(board[0][y] == board[1][y] && board[0][y] == board[2][y]) {
            if(board[0][y]>0) {
               System.out.println("Game won by Player "  + board[0][y]);
               return board[0][y];
            }
         }
      }

      if((board[0][0] == board[1][1] && board[0][0] == board[2][2]) ||
         (board[0][2] == board[1][1] && board[0][2] == board[2][0])) {
         if(board[1][1]>0) {
            System.out.println("Game won by Player "  + board[1][1]);
            return board[1][1];
         }
      }
      return 0;
   }

   private boolean check_full() {
      for(int x=0; x < 3;x++) {
         for(int y=0; y < 3;y++) {
            if(board[x][y]==0) {
               return false;
            }
         }
      }
      System.out.println("Board is full");
      return true;
   }


   private void test_all() { // make sure that they don't trigger on nothing.
      int[] test_xy = { 0, 0};
      assert(get_character(test_xy) == 0);
      put_character(test_xy ,1);
      assert(get_character(test_xy) == 1);

      test_board1();
      System.out.println("Test: Player 1 should win:");
      check_win();
      clear_board();

      test_board2();
      System.out.println("Test: Player 2 should win:");
      check_win();
      clear_board();

      test_board3();
      print_board();
      System.out.println("Test: Player 1 should win:");
      check_win();
      clear_board();

      test_board4();
      print_board();
      System.out.println("Test: Player 2 should win:");
      check_win();

      test_board1();
      print_board();
      System.out.println("Test: Board should be full:");
      check_full();
      clear_board();

      test_board3();
      print_board();
      System.out.println("Test: Board should not be full:");
      if(!check_full()) {
         System.out.println("Board not full");
      }
      clear_board();

      System.out.println("Tests complete, now running main: ");
   }

   private void test_board1() {
      for(int x=0; x < 3;x++) {
         for(int y=0; y < 3;y++) {
            board[x][y] = 1;
         }
      }
   }

   private void test_board2() {
      for(int x=0; x < 3;x++) {
         for(int y=0; y < 3;y++) {
            board[x][y] = 2;
         }
      }
   }

   private void test_board3() {
      board[0][0] = 1;
      board[1][1] = 1;
      board[2][2] = 1;
   }

   private void test_board4() {
      board[0][2] = 2;
      board[1][1] = 2;
      board[2][0] = 2;
   }
}
