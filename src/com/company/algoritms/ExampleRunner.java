package com.company.algoritms;

import com.company.algoritms.enums.ExampleType;
import com.company.algoritms.examples.Example;

import java.util.ArrayList;
import java.util.List;

public class ExampleRunner {

    private static final ExampleFactory exampleFactory = new ExampleFactory();
    private static final List<Example> exampleStorage = new ArrayList<Example>();

    public ExampleRunner() {
        exampleStorage.add(exampleFactory.createExample(ExampleType.ARRAY));
        exampleStorage.add(exampleFactory.createExample(ExampleType.STACK));
        exampleStorage.add(exampleFactory.createExample(ExampleType.QUEUE));
        exampleStorage.add(exampleFactory.createExample(ExampleType.LINKED_LIST));
        exampleStorage.add(exampleFactory.createExample(ExampleType.LIST_ITERATOR));
        exampleStorage.add(exampleFactory.createExample(ExampleType.RECURSION));
        exampleStorage.add(exampleFactory.createExample(ExampleType.SHELL_SORT));
        exampleStorage.add(exampleFactory.createExample(ExampleType.QUICK_SORT));
        exampleStorage.add(exampleFactory.createExample(ExampleType.TREE));
        exampleStorage.add(exampleFactory.createExample(ExampleType.HASH_MAP));
    }

    public void run(ExampleType exampleType) {
        Example neededExample = exampleStorage
                .stream()
                .filter(example -> example
                        .getType()
                        .equals(exampleType))
                .findFirst()
                .orElse(null);

        assert neededExample != null;
        neededExample.showExample();
    }
}
