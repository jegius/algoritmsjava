package com.company.algoritms.examples.recursion;

import com.company.algoritms.examples.Example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursionExample implements Example {

    @Override
    public void showExample() {
        try {
            recursionShowCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void recursionShowCase() throws IOException {
        System.out.println("Enter a number: ");
        int baseNumber = getInt();
        System.out.println("Triangle=" + triangle(baseNumber));
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
