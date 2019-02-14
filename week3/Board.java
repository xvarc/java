class Board {
   public static void main(String[] args) {
      Board program = new Board();
      program.board_init();
      program.print_frame();
   }


   public void board_init() {
      int rows = 5, columns = 5;
      char[][] frame = new char[rows][columns];
      for (char[] x : frame) {
         for (char y : x) {
            frame[x][y] = 'A';
         }
      }

   }

   public void print_frame() {
      int rows = 5, columns = 5;
      char[][] frame = new char[rows][columns];
      for (char[] x : frame) {
         for (char y : x) {
            System.out.print(" X ");
         }
         System.out.println();
      }
   }
}
