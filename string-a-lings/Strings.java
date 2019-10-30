/*
* Copyright 2019 David Boyd, all rights reserved
* Program: Strings
* Description:
*     The program manipulates strings by reverse, random shuffle, odd/even
*     index chars, and subsets.
* Date: Fri Sep 27
* Revised:
*     <revision date>
*/
import java.util.Scanner;
import java.util.Random;

public class Strings
{
  // Declare Strings Class Vars
  int length;                    // Length
  Random r_word = null;          // Random word
  String usrInput = null;        // Input string from user
  String revUsrInput = null;     // Reverse string
  String subStr_even = null;     // Even alternate chars
  String subStr_odd = null;      // Odd alternate chars
  String subString = null;       // Cat alt chars (oddeven)
  String revSubStr_odd = null;   // Reversed odd alt chars
  String revSubStr_even = null;  // Reversed even alt chars
  String revSubString = null;    // Reversed cat alt chars (oddeven)
  String shuffle = null;         // Shuffled chars
  String[] stringSet = null;     // Input strings sep = " "
  String[] shuffleSet = null;    // Set of shuffled individual strings

  // Get user input & call setters
  Strings()
  {
    setString();
    setAllClassVars();
  }

  // Call all setters (for hardcoding user input)
  Strings(String hardcode)
  {
    this.usrInput = hardcode.trim();
    setAllClassVars();
  }

  // Set All Class Variables
  public void setAllClassVars()
  {
    setLength();
    setReverse();
    setSubString_even();
    setSubString_odd();
    setSubString();
    setRevSubString_odd();
    setRevSubString_even();
    setRevSubString();
    setRandomWord();
    setShuffle();
    setStringSet();
    setStringShuffleSet();
  }
  // Set length of string
  public void setLength()
  {
    this.length = usrInput.length();
  }
  // Set reverse string
  public void setReverse()
  {
    String s = this.usrInput;
    char[] usrInput = s.toCharArray();
    int begin = 0;
    int end = this.length-1;

    while (end > begin)
    {
        char temp = usrInput[begin];
        usrInput[begin] = usrInput[end];
        usrInput[end] = temp;
        --end;
        ++begin;
    }
    this.revUsrInput = new String(usrInput);
  }
  // Set even number of substring chars
  public void setSubString_even()
  {
    this.subStr_even = "";
    for (int even=0; even<this.length; even+=2)
    {
        this.subStr_even += this.usrInput.charAt(even);
    }
  }
  // Set odd number of substring chars
  public void setSubString_odd()
  {
    this.subStr_odd = "";
    for (int odd=1; odd<this.length; odd+=2)
    {
        this.subStr_odd += this.usrInput.charAt(odd);
    }
  }
  // Set concatenated substring starting with odd chars
  public void setSubString()
  {
    this.subString = (this.subStr_odd + subStr_even);
  }
  // Set Random Word
  public void setRandomWord()
  {
    this.r_word = new Random();
  }
  // Set string
  public void setString()
  {
    // Get user input
    Scanner input = new Scanner(System.in);
    String s_input = input.nextLine();
    // Remove leading & trailing whitespace
    this.usrInput = s_input.trim();
  }
  // Set string into "sets" of words
  public void setStringSet() {
      this.stringSet = this.usrInput.split(" ");
    }
  // Set reversed even number of substring chars
  public void setRevSubString_even()
  {
    this.revSubStr_even = "";
    for (int even = this.length-2; even>=0; even-=2)
    {
        this.revSubStr_even += this.usrInput.charAt(even);
    }
  }
  // Set reversed odd number of substring chars
  public void setRevSubString_odd()
  {
    this.revSubStr_odd = "";
    for (int odd = this.length-1; odd>=0; odd-=2)
    {
      this.revSubStr_odd += this.usrInput.charAt(odd);
    }
  }
  // Set concatenated reversed substring starting with odd chars
  public void setRevSubString()
  {
    this.revSubString = (this.revSubStr_odd + this.revSubStr_even);
  }
  // Set shuffled string
  public void setShuffle()
  {
    this.shuffle = stringShuffle(this.usrInput, this.r_word);
  }
  // Shuffle string
  public static String stringShuffle(String s, Random r) {
    char[] userInput = s.toCharArray();

    for(int i = 0; i < userInput.length; ++i) {
      int j = r.nextInt(userInput.length);
      char temp = userInput[i];
      userInput[i] = userInput[j];
      userInput[j] = temp;
    }

    String string = new String(userInput);
    return string;
  }
  // Shuffle set of strings
  public void setStringShuffleSet()
  {
    this.shuffleSet = this.usrInput.split(" ");
    int size = this.shuffleSet.length;
    for (int i=0; i<size; ++i) {
      this.shuffleSet[i] = stringShuffle(this.stringSet[i], this.r_word);
    }
    randomizeArray();
  }
  // Shuffle elements in shuffleSet array
  public void randomizeArray() {
    Random rgen = new Random();

    for (int i=0; i<shuffleSet.length; ++i)
    {
      int randomPosition = rgen.nextInt(shuffleSet.length);
      String temp = this.shuffleSet[i];
      this.shuffleSet[i] = this.shuffleSet[randomPosition];
      this.shuffleSet[randomPosition] = temp;
    }
  }
  // Display Part Two of Assignment
  public static void displayPartTwo(Strings obj)
  {
    System.out.println("Output: " + obj.revSubString);
    System.out.println("\nExplanation:");
    System.out.println("\tSubstrings are :" + obj.subStr_even + ", "
                        + obj.subStr_odd);
    System.out.println("\tReversed substrings are :" + obj.revSubStr_odd
                        + ", " + obj.revSubStr_even);
    System.out.println("\tOutput: " + obj.revSubString);
  }
  // Display Part Three of Assignment
  public static void displayPartThree(Strings obj) {

    System.out.println("Input: \"" + obj.usrInput + "\"  " + "(length "
                       + obj.length + ")");
    System.out.print("Output: \"");
    displayShuffledSet(obj);
    System.out.print("\b\" " + "(length " + obj.length + ")");


  }
  // Display Shuffle
  public static void displayShuffleTruffle(Strings obj, int nTimes)
  {
    for (int i=0; i<nTimes; ++i)
    {
        System.out.println("\tShuffled string " + (i+1) + ": " + obj.shuffle);
        obj.shuffle = stringShuffle(obj.usrInput, obj.r_word);
    }
  }
  // Display Shuffled Set
  public static void displayShuffledSet(Strings obj)
  {
    for (int i=0; i<obj.shuffleSet.length; ++i)
    {
        System.out.print(obj.shuffleSet[i] + " ");
    }
  }
  // Call command line args
  public static boolean anyArgs(String[] args)
  {
    return (args.length == 0) ? false : true;
  }
  // Cat command line args w/ whitespace
  public static String callCLIArgs(String[] args)
  {
    String cli_input = "";
    for (String s: args) {
        cli_input += (s + " ");
    }
    // Remove all leading and trailing whitespaces
    return cli_input.trim();
  }
  // ============
  // === main ===
  // ============
  public static void main (String[] args)
  {
    // Declare and initialize objects, loops, and shuffles
    int num_objs = 3;      // Number of objects to create
    int num_shuffles = 3;  // Number of times to shuffle & display words
    Strings[] objArray = new Strings[num_objs];

    // Check for CLI arguments
    boolean cli_bool = anyArgs(args);


    // Initialize & process objects
    for (int i=0; i<num_objs; ++i) {
      System.out.print("\nInitializing test " + (i+1)
                        + " . . . . . . .\n\nInput: ");
      if (i==0) {
        // Get user input
        if (cli_bool) {
          // Get from CLI args
          String cli_input = callCLIArgs(args);
          objArray[i] = new Strings(cli_input);
          System.out.println(objArray[i].usrInput);
        } else {
            // Get from runtime
            objArray[i] = new Strings();}
      // Run hardcoded data
      } else {
          if (i==1)      { objArray[i] = new Strings("abscacd"); }
          else if (i==2) { objArray[i] = new Strings("1234567"); }
          else { System.out.println("\nYou Shouldn't Be Here!"); }

          // Print hardcoded data
          System.out.println(objArray[i].usrInput);
      } // End if/else object-creation

      // Display results of maninpulated string data
      displayPartTwo(objArray[i]);
      System.out.println("\nBegin the Shuffle Truffle!");
      displayShuffleTruffle(objArray[i], num_shuffles);
      System.out.println();
      displayPartThree(objArray[i]);
      System.out.println();
      System.out.println("\nTest " + (i+1) + " complete . . . . . . . . .\n");
    } // End for loop obj-creation & display
  }
}
