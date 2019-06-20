package com.company.algoritms;

import com.company.algoritms.examples.Example;
import com.company.algoritms.enums.ExampleTypes;

import java.util.ArrayList;

public class ExampleRunner {

    private static final ExampleFactory exampleFactory = new ExampleFactory();
    private static final ArrayList<Example> exampleStorage = new ArrayList();

    public ExampleRunner() {
//        exampleStorage.add(exampleFactory.createExample(ExampleTypes.ARRAY));
//        exampleStorage.add(exampleFactory.createExample(ExampleTypes.STACK));
//        exampleStorage.add(exampleFactory.createExample(ExampleTypes.QUEUE));
//        exampleStorage.add(exampleFactory.createExample(ExampleTypes.LINKED_LIST));
        exampleStorage.add(exampleFactory.createExample(ExampleTypes.LIST_ITERATOR));
    }

    public void run() {
        for (Example example : exampleStorage) {
            example.showExample();
        }
    }
}
