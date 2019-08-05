package com.company.algoritms;

import com.company.algoritms.examples.Example;
import com.company.algoritms.enums.ExampleTypes;

import java.util.ArrayList;
import java.util.List;

public class ExampleRunner {

    private static final ExampleFactory exampleFactory = new ExampleFactory();
    private static final List<Example> exampleStorage = new ArrayList<Example>();

    public ExampleRunner() {
//        exampleStorage.add(exampleFactory.createExample(ExampleTypes.ARRAY));
//        exampleStorage.add(exampleFactory.createExample(ExampleTypes.STACK));
//        exampleStorage.add(exampleFactory.createExample(ExampleTypes.QUEUE));
//        exampleStorage.add(exampleFactory.createExample(ExampleTypes.LINKED_LIST));
//        exampleStorage.add(exampleFactory.createExample(ExampleTypes.LIST_ITERATOR));
//        exampleStorage.add(exampleFactory.createExample(ExampleTypes.RECURSION));
//        exampleStorage.add(exampleFactory.createExample(ExampleTypes.SHELL_SORT));
        exampleStorage.add(exampleFactory.createExample(ExampleTypes.QUICK_SORT));
    }

    public void run() {
        for (Example example : exampleStorage) {
            example.showExample();
        }
    }
}
