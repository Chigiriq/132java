package test;

import java.util.Arrays;

public class arrayTest {
	public static void main(String[] args) {
		int[] array3 = {44, 44, 44, 81, 53, 53, 53, 44};
//		System.out.println(Arrays.toString(array3));
		
		calculate_mode(array3);
		
		System.out.println("---------------------------------------------");
		
		
	}
	
	private static void calculate_mode(int[] array) {
		
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		int count_current = 1;
		int index = 0;
		int count_past = 0;
		
		
		//start at 1 and reach forward for prev value
		for (int i = 1; i < array.length; i++) {
			System.out.println("Current value: " + array[i]);
		
			//find first duplicates
			if (array[i] == array[i-1]) {
				count_current += 1;
				
				
			}
			
			//next num is not duplicate
			else {
				
				//current is larger
				if (count_current > count_past) {
					count_past = count_current;
					count_current = 1;
					index = i-1;
				}	
			}
		System.out.println("Current: " + count_current);	
		System.out.println("Past: " + count_past);	
		System.out.println();	
		}
		
		System.out.println("Final index: " + index);
	}
}
