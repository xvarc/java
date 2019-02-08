/* Calculate a grade from a mark. */
class Grade {

    // Convert the mark into a grade   TODO: complete this
    String grade(int mark) {
       if(0<=mark && mark<=49) {
             return "Fail";
       }
       if(50<=mark && mark<=59) {
             return "Pass";
       }
       if(60<=mark && mark<=69) {
             return "Merit";
       }
       if(70<=mark && mark<=100) {
             return "Distinction";
       }
       else {
          return "Invalid";
       }
    }

    // Convert string to int, or -1 if invalid TODO: complete this
    int convert(String mark) {
       if (mark.matches("[1-9]?\\d")||mark == "100") {
          return Integer.parseInt(mark);
       }
      else {
          return -1;
        }
    }

    // Check each grade
    void testGrades() {
        assert(grade(45).equals("Fail"));
        assert(grade(55).equals("Pass"));
        assert(grade(65).equals("Merit"));
        assert(grade(75).equals("Distinction"));
    }

    // Check boundaries: 0..49, 50..59, 60..69, 70..100
    void testBoundaries() {
        assert(grade(0).equals("Fail"));
        assert(grade(49).equals("Fail"));
        assert(grade(50).equals("Pass"));
        assert(grade(59).equals("Pass"));
        assert(grade(60).equals("Merit"));
        assert(grade(69).equals("Merit"));
        assert(grade(70).equals("Distinction"));
        assert(grade(100).equals("Distinction"));
    }

    // Check out of range gives Invalid
    void testRange() {
        assert(grade(-1).equals("Invalid"));
        assert(grade(101).equals("Invalid"));
    }

    // Check convert works on numbers in range
    void testConvert() {
        assert(convert("0") == 0);
        assert(convert("53") == 53);
        assert(convert("100") == 100);
    }

    // Check non-digits or number out of range or leading zero gives -1
    // (Note: leading zeros are potentially ambiguous because they
    // indicate octal in some circumstances)
    void testInvalid() {
        assert(convert("x") == -1);
        assert(convert("5x") == -1);
        assert(convert("5x6") == -1);
        assert(convert("40.5") == -1);
        assert(convert("-1") == -1);
        assert(convert("101") == -1);
        assert(convert("01") == -1);
        assert(convert("099") == -1);
    }

    // Run the tests.
    void test() {
        boolean testing = false;
        assert(testing = true);
        if (! testing) throw new Error("To test, use java -ea Grade");
        testGrades();
        testBoundaries();
        testRange();
        testConvert();
        testInvalid();
        System.out.println("All tests passed");
    }

    void run(String[] args) {
        if (args.length == 0) test();
        else if (args.length == 1) System.out.println(grade(convert(args[0])));
        else {
            System.err.println("Use:  java -ea Grade   or  java Grade m");
            System.err.println("where m is an integer mark from 0 to 100");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        Grade program = new Grade();
        program.run(args);
    }
}
