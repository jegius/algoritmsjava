package com.company.algoritms.examples.linkedlist;

import com.company.algoritms.examples.ExampleCollection;

public class LinkedList implements ExampleCollection<Double> {
    private Link first;
    private long elementCount;

    public LinkedList() {
        this.elementCount = 0;
        this.first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    @Override
    public void insert(Double value) {
        Link newLink = new Link(elementCount++, value);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = temp.next;

        if (first != null ) {
            elementCount--;
        }

        return temp;
    }

    public Link find(long key) {
        Link current = first;

        while (current.id != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(long key) {
        Link current = first;
        Link previous = first;

        while (current.id != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }

        if (first != null ) {
            elementCount--;
        }
        return current;
    }

    public void displayList() {
        System.out.println("List (first ==> last): ");

        Link current = first;

        while (current != null) {
            current.display();
            current = current.next;
        }
    }
}
