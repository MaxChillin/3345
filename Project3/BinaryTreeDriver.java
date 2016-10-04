package Project3;

import java.util.Scanner;

import Project2.DoublyLinkedList;
import Project2.Magazine;

/** 
 * @author 		Jeremy Pierce
 * Class: 		SE 3345.003 Data Structures
 * Section:		003
 * Semester:	Fall 2016
 * Project 3: 	BinaryTreeDriver class
 * Description: This is the driver class to demonstrate the linked list
 * Date: 		10/3/2016
 */
public class BinaryTreeDriver {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		BinarySearchTree bt = new BinarySearchTree();
		boolean badInput = true;// always set badInput back to true so it will be ready to test the next input
		int ID;
		
		System.out.println("\n**********\nGreetings!\n**********");
		
		while(true){// main while loop
			
			System.out.print("\n**************************" + 
								"\nWhat would you like to do?" +
								"\n**************************" +
								"\n1) Insert\n2) Delete\n3) Find Max" +
								"\n4) Find Min\n5) Contains" +
								"\n6) In Order Tree Traversal\n7) Height" +
								"\n8) Number of Nodes\n9) Exit" +
								"\n**************************" +
								"\nPlease Make A Selection: ");
			switch(input.nextLine()){
			case "1":
				while(true){
					System.out.print("Enter a number between 1 and 99: ");
					if(input.hasNextInt()){
						if(0 < input.nextInt() && input.nextInt() < 100){
							bt.insert(input.nextInt());
							input.nextLine();
							break;
						}
					}
				}
				break;
			case "2":
				bt.delete(4);
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				break;
			case "6":
				break;
			case "7":
				break;
			case "8":
				break;
			case "9":
				break;
				default:
			}// end of switch
			
		}// end of main while loop

	}// end of main method

}// end of BinaryTreeDriver class
