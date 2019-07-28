package com.company.algoritms.examples.recursion;

import com.company.algoritms.examples.Example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RecursionExample implements Example {

    private RecursionMode mode = RecursionMode.ANAGRAM;
    private int anagramSize;
    private int anagramCounter;
    private char[] anagramCharByInput = new char[100];

    @Override
    public void showExample() {

        if (mode == RecursionMode.BASE_RECURSION) {
            try {
                recursionShowCase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (mode == RecursionMode.ANAGRAM) {
            try {
                anagramShowCase();
            } catch (IOException e) {
                e.printStackTrace();
            }
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

        for (newPosition = currentPosition + 1; newPosition < anagramSize; newPosition++){
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
