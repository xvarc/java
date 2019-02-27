import java.util.ArrayList;
public class Record {
  // should this be in a constructor?  
   ArrayList<String> myArray = new ArrayList<String>(); 
   

   private String getRecord(int arrayField) {
      return myArray.get(arrayField);
   }

   private void setRecord(String input, int arrayField) {
      myArray.set(arrayField, input);
   }

//Helper Functions
   /*private ArrayList<String> arrayInit() {
      ArrayList<String> myArray = new ArrayList<String>(); 
      return myArray;
   }  */ 

   private void arrayPrint() {
      for(String element: myArray) {
         System.out.println(element);
      }
   }
}


/* I have an issue with how i am doing this here.
 *
 * Two possible methods. 
 *
 * 1. do what i have done. create a class wide array that can be accessed by all functions. 
 * i can then put instances of this class into an array and that could be my table. 
 *
 * 2. I make a function that initialises an array and returns it. 
 * the problem is that it would then need to be an argument of all my other functions.
 * this is because it is not globally available. for this reason i have commented it out.
 *
 *this is not currently being tested either
 *
 * */ 
