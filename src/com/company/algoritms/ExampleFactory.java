package com.company.algoritms;

import com.company.algoritms.enums.ExampleTypes;
import com.company.algoritms.examples.Example;
import com.company.algoritms.examples.array.ArrayExample;
import com.company.algoritms.examples.stack.SimpleStack;
import com.company.algoritms.examples.stack.StackExample;

class ExampleFactory {
    Example createExample(ExampleTypes type) {
        Example createdExample;
        switch (type) {
            case ARRAY:
                createdExample = new ArrayExample();
                break;
            case STACK:
                createdExample = new StackExample();
                break;
            default:
                throw new IllegalArgumentException("Wrong example type:" + type);
        }
        return createdExample;
    }
}
