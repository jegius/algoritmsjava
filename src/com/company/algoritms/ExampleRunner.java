package com.company.algoritms;

import com.company.algoritms.examples.Example;
import com.company.algoritms.enums.ExampleTypes;

import java.util.ArrayList;

public class ExampleRunner {

    private static final ExampleFactory exampleFactory = new ExampleFactory();
    private static final ArrayList<Example> exampleStorage = new ArrayList();

    public ExampleRunner() {
        exampleStorage.add(exampleFactory.createExample(ExampleTypes.ARRAY));
    }

    public void run() {
        for (Example example : exampleStorage) {
            example.showExample();
        }
    }
}
