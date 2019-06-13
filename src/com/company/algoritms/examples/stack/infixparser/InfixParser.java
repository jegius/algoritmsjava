package com.company.algoritms.examples.stack.infixparser;

import com.company.algoritms.examples.ShowCase;
import com.company.algoritms.examples.stack.SimpleStack;

import static com.company.algoritms.examples.stack.Constants.*;

public class InfixParser implements ShowCase {
    private static final int MAX_STACK_SIZE = 20;

    private SimpleStack stack;
    private String input;

    public InfixParser(String input) {
        this.input = input;
    }

    @Override
    public void doShowCase() {
        System.out.println("Evaluates to " + doParse());
    }

    private long doParse() {
        this.stack = new SimpleStack(MAX_STACK_SIZE);
        char elementAsChar;
        int elementIndex;

        for (elementIndex = 0; elementIndex < input.length(); elementIndex++) {
            elementAsChar = input.charAt(elementIndex);
            stack.display(elementAsChar + " ");

            if (elementAsChar >= '0' && elementAsChar <= '9') {
                stack.push(elementAsChar - '0');
            } else {
                calculateData(elementAsChar);
            }
        }
        return stack.pop();
    }

    private void calculateData(char currentChar) {
        long secondNumber = stack.pop();
        long firstNumber = stack.pop();
        long result;

        if (currentChar == PLUS) {
            result = firstNumber + secondNumber;
        } else if (currentChar == MINUS) {
            result = firstNumber - secondNumber;
        } else if (currentChar == MULTIPLICATION) {
            result = firstNumber * secondNumber;
        } else if (currentChar == DIVISION) {
            result = firstNumber / secondNumber;
        } else {
            result = 0;
        }

        stack.push(result);
    }
}
