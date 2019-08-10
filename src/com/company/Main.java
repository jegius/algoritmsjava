package com.company;

import com.company.algoritms.ExampleRunner;
import com.company.algoritms.enums.ExampleType;

public class Main {

    public static void main(String[] args) {
        ExampleRunner applicationRunner = new ExampleRunner();
        applicationRunner.run(ExampleType.TREE);
    }
}
