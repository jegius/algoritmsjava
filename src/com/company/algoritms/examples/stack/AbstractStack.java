package com.company.algoritms.examples.stack;

public abstract class AbstractStack<T> {

    abstract T getPeek(int elementIndex);
    abstract int size();

    public void display(String startText) {
        System.out.print(startText);
        System.out.print("Stack (bottom => top): ");
        for (int charIndex = 0; charIndex < size(); charIndex++) {
            System.out.print(getPeek(charIndex));
            System.out.print(' ');
        }
        System.out.println();
    }
}
