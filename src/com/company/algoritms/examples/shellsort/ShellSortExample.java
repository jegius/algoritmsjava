package com.company.algoritms.examples.shellsort;

import com.company.algoritms.AlgorithmUtils;
import com.company.algoritms.enums.ExampleType;
import com.company.algoritms.examples.Example;
import com.company.algoritms.examples.array.SimpleArray;

public class ShellSortExample implements Example {
    private static final int MAX_LENGTH = 10;
    private final ExampleType type;

    public ShellSortExample(ExampleType type) {
        this.type = type;
    }

    @Override
    public void showExample() {
        SimpleArray demo = new SimpleArray(MAX_LENGTH);
        AlgorithmUtils.fillCollectionWithRandomNumbers(demo, MAX_LENGTH);

        demo.display();
        System.out.println("============================");
        demo.shellSort();
        demo.display();

        System.out.println("============================");

        try {
            System.out.println(demo.get(2));
            demo.partitionIt(0, MAX_LENGTH - 1, demo.get(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        demo.display();

    }

    public ExampleType getType() {
        return type;
    }
}
