import java.util.ArrayList;
import java.io.IOException;

public class Db {

	public static void main(String [] args) throws IOException
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

//test write file
      String file_name = "./text.txt";
      try {
         WriteFile data = new WriteFile( file_name, true );// add true here to append. false to overwrite
         data.writeToFile("This is another line of text");
         data.writeToFile(testTable.concatenateTable());

      }
      catch (IOException e) {
         System.out.println( e.getMessage());
      }

// test readfile and print it. this is doing by string lines. so i am not importing it as records and tables here.
      try {
         ReadFile inputData = new ReadFile(file_name);
         inputData.openFile();
         for(String element: inputData.openFile()) {
            System.out.print(element);
         }
         System.out.println();
      }
      catch (IOException e) {
         System.out.println( e.getMessage());
      }

// testing the Parser
      try {
         Table parsedTable = new Table();

         ReadFile inputData = new ReadFile("testParse.txt");
         inputData.openFile();
         Parser parseData = new Parser();
         parsedTable = parseData.parseText(inputData.openFile());

         System.out.println();

         parsedTable.printTable();

         System.out.println();
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
