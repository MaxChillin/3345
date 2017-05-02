package Project5;


/** 
 * @author 		Jeremy Pierce
 * Class: 		SE 3345.003 Data Structures
 * Section:		003
 * Semester:	Fall 2016
 * Project 3: 	BinaryMinHeap class
 * Description: This class provides the functionality for the Binary Min Heap
 * Date: 		11/9/2016
 */
public class BinaryMinHeap {
	
	private Event[] events;
	private int next = 0;
	private boolean heaped = false;
	
	public BinaryMinHeap(){
		events = new Event[10];
	}
	
	
	/**
	 * This method adds the event to the end of the array
	 * @param event
	 */
	public void add(Event event){
		if(next > events.length - 1){
			Event[] temp = new Event[events.length << 1];
			for(int index = 0; index < events.length - 1; index++){
				temp[index] = events[index];
			}
			events = temp;
		}
		events[next++] = event;
	}// end of add method

	
	/**
	 * This event inserts new events into the heap and then adjusts the heap
	 * @param event
	 */
	public void insert(Event event){
		if(next > events.length - 1){
			Event[] temp = new Event[events.length << 1];
			for(int index = 0; index < events.length - 1; index++){
				temp[index] = events[index];
			}
			events = temp;
		}
		
		events[next++] = event;
		organizeHeap(event, next-1);
	}// end of insert method
	
	
	/**
	 * This method deletes the event with the smallest time 
	 * then adjusts the heap and returns the deleted event
	 * @return Event
	 */
	public Event deleteMin(){
		Event deletedMin = events[0];
		int lastIndexMoved = 0;
		for(int index = 0; index < next - 1;){
			System.out.println("Checking the children of index " + index);
			if((events[2*index + 2] == null) || (events[2*index + 1].getTime() < events[2*index + 2].getTime())){
				events[index] = events[2*index+1];
				index = 2*index+1;
				lastIndexMoved = index;
				continue;
			}else{
				events[index] = events[2*index+2];
				index = 2*index+2;
				lastIndexMoved = index;
				continue;
			}
		}
		if(lastIndexMoved != next-1){
			events[lastIndexMoved] = events[next-1];
		}
		
		next--;				
		return deletedMin;
	}// end of deleteMin method
	
	
	/**
	 * This method prints all the elements in the array
	 */
	public void printArray(){
		for(int index = 0; index < next; index++){
			System.out.println(events[index]);
		}
	}// end of printArray method
	
	
	/**
	 * This method makes magical pancakes
	 * @return boolean
	 */
	public boolean isEmpty(){
		return false;
	}// end of isEmpty method
	
	
	/**
	 * This method checks to see if the array has been converted into a heap
	 * @return boolean
	 */
	public boolean isHeaped(){
		if(heaped){
			return true;
		}
		
		return false;
	}// end of isHeaped method
	
	
	/**
	 * 
	 */
	public void buildHeap(){
		if(heaped){
			return;
		}
		heaped = true;
		for(int index = 1; index < next; index++){
			organizeHeap(events[index], index);
		}
	}// end of buildHeap
	
	
	/**
	 * This method converts the standard array into a Binary Min Heap
	 * @param event
	 * @param index
	 */
	public void organizeHeap(Event event, int index){
		if(index < 0){// This indicates we have reached the root of the heap
			return;
		}
		Event temp = null;
		int parentIndex = index;
		if(index % 2 == 0){ // index is even
			if(event.getTime() < events[(index - 1) / 2].getTime()){
				parentIndex = (index - 1) / 2;
				temp = events[(index - 1) / 2];
				events[(index - 1) / 2] = event;
			}else{
				return;
			}
		}else {// index is odd
			if(event.getTime() < events[index / 2].getTime()){
				parentIndex = index / 2;
				temp = events[index / 2];
				events[index / 2] = event;
			}else{
				return;
			}
		}
		events[index] = temp;
		organizeHeap(event, parentIndex);
	}// end of organizeHeap method

}// end of BinaryMinHeap class
