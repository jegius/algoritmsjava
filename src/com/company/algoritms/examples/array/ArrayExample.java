package com.company.algoritms.examples.array;

import com.company.algoritms.examples.Example;

public class ArrayExample implements Example {
    private static final int MAX_LENGTH = 10;

    public void showExample() {
        this.showSimpleExample();
        this.showBinarySearch();
    }

    private void showSimpleExample() {
        SimpleArray demo = new SimpleArray(MAX_LENGTH);

        demo.insert(22);
        demo.insert(11);
        demo.insert(323);
        demo.insert(453);
        demo.insert(44);
        demo.insert(222);

        demo.display();

        int testValue = 11;
        if (demo.find(testValue)) {
            System.out.println("Found " + testValue);
        } else {
            System.out.println("Can't find " + testValue);
        }

        demo.delete(22);
        demo.delete(323);

        demo.display();
    }

    private void showBinarySearch() {

        SimpleArray manualSorted = new SimpleArray(MAX_LENGTH);
        manualSorted.insert(12);
        manualSorted.insert(22);
        manualSorted.insert(31);
        manualSorted.insert(43);
        manualSorted.insert(54);
        manualSorted.insert(65);
        manualSorted.insert(76);

        System.out.println(manualSorted.binyriSearch(62));
    }
}
