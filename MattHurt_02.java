/**Class name: MattHurt_02
 * Purpose: This program tests the code in the Student and GradeItem classes
 * for each component: Constructor, Get methods, toString method, equals method.
 * Name: Matt Hurt
 * Assignment: Project #2
 * IDE: Eclipse, OS: Mac OSX
 * Vocab word: Cacophony - 
	1 : harsh or discordant sound : dissonance; specifically : harshness in the 
	sound of words or phrases
	2 : an incongruous or chaotic mixture : a striking combination
 * Quote: "The only way to discover the limits of the possible is to go 
 * 		  beyond them into the impossible." - Arthur C. Clarke 
*/ 
//*****************************************************************************

/**
 * 
 * @author Matthew Hurt
 *
 */

import java.util.Scanner;
import java.io.*;  // access Java input/output classes

// ***** Begin Class *****

public class MattHurt_02 {
	
	  // ***** Begin Declarations *****	
	
      static Student student1;
      static Student student2 = new Student();
      static GradeItem gradeItem1;
      static GradeItem gradeItem2 = new GradeItem();
      static Student listOfStudents;  // = newStudent
      static GradeItem listOfGradeItems;  // = new GradeItem

      
      // ***** End Declarations *****
      
      private static final String INPUT_FILENAME = "Project_02_Input01.txt"; 

      static String [] items = new String [7];
      
   // ***** Begin Main *****   
      
      public static void main(String[] args) {
    	  
    	  System.out.println("\n****** Running test 1 ******");
    	  System.out.println();
      
    	  //*******************************************************************
    	  
    	  // ***** Begin test 1 *****
    	  /**
    	   * Test 1 is hard coded in the same order that the input file is 
    	   * written to show what should appear in the following tests.
    	   */
    	  gradeItem1 = new GradeItem(1, 
    			  "900123456", 	// Student 900# 
    			  "CS 2050",   	// courseId
    			  "HW", 		// itemType
    			  "20190214", 	// date
    			  100, 			// maxScore
    			  100);			// actualScore
    	  
    	  student1 = new Student("900123456", 
    			  "Joe", 
    			  "Doe", 
    			  "JoeDoe@msudenver.edu");
    	  
    	  System.out.println(student1.toString());
    	  System.out.println(gradeItem1.toString());
    	  System.out.println();
    	  
    	  // ***** End Test 1  *****

    	  //*******************************************************************

    	  // ***** Begin test 2a *****
      
    	  /**
    	   * Test 2 tests the constructors, getters and the reading of the data
    	   *  from the input file.
    	   */
    	  System.out.println("\n****** Running test 2 ******");
      
    	  try {

    		  File inputDataFile = new File(INPUT_FILENAME); 
    		  Scanner inputFile = new Scanner(inputDataFile);
    		  
    		  while (inputFile.hasNext()) {
         
    			  String line = inputFile.nextLine();
    			  String [] items = line.split(",");
    			  
    			  /**for(int i =0; i<items.length; i++) {
    				  System.out.println(items[i]);
    			  }*/
    			  
    			  if(items[0].equals("STUDENT")) { // test 2a, 
    				  student2 = processStudentData(items);  
    				  System.out.print("\nName: " + student2.getfirstName()
                		  + " " + student2.getlastName()
                		  + "\nStudent email: " + student2.getstudentEmail()
                		  
                		  );
    			  } //end if
    			  else {
    				  
                	  throw new IllegalArgumentException(
                			  "Student or grade item data does not exist");
        			  }//end else
    			  
    			  line = inputFile.nextLine();
    			  items = line.split(",");
    			  
    			  if(items[0].equals("GRADE ITEM")) { // Test 2b
    				  gradeItem2 = processGradeItemData(items);  
    				  System.out.print("\nGrade ID: " 
    				      + gradeItem2.getGradeItemId() 
                		 // + "\nStudent Id :" + gradeItem2.getstudentId()
                		  + "\nCourse Id: " + gradeItem2.getcourseId()
                		  + "\nItem for grade: " + gradeItem2.getitemType()
                		  + "\nDate: " + gradeItem2.getdate() //.toString()
                		  + "\nMaximum Score: " + gradeItem2.getmaxScore()
                		  + "\nActual Score: " + gradeItem2.getactualScore()
                		  );
    			  } // end else if  
    			  else {
    				  
            	  throw new IllegalArgumentException(
            			  "Student or grade item data does not exist");
    			  } //end else
    		  } // end while
    	  
    		inputFile.close(); // closes input file
    	  } //end try
    	  
    	  catch(FileNotFoundException e) {
      		System.err.println("\nFile not found: " + INPUT_FILENAME);
      
      	  } // End catch
    	  
    	  //***** End test 2 *****
    	  
    	  
			//*****************************************************************
			/**
			 * The third test checks the equals methods for both classes 
			 * GradeItem and Student and display a string message if the 
			 * information matches or if it is different.  
			 */
    	  
    	// ***** Begin test 3 ******
          
    	  System.out.println();
          System.out.println("\n***** Beginning Test 3 ******");
          
          System.out.println("\nRunning Test 3a:");
          
          if(student1.equals(student2)) {
        	  System.out.println("Student objects are equal: Student ID's "
        	  		+ "are "
        			  + student1.getstudentId());
          }
          else {
        	  System.out.println("Student objects are unequal: Student "
        	  		+ "IDs are "
        			  + student1.getstudentId() + " and" 
        			  + student2.getstudentId());
          }
          System.out.println("Running Test 3b:");
          
          if(gradeItem1.equals(gradeItem2)) {
        	  System.out.println("Grade objects are equal: Student IDs are " 
        			  + gradeItem1.getstudentId());
          }
          else {
        	  System.out.println("GradeItem objects are unequal: "
        	  		+ "Student ID's are " 
        			  + gradeItem1.getstudentId() 
        			  + " and " + gradeItem2.getstudentId());
          }
          
          
          
     // ***** End test 3 *****
		
   } // End main
      

//*****************************************************************************

// ****** Begin processGradeItemData ******

/**
 * processGradeItemData uses the information in the GradeItem class
 * and sorts the information according to the corresponding index
 * of how the information is stored.  
 * 
 * @param items, is will be used to store the information 
 * 		  in this method
 * @return void
 */
 
   public static GradeItem processGradeItemData(String[] items) { 

	//int studentId; // studentId 
   	int maxScore; // maxScore
   	int actualScore; // actualSCore
   	
   	GradeItem gradeItem = new GradeItem();
   	
   	try {
      maxScore = Integer.parseInt(items[7]); 
      actualScore = Integer.parseInt(items[8]); 
   
      gradeItem = new GradeItem (
    		  Integer.parseInt(items[2]), // gradeItem
    		  items[3],  // studentId
    		  items [4], // Course Id
    		  items [5], // itemType 		  
    		  items [6], // date
    		  maxScore,	// maxScore
    		  actualScore); // actualScore
   	} // End try

   	catch(IllegalArgumentException e) {
	   System.err.println("\nStudent's grades were not added");
   	} // End catch
   	return gradeItem;
   	

      
	}// ***** End processGradeItemData *****

//*****************************************************************************

// ***** Begin processStudentData *****

/**
 * processStudentData uses the information in the Student class
 * and sorts the information according to the corresponding index
 * of how the information is stored.  
 * 
 * @param student is will be used to store the information 
 * 		  in this method
 * @return 
 * @return void
 */

	public static Student processStudentData(String [] items) {
		Student student = new Student();
		
		try {

			if(items[1].equals("ADD")) {
				student = new Student(
						items[2], // Student ID
						items[3], // first name
						items[4], // last name
						items[5]  // student email
						);
			} // end if 
			//return student2;
		}// end try
   
		catch(IllegalArgumentException e) {
			System.err.println("Missing @ symbol");
   
		}// end catch
		return student;
		
// ***** End processStudentData *****
          
//*****************************************************************************
		
// ***** Begin generateReport *****
		
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
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}	
	
	
	
}