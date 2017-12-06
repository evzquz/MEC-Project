/*--------------------------------------------------------------------------------------------------
*   Author: Erika Vazquez
*   Written: 10/2017
*   Last Updated: 12/04/2017
*
*   Mathematical Expression Calculator
*   goCalc.java
*
*   Small program that computes a mathematical expression using up to 4 variables if user desires.
--------------------------------------------------------------------------------------------------*/

import bsh.EvalError;
import bsh.Interpreter;
import java.util.Scanner;

public class goCalc {
    Scanner reader = new Scanner(System.in);    //reading from System.in

    public static void main (String[] args) throws EvalError{
         System.out.println("\tMEC - Mathematical Expression Calculator"+"\n *******************************************************************************");     //displays name of the app
         new goCalc().numVars();     //calls function for number of variables to work with
    }

    public void numVars() throws EvalError{
         System.out.print(" \n\n Enter number of variables (0-4): ");     //asks user for number of variables
         int n = reader.nextInt();   //scans next token of the input as an int
         double[] nums = new double[6];    //Array that holds 6 variables
         double a;
         double b;
         double c;
         double d;
    
         System.out.println("Enter numerical values next to the following variables. ");    //asks user to input values next to each variable if any
         switch (n) {
           case 0:
                calculation(nums);
                break;
            case 1:
                System.out.print("a: ");
                a = reader.nextDouble();
                nums[0] = a;
                break;
            case 2:
                System.out.print("a: ");
                a = reader.nextDouble();
                System.out.print("b: ");
                b = reader.nextDouble();
                nums[0] = a;
                nums[1] = b;
                break;
            case 3:
                System.out.print("a: ");
                a = reader.nextDouble();
                System.out.print("b: ");
                b = reader.nextDouble();
                System.out.print("c: ");
                c = reader.nextDouble();
                nums[0] = a;
                nums[1] = b;
                nums[2] = c;
                break;
            case 4:
                System.out.print("a: ");
                a = reader.nextDouble();
                System.out.print("b: ");
                b = reader.nextDouble();
                System.out.print("c: ");
                c = reader.nextDouble();
                System.out.print("d: ");
                d = reader.nextDouble();
                nums[0] = a;
                nums[1] = b;
                nums[2] = c;
                nums[3] = d;
                break;
            default:
                System.out.println("\t ERROR! Please enter a number from 0-4.");
                numVars();  //Choosing a number out of the range will cause program to ask user again for a valid entry
                break;
         }
         calculation(nums);     //call on the calculation function once variables have been handled
    }
  
    public void menuOpt(double [] nums) throws EvalError{
         String menuOpt;

         //Displays options that user can do after an expression has been calculated 
         System.out.println("Evaluate another expression( with same variable values) -> e");
         System.out.println("Start Over -> s");
         System.out.println("Quit -> q");
        
         System.out.println("What would you like to do?");
         menuOpt = reader.next();   //user input - single character only - uppercase works too
        
         if(menuOpt.equals("e") || menuOpt.equals("E")){
             calculation(nums);
         }
         else if(menuOpt.equals("s") || menuOpt.equals("S")){
             numVars();
         }
         else if(menuOpt.equals("q") || menuOpt.equals("Q")){
             reader.close();     //finished with scanner
             System.exit(0);    //cause program to terminate
         }
         else{
            System.out.println("\t Error! Try again. select an option from above.");
            menuOpt(nums);  //asks user again for a valid option
         }
    }
  
    public void calculation(double[] nums) throws EvalError{
         double varA = nums[0];    //takes the variables from the numVars function into new variables
         double varB = nums[1];
         double varC = nums[2];
         double varD = nums[3];     
 
         System.out.println("\n \n Please enter math expression: ");    //asks user to input math expression
         String s = reader.next();      //takes in the expression as a string
    
         Interpreter interpreter = new Interpreter();            //beanshell interpreter


         interpreter.set("a", varA);    //interpreter finds these chars and gives them numerical vals 
         interpreter.set("b", varB);
         interpreter.set("c", varC);
         interpreter.set("d", varD);

         String expression = s;   //assigns the s equation to new string called expression
         Object checkIt = interpreter.eval(expression);   //checkIt will evaluate the expression
         System.out.println("= "+ checkIt);     //displays the evaluation result
         System.out.println(" *******************************************************************************");
         menuOpt(nums);     //asks user what they would like to do next
    }
}
