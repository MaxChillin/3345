package Project5;

import java.util.Scanner;


/** 
 * @author 		Jeremy Pierce
 * Class: 		SE 3345.003 Data Structures
 * Section:		003
 * Semester:	Fall 2016
 * Project 3: 	HeapDriver class
 * Description: This is the driver class to demonstrate the Binary Min Heap
 * Date: 		11/9/2016
 */
public class HeapDriver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BinaryMinHeap heap = new BinaryMinHeap();
		Event event = null;

		System.out.println("\n**************");
		System.out.println("* Greetings! *");
		System.out.println("**************");

		while(true){// main while loop
			event = null;

			System.out.println("Event = " + event);
			System.out.print("\n\n**************************" + 
					"\nWhat would you like to do?" +
					"\n**************************" +
					"\n1) Add Event\n2) Insert\n3) Print Array" +
					"\n4) Build Heap\n5) Delete Min\n6) Quit" +
					"\n**************************" +
					"\nPlease Make A Selection: ");
			switch(input.nextLine()){
			case "1":
				if(heap.isHeaped()){
					System.out.println("\n\n***************************************");
					System.out.println("The 'add' method can only be used");
					System.out.println("before the heap is built.");
					System.out.println("Please use the 'insert' method instead.");
					System.out.println("***************************************");
					break;
				}
				do{
					System.out.println("\n\n**************************" +
							"\nWhat type of event would" +
							"\nyou like to add?" +
							"\n**************************" +
							"\n1) Arrival\n2) End of Service\n3) Termination" +
							"\n**************************" +
							"\nPlease Make A Selection: ");
					switch(input.nextLine()){
					case "1":
						event = new Arrival();
						while(true){
							System.out.println("\n*************************************");
							System.out.print("Please enter the time of the event: ");
							if(input.hasNextDouble()){
								event.setTime(input.nextDouble());
								break;
							}
						}
						break;
					case "2":
						event = new EndOfService();
						while(true){
							System.out.println("\n*************************************");
							System.out.print("Please enter the time of the event: ");
							if(input.hasNextDouble()){
								event.setTime(input.nextDouble());
								break;
							}
						}
						break;
					case "3":
						event = new Termination();
						while(true){
							System.out.println("\n*************************************");
							System.out.print("Please enter the time of the event: ");
							if(input.hasNextDouble()){
								event.setTime(input.nextDouble());
								break;
							}
						}
						break;
					default:
						System.out.println("\n\n**************");
						System.out.println("Invalid Input!");
						System.out.println("**************");
					}// end of event type switch

				}while(event == null);// Event type do while loop
				
				input.nextLine();// this clears the key buffer

				System.out.println("\n\n***************");
				System.out.println("* Event Added *");
				System.out.println("***************");
				heap.add(event);
				break;
			case "2":
				if(!heap.isHeaped()){
					System.out.println("\n\n*************************************");
					System.out.println("The 'insert' method can only be used");
					System.out.println("after the heap is built.");
					System.out.println("Please use the 'add' method instead.");
					System.out.println("*************************************");
					break;
				}
				do{
					System.out.println("\n\n************************" +
							"\nWhat type of event would" +
							"\nyou like to add?" +
							"\n************************" +
							"\n1) Arrival\n2) End of Service\n3) Termination" +
							"\n**************************" +
							"\nPlease Make A Selection: ");
					switch(input.nextLine()){
					case "1":
						event = new Arrival();
						while(true){
							System.out.println("\n*************************************");
							System.out.print("Please enter the time of the event: ");
							if(input.hasNextDouble()){
								event.setTime(input.nextDouble());
								break;
							}
						}
						break;
					case "2":
						event = new EndOfService();
						while(true){
							System.out.println("\n*************************************");
							System.out.print("Please enter the time of the event: ");
							if(input.hasNextDouble()){
								event.setTime(input.nextDouble());
								break;
							}
						}
						break;
					case "3":
						event = new Termination();
						while(true){
							System.out.println("\n*************************************");
							System.out.print("Please enter the time of the event: ");
							if(input.hasNextDouble()){
								event.setTime(input.nextDouble());
								break;
							}
						}
						break;
					default:
						System.out.println("\n\n**************");
						System.out.println("Invalid Input!");
						System.out.println("**************");
					}// end of event type switch

				}while(event == null);// Event type do while loop

				input.nextLine();// this clears the key buffer

				System.out.println("\n\n******************");
				System.out.println("* Event Inserted *");
				System.out.println("******************");
				heap.insert(event);
				break;
			case "3":
				System.out.println("\n\n***************");
				System.out.println("* Print Array *");
				System.out.println("***************");
				heap.printArray();
				break;
			case "4":
				System.out.println("\n\n**************");
				System.out.println("* Build Heap *");
				System.out.println("**************");
				heap.buildHeap();
				break;
			case "5":
				System.out.println("\n\n**************");
				System.out.println("* Delete Min *");
				System.out.println("**************");
				System.out.println("\n\n******************************");
				System.out.println(heap.deleteMin());
				System.out.println("has been deleted from the heap");
				System.out.println("******************************");
				break;
			case "6":
				System.out.println("\n\n********");
				System.out.println("* Quit *");
				System.out.println("********");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Input!");
			}// end of switch

		}// end of main while loop

	}// end of HeapDriver class

}
