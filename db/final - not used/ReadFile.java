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

      String line;
      while ((line = textReader.readLine()) != null) {
         textData.add(line);
      }
      textReader.close();
      return textData;
   }
}
