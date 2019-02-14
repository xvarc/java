/*
- check functions. rows/ columns/diagonals.
   - are there 3 in a row of either naughts or crosses.
   - is the board full?

*/
public class Board {
   private int[][] board = new int[3][3];

   public Board() {
      test_all();


      clear_board();
      print_board();
      check_win(); // at the moment it is only checking for two in a row. and it includes 0.

   }

   public void clear_board() {
      for(int x=0; x < 3;x++) {
         for(int y=0; y < 3;y++) {
            board[x][y] = 0;
         }
      }
   }

   public void print_board() {
      for(int x=0; x < 3;x++) {
         for(int y=0; y < 3;y++) {
            System.out.print(" " + board[x][y]);
         }
         System.out.println();
      }
   System.out.println();
   }

   public int get_character(int[] xy) { // these take a int array with 2 coordinates as argument.
      return board[xy[0]][xy[1]];
   }

   public void put_character(int[] xy, int player) {
      board[xy[0]][xy[1]]= player; // if player 1, place is 1. if player 2. it is 2.
   }


   public int check_win() {
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

   public boolean check_full() {
      for(int x=0; x < 3;x++) {
         for(int y=0; y < 3;y++) {
            if(board[x][y]==0) {
               return false;
            }
         }
      }
      return true;
   }


   private void test_all() { // make sure that they don't trigger on nothing.
      int[] test_xy = { 0, 0};
      assert(get_character(test_xy) == 0);
      put_character(test_xy ,1);
      assert(get_character(test_xy) == 1);

      test_board1();
      System.out.println("Player 1 should win:");
      check_win();
      clear_board();

      test_board2();
      System.out.println("Player 2 should win:");
      check_win();
      clear_board();

      test_board3();
      print_board();
      System.out.println("Player 1 should win:");
      check_win();
      clear_board();

      test_board4();
      print_board();
      System.out.println("Player 2 should win:");
      check_win();

      System.out.println("Tests complete, now running main: ");
   }

   public void test_board1() {
      for(int x=0; x < 3;x++) {
         for(int y=0; y < 3;y++) {
            board[x][y] = 1;
         }
      }
   }
   public void test_board2() {
      for(int x=0; x < 3;x++) {
         for(int y=0; y < 3;y++) {
            board[x][y] = 2;
         }
      }
   }

   public void test_board3() {
      board[0][0] = 1;
      board[1][1] = 1;
      board[2][2] = 1;
   }
   public void test_board4() {
      board[0][2] = 2;
      board[1][1] = 2;
      board[2][0] = 2;
   }
}
