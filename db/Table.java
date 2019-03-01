import java.util.ArrayList;


public class Table {
	
	ArrayList<Record[]> myTable = new ArrayList<Record[]>();
	
	int totalRows = 0;
	int currentRow = 0;
	
	private void insertRec(int totalRows) {

		Record emptyRecord = new Record();
		myTable.add(emptyRecord);
		totalRows++;
		currentRow++;
		// insert this record into the array at the current row in the array
		// increment the current row number in the array
			
	}




	 // i should save save the current row number automatically at the first place on a reccord


}
