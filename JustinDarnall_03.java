/** 
 * CS 2050
 * Program reports the information about the students given an input file.
 * 
 * @author Justin Darnall, Matt Hurt
 * @version 1.0
 */
import java.io.*;
import java.util.*;
import java.lang.Object;



public class JustinDarnall_03 {
	
	/**
	 * 
	 */

   static String INPUT_FILE;
   static String OUTPUT_FILE;
   static List <String> listOfStudents;
   static List <String> listOfGradeItems;
   
   /**
    * The input file is read using the split method to identify the 
    * commas in the file and parses through the information.
    * @param none
    * @return void
    */
   public static void processInput() {
      
      try {
      
      File inputDataFile = new File(INPUT_FILE);
      Scanner inputFile = new Scanner(inputDataFile);
      
         while (inputFile.hasNext()) {
         
            String line = inputFile.nextLine();
            String [] items = line.split(",");
            
            if (items[0].equals("STUDENT")) {
               processStudentData(items);
            } // End if
            else if (items[0].equals("GRADE ITEM")) {
               //processGradeItemData(items);
            } // End else if
            else {
               System.out.println("First item in " + INPUT_FILE 
            		   + " is not STUDENT or GRADE ITEM, please correct");
            } // End else
         } // End while
      } // End try
      catch (FileNotFoundException e) {
         System.err.println("Could not open " + INPUT_FILE);
      } // End catch
   } // End processInput
   
//*****************************************************************************

   /**
    * Checks info[1] for ADD or DEL and either adds the line of information 
    * about the student or
    * deletes the information.
    * 
    * @param student contains students info from Student class.
    * @return void
    * @throw System.err.println occurs if remove action could not be completed.
    */
   public static void processStudentData(String [] info) {
      
      Student student = new Student(); // Adds array from Student to student
      
      if (info[1].equals("ADD")) { // if the index at 1 reads ADD
         try { // warns the user that the student has already been added
            student = new Student(info[2], info[3], info[4], info[5]);
            if (listOfStudents.contains(info[2])) {
               System.out.println("Student " + student.getId() 
               	+ " is already in the list");
            } // End if
            else { // 
               try { // adds to the listOfStudents if no conflict
                  listOfStudents.add(student.getId());
                  listOfStudents.add(student.getFirstName());
                  listOfStudents.add(student.getLastName());
                  listOfStudents.add(student.getEmail());
               } // End try
               catch (Exception e) { // notification of error that occured 
                  System.err.println("Could not add " + student.getId() 
                  	+ " to the list");//Question....WHY
               } // End catch
         } // End try
         } // End try
         catch (IllegalArgumentException e) { // creates an error message ???
            System.err.println(e.getMessage());
         } // End catch
      } // End if
      else if (info[1].equals("DEL")) { // removes if reads phrase DEL
         try {
            student = new Student(info[2], info[3], info[4], info[5]);
               listOfStudents.remove(student.getId());
               listOfStudents.remove(student.getFirstName());
               listOfStudents.remove(student.getLastName());
               listOfStudents.remove(student.getEmail());
         } // End try
         catch (IllegalArgumentException e) { // creates error message???
            System.err.println(e.getMessage());
         } // End catch
         catch (Exception e) { // creates error message???
            System.err.println("Could not remove " + student.getId() 
            	+ " from the list");//Question....WHY
         } // End catch
       
      } // End else if

      else { // print if incorrect phrase at info[1]
         System.out.println("Second data set in student record is not ADD or " 
        		 + "DEL; please correct");
      } // End else      
      
   } // ***** End processStudentData *****
   
//*****************************************************************************

   	// ***** Begin processGraeItemData *****
   
   /**
    * Adds the information from GradeItem class
    * @param info
    */
   
   public static void processGradeItemData (String [] info) {
	   
     /**
      * @param gradeItem contains info about students grades from GradeItem 
      * class
      * @return void
      */
      GradeItem gradeItem = new GradeItem(); 
      
      if (info[1].equals("ADD")) { // if the index at 1 reads ADD. 
         try { // sets the variables to the item in the array.
            int id = Integer.parseInt(info[2]);
            int max = Integer.parseInt(info[7]);
            int score = Integer.parseInt(info[8]);
            
            gradeItem = new GradeItem(id, // gradeItem organized by index.
            	info[3], 
            	info[4], 
            	info[5], 
            	info[6], 
            	max, 
            	score);
            
            // prints message if there is duplicate entry
            if (listOfGradeItems.contains(gradeItem.getItemId()) && 
                 listOfGradeItems.contains(gradeItem.getId())) {
               
               System.out.println("Student " + gradeItem.getId() 
               		+ " and Grade Item:"
                    + gradeItem.getItemId() 
                    + " is already in the list");
            } // End if
            else { // adds the grade information in the array.
               try {
                  listOfGradeItems.add(gradeItem.getId());
                  listOfGradeItems.add(info[2]);
                  listOfGradeItems.add(gradeItem.getCourseId());
                  listOfGradeItems.add(gradeItem.getItem());
                  listOfGradeItems.add(gradeItem.getDate());
               } // End try
               // prints error message if unsuccessful add.
               catch (Exception e) {
                  System.err.println("Could not add " + gradeItem.getId() 
                  + " and GradeItem:"
                  + gradeItem.getItemId() 
                  + " to the list");//Question....WHY
               } // End catch
            } // End else
         } // End try
         catch (IllegalArgumentException e) { // prints erro message???
            System.err.println(e.getMessage());
         } // End catch
      } // End if
      else if (info[1].equals("DEL")) { // if index at 1 equals DEL.
         int id = Integer.parseInt(info[2]); 
         int max = Integer.parseInt(info[7]);
         int score = Integer.parseInt(info[8]);
         
         try { // grade item organized by index to remove elements
            gradeItem = new GradeItem(id, 
               info[3], 
               info[4], 
               info[5], 
               info[6], 
               max, 
               score);
               		listOfGradeItems.remove(gradeItem.getId());
               		listOfGradeItems.remove(info[2]);
               		listOfGradeItems.remove(gradeItem.getCourseId());
               		listOfGradeItems.remove(gradeItem.getItem());
               		listOfGradeItems.remove(gradeItem.getDate());	
          } // End try
         catch (IllegalArgumentException e) { // prints error message???
            System.err.println(e.getMessage());
         } // End catch
         catch (Exception e) { // prints error message???
            System.err.println("Could not remove " + gradeItem.getId() 
            	+ " and GradeItem:"
                + gradeItem.getItemId() 
                + " from the list");  //Question....WHY???         
         } // End catch
       
      } // End else if

      else { // prints message if incorrect phrase at info[1]. 
         System.out.println("Second data set in grade item record is not ADD "
         		+ "or"
         		+ " DEL; please correct");
      } // End else      
      
   } // End processGradeItemData
   
//*****************************************************************************


                   
      