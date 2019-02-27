/*
Xan Varcoe's build of Naughts and Crosses


*/
public class Game {
   private int[][] grid = new int[3][3];
   private int[] board_input;
   private Player player = new Player();

   public Game() {
      assert(test_all());
      clear_board();

      while(true) {
         if(check_win()>0) {
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

   private void clear_board() {
      for(int x=0; x < 3;x++) {
         for(int y=0; y < 3;y++) {
            grid[x][y] = 0;
         }
      }
   }

   private void print_board() {
      char temp = 'a';
      for(int x=0; x < 3;x++) {
         for(int y=0; y < 3;y++) {
            if(grid[x][y]==0) {
               temp = '*';
            }
            if(grid[x][y]==1) {
               temp = 'X';
            }
            if(grid[x][y]==2) {
               temp = 'O';
            }
            System.out.print(" " + temp);
         }
         System.out.println();
      }
   System.out.println();
   }

   private int get_character(int[] xy) { // return the character at the location specified by xy
      return grid[xy[0]][xy[1]];
   }

   private void put_character(int[] xy, int player) {
      grid[xy[0]][xy[1]]= player; // if player 1, put char is 1. if player 2. put char is 2.
   }

   private int check_win() {
      for(int x=0;x<3;x++) { // check rows
         if(grid[x][0] == grid[x][1] && grid[x][0] == grid[x][2]) {
            if(grid[x][0]>0) {
               System.out.println("Game won by Player " + grid[x][1]);
               return grid[x][0]; // returns the winning player number.
            }
         }
      }

      for(int y=0;y<3;y++) { //check columns
         if(grid[0][y] == grid[1][y] && grid[0][y] == grid[2][y]) {
            if(grid[0][y]>0) {
               System.out.println("Game won by Player "  + grid[0][y]);
               return grid[0][y];
            }
         }
      }

      if((grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2]) || // check diagonals
         (grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0])) {
         if(grid[1][1]>0) {
            System.out.println("Game won by Player "  + grid[1][1]);
            return grid[1][1];
         }
      }
      return 0;
   }

   private boolean check_full() {
      for(int x=0; x < 3;x++) {
         for(int y=0; y < 3;y++) {
            if(grid[x][y]==0) {
               return false;
            }
         }
      }
      System.out.println("Board is full");
      return true;
   }


   private boolean test_all() {
      int[] test_xy = { 0, 0};

      System.out.println("Now running tests:");

      assert(get_character(test_xy) == 0);
      put_character(test_xy ,1);
      assert(get_character(test_xy) == 1);

      test_board1();
      assert(check_win()==1); // check that player 1 wins
      clear_board();

      test_board2();
      assert(check_win()==2); // check that player 2 wins
      clear_board();

      test_board3();
      assert(check_win()==1); // check that player 1 wins diagonal
      clear_board();

      test_board4();
      assert(check_win()==2); // check that player 2 wins diagonal

      test_board1();
      assert(check_full()); // check that board is full
      clear_board();

      test_board3();
      assert(!check_full()); // check that board is not full
      clear_board();

      System.out.println("Tests complete, now running main: ");
      return true;
   }

   private void test_board1() {
      for(int x=0; x < 3;x++) {
         for(int y=0; y < 3;y++) {
            grid[x][y] = 1;
         }
      }
   }

   private void test_board2() {
      for(int x=0; x < 3;x++) {
         for(int y=0; y < 3;y++) {
            grid[x][y] = 2;
         }
      }
   }

   private void test_board3() {
      grid[0][0] = 1;
      grid[1][1] = 1;
      grid[2][2] = 1;
   }

   private void test_board4() {
      grid[0][2] = 2;
      grid[1][1] = 2;
      grid[2][0] = 2;
   }
}
