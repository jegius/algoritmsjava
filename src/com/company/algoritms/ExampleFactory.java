package com.company.algoritms;

import com.company.algoritms.enums.ExampleTypes;
import com.company.algoritms.examples.Example;
import com.company.algoritms.examples.array.ArrayExample;
import com.company.algoritms.examples.linkedlist.LinkedListExample;
import com.company.algoritms.examples.listiterator.ListIteratorExample;
import com.company.algoritms.examples.queue.QueueExample;
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
            case QUEUE:
                createdExample = new QueueExample();
                break;
            case LINKED_LIST:
                createdExample = new LinkedListExample();
                break;
            case LIST_ITERATOR:
                createdExample = new ListIteratorExample();
                break;
            default:
                throw new IllegalArgumentException("Wrong example type:" + type);
        }
        return createdExample;
    }
}
