package com.company.algoritms;

import com.company.algoritms.enums.ExampleType;
import com.company.algoritms.examples.Example;
import com.company.algoritms.examples.array.ArrayExample;
import com.company.algoritms.examples.hashmap.HashMapExample;
import com.company.algoritms.examples.linkedlist.LinkedListExample;
import com.company.algoritms.examples.listiterator.ListIteratorExample;
import com.company.algoritms.examples.queue.QueueExample;
import com.company.algoritms.examples.quicksort.QuickSortExample;
import com.company.algoritms.examples.recursion.RecursionExample;
import com.company.algoritms.examples.shellsort.ShellSortExample;
import com.company.algoritms.examples.stack.StackExample;
import com.company.algoritms.examples.tree.TreeExample;

class ExampleFactory {
    Example createExample(ExampleType type) {
        switch (type) {
            case ARRAY:
                return new ArrayExample(type);
            case STACK:
                return new StackExample(type);
            case QUEUE:
                return new QueueExample(type);
            case LINKED_LIST:
                return new LinkedListExample(type);
            case LIST_ITERATOR:
                return new ListIteratorExample(type);
            case RECURSION:
                return new RecursionExample(type);
            case SHELL_SORT:
                return new ShellSortExample(type);
            case QUICK_SORT:
                return new QuickSortExample(type);
            case TREE:
                return new TreeExample(type);
            case HASH_MAP:
                return new HashMapExample(type);
            default:
                throw new IllegalArgumentException("Wrong example type:" + type);
        }
    }
}
