
import java.util.Stack;

public class Lab10Demo {


	public static String fix_string(String s) {
		//TO DO: Use recursion to solve this problem
		
		//base case
		if (s.length() == 0) {
			return s;
		}
		//recursive case
		else {
			
			char a = s.charAt(0);
			if (a == 'a') {
				 return "t" + fix_string(s.substring(1));
			}
			else if (a == 'g') {
				 return "c" + fix_string(s.substring(1));
			}	
			else if (a == 't') {
				 return "a" + fix_string(s.substring(1));
			}
			else {
				return "g" + fix_string(s.substring(1));
			}		
		}
	}
	
	public static void print_stack_reverse_recursive(Stack<String> stack) {
		//TO DO: Use recursion to solve this problem
		
		//base case
		if (stack.size() == 0) {
			return;
		}
		//recursive case
		String element = stack.get(0); //find first entered
		stack.remove(0); //remove it
		
		//sort element
		System.out.println("Original String: " + element);
		System.out.println("Fixed String: " + fix_string(element));
		System.out.println("--------------------------");
		
		print_stack_reverse_recursive(stack);
		
	}
	
	//You should NOT change anything below this comment
	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>();
		
		stack.push("ctgtcctt");
		stack.push("agtgccct");
		stack.push("taacgcgg");
		stack.push("ccctcagt");
		stack.push("ggataata");
		stack.push("gtgaatgc");
			
		System.out.println("Printing out the stack in reverse order:");
		System.out.println();
		print_stack_reverse_recursive(stack);
	}

}

