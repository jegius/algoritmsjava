package com.company.algoritms.examples.linkedlist;

import com.company.algoritms.examples.ExampleCollection;

public class LinkedList implements ExampleCollection<Double> {
    private Link first;
    private Link last;
    private long elementCount;

    /**
     * Общий + у списков по сравнению с массивам - жкономия памяти,
     * т.к. нам не нужно резервировать память заранее.
     * */
    public LinkedList() {
        this.elementCount = 0;
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    /**
     * Сложность вставки O(1)
     * */
    @Override
    public void insert(Double value) {
        Link newLink = new Link(elementCount++, value);

        if (isEmpty()) {
            last = newLink;
        }

        newLink.next = first;
        first = newLink;
    }

    public void insertLast(Double value) {
        Link newLink = new Link(elementCount++, value);

        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            last = newLink;
        }
    }

    public Link deleteFirst() {
        Link temp = first;

        if (first.next == null) {
            last = null;
        }

        first = temp.next;

        if (first != null) {
            elementCount--;
        }

        return temp;
    }

    /**
     * Сложность поиска О(N)
     * */
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

    /**
     * Сложность удаления O(N)
     * */
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

        if (first != null) {
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
