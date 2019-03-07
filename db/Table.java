import java.util.ArrayList;
public class Table {

	ArrayList<Record> myTable = new ArrayList<Record>();
	//static int totalRows = 0;
	static int currentRow = 1;

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

   void deleteMultiRecord(int startIndex, int endIndex) {
      for(;startIndex<endIndex;) {
         myTable.remove(startIndex);
         startIndex++;
         currentRow--;
      }
      // totalRows--;
   }

   void printTable() {

      for (Record list : myTable) {
         for (String element : list.myArray) {
            System.out.print(element + " ");
         }
         System.out.println();
      }
   }

   void allTests()
   {
      System.out.println("start testing table");
      Record testRecord = new Record();
      testRecord.addField(Integer.toString(currentRow));
      testRecord.addField(" xan lives in ");
      testRecord.addField("a house - ");
      testRecord.addField("07811246789");
      insertRecord(testRecord);
      assert(getRecord(0) == testRecord);

      Record testRecord1 = new Record();
      testRecord1.addField(Integer.toString(currentRow));
      testRecord1.addField(" Beau lives in ");
      testRecord1.addField("a castle - ");
      testRecord1.addField("07589485789");
      insertRecord(testRecord1);
      assert(getRecord(1) == testRecord1);

      deleteRecord(1);

      insertRecord(testRecord1);
      assert(getRecord(1) == testRecord1);

      setRecord(1, testRecord);
      assert(getRecord(1) == testRecord);

      insertRecord(testRecord1);
      insertRecord(testRecord1);
      insertRecord(testRecord1);
      insertRecord(testRecord1);
      printTable();
      System.out.println();

      deleteMultiRecord(0,3); // this doesnt work for some reason.
      // never deletes the first record. if you go up to 4 it says that it was out of bounds
      printTable();
      System.out.println();

      System.out.println("table testing complete");
      System.out.println();
   }




	 // i should save save the current row number automatically at the first place on a reccord


}
