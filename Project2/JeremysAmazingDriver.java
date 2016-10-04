package Project2;

import java.util.Scanner;

/** 
 * @author Jeremy Pierce
 * @version 0.0.0
 * Description: This is the driver class to demonstrate the linked list
 * Class: SE 3345.003 Data Structures and Algorithms
 * Project 2: JeremysAmazingDriver class
 * Date: 9/20/2016
 */
public class JeremysAmazingDriver {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Magazine magazine;
		DoublyLinkedList<Magazine> myList = new DoublyLinkedList<Magazine>();
		boolean badInput = true;// always set badInput back to true so it will be ready to test the next input
		int ID;
		
		System.out.println("\n**********\nGreetings!\n**********");
		
		while(true){
			
			System.out.print("\n**************************" + 
								"\nWhat would you like to do?" +
								"\n**************************" +
								"\n1) Make Empty\n2) Find ID\n3) Insert At Front" +
								"\n4) Delete From Front\n5) Delete ID" +
								"\n6) Print All Records\n7) Done" +
								"\n**************************" +
								"\nPlease Make A Selection: ");
			
			switch(input.nextLine()){
			case "1":
				System.out.println("\n***********\nMake Empty:\n***********");
				myList.makeEmpty();
				System.out.println("\n******************\nList is now Empty:\n******************");
				break;
			case "2":
				System.out.print("\n********\nFind ID:\n********");
				while(badInput){
					System.out.print("\nPlease Enter the ID you would like to find: ");
					if(input.hasNextInt()){
						if((magazine = myList.findID(input.nextInt())) != null){
							System.out.println("\n******************");
							System.out.println(magazine);
							System.out.println("\n******************");
						}else
							System.out.println("\nI'm Sorry. That ID is not in our records.");
						
						input.nextLine();// This clears the keyboard buffer
						break;
					}else
						System.out.println("I'm sorry you have entered invalid input.\nPlease try again.");
						input.nextLine();
				}// end of badInput while loop
				break;
			case "3":
				magazine = new Magazine();
				System.out.print("\n*****************\nInsert At Front:\n*****************");
				do{// this loop is to catch duplicate ID numbers
				while(badInput){
					System.out.print("\nEnter Magazine ID: ");
					if(input.hasNextInt()){
						magazine.setMagazineID(input.nextInt());
						input.nextLine();// This clears the keyboard buffer
						badInput = false;
					}else{
						System.out.println("I'm sorry you have entered invalid input.\nPlease try again.");
						input.nextLine();// This clears the keyboard buffer
					}					
				}// end of badInput while loop
				badInput = true;// always set badInput back to true so it will be ready to test the next input
				System.out.print("Enter Magazine Name: ");
				magazine.setMagazineName(input.nextLine());
				
				System.out.print("Enter Publisher Name: ");
				magazine.setPublisherName(input.nextLine());
				
				}while(!myList.insertAtFront(magazine));// end of do while loop
				break;
			case "4":
				System.out.println("\n*****************\nDelete From Front\n*****************");
				if((magazine = myList.deleteFromFront()) != null){
					System.out.println("\n****\nLink\n****");
					System.out.println(magazine);
					System.out.println("\n***************\nHas Been Deleted");
				}
				break;
			case "5":
				System.out.println("\n*********\nDelete ID\n*********");
				while(badInput){
					System.out.print("\nPlease Enter the ID you would like to delete: ");
					if(input.hasNextInt()){
						ID = input.nextInt();
						if((magazine = myList.delete(ID)) != null){
							System.out.println("\n****\nLink\n****");
							System.out.println(magazine);
							System.out.println("\n***************\nHas Been Deleted");
						}else
							System.out.println("\nI'm Sorry. That ID is not in our records.");
						input.nextLine();
						badInput = false;
					}else{
						System.out.println("I'm sorry you have entered invalid input.\nPlease try again.");
						input.nextLine();// This clears the keyboard buffer
					}
				}// end of badInput while loop
				badInput = true;// always set badInput back to true so it will be ready to test the next input
				break;
			case "6":
				System.out.println("\n*****************\nPrint All Records\n*****************");
				myList.printAllRecords();
				break;
			case "7":
				System.out.println("\n*******************************\nHave A Wonderful Day! Good-Bye!\n*******************************");
				System.exit(0);
			case "8":
				System.out.print("ID to Swap:");
				myList.swapAdjacent(input.nextInt());
				default:
					System.out.println("I'm sorry you have entered invalid input.\nPlease try again.");
			}// end of switch
			
		}// end of main while loop
		
	}// end of main method

}// end of JeremysAmazingDriver class
