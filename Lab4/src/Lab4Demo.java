import java.util.Arrays;

public class Lab4Demo {

	public static void main(String[] args) {
	
		
		int[] array1 = {97, 43, 80, 80, 63, 20, 67, 8, 20, 80};
		System.out.println(Arrays.toString(array1));
		calculate_statistics(array1);
		System.out.println("---------------------------------------------");
		
		
		int[] array2 = {11, 45, 27, 55, 11};
		System.out.println(Arrays.toString(array2));
		calculate_statistics(array2);
		System.out.println("---------------------------------------------");
		
		int[] array3 = {44, 44, 44, 81, 53, 53, 53, 44};
		System.out.println(Arrays.toString(array3));
		calculate_statistics(array3);
		System.out.println("---------------------------------------------");
		

	}


	private static void calculate_statistics(int[] array) {
		calculate_mean(array);
		calculate_median(array);
		calculate_mode(array);
		
	}

	//gucci
	private static void calculate_mean(int[] array) {
		//TO DO: Write method that will calculate mean of an integer array
		double average = 0;
		for (int i = 0; i < array.length; i++) {
			average += array[i];
		}
		
		double answer = average / array.length;
		System.out.println("The mean is: " + answer);
	
		
	} 
	
	//gucci2
	private static void calculate_median(int[] array) {
		//TO DO: Write method that will calculate median of an integer array
		
		double median = 0;
		int median2 = 0;
		//sort---apparently affects every instance from this point...ehhh still works
		Arrays.sort(array);

		for (int i = 0; i < array.length; i++) {		
			//if even # of values
			if (array.length % 2.0 == 0) {
				//grab left and right middle values
				int left_i = (int) (array.length / 2.0 - 1);
				int right_i = (int) (array.length / 2.0);
				
				median = (array[left_i] + array[right_i]) / 2.0;
			}
			
			//if odd # of values
			else {
				int index = (int) (array.length / 2.0 + 0.5 - 1); 
				median2 = array[index];
			}
			
		}
		
		if (array.length % 2.0 == 0) {
			System.out.println("The median is: " + median);
		}
		
		else {
			System.out.println("The median is: " + median2);
		}
		
		
	}

	//gucci3
	private static void calculate_mode(int[] array) {
			
			Arrays.sort(array);
			//System.out.println(Arrays.toString(array));
			int count_current = 1;
			int index = 0;
			int count_past = 0;
			
			
			//start at 1 and reach forward for prev value
			for (int i = 1; i < array.length; i++) {
				//System.out.println("Current value: " + array[i]);
			
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
			//System.out.println("Current: " + count_current);	
			//System.out.println("Past: " + count_past);	
			//System.out.println();	
			}
			
			//System.out.println("Final index: " + index);
			
			//there is no : in the screenshot so here i guess
			System.out.println("The mode is " + array[index]);
		}
	
	}