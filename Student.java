
/**Class name: Student
 * Purpose: To verify each student by a unique number and ensure email 
 * address contains '@' symbol.
 * Name: Matt Hurt
 * Assignment: Project #1
 * IDE: Eclipse, OS: Mac OSX
 * Vocab word: Foray - (1)a sudden or irregular invasion or attack for 
 * war or spoils: raid. 
 * (2)an initial and often tentative attempt to do something in a new 
 * or different field or area of activity.
 * Quote: "Happiness is an attitude.  We either makes ourselves miserable, 
 * or happy and strong. The amount of work is the same". -- Carlos Castaneda 
 * 		    
 * 
 */
//*****************************************************************************	

public class Student {

//***** Begin Declarations ***** 

	private String studentId;		// unique student Id
	private String lastName;		// last name of student
	private String firstName;		// first name of student
	private String studentEmail;	// student email address 
	
    
//***** End Declarations *****

//*****************************************************************************	

/***** Begin constructor *****
* 
* The constructor refers to the private variables to check if there is any 
* instance that is not filled with student's information
* @param lastName: student last name
* @param firstName: student first name
* @param studentId: student Id
* @param studentEmail: student email address
* @throws: lastName: if student last name is blank
* @throws: firstName: if student first name is blank
* @throws: studentEmail: if student email is blank
* @throws: studentId: if students 900 number is blank
* @throws: studentEmail: if the students email does not contain an @ symbol 
*/

	public Student() {
   
		this.lastName = "";     	// refers student last name 
		this.firstName = "";		// refers to students first name
		this.studentId = "";    	// refers to unique student Id 900 number
		this.studentEmail = ""; 	// refers to the students email
		
	}

//*****************************************************************************	
	
/**
 * This method passes in the in the parameters of Student in order to check 
 * to see if the student's email address contains an '@' symbol.		
 * @param studentId: uses student's Id
 * @param firstName: uses student's first name
 * @param lastName: uses student's last name
 * @param studentEmail: uses student's email
 * @throw studentEmail: lets the user now that the address is missing '@' 
 */
	public Student(
      String studentId, 
      String firstName, 
      String lastName, 
      String studentEmail){
          
		if(studentEmail.contains("@")) {
			this.studentEmail = studentEmail;
		}
		else {
			throw new IllegalArgumentException(
         "Students email address " + studentEmail 
         + " does not contain @ symbol");  
		}
		//checks for blank variables
		if((studentId.length() > 0) 
         && (lastName.length() > 0) 
			&& (firstName.length() > 0) 
			&& (studentEmail.length() > 0 
         && studentEmail.contains("@"))) {
			
			this.studentId = studentId;
			this.lastName = lastName; 
			this.firstName = firstName;
			this.studentEmail = studentEmail;
						
		}
		else{
			throw new IllegalArgumentException("There is missing information "
					+ "in the following: " 
					+ "Student Id, First name, Last Name, Student Email");
			
		}
	}	

//***** End constructor *****

//*****************************************************************************
   
//***** Begin getters method *****

   /** @return: getlastName - returns student last name
   *
   */
	public String getlastName() {     // access lastName 
	
		return lastName;
	}
   
	/** @return: getfirstName - student first name
   *
   */ 
	public String getfirstName() {    // access firstName 
		
		return firstName;
	}
   
	/**@return: getstudentId - student identification number (unique)
   *
   */
	public String getstudentEmail() { // access studentEmail 		
		return studentEmail;
	}
   
	/** @return: getstudentEmail - student email address
	*
   */
   public String getstudentId() {    // access studentId 
		
		return studentId;
	}
   
//***** End Getters *****

//*****************************************************************************

//***** Begin equals method *****

/** Method compares the data of the instance variables to see if they contain 
* the same data.   
*
* @param: studentId - compares studentId with object other to make sure they 
*                     are the same.
* @param: firstName - compares the firstName object with object other
* @param: lastName - compares the lastName object with object other
* @param: studentEmail - compares studentEmail object with object other
* @return: will return false if all objects are not the same.
*/ 
	
	public boolean equals(Student other) { // Method header
		return (this.studentId.equals(other.studentId));
		
		// ***The following is for reference***
		 /*if (studentId.equals(other.studentId) 
			&& firstName.equals(other.firstName) 
			&& lastName.equals(other.lastName) 
			&& studentEmail.equals(other.studentEmail)) { 
         
			return true;
		}
		return false;*/
	}
	
//***** End Equals Method *****

//*****************************************************************************
   
//***** Begin toString Method *****
	
	public String toString() {
		String message = "Student ID: " + studentId 
				+ "\nFirst Name: " + firstName
				+ "\nLast Name: " + lastName
				+ "\nStudnet Email: " + studentEmail;		
            
		return message; 
       
	}
   
//*****************************************************************************

}

	
//	End Program
