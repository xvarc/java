/*
COMSM0103 - Object Oriented Programming with Java
Databases Coursework
Xan Varcoe
*/

import java.util.ArrayList;
public class Record {
   // should this be in a constructor?
   ArrayList<String> myArray = new ArrayList<String>();
   static int key;


   public Record() {
      addField(Integer.toString(key));
      if(key == 0) {
         setField(0,"Key");
      }
      key++;
   }


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

   void deleteFields() {
      for (int i = 0;i<myArray.size();) {
         myArray.remove(i);
      }
   }



//Helper Functions
   /*private ArrayList<String> arrayInit() {
      ArrayList<String> myArray = new ArrayList<String>();
      return myArray;
   }  */


   void printRecord() {
      for(String element: myArray) {
         System.out.print(" " + element);
      }
       System.out.println();
   }

   void allTests() {
      //commented print statments can be used to test outputs in terminal


      System.out.println("start testing record");

      addField("one");
      addField("what?");
      setField(2, "two");
      assert(getField(1)=="one");
      assert(getField(2)=="two");
      //printRecord();
      deleteFields();
      //printRecord();



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
