package Project6;

import java.util.Random;

public class QuickSortDriver {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		int[] array1, array2, array3, array4, array5;
		array1 = new int[1000];
		array2 = new int[5000];
		array3 = new int[10000];
		array4 = new int[50000];
		array5 = new int[100000];
		
		for(int i = 0; i < array5.length; i++){
			if(i<array1.length){
				array1[i] = random.nextInt();
			}
			
			if(i<array2.length){
				array2[i] = random.nextInt();
			}
			
			if(i < array3.length){
				array3[i] = random.nextInt();
			}
			
			if(i < array4.length){
				array4[i] = random.nextInt();
			}
			
			array5[i] = random.nextInt();
		}// end of for loop the fill the arrays with random numbers
		
		for(int i = 0; i < 20; i++){
			System.out.printf("Array 1 index %2d = %11d\n", i, array1[i]);
			System.out.printf("Array 2 index %2d = %11d\n", i, array2[i]);
			System.out.printf("Array 3 index %2d = %11d\n", i, array3[i]);
			System.out.printf("Array 4 index %2d = %11d\n", i, array4[i]);
			System.out.printf("Array 5 index %2d = %11d\n", i, array5[i]);
		}
		
		System.out.println(array1[999]);
		
	}// end of main

}
