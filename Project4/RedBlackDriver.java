package Project4;

import java.util.Scanner;

/** 
 * @author 		Jeremy Pierce
 * Class: 		SE 3345.003 Data Structures
 * Section:		003
 * Semester:	Fall 2016
 * Project 3: 	RedBlackDriver class
 * Description: This is the driver class to demonstrate the Red Black Tree
 * Date: 		10/19/2016
 */
public class RedBlackDriver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		RedBlackTree tree = new RedBlackTree();
		int ID;
		
		System.out.println("\n**********\nGreetings!\n**********");
		
		while(true){// main while loop
			
			System.out.print("\n\n\n**************************" + 
								"\nWhat would you like to do?" +
								"\n**************************" +
								"\n1) Insert\n2) Contains\n3) Print Tree" +
								"\n4) Exit" +
								"\n**************************" +
								"\nPlease Make A Selection: ");
			switch(input.nextLine()){
			case "1":
				while(true){
					System.out.println("\n\n**********\n* INSERT *\n**********");
					System.out.println("\n\n***********************************");
					System.out.print("Enter a number you wish to insert: ");
					if(input.hasNextInt()){
							tree.insert(ID = input.nextInt());
							input.nextLine();
							System.out.println("\n\n\n**************************");
							System.out.println(ID + " was added to the tree.");
							System.out.println("**************************");
							break;
					}
				}
				break;
			case "2":
					System.out.println("\n\n************\n* CONTAINS *\n************");
					System.out.println("\n\n************************************************");
					System.out.print("Enter the key of the node you wish to look for: ");
					if(input.hasNextInt()){
						if(tree.contains(ID = input.nextInt())){
							System.out.println("\n\n\n**********************");
							System.out.println("Yes " + ID + " is in the tree!");
							System.out.println("**********************");
						}else{
							System.out.println("\n\n\n************************");
							System.out.println("No " + ID + " is not in the tree!");
							System.out.println("************************");
						}
					}
					input.nextLine();
				break;
			case "3":
				System.out.println("\n\n**************\n* PRINT TREE *\n**************");
				tree.printTree();
				break;
			case "4":
				System.out.println("***************************");
				System.out.println("Have a great day! Good-Bye!");
				System.out.println("***************************");
				System.exit(0);
				break;
				default:
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("\n\n\n*************");
					System.out.println("Invalid Input");
					System.out.println("*************");
			}// end of switch
			
		}// end of main while loop

	}// end of main method

}// end of BinaryTreeDriver class
