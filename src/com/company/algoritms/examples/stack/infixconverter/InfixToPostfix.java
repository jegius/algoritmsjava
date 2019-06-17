package com.company.algoritms.examples.stack.infixconverter;

import com.company.algoritms.examples.ShowCase;
import com.company.algoritms.examples.stack.SimpleCharStack;

import static com.company.algoritms.examples.stack.Constants.*;

public class InfixToPostfix implements ShowCase {
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
        System.out.println("Postfix is: " + doTrans());
    }

    public String doTrans() {
        for (int charIndex = 0; charIndex < input.length(); charIndex++) {
            buildOutput(charIndex);
        }

        while (!stack.isEmpty()) {
            stack.display("While ");
            output = output + stack.pop();
        }
        stack.display("End ");
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
        }
        stack.push(thisOperator);
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

    private void buildOutput(int charIndex) {
        char selectedChar = input.charAt(charIndex);
        stack.display("For " + selectedChar + " ");

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
}
