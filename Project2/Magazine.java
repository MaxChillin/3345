package Project2;
/** 
 * @author Jeremy Pierce
 * @version 0.0.0
 * Description: This class is to be used with the Singly_LinkedList_Pierce class
 * Class: SE 3345.003 Data Structures and Algorithms
 * Project 2: Magazine Class
 * Date: 9/20/2016
 */
public class Magazine implements IDedObject {
	
	private int magazineID;
	private String magazineName;
	private String publisherName;
	
	/**
	 * No parameter constructor
	 */
	public Magazine(){
		magazineID = 0;
		magazineName = "";
		publisherName = "";
	}// end of no parameter constructor
	
	/**
	 * Parameter Constructor
	 * @param id to be used to find links in the list
	 * @param magName This is the Magazine Name
	 * @param pubName This is the Publisher Name
	 */
	public Magazine(int id, String magName, String pubName){
		magazineID = id;
		magazineName = magName;
		publisherName = pubName;
	}// end of parameter constructor
	
	/**
	 * Copy Constructor
	 * @param mag This is an object of the Magazine class
	 */
	public Magazine(Magazine mag){
		magazineID = mag.getID();
		magazineName = mag.getMagazineName();
		publisherName = mag.getPublisherName();
	}// end of copy constructor

	/**
	 * This method returns the name of the magazine
	 * @return magazineName
	 */
	public String getMagazineName() {
		return magazineName;
	}// end of getMagazineName method

	/**
	 * This method returns the name of the publisher
	 * @return publisherName
	 */
	public String getPublisherName() {
		return publisherName;
	}// end of getPublisherName method

	/**
	 * This method returns the magazine ID
	 */
	public int getID() {
		return magazineID;
	}// end of getID method

	/**
	 * This method prints the magazine ID to the console
	 */
	public void printID() {
		System.out.print(magazineID);		
	}// end of printID method

	/**
	 * 
	 * @param id
	 */
	public void setMagazineID(int id) {
		magazineID = id;		
	}// end of setMagazineID method

	/**
	 * 
	 * @param name
	 */
	public void setMagazineName(String name) {
		magazineName = name;
	}// end of setMagazineName method

	/**
	 * 
	 * @param name
	 */
	public void setPublisherName(String name) {
		publisherName = name;
	}// end of setPublisherName method
	
	/**
	 * 
	 */
	public String toString(){
		String str = "";
		str += "Magazine ID: " + magazineID;
		str += "\nMagazine Name: " + magazineName;
		str += "\nPublisher Name: " + publisherName;
		return str;
	}// end of toString method

}// end of Magazine class
