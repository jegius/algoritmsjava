package com.company.algoritms.examples.linkedlist.doublylinked;

public class Link<T> {
    public T data;
    public Link next;
    public Link previous;

    public Link(T data) {
        this.data = data;
    }

    public void display() {
        System.out.print(data + " ");
    }
}
