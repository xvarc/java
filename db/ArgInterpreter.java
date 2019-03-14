public class ArgInterpreter {

   public ArgInterpreter (String[] args) {
      Db program = new Db();
      if(args[0].equals("test")) {
         System.out.println("Now testing...");
         program.testAll();
         System.out.println("Testing complete.");
      }

      if(args[0].equals("print")) {
         if(args[1].equals("db")) {
            
         }
         if(args[1].equals("table")) {

         }
         if(args[1].equals("record")) {

         }
      }
   }
}
