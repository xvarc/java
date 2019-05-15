/* 
COMSM0103 - Object Oriented Programming with Java
Databases Coursework
Xan Varcoe
*/

import java.util.ArrayList;
import java.io.IOException;

public class Db {
   ArrayList<Table> myDb = new ArrayList<Table>();

	public static void main(String [] args) throws IOException
	{
      Db program = new Db();
      ArgInterpreter interp = new ArgInterpreter(args);
   }

   void insertTable(Table input)
   {
      myDb.add(input);
   }

   void printDb()
   {
      for(Table element: myDb) {
         element.printTable();
         System.out.println();
      }
   }

   void clearDb()
   {
      for (int i = 0;i<myDb.size();) {
         myDb.remove(i);
        }
   }

   void testAll()
   {
      System.out.println("\n" + "Now testing....");

      Table testTable = new Table();
      testTable.allTests();
      Record testRecord = new Record();
      testRecord.allTests();

      String output_file = "./output_file.txt";
      String output_file1 = "./output_file1.txt";
      String input_file = "./input_file.txt";

//test write file
      System.out.println("start testing write file.");
      try {
         WriteFile data = new WriteFile( output_file, false );// add true here to append to file. false to overwrite
         data.writeToFile("This is another line of text");

         WriteFile data1 = new WriteFile( output_file1, false );
         data1.writeToFile(testTable.concatenateTable());
      }
      catch (IOException e) {
         System.out.println(e.getMessage());
      }
      System.out.println("testing write file complete");

// test readfile and print it. this imports by string lines which will be parsed after.
// commented print statements below can be used to check output of read file in terminal.
      System.out.println("start testing read file");
      try {
         ReadFile inputData = new ReadFile(input_file);
         ArrayList<String> textData = new ArrayList<String>();
         textData = inputData.openFile();
         //for(int i=0;i<textData.size();i++){
         //    System.out.println(textData.get(i));
         //}
      }
      catch (IOException e) {
         System.out.println( e.getMessage());
      }
      System.out.println("testing read file complete");



// testing the Parser. this reads the strings imported by my readfile class and parses them into records.
      System.out.println("start testing parser");
      try {
         Table parsedTable = new Table();
         ReadFile inputData = new ReadFile(input_file);
         inputData.openFile();
         Parser parseData = new Parser();
         parsedTable = parseData.parseText(inputData.openFile());
      }
      catch (IOException e) {
         System.out.println( e.getMessage());
      }
		System.out.println("testing parser complete");

      // test DB Functions
		System.out.println("start testing DB functions");
		insertTable(testTable);
		insertTable(testTable);
		clearDb();
		printDb();
		System.out.println("testing DB functions complete");

      System.out.println("Testing complete."+"\n");
   }
}
