public class StringArrayList implements StringList {

  private int k = 50; // default capacity
  private String[] myList = new String[k];
  private int nextItem = 0; // pointer to next item
  public int numberOfEntries = 0; // serves as index

  /**
   * Add a String to this list.
   */
  public int add(String s) {
  		if(isFull()) { // check to see if array is full
  			resizeArray(); // if array is full, make new array 2x the original size
  		}
	  	myList[numberOfEntries] = s; // add new string at end of array
	  	numberOfEntries++; // increment array
  		return numberOfEntries - 1;
  }

  /**
   * Takes the original array's objects and copies it into a new array that is
   * double the size of the original one.
   */
  public void resizeArray() {
		String[] newList = new String[2 * myList.length];
		for(int i = 0; i < myList.length; i++) {
			newList[i] = myList[i]; // restock items from old array into new array
		}
		myList = newList;
  }

  /**
   * Retrieve the String at position i.
   */
  public String get(int i) {
  		if(i < numberOfEntries) {
  				return myList[i];
  		} else {
  			throw new IndexOutOfBoundsException("String not found.");
  		}
  }

  /**
   * Return true if this list contains String s.
   */
  public boolean contains(String s) {
  		boolean found = false;
  		int index = 0;
  		while(!found && (index < numberOfEntries)) {
  			if(s.equals(myList[index])) { // compare proposed string with each item
  				found = true;
  			}
  			index++;
  		}
  		return found;
  }

  /**
   * Return the index of String s in this list, or -1 if s is not in this list.
   */
  public int indexOf(String s) {
  		for(int i = 0; i < numberOfEntries; i++) {
  			System.out.println(myList[i]);
  			if(myList[i].equals(s)) {
  				return i;
  			}

  		}
  		return -1;
  }

  /**
   * Return the current size of this list.
   */
  public int size() {
  		return numberOfEntries;
  }
  /**
   * Insert a string into this list in the specified index.
   * Note that this should move the rest of the values in the list.
   */
  public int add(int index, String s) {
	  if(isFull()) {
		  resizeArray();
	  }
  			if(index > numberOfEntries) {
  				throw new IndexOutOfBoundsException("");
  			} else if(index == numberOfEntries) {
  				add(s);
  			} else {
  				for(int i = numberOfEntries; i > index; i--) {
  						myList[i] = myList[i-1]; // makes room for new item from back of array
  				}
  				numberOfEntries++;
  			}
  			myList[index] = s;
  			return index;
  }

  /**
   * Remove all strings from this list.
   */
  public void clear() {
  		for(int i = 0; i < numberOfEntries; i++) {
  			myList[i] = null;
		}
		numberOfEntries = 0;
  }

  /**
   * Return true if this list is empty, false otherwise.
   */
  public boolean isEmpty() {
  		if (numberOfEntries == 0) {
  			return true;
  		} else {
  			return false;
  		}
  }

	/**
	 * Returns true if this list is full, false otherwise.
	 */
	public boolean isFull() {
		return numberOfEntries >= myList.length;
	}

  /**
   * Remove a String at the specified position.
   * Note that all other values should move to fill the gap.
   */
  public String remove(int i) {
  			String result = myList[i];
  			myList[i] = myList[numberOfEntries - 1];
  			myList[numberOfEntries - 1] = null;
  			numberOfEntries--;
  		return result;
  }

  /**
   * Set the value of the String in position index.
   */
  public void set(int index, String s) {
  		myList[index] = s;
  }

  /**
   * Return an array representation of this list.
   */
  public String[] toArray() {
  		@SuppressWarnings("unchecked")
  		String[] result = new String[numberOfEntries];
  		for(int index = 0; index < numberOfEntries; index++) {
  			result[index] = myList[index];
  		}
  		return result;
  }
}
