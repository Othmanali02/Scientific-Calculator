package application;

import java.util.Scanner;
import java.util.*;

public class Chauffeur {
	public static void main(String[] args) {

		System.out.println(infixToPostfix("( 2.24 + 4 ) - 2 / ( 8 / 2 )"));
		

	}
	
	public static String infixToPostfix(String infix) {
		String post = "";
		System.out.println(infix);
		CursorStack<String> stack = new CursorStack<String>();
		String [] split = infix.split(" ");
		
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
			if (isNumeric(split[i])) {// checks whether it is a number and adds it to the result
				post += split[i];
			} else if (split[i].equals("(")) {// pushes '(' to the stack
				stack.push(split[i]);
			} else if (split[i].equals(")")) {// if it is a ')' append to the output until '(' is spotted or stack is
				// empty
				while (!stack.isEmpty() && stack.peek() != "(") {
					post += stack.pop();// adds the
				}
				stack.pop();
			} else {// this checks for the order of the operation
				while (!stack.isEmpty() && Precedence(split[i]) <= Precedence(stack.peek())) {
					post += stack.pop();// appends the operator to the result statement
				}
				stack.push(split[i]);// adds the operator to the stack
			}
		}
 
		while (!stack.isEmpty()) {
			if (stack.peek() == "(" || stack.peek() == ")")
				return null;
			post += stack.pop();// appends whatever operator is left in the stack
		} // as long as the stack is empty and no ( is encountered

		return post.replaceAll("[()]", "");
	}

	static int Precedence(String ch) {
		switch (ch) {
		case "+":
			return 1;
		case "-":
			return 1;
		case "*":
			return 2;
		case "/":
			return 2;
		case "^":
			return 3;
		case "√":
			return 3;
		default:
			return -1;
		}
	}

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
