package com.company.algoritms.examples.tree;

import com.company.algoritms.enums.ExampleType;
import com.company.algoritms.examples.Example;
import com.company.algoritms.examples.tree.binarytree.Tree;

public class TreeExample implements Example {

    private final ExampleType type;

    public TreeExample(ExampleType type) {
        this.type = type;
    }

    @Override
    public void showExample() {
        Tree<Person> tree = new Tree<>();

        Person personOne = new Person("Jack","Daniels", 22, 12);
        Person personTwo = new Person("Rick","Radriges", 23, 44);
        Person personThree = new Person("Robert","Martin", 44, 56);
        Person personFour = new Person("Stive","Macconel", 55, 67);

        tree.insert(1, personOne);
        tree.insert(2, personTwo);
        tree.insert(3, personThree);
        tree.insert(4, personFour);

        Person result = tree.find(3);

        System.out.println(result);
        System.out.println(tree.minimum());
        System.out.println(tree.maximum());
        tree.delete(2);
        System.out.println(tree.maximum());

    }

    @Override
    public ExampleType getType() {
        return type;
    }
}
