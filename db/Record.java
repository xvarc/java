import java.util.ArrayList;
public class Record {
  // should this be in a constructor?
   ArrayList<String> myArray = new ArrayList<String>();


   void run()
   {
      allTests();
   }

   void addField(String input) {
      myArray.add(input);
   }

   void setField(int arrayField, String input) {
      myArray.set(arrayField, input);
   }

   String getField(int arrayField) {
      return myArray.get(arrayField);
   }



//Helper Functions
   /*private ArrayList<String> arrayInit() {
      ArrayList<String> myArray = new ArrayList<String>();
      return myArray;
   }  */


   void printRecord() {
      for(String element: myArray) {
         System.out.print(element);
      }
       System.out.println();
   }

   void allTests() {
      System.out.println("start testing record");

      addField("one");
      addField("what?");
      setField(1, "two");
      assert(getField(0)=="one");
      assert(getField(1)=="two");

      System.out.println("record testing complete");
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
