package Project1;

import java.util.ArrayList;
import java.util.Scanner;
/** 
 * @author Jeremy Pierce
 * @version 0.0.0
 * Description: This program will make an arraylist of integers from 2 up to
 * 				a number n that is provided by the user input. Then all the
 * 				integers that are multiples of any prime will be removed from the list.
 * Class: SE 3345.003 Data Structures and Algorithms
 * Project 1: PrimeFinder Class
 * Date: 9/5/2016
 */
public class PrimeFinder {
	public static ArrayList<Integer> primes = new ArrayList<>();
	public static Scanner input = new Scanner(System.in);
	public static boolean continueCheck = true;
	public static boolean badInput = true;
	public static int number;

	public static void main(String[] args){

		while(true){// main while loop

			System.out.println("\n\nHello And Welcome To The Prime Finder!"+
					"\nWe Are Going To Find All The Prime Numbers"+
					"\nFrom 2 Through The Number You Provide!");
			do{

				System.out.print("\nPlease Enter A Number For The Limit: ");
				if(input.hasNextInt()){
					badInput = false;
					number = input.nextInt();
					getPrimes(number);
				}else{
					System.out.println("I'm sorry but the input you entered is not valid.");
				}
				input.nextLine();
			}while(badInput);
			badInput = true;
			
			System.out.println("\nHere are all the prime numbers from 2 through " + number);
			System.out.println(primes.toString());

			do{
				System.out.print("\nWould you like to continue? Y/N: ");
				switch(input.nextLine()){
				case "Y":
				case "y":
					continueCheck = false;
					break;
				case "N":
				case "n":
					System.out.println("Thank you! Have A Wonderful Day!\nGood-Bye!");
					System.exit(0);
				default:
					System.out.println("Invalid Input.");
				}
			}while(continueCheck);
			continueCheck = true;

		}// end of main while loop

	}// end of main method


	/**
	 * This method creates an ArrayList and then fills the list with integers
	 * 		from 2 through the number given by the user. Then all the integers
	 *		that are multiples of any prime will be removed from the list 
	 * @param num
	 */
	public static void getPrimes(int num){
		//This for loop sets up the list of integers from 2 - num
		for(int i = 2; i <= num; i++){
			primes.add(i);			
		}// end of first for loop

		//This nested for loop removes all the integers that are multiples of primes
		for(int i = 0; i <= Math.sqrt(num); i++){
			for(int j = i+1; j < primes.size(); j++){
				if(primes.get(j)%primes.get(i)==0) primes.remove(j);
			}// end of inner for loop
		}// end of outer for loop

	}// end of getPrimes method

}// end of PrimeFinder class
