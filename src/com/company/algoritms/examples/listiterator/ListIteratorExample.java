package com.company.algoritms.examples.listiterator;

import com.company.algoritms.examples.Example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListIteratorExample implements Example {

    @Override
    public void showExample() {
        runListIteratorShowCase();
    }

    /** s - ввод содержимого списка.
     *  r - возвращение итератора в начало списка
     *  n - переход к следующему элементу
     *  g - вывод содержимого текущего элемента
     *  b - вставка перед текущим элементом
     *  a - вставка новго элемента после текущего
     *  b -  удаление текущего элемента
     * */
    private void runListIteratorShowCase() {
        LinkedList linkedList = new LinkedList();
        ListIterator iterator = linkedList.getIterator();


        iterator.insertAfter(20);
        iterator.insertAfter(10);
        iterator.insertAfter(50);
        iterator.insertBefore(90);

        while (true) {
            System.out.print("Enter first letter of show, reset, ");
            System.out.print("next, get, before, after, delete: ");
            System.out.flush();

            try {
                makeChoice(getChar(), linkedList, iterator);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void makeChoice(int choice, LinkedList linkedList, ListIterator iterator) throws IOException {
        long value;

        switch (choice) {
            case 's': {
                if (!linkedList.isEmpty()) {
                    linkedList.displayList();
                } else {
                    System.out.println("List is Empty");
                }
                break;
            }
            case 'r': {
                iterator.reset();
                break;
            }
            case 'n': {
                if (!linkedList.isEmpty() && !iterator.isEnd()){
                    iterator.nextLink();
                } else {
                    System.out.println("Can't go to nex link");
                }
                break;
            }
            case 'g': {
                if (!linkedList.isEmpty()){
                    value = iterator.getCurrent().data;
                    System.out.println("Returned " + value);
                } else {
                    System.out.println("List is empty");
                }
                break;
            }
            case 'b': {
                System.out.print("Enter value to insert: ");
                System.out.flush();

                value = getInt();
                iterator.insertBefore(value);
                break;
            }
            case 'a': {
                System.out.print("Enter value to insert: ");
                System.out.flush();

                value = getInt();
                iterator.insertAfter(value);
                break;
            }
            case 'd': {
                if (!linkedList.isEmpty()) {
                    value = iterator.deleteCurrent();
                    System.out.println("Deleted " + value);
                }
                else {
                    System.out.println("Can't delete");
                }
                break;
            }
            default: {
                System.out.println("Invalid entry");
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
