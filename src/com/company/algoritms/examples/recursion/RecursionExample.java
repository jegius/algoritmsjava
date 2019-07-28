package com.company.algoritms.examples.recursion;

import com.company.algoritms.AlgorithmUtils;
import com.company.algoritms.examples.Example;
import com.company.algoritms.examples.array.SimpleArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursionExample implements Example {

    private RecursionMode mode = RecursionMode.MERGE_SORT;
    private int anagramSize;
    private int anagramCounter;
    private char[] anagramCharByInput = new char[100];
    private static final int MAX_LENGTH = 10;
    private static final int DISK_QUANTITY = 3;

    @Override
    public void showExample() {

        try {
            switch (mode) {
                case BASE_RECURSION:
                    recursionShowCase();
                    break;
                case TOWERS:
                    doTowers(DISK_QUANTITY,  'A', 'B', 'C');
                    break;
                case ANAGRAM:
                    anagramShowCase();
                    break;
                case MERGE_SORT:
                    mergeSortShowCase();
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mergeSortShowCase() {
        SimpleArray demo = new SimpleArray(MAX_LENGTH);
        AlgorithmUtils.fillCollectionWithRandomNumbers(demo, MAX_LENGTH);

        demo.display();
        System.out.println("============================");
        demo.mergeSort();
        demo.display();
    }

    private void doTowers(int towerSize, char from, char inter, char to) {
        if (towerSize == 1) {
            System.out.println("Disk 1 from " + from + "  to " + to);
        } else {
            doTowers(towerSize - 1, from, to, inter);
            System.out.println("Disk " + towerSize + " from " + from + " to " + to);
            doTowers(towerSize - 1, inter, from, to);
        }
    }

    private void recursionShowCase() throws IOException {
        System.out.println("Enter a number: ");
        int baseNumber = getInt();
        System.out.println("Triangle=" + triangle(baseNumber));
    }

    private void anagramShowCase() throws IOException {

        System.out.println("Enter a word: ");
        String input = getString();
        anagramSize = input.length();
        anagramCounter = 0;

        for (int charIndex = 0; charIndex < anagramSize; charIndex++) {
            anagramCharByInput[charIndex] = input.charAt(charIndex);
        }
        doAnagram(anagramSize);
    }

    private void doAnagram(int newSize) {
        if (newSize == 1) {
            return;
        }

        for (int cycleCounter = 0; cycleCounter < newSize; cycleCounter++) {
            doAnagram(newSize - 1);

            if (newSize == 2) {
                displayWord();
            }

            rotate(newSize);
        }
    }

    private void rotate(int newSize) {
        int newPosition;
        int currentPosition = anagramSize - newSize;
        char tempChar = anagramCharByInput[currentPosition];

        for (newPosition = currentPosition + 1; newPosition < anagramSize; newPosition++) {
            anagramCharByInput[newPosition - 1] = anagramCharByInput[newPosition];
        }
        anagramCharByInput[newPosition - 1] = tempChar;
    }

    private void displayWord() {
        if (anagramCounter < 99) {
            System.out.print(" ");
        }
        if (anagramCounter < 9) {
            System.out.print(" ");
        }
        System.out.print(++anagramCounter + " ");

        for (int charIndex = 0; charIndex < anagramSize; charIndex++) {
            System.out.print(anagramCharByInput[charIndex]);
        }
        System.out.print("  ");
        System.out.println();

        if (anagramCounter % 6 == 0) {
            System.out.println();
        }
    }

    private static int triangle(int number) {
        return number == 1
                ? 1
                : number + triangle(number - 1);
    }

    private static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        return bufferedReader.readLine();
    }

    private static int getInt() throws IOException {
        return Integer.parseInt(getString());
    }
}
