package Project2;
/** 
 * @author Jeremy Pierce
 * @version 0.0.0
 * Description: This program defines all the methods needed to build a linked list
 * Class: SE 3345.003 Data Structures and Algorithms
 * Project 2: Singly_LinkedList_Pierce Class
 * Date: 9/20/2016
 */
public class Singly_LinkedList_Pierce<Anytype extends IDedObject>  {

	private Link<Anytype> header;
	
	/**
	 * No parameter Constructor
	 */
	public Singly_LinkedList_Pierce(){
		header = new Link<Anytype>();
		header.data = null;
		header.next = null;
	}// End of no parameter constructor
	
	/**
	 * This method sets the linked list back to an empty state
	 */
	public void makeEmpty(){
		header = new Link<Anytype>();
		header.data = null;
		header.next = null;
	}// end of makeEmpty method
	
	public void swapAdjacent(int ID){
		Link<Anytype> previousLink = null;
        Link<Anytype> firstLinkToSwap = header;
        Link<Anytype> secondLinkToSwap = null;
        Link<Anytype> endOfSwapChain = null;
        
        while(firstLinkToSwap != null && firstLinkToSwap.data != null && firstLinkToSwap.data.getID() != ID){
            previousLink = firstLinkToSwap;
            firstLinkToSwap = firstLinkToSwap.next;
        }
        
        if(previousLink != null){
        	secondLinkToSwap = firstLinkToSwap.next;
        	endOfSwapChain = firstLinkToSwap.next.next;
        	previousLink.next = secondLinkToSwap;
        	secondLinkToSwap.next = firstLinkToSwap;
        	firstLinkToSwap.next = endOfSwapChain;
        }else{
        	secondLinkToSwap = firstLinkToSwap.next;
        	endOfSwapChain = firstLinkToSwap.next.next;
        	header = secondLinkToSwap;
        	secondLinkToSwap.next = firstLinkToSwap;
        	firstLinkToSwap.next = endOfSwapChain;
        }
       
	}
	
	/**
	 * This method traverse the list and returns the listing if found. If the ID is not found returns null
	 * @param ID This is the id of the link you want to find
	 * @return Link<Anytype> 
	 */
	public Anytype findID(int ID){
		Link<Anytype> currentLink = header;
		
		while(currentLink != null && currentLink.data != null && currentLink.data.getID() != ID){
			currentLink = currentLink.next;
		}
		
		if(currentLink != null && currentLink.data != null) 
			return currentLink.data;
		
		return null;
	}// End of findID method
	
	/**
	 * This method inserts a link at the front of the list
	 * @param x This is the link to be inserted
	 * @return false if the list is empty or if ID is already in the list. Returns true otherwise.
	 */
	@SuppressWarnings("unused")
	public boolean insertAtFront(Anytype x){
		Link<Anytype> tempLink = new Link<Anytype>();
		Link<Anytype> currentLink = header;
		
		if(tempLink == null) return false; // out of memory
		
		//This loop checks for duplicate links
		while(currentLink.data != null) {
			if(currentLink.data.getID() == x.getID()){
				System.out.println("That ID is already in use.\nPlease use another ID.");
				return false;
			}
			currentLink = currentLink.next;
		}
		
		tempLink.next = header;
		header = tempLink;
		tempLink.data = x;
		return true;
	}// End of insertAtFront method
	
	/**
	 * 
	 * @return tempLink.listing
	 */
	public Anytype deleteFromFront(){
		if(header.data == null)
			return null;
		else{
			Link<Anytype> tempLink = new Link<Anytype>();
			tempLink = header;
			header = header.next;
			return tempLink.data;
		}
	}// end of deleteFromFront method
	
	/**
	 * 
	 * @param ID
	 * @return
	 */
	public Anytype delete(int ID) {
        Link<Anytype> previousLink = null;
        Link<Anytype> currentLink = header;
        Link<Anytype> tempLink = new Link<Anytype>();
        
        while(currentLink != null && currentLink.data != null && currentLink.data.getID() != ID){
            previousLink = currentLink;
            currentLink = currentLink.next;
        }
        
        if(previousLink == null)
            return this.deleteFromFront();
        
        if(currentLink != null){
            tempLink = currentLink;
            previousLink.next = currentLink.next;
            return tempLink.data;
        }
        return null;
    }// End of delete method
	
	/**
	 * 
	 */
	public void printAllRecords(){
		Link<Anytype> link = header;
		
		// This checks if the list is empty and prints a message if it is empty
		if(link != null && link.data == null){
			System.out.println("\n***********************");
			System.out.print("Linked List is empty :(");
			System.out.println("\n***********************");
			return;
		}
		
		while(link != null && link.data != null){
			System.out.println("\n*****************");			
			System.out.println(link.data.toString());			
			link = link.next;
		}
		System.out.println("\n*****************");
	}// End of printAllRecords method

	/**
	 * 
	 * @author Jeremy Pierce
	 *
	 * @param <Anytype>
	 */
	public static class Link<Anytype>{
		private Anytype data;
		private Link<Anytype> next;
		
		// Link no parameter Constructor
		public Link(){}
		
	}//End of Inner Link Class

}// End of Singly_LinkedList_Pierce Class
