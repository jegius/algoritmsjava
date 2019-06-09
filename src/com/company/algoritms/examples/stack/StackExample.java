package com.company.algoritms.examples.stack;

import com.company.algoritms.examples.Example;

public class StackExample implements Example {
    private static final int MAX_LENGTH = 10;

    public void showExample() {
        SimpleStack simpleStack = new SimpleStack(MAX_LENGTH);
        simpleStack.insert(1);
        simpleStack.insert(2);
        simpleStack.insert(3);
        simpleStack.insert(4);

        while (!simpleStack.isEmpty()) {
            long value = simpleStack.pop();
            System.out.println(value);
        }
    }
}
