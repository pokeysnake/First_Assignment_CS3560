# Pyramid Rubik Cube Validator

## Description
The program initializes and tests whether or not the pyramid Rubik is set up properly.

- **Color Enum**: Defines 4 colors for the pyramid (Red, Green, Blue, Yellow).
- **Face Class**: Represents a face of the pyramid, each with 9 tiles of a specific color.
- **PyramidRubik Class**: Models the entire pyramid. It assigns colors to faces, ensures correct edge sharing, and validates the cube.
- **Validation**: Ensures:
  1. Each face has 9 tiles.
  2. Each color is used exactly 9 times across all faces.

## How It Works

1. **Initialization**: Each face gets a color (Red, Green, Blue, Yellow).
2. **Edge Sharing**: Adjacent faces share edges with the same color.
3. **Validation**: The cube is valid if:
   - Each face has 9 tiles.
   - Each color appears exactly 9 times.

# Valid Parentheses Checker

## Description
Program tests whether a string has a correct number of opening and corresponding closing brackets. The brackets must be in the proper order and every bracket needs a pair. 

### **How It Works**

- The isValid() method checks if the parentheses are balanced by pushing opening brackets onto a stack and popping them when a matching closing bracket is found.
- If the stack is empty at the end of the string, the parentheses are valid. If not, they are invalid.

### **Test Cases for Valid Parentheses**

#### **Valid Parentheses**
These strings have correctly matched and nested parentheses:
- assertTrue(validator.isValid("()"));
- assertTrue(validator.isValid("{}"));
- assertTrue(validator.isValid("[]"));
- assertTrue(validator.isValid("()[]{}"));
- assertTrue(validator.isValid("{[()]}"))
- assertTrue(validator.isValid("(([]){})"));`

#### **Invalid Parentheses**
These strings have mismatched or incorrectly nested parentheses:
- assertFalse(validator.isValid("(]"));  // Mismatched pair
- assertFalse(validator.isValid("([)]")); // Incorrect nesting
- assertFalse(validator.isValid("{[(])}")); // Nested incorrectly
- assertFalse(validator.isValid("{[}"));  // Unmatched opening
- assertFalse(validator.isValid("({[})]"));  // Mixed incorrect order

#### **Edge Cases**
These tests handle special cases:
- assertTrue(validator.isValid("")); // Empty string is valid
- assertFalse(validator.isValid("(")); // Single character (invalid)
- assertFalse(validator.isValid("({[")); // Unclosed brackets
- assertFalse(validator.isValid("())"));  // Extra closing bracket
- assertFalse(validator.isValid(")")); // Single closing bracket (invalid)
- assertFalse(validator.isValid("}]")); // Single closing bracket (invalid)
- assertFalse(validator.isValid(")))"));  // Multiple closing brackets
- assertFalse(validator.isValid("}}]]"));  // Multiple closing brackets




