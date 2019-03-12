import java.util.Arrays;
import java.util.ArrayList;

public class GradeBookList<T> implements MyCollectionInterface <T> {
	
	private ArrayList<T> GradeBookList = new ArrayList<T>();
	private int numberOfEntries=0;
	boolean ifSuccessfull;
	private int givenPosition;
	
//*****************************************************************************
	

	
	/**
	 * An interface that describes all the operations to be implemented in a 
	 * collection class. It uses generic object (T) and can be used to implement a 
	 * collection class to store generic objects.
	 * @author Dr. Salim Lakhani
	 * @version 1.1, 2017, February 7
	 */
	   
	   /**
	    * Adds a new entry to this collection
	    * 
	    * @param newItem The object to be added to the collection
	    * @return True if the addition is successful, or false if not.
	    */
	   public boolean add (T newItem) {

		   if (!contains(newItem)) {
			   numberOfEntries++;
			   GradeBookList.add(newItem);
			   return true;
		   }   
		   return false;
	   }// end add

		 
//*****************************************************************************	   

		public int getLength() {
	
			return numberOfEntries;
		
		}// end getLength

//************************************************************************
	   
	   public T remove() {
		   
		   T removedItem = GradeBookList.get(0);
		   GradeBookList.remove(0);
		   return removedItem;
		   
	   }
	   
//************************************************************************
	   

	   /**
	    * Removes one occurrence of a given entry from this collection.
	    *
	    * @param anEntry The entry to be removed.
	    * @return true if the removal was successful, false if not.
	    */
	   public boolean remove (T anEntry) {
		   
		   if(contains(anEntry))
		   {
			--numberOfEntries;
			GradeBookList.remove(anEntry);
			return true;
		   }
		   
		   return false;
	   }// end remove

//************************************************************************

	   /**
	    * Removes all entries from this collection.
	    */
	   public void clear(){
		   
		   numberOfEntries = 0;
		   GradeBookList.clear();
	   }// end clear

//************************************************************************

	   /**
	    * Gets the current number of entries in this collection.
	    *
	    * @return The integer number of entries currently in the collection.
	    */
	   public int getCurrentSize(){
		   
		   return GradeBookList.size();
	   }// getCurrentSize

//************************************************************************

	   /**
	    * Check to see if the collection is empty.
	    *
	    * @return True if the collection is empty, or false if not.
	    */
	   public boolean isEmpty() {
		   
		   return true;
	   }// end numberOfEntries

//************************************************************************

	   /**
	    * Counts the number of times a given entry appears in this collection.
	    *
	    * @param anEntry The entry to be counted.
	    * @return The number of times anEntry appears in the collection.
	    */
	   public int getFrequencyOf(T anEntry) {
		  
		  numberOfEntries = 0;
		  for(int i = 0; i < GradeBookList.size(); i++) {
			  if (GradeBookList.get(i).equals(anEntry)) {
				  numberOfEntries++;
			  } // End if
		  } // End for
		  return numberOfEntries;
	   }// end getFrequencyOf

//************************************************************************

	   /**
	    * Tests whether this collection contains a given entry.
	    *
	    * @param anEntry The entry to locate.
	    * @return True if the collection contains anEntry, or false if not.
	    */
	   public boolean contains (T anEntry){
		   boolean found = false;
		   int index = 1;
		   
		   while(!found &&(index <= numberOfEntries)) {
			   if(anEntry.equals(GradeBookList.get(index-1))) {
				   found = true;
			   }
			   index++;// end if
		   }// end while
		   return found;
	   }// end contains

//************************************************************************

	   /**
	    * Retrieves all entries that are in this collection.
	    *
	    * @return A newly allocated array of all the entries in the collection. 
	    * Note: If the collection is empty, the returned array is empty.
	    */
	public T[] toArray (T[] cheat) { //RENAME ME TOO
		   T[] result = GradeBookList.toArray(cheat);
		   
		   return result;
		   
	   }


	/**
	 * Don't use this, it's not working.
	 */
	@Override
	public T[] toArray() {
		   return null;
	}


		
	
}

