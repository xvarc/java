import java.util.ArrayList;
import java.io.IOException;

public class MyTesting {
   Db testDb = new Db();

   void testAll()
   {
      Table testTable = new Table();
      testTable.allTests();
      Record testRecord = new Record();
      testRecord.allTests();



//test write file
      System.out.println("start testing write file...");
      String file_name = "./text.txt";
      String file_name1 = "./text1.txt";
      try {
         WriteFile data = new WriteFile( file_name, false );// add true here to append. false to overwrite
         data.writeToFile("This is another line of text");

         WriteFile data1 = new WriteFile( file_name1, false );
         data1.writeToFile(testTable.concatenateTable());
      }
      catch (IOException e) {
         System.out.println(e.getMessage());
      }
      System.out.println("testing write file complete");


      System.out.println("start testing read file");
// test readfile and print it. this is doing by string lines. so i am not importing it as records and tables here.
      try {
         ReadFile inputData = new ReadFile(file_name1);
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



// testing the Parser
      System.out.println("start testing parser");
      try {
         Table parsedTable = new Table();
         ReadFile inputData = new ReadFile(file_name1);
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
		testDb.insertTable(testTable);
		testDb.insertTable(testTable);
		testDb.printDb();
		testDb.clearDb();
		testDb.printDb();
      testDb.insertTable(testTable);
      testDb.insertTable(testTable);
      testDb.insertTable(testTable);
      testDb.insertTable(testTable);
      testDb.insertTable(testTable);
      testDb.insertTable(testTable);
      testDb.printDb();
		System.out.println("testing DBs functions complete");
   }
}
