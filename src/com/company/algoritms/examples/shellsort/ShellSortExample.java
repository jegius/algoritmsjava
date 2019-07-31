package com.company.algoritms.examples.shellsort;

import com.company.algoritms.AlgorithmUtils;
import com.company.algoritms.examples.Example;
import com.company.algoritms.examples.array.SimpleArray;

public class ShellSortExample implements Example {
    private static final int MAX_LENGTH = 10;

    @Override
    public void showExample() {
        SimpleArray demo = new SimpleArray(MAX_LENGTH);
        AlgorithmUtils.fillCollectionWithRandomNumbers(demo, MAX_LENGTH);

        demo.display();
        System.out.println("============================");
        demo.shellSort();
        demo.display();
    }
}
