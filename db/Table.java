import java.util.ArrayList;
public class Table {

	ArrayList<Record> myTable = new ArrayList<Record>();
	//static int totalRows = 0;
	static int currentRow = 0;

   void run()
   {
      allTests();
   }

   void insertRecord(Record input) {
		myTable.add(input);
		// totalRows++;
		currentRow++;
	}

   void setRecord(int index, Record input) {
      myTable.set(index, input);
   }

   Record getRecord(int index) {
      return myTable.get(index);
   }

   void deleteRecord(int index) {
      myTable.remove(index);
      // totalRows--;
      currentRow--;
   }

   void clearTable()
   {
      for (int i = 0;i<myTable.size();) {
         myTable.remove(i);
        }
   }

   void emptyRecord(Record targetRecord) {
      targetRecord.deleteFields();
   }

   void deleteMultiRecord(int startIndex, int endIndex) {
      for(int i = startIndex;i<=endIndex;i++) {
         myTable.remove(startIndex);
         currentRow--;
      }
      // totalRows--;
   }

   void printTable() {

      for (Record list : myTable) {
         for (String element : list.myArray) {
            System.out.print(String.format("%-10s %s" , element, " | " ));
         }
         System.out.println();
      }
   }

   String concatenateTable() {
      String output = "";

      for (Record list : myTable) {
         for (String element : list.myArray) {
            output = output + String.format("%-10s %s" , element, " | " );
         }
         output = output + "\n";
      }
      return output;
   }

   void allTests()
   {
      System.out.println("start testing table");

      Record testRecord = new Record();
      testRecord.addField("  Name");
      testRecord.addField("  Dwelling");
      testRecord.addField("  Deets");
      insertRecord(testRecord);
      assert(getRecord(0) == testRecord);

      Record testRecord1 = new Record();
      testRecord1.addField("Donald");
      testRecord1.addField("Hovel");
      testRecord1.addField("0758945789");
      insertRecord(testRecord1);
      assert(getRecord(1) == testRecord1);

      Record testRecord2 = new Record();
      testRecord2.addField("Beau");
      testRecord2.addField("Castle");
      testRecord2.addField("0758948578");

      insertRecord(testRecord2);
      assert(getRecord(2) == testRecord2);

      printTable();
      System.out.println();

      setRecord(0, testRecord);
      assert(getRecord(0) == testRecord);

      deleteRecord(2);
      printTable();
      System.out.println();

      deleteMultiRecord(0,1); // all records deleted
      printTable();
      System.out.println();

      insertRecord(testRecord);
      insertRecord(testRecord1);
      insertRecord(testRecord2);

      // i haven't tested the empty record

      System.out.println("table testing complete");
      System.out.println();
   }




	 // i should save save the current row number automatically at the first place on a reccord


}
