package com.company.algoritms.examples.stack;

import com.company.algoritms.enums.BracketsType;
import com.company.algoritms.examples.ShowCase;

public class BracketChecker implements ShowCase {
    private String input;

    public BracketChecker(String input) {
        this.input = input;
    }

    @Override
    public void doShowCase() {
        int stackSize = input.length();
        SimpleCharStack stack = new SimpleCharStack(stackSize);

        for (int elementIndex = 0; elementIndex < stackSize; elementIndex++) {
            char currentChar = input.charAt(elementIndex);

            if (checkBracketStart(currentChar)) {
                stack.push(currentChar);
            } else if (checkBracketEnd(currentChar)) {
                popAndCheck(stack, currentChar);
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }

    private boolean checkBracketStart(char inputChar) {
        return BracketsType.START_BRACE.getAsChar() == inputChar ||
                BracketsType.START_PARENTHESIS.getAsChar() == inputChar ||
                BracketsType.START_SQUARE.getAsChar() == inputChar;
    }

    private boolean checkBracketEnd(char inputChar) {
        return BracketsType.END_BRACE.getAsChar() == inputChar ||
                BracketsType.END_PARENTHESIS.getAsChar() == inputChar ||
                BracketsType.END_SQUARE.getAsChar() == inputChar;
    }

    private void popAndCheck(SimpleCharStack stack, char currentChar) {
        if (!stack.isEmpty()) {
            char executedChar = stack.pop();

            if (checkSequence(currentChar, executedChar)) {
                System.out.println("Error: " + currentChar + " at " + executedChar);
            } else {
                System.out.println("No elements on array.");
            }
        }
    }

    private boolean checkSequence(char currentValue, char executedValue) {
        return (
                BracketsType.END_BRACE.getAsChar() == currentValue &&
                        BracketsType.START_BRACE.getAsChar() != executedValue
        ) || (
                BracketsType.END_SQUARE.getAsChar() == currentValue &&
                        BracketsType.START_SQUARE.getAsChar() != executedValue
        ) || (
                BracketsType.END_PARENTHESIS.getAsChar() == currentValue &&
                        BracketsType.START_PARENTHESIS.getAsChar() == executedValue
        );
    }


}
