/**Class name: MattHurt_JustinDarnall_JorgeSilva_03
 * Purpose: This program tests the code in the Student and GradeItem classes
 * for each component: Constructor, Get methods, toString method, equals method.
 * Name: Matt Hurt, Justin Darnall, Jorge Silva
 * Assignment: Project #3
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

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// ***** Begin Class *****

public class MattHurt_JustinDarnall_JorgeSilva_03 {
	
	  // ***** Begin Declarations *****	
	
      static Student student1;
      static Student student2;
      static GradeItem gradeItem1;
      static GradeItem gradeItem2;
      static GradeBookList<Student> listOfStudents;  // = newStudent
      static GradeBookList<GradeItem> listOfGradeItems;  // = new GradeItem
      
      
      
      // ***** End Declarations *****
      
      private static final String INPUT_FILENAME = "Project_03_Input01.txt"; 

      static String [] items = new String [7];
      
   // ***** Begin Main *****   
      
      public static void main(String[] args) {
    	  
    	  listOfGradeItems = new GradeBookList <GradeItem> ();
    	  listOfStudents = new GradeBookList <Student> ();
    	  
    	  processInput();
    	  generateReport();
 
   } // End main
      /**
       * 
       * @throws IOException - if file is not found.
       */
      private static void processInput()  
      {
    		System.out.println("Opening file Project_03_Input01.txt");
    	  	try {
    		FileInputStream inputFile = new FileInputStream("Project_03_Input01.txt"); // file input stream
    		Scanner scnr = new Scanner(inputFile);

      		  //FileInputStream inputDataFile = new FileInputStream("Project_03_Input01.txt"); 
      		  //Scanner inputFile = new Scanner(inputDataFile);
      		  
      		  while (scnr.hasNextLine()) 
      		  {
      			  try 
      			  {
      				  String line = scnr.nextLine();
      				  String [] items = line.split(",");
      			  
      				  if(items[0].equals("STUDENT")) 
      				  { 
      					  processStudentData(items);
      				  
      				  } //end if

      				  //String line1 = scnr.nextLine();
      				  //items = line1.split(",");
      			  
      				  if(items[0].equals("GRADE ITEM")) 
      				  { 
      					  processGradeItemData(items);  
      				  } // end if 
      				//inputFile.close(); // closes input file
      			} 
      			catch (IllegalArgumentException e)
      				  {
      					  System.err.println("Student or grade item data does not exist");
              			
      				  } //end catch
   
      		  } // end while
      	  
      		
      	  } //end try
      	  
      	  catch(FileNotFoundException e) {
        		System.err.println("\nFile not found: " + INPUT_FILENAME);
        
        	  } // End catch
    	  /*catch(Exception e) {
    		  System.err.println("Could not close file");
    	  }*/
    		
    		
      } //end processInput

//*****************************************************************************

// ****** Begin processGradeItemData ******

/**
 * processGradeItemData uses the itemsrmation in the GradeItem class
 * and sorts the itemsrmation according to the corresponding index
 * of how the itemsrmation is stored.  
 * 
 * @param items, is will be used to store the itemsrmation 
 * 		  in this method
 * @return 
 * @return void
 */
 
   public static void processGradeItemData(String [] items) { 

	   GradeItem gradeItem = new GradeItem(); 
	      
	      if (items[1].equals("ADD")) { // if the index at 1 reads ADD. 
	         try { // sets the variables to the item in the array.
	            int id = Integer.parseInt(items[2]);
	            int max = Integer.parseInt(items[7]);
	            int score = Integer.parseInt(items[8]);
	            
	            gradeItem = new GradeItem(id, // gradeItem organized by index.
	            	items[3], 
	            	items[4], 
	            	items[5], 
	            	items[6], 
	            	max, 
	            	score);
	            
	            // prints message if there is duplicate entry
	            if (listOfGradeItems.contains(gradeItem) && 
	                 listOfGradeItems.contains(gradeItem)) {
	               
	               System.out.println("Student " + gradeItem.getstudentId() 
	               		+ " and Grade Item:"
	                    + gradeItem.getcourseId() 
	                    + " is already in the list");
	            } // End if
	            else { // adds the grade itemsrmation in the array.
	               try {
	                  listOfGradeItems.add(gradeItem);
	               } // End try
	               // prints error message if unsuccessful add.
	               catch (Exception e) {
	                  System.err.println("Could not add " + gradeItem.getstudentId() 
	                  + " and GradeItem:"
	                  + gradeItem.getitemType() 
	                  + " to the list");//Question....WHY
	               } // End catch
	            } // End else
	         } // End try
	         catch (IllegalArgumentException e) { // prints erro message???
	            System.err.println(e.getMessage());
	         } // End catch
	      } // End if
	      else if (items[1].equals("DEL")) { // if index at 1 equals DEL.
	         int id = Integer.parseInt(items[2]); 
	         int max = Integer.parseInt(items[7]);
	         int score = Integer.parseInt(items[8]);
	         
	         try { // grade item organized by index to remove elements
	            gradeItem = new GradeItem(id, 
	               items[3], 
	               items[4], 
	               items[5], 
	               items[6], 
	               max, 
	               score);
	               		listOfGradeItems.remove(gradeItem);
	          } // End try
	         catch (IllegalArgumentException e) { // prints error message???
	            System.err.println(e.getMessage());
	         } // End catch
	         catch (Exception e) { // prints error message???
	            System.err.println("Could not remove " + gradeItem.getstudentId() 
	            	+ " and GradeItem:"
	                + gradeItem.getcourseId() 
	                + " from the list");  //Question....WHY???         
	         } // End catch
	       
	      } // End else if

	      else { // prints message if incorrect phrase at items[1]. 
	         System.out.println("Second data set in grade item record is not ADD "
	         		+ "or"
	         		+ " DEL; please correct");
	      } // End else      
	      
	   } // End processGradeItemData
	   
	//*****************************************************************************

// ***** Begin processStudentData *****

/**
 * processStudentData uses the itemsrmation in the Student class
 * and sorts the itemsrmation according to the corresponding index
 * of how the itemsrmation is stored.  
 * 
 * @param student is will be used to store the itemsrmation 
 * 		  in this method
 * @return 
 * @return void
 */

	public static void processStudentData(String [] items) 
	{
		//Student student = new Student();
		//System.out.println("Attempting to " + items[1] + " student#: " + items[2]);
			if(items[1].equals("ADD")) 
			{
				try 
				{ // warns the user that the student has already been added
		            Student student = new Student(items[2], items[3], items[4], items[5]);
		            if (listOfStudents.contains(student)) 
		            {
		               System.out.println("Student " + student.getstudentId() 
		               	+ " is already in the list");
		            } // End if
		            else 
		            { // 
		               try 
		               { // adds to the listOfStudents if no conflict
		                  listOfStudents.add(student);
		                  
		               } // End try
		               catch (Exception e) 
		               { // notification of error that occured 
		                  System.err.println("Could not add " + student.getstudentId() 
		                  	+ " to the list");//Question....WHY
		               } // End catch
		            }// end else
		         } // End try
		         
		        catch (IllegalArgumentException e) 
				{ // creates an error message ???
		            System.err.println(e.getMessage());
		        } // End catch
		      } // End if
		      else if (items[1].equals("DEL")) 
		      { // removes if reads phrase DEL
		         try 
		         {
		            Student student = new Student(items[2], items[3], items[4], items[5]);
		               listOfStudents.remove(student);
		         } // End try
		         catch (IllegalArgumentException e) 
		         { // creates error message???
		            System.err.println(e.getMessage());
		         } // End catch
		         catch (Exception e) 
		         { // creates error message???
		            System.err.println("Could not remove " + items[2]
		            	+ " from the list");//Question....WHY
		         } // End catch
		       
		      } // End else if

		      else 
		      { // print if incorrect phrase at items[1]
		         System.out.println("Second data set in student record is not ADD or " 
		        		 + "DEL; please correct");
		      } // End else      
		      
		   } // ***** End processStudentData *****
		   
		//*****************************************************************************
   
		
// ***** End processStudentData *****
          
//****************************************************************************
		
// ***** Begin generateReport *****
		
//************************************************************************

		   /**
		      The generateReport method generates the report as indicated in the spec.
		      Make the changes below. Substitute for array "examples" the name of the
		      array you want to use in the generateReport method. Variable "list" 
		      is the reference variable for a list you have created. In this example
		      we use Student. Similar changes apply to GradeItem.
		   */
		   
	
		   public static void generateReport() { // ***** NOT FINISHED *****
		        // The name of the array is what should be used below
			   /**
			    * Copy line 313 and 314 and make another array for GradeBookList because
			    * were going to need to print out all the other GradeItems.
			    */
			   
			   // Declares the reference variable of type Student and sets the length of the array based on the amount of elements in the array 
			    Student[] setLengthOfArrayToListOfStudents = new Student[listOfStudents.getLength()]; 
			    
			    // The reference variable created is set to type Student and creates an array by setting it to 
			    // the toArray method and passing in the length of the array listOfStudents.
		        Student[] student = listOfStudents.toArray(setLengthOfArrayToListOfStudents);
		        
		        // These new operators are created using the same idea for the students but is referring to grades
		        GradeItem[] gradeCheat = new GradeItem[listOfGradeItems.getLength()];
		        GradeItem[] grade = listOfGradeItems.toArray(gradeCheat);
		        
		        Student s1;  // Not sure why these are here or what they do
		        GradeItem g1;
		        double sumMax ;
				double sumActual ;
				double percent;
				
				
			        
			        for (int i = 0; i < student.length; i ++) {
			        	System.out.println(student[i]);
			        	System.out.println("\tGrade Items");
			        	sumMax = 0;
			        	sumActual = 0;
			        	percent = 0;

			        	for(int j = 0; j < grade.length; j ++) {
			        		if(student[i].getstudentId().equals(grade [j].getstudentId())) {
						
			        			System.out.printf("\t%-4s %-10s %-12s %-10s %-7s %-5s\n" , 
			        					grade[j].getGradeItemId(), 
			        					grade[j].getcourseId(), 
			        					grade[j].getitemType(), 
			        					grade[j].getdate(), 
			        					grade[j].getmaxScore(),
			        					grade[j].getactualScore());
			        			sumMax += grade[j].getmaxScore();
			        			sumActual += grade[j].getactualScore();
			        			

			        		}
			        	}
			        	System.out.println("\n===========================================================================");
			        	 
			        	if(sumMax > 0) {
			        		percent = (sumActual / sumMax) * 100;
			        	}
					        System.out.printf("Total\t\t\t\t\t" + sumMax +"\t" +  sumActual
					        		+ "\t" + percent);
					        System.out.println("%\n");
					        
			        } // End for
			      
			      
		       
		   }
}
			        
