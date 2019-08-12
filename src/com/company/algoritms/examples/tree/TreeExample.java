package com.company.algoritms.examples.tree;

import com.company.algoritms.enums.ExampleType;
import com.company.algoritms.examples.Example;
import com.company.algoritms.examples.tree.binarytree.Tree;
import com.company.algoritms.examples.tree.treetwothreefour.TreeTwoThreeFour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeExample implements Example {

    private final ExampleType type;

    public TreeExample(ExampleType type) {
        this.type = type;
    }

    @Override
    public void showExample() {
        binaryTreeExample();

        try {
            treeTwoThreeFourExample();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ExampleType getType() {
        return type;
    }

    private void binaryTreeExample() {
        Tree<Person> tree = new Tree<>();

        Person personOne = new Person("Jack", "Daniels", 22, 12);
        Person personTwo = new Person("Rick", "Radriges", 23, 44);
        Person personThree = new Person("Robert", "Martin", 44, 56);
        Person personFour = new Person("Stive", "Macconel", 55, 67);

        tree.insert(1, personOne);
        tree.insert(2, personTwo);
        tree.insert(3, personThree);
        tree.insert(4, personFour);

        Person result = tree.find(3);

        System.out.println(result);
        System.out.println(tree.minimum());
        System.out.println(tree.maximum());
        tree.delete(2);
        System.out.println(tree.maximum());
    }

    private void treeTwoThreeFourExample() throws IOException {
        TreeTwoThreeFour treeTwoThreeFour = new TreeTwoThreeFour();

        treeTwoThreeFour.insert(50);
        treeTwoThreeFour.insert(40);
        treeTwoThreeFour.insert(60);
        treeTwoThreeFour.insert(30);
        treeTwoThreeFour.insert(70);

        while (true) {
            System.out.print("Enter fist letter of show, insert, of find:");

            switch (getChar()) {
                case 's':
                    treeTwoThreeFour.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    treeTwoThreeFour.insert(getInt());
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    int index = treeTwoThreeFour.find(getInt());

                    if (index != -1) {
                        System.out.println("Found in index: " + index);
                    } else {
                        System.out.println("Not found!");
                    }
                default:
                    System.out.print("Invalid entry!");
            }
        }
    }

    private static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        return bufferedReader.readLine();
    }

    private static char getChar() throws IOException {
        return getString().charAt(0);
    }

    private static int getInt() throws IOException {
        return Integer.parseInt(getString());
    }
}
