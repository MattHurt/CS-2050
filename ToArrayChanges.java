// WARNING This file will not compile correctly
/**
   @author Peter Nielson, some documentation added by Mr. Kramer
   @version 1.0
   
   This file contains modifications needed for Project 3 to correctly implement
   the List class's toArray method. There are changes to your main class and
   to the List class 
*/
import java.util.Objects;  // Import into you main and List classes
public class ToArrayChanges {

    // The following goes in your main class

    public static void main(String[] args) {
      // Do nothing in the main class. Changes are to the generateReport method
    } // End main

   //************************************************************************

   /**
      The generateReport method generates the report as indicated in the spec.
      Make the changes below. Substitute for array "examples" the name of the
      array you want to use in the generateReport method. Variable "list" 
      is the reference variable for a list you have created. In this example
      we use Student. Similar changes apply to GradeItem.
   */
   
    public static void generateReport() {
        // The name of the array is what should be used below
        Object[] students = list.toArray();
        Student s1;
        for (int i = 0; i < students.length(); i++) {
            // Cast the generic object as a specific type and print to check
            s1 = (Student) students[i];
            System.out.println(s1.toString());
        } // End for
    } // End generateReport

    //////////////////////
    
    //// List/ArrayList/LinkedList information

    // The toArray inside a list object
    public Object[] toArray() {
        // T[] examples : Generic array used for internal storage in private 
        //                declaration of list class
        // int len      : Length of generic array
        Object[] outputArray = Object[len];

        for(int i = 0; i< len; i++) {
            outputArray[i] = (Object) examples[i];
        }
        return outputArray;
    } // End toArray
} // End class