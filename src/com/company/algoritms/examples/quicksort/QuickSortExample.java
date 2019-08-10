package com.company.algoritms.examples.quicksort;

import com.company.algoritms.AlgorithmUtils;
import com.company.algoritms.enums.ExampleType;
import com.company.algoritms.examples.Example;
import com.company.algoritms.examples.array.SimpleArray;

public class QuickSortExample implements Example {
    private static final int MAX_LENGTH = 10;
    private final ExampleType type;

    public QuickSortExample(ExampleType type) {
        this.type = type;
    }

    @Override
    public void showExample() {
        SimpleArray demo = new SimpleArray(MAX_LENGTH);
        AlgorithmUtils.fillCollectionWithRandomNumbers(demo, MAX_LENGTH);

        demo.display();
        System.out.println("============================");

        demo.quickSort();
        demo.display();

        System.out.println("============================");

        SimpleArray quickSortDemo = new SimpleArray(MAX_LENGTH);
        AlgorithmUtils.fillCollectionWithRandomNumbers(quickSortDemo, MAX_LENGTH);
        quickSortDemo.display();
        System.out.println("============================");

        quickSortDemo.optimizedQuickSort();
        quickSortDemo.display();
    }

    public ExampleType getType() {
        return type;
    }
}
