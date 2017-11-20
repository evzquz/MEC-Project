
import java.util.Scanner;
import javax.swing.JOptionPane;



public class goCalc {
    
    public static void main (String[] args){
    System.out.println("goCalculator");     //displays name of the app
        new goCalc().numVars();                 //calls function for number of variables to work with
    }
    
    
  public void numVars() {

Scanner reader = new Scanner(System.in);    //reading from System.in
System.out.print("Enter number of variables: ");  //asks user for number of variables
    int n = reader.nextInt();   //scans next token of the input as an int
    
    int[] nums = new int[6];
    int x = 0;
    
    int a;
    int b;
    int c;
    int d;
    
    System.out.println("Enter numerical values next to the following variables. ");
  
    if(n == 1)
    {
    System.out.print("a: ");
        a = reader.nextInt();
            nums[0] = a;
    }
    else if (n == 2)
    {
    System.out.print("a: ");
        a = reader.nextInt();
    System.out.print("b: ");
        b = reader.nextInt();
            nums[0] = a;
            nums[1] = b;
           
    }
    else if (n == 3)
    {
    System.out.print("a: ");
        a = reader.nextInt();
    System.out.print("b: ");
        b = reader.nextInt();
    System.out.print("c: ");
        c = reader.nextInt();
            nums[0] = a;
            nums[1] = b;
            nums[2] = c;
    } 
    else if (n == 4)
    {
    System.out.print("a: ");
        a = reader.nextInt();
    System.out.print("b: ");
        b = reader.nextInt();
    System.out.print("c: ");
        c = reader.nextInt();
    System.out.print("d: ");
        d = reader.nextInt();
            nums[0] = a;
            nums[1] = b;
            nums[2] = c;
            nums[3] = d;
    }
    else{
    System.out.println("ERROR! Please enter a number from 1-4.");
    JOptionPane.showMessageDialog(null,"4 variable max! Please enter a number from 1-4.");

    }
        reader.close();                 //finished with scanner
        
        calculation(nums);

}
  
  public void calculation(int[] nums) {
     int numsLength = nums.length;
for(int i=0; i<numsLength; i++){
   // System.out.print(nums[i] + " ");
}   
}
  
  
}

