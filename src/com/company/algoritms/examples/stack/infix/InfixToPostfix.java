package com.company.algoritms.examples.stack.infix;

import com.company.algoritms.examples.ShowCase;
import com.company.algoritms.examples.stack.SimpleCharStack;

public class InfixToPostfix implements ShowCase {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char START_PARENTHESIS = '(';
    private static final char END_PARENTHESIS = ')';
    private static final int FIRST_PRIORITY = 1;
    private static final int SECOND_PRIORITY = 2;

    private SimpleCharStack stack;
    private String input;
    private String output;

    public InfixToPostfix(String input) {
        this.input = input;
        this.stack = new SimpleCharStack(input.length());
        this.output = "";
    }

    @Override
    public void doShowCase() {
        System.out.println(doTrans());
    }

    public String doTrans() {
        for (int charIndex = 0; charIndex < input.length(); charIndex++) {
            buildOutput(charIndex);
        }

        while (!stack.isEmpty()) {
            stack.display();
            output = output + stack.pop();
        }
        stack.display();
        return output;
    }

    public void gotOperator(char thisOperator, int firstOperatorPriority) {
        while (!stack.isEmpty()) {
            char topOperator = stack.pop();

            if (topOperator == START_PARENTHESIS) {
                stack.push(topOperator);
                break;
            } else {
                int secondOperatorPriority = topOperator == PLUS || topOperator == MINUS
                        ? FIRST_PRIORITY
                        : SECOND_PRIORITY;

                if (secondOperatorPriority < firstOperatorPriority) {
                    stack.push(topOperator);
                    break;
                } else {
                    output = output + topOperator;
                }
            }
            stack.push(thisOperator);
        }
    }

    private void buildOutput(int charIndex) {
        char selectedChar = input.charAt(charIndex);
        stack.display();

        if (selectedChar == PLUS || selectedChar == MINUS) {
            gotOperator(selectedChar, FIRST_PRIORITY);
        } else if (selectedChar == MULTIPLICATION || selectedChar == DIVISION) {
            gotOperator(selectedChar, SECOND_PRIORITY);
        } else if (selectedChar == START_PARENTHESIS) {
            stack.push(selectedChar);
        } else if (selectedChar == END_PARENTHESIS) {
            gotParent();
        } else {
            output = output + selectedChar;
        }
    }

    public void gotParent() {
        while (!stack.isEmpty()) {
            char operator = stack.pop();

            if (operator == START_PARENTHESIS) {
                break;
            } else {
                output = output + operator;
            }
        }
    }
}