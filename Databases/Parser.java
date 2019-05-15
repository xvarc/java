/*
COMSM0103 - Object Oriented Programming with Java
Databases Coursework
Xan Varcoe
*/

// Commented print statements are included below in order to check the results being parsed in terminal.

import java.util.ArrayList;

public class Parser {
   Table outputTable = new Table();

   public Table parseText(ArrayList<String> textData) {

      //for(int i=0;i<textData.size();i++){
      //    System.out.println(textData.get(i));
      //}
      for(String element: textData) {
         Record outputRecord = new Record();
         //System.out.print(element);
         //System.out.println();
         String[] data = element.split("  \\| ");
         for(String field: data) {
            outputRecord.addField(field);
         }
         outputTable.emptyRecord(outputRecord);
         outputTable.insertRecord(outputRecord);
      }
      return outputTable;
   }
}
