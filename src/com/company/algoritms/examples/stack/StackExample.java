package com.company.algoritms.examples.stack;

import com.company.algoritms.enums.ShowCaseType;
import com.company.algoritms.examples.Example;
import com.company.algoritms.examples.ShowCase;
import com.company.algoritms.examples.ShowCaseFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.company.algoritms.Constants.EXIT_SYMBOL;
import static com.company.algoritms.Constants.INFINITE_LOOP;

public class StackExample implements Example {
    private static final int MAX_LENGTH = 10;
    private static final ShowCaseFactory showCaseFactory  = new ShowCaseFactory();

    /**
     * Сложность добавления и извлечения элементов
     * стека O(1)
     * */
    public void showExample() {
//        stackBaseExample();
//        checkBracketChecker();
//        infixShowCase();
        parseInfixShowCase();
    }

    private void infixShowCase() {
        executeConsoleEnter(ShowCaseType.INFIX_CONVERTER);
    }

    private void parseInfixShowCase() {
        executeConsoleEnter(ShowCaseType.INFIX_PARSER);
    }

    private void checkBracketChecker() {
        executeConsoleEnter(ShowCaseType.BRACKETS_CHECKER);
    }

    private void executeConsoleEnter(ShowCaseType type) {
        String input;

        while (INFINITE_LOOP) {
            System.out.println("Enter the data: ");
            input = getString();

            if (input.equals(EXIT_SYMBOL)) {
                break;
            }

            ShowCase bracketChecker = showCaseFactory.createShowCase(type, input);
            bracketChecker.doShowCase();
        }
    }

    private static String getString(){
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            return bufferedReader.readLine();

        } catch (IOException exception) {
            System.out.println(exception);
            return  null;
        }
    }

    private void stackBaseExample() {
        SimpleStack simpleStack = new SimpleStack(MAX_LENGTH);
        simpleStack.insert(1L);
        simpleStack.insert(2L);
        simpleStack.insert(3L);
        simpleStack.insert(4L);

        while (!simpleStack.isEmpty()) {
            long value = simpleStack.pop();
            System.out.println(value);
        }
    }
}
