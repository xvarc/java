/* doesnt work

public class Test {

      public void test_all() { // make sure that they don't trigger on nothing.
         int[] test_xy = { 0, 0};
         assert(Board.get_character(test_xy) == 0);
         Board.put_character(test_xy ,1);
         assert(Board.get_character(test_xy) == 1);

         test_board1();
         System.out.println("Player 1 should win:");
         Board.check_win();
         Board.clear_board();

         test_board2();
         System.out.println("Player 2 should win:");
         Board.check_win();
         Board.clear_board();

         test_board3();
         Board.print_board();
         System.out.println("Player 1 should win:");
         Board.check_win();
         Board.clear_board();

         test_board4();
         Board.print_board();
         System.out.println("Player 2 should win:");
         Board.check_win();
         System.out.println("Tests complete");
      }

      public static void test_board1() {
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

*/
