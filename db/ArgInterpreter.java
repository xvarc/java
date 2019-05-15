/*
COMSM0103 - Object Oriented Programming with Java
Databases Coursework
Xan Varcoe
*/

public class ArgInterpreter {
   Db uiDb = new Db();
   Table uiTable = new Table();
   Record uiRecord = new Record();
   //MyTesting myTests = new MyTesting();

   public ArgInterpreter (String[] args) {
      for(int i=0; i<args.length;i++) {
         argHandler(args, i);
      }
   }

   void argHandler(String[] arg, int i)
   {
      if(arg[i].equals("test")) {
         //myTests.testAll();
         uiDb.testAll();

      }
      if(arg[i].equals("insertfield")) {
         uiRecord.addField(arg[i+1]);
      }
      if(arg[i].equals("insertrecord")) {
         uiTable.insertRecord(uiRecord);
      }
      if(arg[i].equals("inserttable")) {
         uiDb.insertTable(uiTable);
      }
      if(arg[i].equals("clearrecord")) {
         uiRecord.deleteFields();
      }
      if(arg[i].equals("cleartable")) {
         uiTable.clearTable();
      }
      if(arg[i].equals("cleardb")) {
         uiDb.clearDb();
      }
      if(arg[i].equals("printrecord")) {
         uiRecord.printRecord();
      }
      if(arg[i].equals("printtable")) {
         uiTable.printTable();
      }
      if(arg[i].equals("printdb")) {
         uiDb.printDb();
      }
   }
}

// need function to take the length of arguments. do not check more than that

// notes - check all against possible.
