package com.company.algoritms.examples.linkedlist.doublylinked;

import com.company.algoritms.examples.ExampleCollection;

public class DoublyLinkedList implements ExampleCollection<Long> {
    private Link first;
    private Link last;

    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFist(Long value) {
        Link newLink = new Link<>(value);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }

        newLink.next = first;
        first = newLink;
    }

    public void insertLast(Long value) {
        Link newLink = new Link<>(value);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;

        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }

        first = first.next;
        return temp;
    }

    public Link deleteLast() {
        Link temp = last;

        if (first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }

    @Override
    public void insert(Long value) {
        insertFist(value);
    }

    public boolean insertAfter(Long key, Long value) {
        Link current = first;
        while (current.data != key) {
            current = current.next;

            if (current == null) {
                return false;
            }
        }

        Link newLink = new Link<>(value);

        if (current == last) {
            newLink.next = current.next;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }

        newLink.previous = current;
        current.next = newLink;
        return true;
    }

    public Link deleteKey(Long key) {
        Link current = first;

        while (current.data != key) {
            current = current.next;

            if (current == null) {
                return null;
            }
        }

        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }

        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }

        return current;
    }

    public void displayForward() {
        System.out.print("List (first ==> last): ");
        Link current = first;

        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        System.out.print("List (first ==> last): ");
        Link current = last;

        while (current != null) {
            current.display();
            current = current.previous;
        }
        System.out.println();
    }
}
