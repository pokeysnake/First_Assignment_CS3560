import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Valid_ParenthesesTest {

    Valid_Parentheses validator = new Valid_Parentheses();  // Create an instance of the class

    @Test
    void testValidParentheses() {
        assertTrue(validator.isValid("()"));
        assertTrue(validator.isValid("{}"));
        assertTrue(validator.isValid("[]"));
        assertTrue(validator.isValid("()[]{}"));
        assertTrue(validator.isValid("{[()]}"));
        assertTrue(validator.isValid("(([]){})"));
    }

    @Test
    void testInvalidParentheses() {
        assertFalse(validator.isValid("(]"));  // Mismatched pair
        assertFalse(validator.isValid("([)]")); // Incorrect nesting
        assertFalse(validator.isValid("{[(])}")); // Nested incorrectly
        assertFalse(validator.isValid("{[}"));  // Unmatched opening
        assertFalse(validator.isValid("({[})]"));  // Mixed incorrect order
    }

    @Test
    void testEmptyString() {
        assertTrue(validator.isValid("")); // Weird case: Empty string should be valid
    }

    @Test
    void testOddNumberOfCharacters() {
        assertFalse(validator.isValid("("));  // Single character (invalid)
        assertFalse(validator.isValid("({["));  // Unclosed brackets
        assertFalse(validator.isValid("())"));  // Extra closing bracket
    }

    @Test
    void testOnlyClosingBrackets() {
        assertFalse(validator.isValid(")"));
        assertFalse(validator.isValid("}]"));
        assertFalse(validator.isValid(")))"));
        assertFalse(validator.isValid("}}]]"));
    }

}