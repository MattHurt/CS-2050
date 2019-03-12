
/**Class name: GradeItem
* Purpose: to track the grades by type of event in order to calculate 
           actualScore
* Assignment:Project #1
* IDE: Eclipse, OS: Mac OSX
* Vocab word: Foray - (1)a sudden or irregular invasion or attack for war or 
*             spoils: raid. 
* (2)an initial and often tentative attempt to do something in a new or 
*    different field or area of activity.
* Quote: "Happiness is an attitude.  We either make ourselves miserable, or 
*        happy and strong. The amount of work is the same". -- Carlos Castaneda 
* 
*/
//*****************************************************************************
/**
 * 
 * @author matthewhurt
 *
 */

public class GradeItem {

//***** Begin Declarations *****

   public static String [] itemTypes = {"HW", 
                                        "Quiz", 
                                        "Class Work", 
                                        "Test", 
                                        "Final"};                              
  
   private int gradeItemId;	   		// Unique value for each grade item
   private String studentId;		// Student unique 900 Id number
   private String courseId;			// Course Identification
   private String itemType;        	// Event that student performed in
   private String date;			    // YYYY/MM/DD
   private int maxScore;         	// maximum score student received
   private int actualScore;      	// score that student received
   
   
//***** End Declarations
				
//*****************************************************************************

//***** Begin constructor *****
		
/**
* Method that receives the specifications as long as they are valid 
* and not null.
*
* @param studentId: unique, sequential, student identification number.		   
* @param GradeItemId: sequence of numbers for each item in itemType.
* @param itemType: HW, Quiz, Class Work, Test, Final.
* @param String date: YYYY/MM/DD
* @param maxScore: max score possible for all events.			
* @param actualScore: actual score student received.	
* @throw: message - if the information is not present for any variable, String 
*                   message will display a message for the corresponding 
*                   issue.
*/

   /**
    * 
    */
   public GradeItem() {  
   
/**
 * Refers to the current objects to initiate default constructor and 
 * declares each variable with a zero or empty string. 
 */  
	  this.gradeItemId = 0;
	  this.studentId = "";
	  this.courseId = "";	 
      this.itemType = "";			      
      this.date = "";				            
      this.maxScore = 0;
      this.actualScore = 0;
  		
   }

/** 
* Method checks to see if all string values are filled with the appropriate
* information corresponding to the students information.
* GRADE ITEM,ADD,1,900123456,23456,HW,20170112,100,95
* new GradeItem(items[3], Intger.parseInt(items[2]), items[5], items[6],
* Intger.parseInt(items [7]), Intger.parseInt(items [8]), items [4]);
*/ 
   public GradeItem(int gradeItemId, 
		   String studentId, 
		   String courseId, 
		   String itemType,
		   String date, 
		   int maxScore, 
      	int actualScore) {
	  
	  boolean isFound = false;
	  boolean isError = false;
            
 /**
  * Array itemTypes length is checked to see if the information has been 
  * given.  isFound returns false if the for loop can not find anything in 
  * itemType. 
  */
      for(int i = 0; i < itemTypes.length; i++) {
         
         if(itemType.equals(itemTypes[i])) {
            isFound = true;
         }
      }
      
/**
 * Checks if the instance length is greater than zero
 *  and assigns the objects with a the value of the original variable.
 */
      if ((gradeItemId != 0) 
            && (studentId.length() > 0)
      		&& (courseId.length() > 0)
      		&& (itemType.length() > 0)
      		&& (date.length() > 0)
            && (maxScore !=  0)
            && (actualScore != 0)) {
      		
    	  this.gradeItemId = gradeItemId;
    	  this.studentId = studentId;
    	  this.courseId = courseId;
    	  this.itemType = itemType;
    	  this.date = date;
    	  this.maxScore = maxScore;
    	  this.actualScore = actualScore;
         
      }
      
/** 
 * If the variable contains a zero value, an exception is thrown and sent 
 * to String message.
 */   
      else { 
         
         String message = "The following is missing input from "
         		+ "the grade item ";
            
         if(gradeItemId <= 0) {
             message += "\nItem number for assignment,";
             isError = true;
          }
         
         if(studentId.length() == 0) {
            message += "\nStudent 900 number";
            isError = true;
         }
         
         if(courseId.length() == 0) {
             message += "\nCourse Id missing,";
             isError = true;
          }
         
         if(itemType.length() == 0) {
            message += "\nEvent type (ex: HW, quiz, Final";
            isError = true;
         }
         
         if(date.length() == 0) {
             message += "\nDate is missing,";
             isError = true;
          }   
         
         if(maxScore <= 0) {
            message += "\nMaximum score is missing,";
            isError = true;
         }
         
         if(actualScore <= 0 || actualScore > maxScore) {
             message += "\nActual score is missing,";
             isError = true;
          }
         
         if(isError) {
        	 throw new IllegalArgumentException(message);      		
         }	 
      }
   }
   
//***** End Constructor *****   
     
//*************************************************************************

//***** Begin getters *****
   
   /**
    * @return studentId - student Id
    */
   public String getstudentId() {   
      return studentId;
   }
      
   /**
    * @return: GradeItemId - unique value for grade item
    */
   public int getGradeItemId() {
      return gradeItemId;
   }
   
/**
 * @return: itemType - returns the assignments inside the array
 */
   public String getitemType() {
      return itemType;
   }
   
/**
 * @return: date yyyy/mm/dd	format 
 */
   public String getdate() {
      return date;
   }
   
/**
 * @return: maxScore - the maximum score the student received
 */
   public int getmaxScore() {
      return maxScore;
   }
   
/**
 * @return: actualScore - the actual score the student received
 */
   public int getactualScore(){
      return actualScore;
   }
   
/**
 * @return: courseId -  returns course identifier
 */
   public String getcourseId(){
      return courseId;
   }  

//***** End getters *****

//*************************************************************************
		
//***** Begin equals method *****
   
/**
 * This method compares each object and returns true or false if condition 
 * isn't met.
 * @param other: instantiated to compare student 900 numbers.
 * @return other: if the student's 900# is the same number being read from 
 * 				  the input file.
 * @param other
 */
   public boolean equals(GradeItem other){
	   return (this.studentId.equals(other.studentId)); // simplified
	   
      /* The following code is commented out for reference of this method
       * 
       * if (gradeItemId == other.gradeItemId
    		&& studentId.equals(other.studentId) 
    		&& courseId.equals(other.studentId)
      		&& itemType.equals(other.itemType) 
      		&& date.equals(other.date)
            && maxScore == other.maxScore
      		&& actualScore == other.actualScore) { 
            
         return true;
      }
      return false;*/
   }
  
//***** End equals method   

//***********************************************************************
		
//***** Begin toString method *****

/**
* The toString prints the information specific to the student.
* @param toString, prints the String message to the console
* @return: message - the information is sent to the console in order to 
*                    display the appropriate information about the 
*                    student.
*/

		
   public String toString() {
   
      String message = "Student Id: " + studentId 
                        + "\nGrade Type: " + gradeItemId 
                        + "\nItem: " + itemType 
                        + "\nDate: " + date
                        + "\nActual Score: " + actualScore + "%"
                        + "\nMaximum Score: " + maxScore + "%";
      return message;
                       
// ***** end toString *****

   }
}

//end program

