package com.company.algoritms;

import com.company.algoritms.enums.ExampleTypes;
import com.company.algoritms.examples.Example;
import com.company.algoritms.examples.array.ArrayExample;

class ExampleFactory {
    Example createExample(ExampleTypes type) {
        Example createdExample;
        switch (type) {
            case ARRAY:
                createdExample = new ArrayExample();
                break;
            default:
                throw new IllegalArgumentException("Wrong example type:" + type);
        }
        return createdExample;
    }
}
