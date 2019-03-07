import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class ReadFile {

   private String path;

   public ReadFile (String file_path) {
      path = file_path;
   }

   public ArrayList<String> openFile() throws IOException {
      FileReader fr = new FileReader(path);
      BufferedReader textReader = new BufferedReader(fr);

      ArrayList<String> textData = new ArrayList<String>();

      //int numberOfLines = 100;
      String line;
      //int i;
      //for (i = 0 ; i<numberOfLines; i++) {
      while ((line = textReader.readLine()) != null) {
         textData.add(textReader.readLine() + "\n");
      }
      textReader.close();
      return textData;
   }

   // i need a function that takes the array list of strings and turns it into records.

}
