import java.util.ArrayList;
import java.io.IOException;

public class Db {

	public static void main(String [] args)
	{
      Db program = new Db();
      program.run();



   }

   void run()
   {
      testAll();
   }

   void testAll()
   {
      Table testTable = new Table();
      testTable.allTests();
      Record testRecord = new Record();
      testRecord.allTests();

      String file_name = "./text.txt";
      try {
         WriteFile data = new WriteFile( file_name, false );// add true here to append. false to overwrite
         data.writeToFile("This is another line of text");
         data.writeToFile(testTable.concatenateTable());

      }
      catch (IOException e) {
         System.out.println( e.getMessage());
      }

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
