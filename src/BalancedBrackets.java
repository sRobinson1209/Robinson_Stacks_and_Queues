
import java.util.LinkedList;
public class BalancedBrackets {
    public static void main(String[] args) {
        // Sample input strings
        String input1 = "(){}[]";
        String input2 = "{[()]()}";
        String input3 = "([)]";
        String input4 = "";

        // Create an instance of BalancedBrackets
        BalancedBrackets balancedBrackets = new BalancedBrackets();

        // Test each input string for balanced brackets
        System.out.println( input1 +  balancedBrackets.isBalanced(input1));
        System.out.println( input2 +  balancedBrackets.isBalanced(input2));
        System.out.println( input3 + balancedBrackets.isBalanced(input3));
        System.out.println( input4 + balancedBrackets.isBalanced(input4));
    }
        public boolean isBalanced(String s) {
            //Create stack to store brackets
            //Stack<Character> st = new Stack<>();
            LinkedList<Character> ll = new LinkedList<>();

            // If the input string is null or empty, it's considered valid
            if (s == null || s.length() == 0) return true;

            // Iterate through each character in the input string
            for (int i = 0; i < s.length(); i++) {
                // If the current character is a closing parenthesis then check if the stack is not empty
                //and the top of the stack is an open parenthesis then pop that from stack.
                if (s.charAt(i) == ')') {
                    if (!ll.isEmpty() && ll.peek() == '(') {
                        ll.pop();
                    } else {
                        // If the stack is empty or the top is not a matching open parenthesis, the string is invalid
                        return false;
                    }
                }
                // For curly bracket
                else if (s.charAt(i) == '}') {
                    if (!ll.isEmpty() && ll.peek() == '{') {
                        ll.pop();
                    } else {
                        return false;
                    }
                }
                // For square bracket
                else if (s.charAt(i) == ']') {
                    if (!ll.isEmpty() && ll.peek() == '[') {
                        ll.pop();
                    } else {
                        return false;
                    }
                }
                // If the current character is an open parenthesis, curly brace, or square bracket
                else {
                    // Push it onto the stack
                    ll.push(s.charAt(i));
                }
            }
            // After iterating all brackets, if the stack is empty, the string is valid
            if (ll.isEmpty()) {
                return true;
            } else {
                // If there are unmatched open symbols left in the stack, the string is invalid
                return false;
            }
        }
    }
