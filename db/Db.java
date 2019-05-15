import java.util.ArrayList;
import java.io.IOException;

public class Db {
	ArrayList<Table> myDb = new ArrayList<Table>();

	public static void main(String [] args) throws IOException
	{
      Db program = new Db();
      program.run();
   }

   void run()
   {
      testAll();
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
      Table testTable = new Table();
      testTable.allTests();
      Record testRecord = new Record();
      testRecord.allTests();

			String output_file = "./output_file.txt";
			String output_file1 = "./output_file1.txt";
			String input_file = "./input_file.txt";
			String input_file1 = "./input_file1.txt";

//test write file
		System.out.println("start testing write file");
      try {
         WriteFile data = new WriteFile( output_file, false );// add true here to append. false to overwrite
         data.writeToFile("This is another line of text");
         WriteFile data1 = new WriteFile( output_file1, false );
         data1.writeToFile(testTable.concatenateTable());
      }
      catch (IOException e) {
         System.out.println( e.getMessage());
      }
		System.out.println("testing write file complete");


// test readfile and print it. the file is imported as one string per line.
		System.out.println("start testing read file");
      try {
         ReadFile inputData = new ReadFile(input_file1);
         ArrayList<String> textData = new ArrayList<String>();
         textData = inputData.openFile();
         for(int i=0;i<textData.size();i++){
             System.out.println(textData.get(i));
         }
      }
      catch (IOException e) {
         System.out.println( e.getMessage());
      }
      System.out.println("testing read file complete");


// testing the Parser. the takes the strings imported from the file and breaks them up into records
		System.out.println("start testing parser");
      try {
         Table parsedTable = new Table();
         ReadFile inputData = new ReadFile(output_file1);
         inputData.openFile();
         Parser parseData = new Parser();
         parsedTable = parseData.parseText(inputData.openFile());
         parsedTable.printTable();
      }
      catch (IOException e) {
         System.out.println( e.getMessage());
      }
    System.out.println("testing parser complete");


// test DB Functions
			System.out.println("start testing DB functions");
			insertTable(testTable);
			insertTable(testTable);
			printDb();
			clearDb();
			printDb();
			System.out.println("testing DB functions complete");
   }
}
