import java.util.ArrayList;


public class Parser {
   Table outputTable = new Table();

   public Table parseText(ArrayList<String> textData) {
      for(String element: textData) {
         Record outputRecord = new Record();


         String data[] = element.split("|");
      //   for(int i=0; i<50;i++) {
         //   System.out.println(data[i]);
      //   }
         for(String field: data) {

            outputRecord.addField(field);
         }
         outputTable.insertRecord(outputRecord);
      }
      return outputTable;
   }
}
