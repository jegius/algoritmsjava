package com.company.algoritms.examples.tree;

import com.company.algoritms.enums.ExampleType;
import com.company.algoritms.examples.Example;

public class TreeExample implements Example {

    private final ExampleType type;

    public TreeExample(ExampleType type) {
        this.type = type;
    }

    @Override
    public void showExample() {
        System.out.println("tree example");
    }

    @Override
    public ExampleType getType() {
        return type;
    }
}
