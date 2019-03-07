import java.util.ArrayList;
import java.io.IOException;

public class Db {

	public static void main(String [] args)
	{
      Db program = new Db();
      program.run();

      String file_name = "./text.txt";
      try {
         WriteFile data = new WriteFile( file_name, true );
         data.writeToFile("This is another line of text");
      }
      catch (IOException e) {
         System.out.println( e.getMessage());
      }

   }

   void run()
   {
      testAll();
   }

   void testAll()
   {
      Table testTable = new Table(); // this is neater than the above. i should put all the testing into the right place.
      testTable.allTests();
      Record testRecord = new Record();
      testRecord.allTests();



   }


// this should be so small it only deals with command line args.

// use add() method to add values in the list


   //   record1.setField(0, "hello");
   //   record1.printRecord();

      /*
      ArrayList<Record> myTable = new ArrayList<Record>();
      Record hello1 = new Record();
      Record hello2 = new Record();
      System.out.println("Running Main");
      myTable.add(hello1);
      myTable.add(hello2);
      */
}
