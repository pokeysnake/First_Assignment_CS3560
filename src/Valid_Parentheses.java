import java.util.Stack;


public class Valid_Parentheses {
    public boolean isValid(String s){
        if(s.length() % 2 != 0) return false;                                       //checks if there are an odd amount of characters --> always invalid

        Stack<Character> stack = new Stack<>();                                     //initializes a new stack

        for(char c : s.toCharArray()) {                                             //iterative loop with the string broken into characters
            if (c == '(' || c == '{' || c == '['){                                  //checks for the opening characters (All opening brackets, etc.)
                stack.push(c);                                                      //push those onto stack as they are our openings
            }else if (c == ')' && !stack.isEmpty() && stack.peek() == '('){         //each line checks if the top of stack and current iterating value are equal
                stack.pop();                                                        //if equal, pop from the stack as that is a valid pair
            }else if (c == ']' && !stack.isEmpty() && stack.peek() == '['){         //continue
                stack.pop();
            }else if (c == '}' && !stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            } else {
                return false;                                                       //if reaches this line --> only contains closing brackets
            }
        }

        return stack.isEmpty();                                                     //if the stack is completely empty we know that each opening had a close, thus it is valid
    }
}
