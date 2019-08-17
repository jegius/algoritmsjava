package com.company.algoritms.examples.hashmap.simplehashchain;

public class SortedList <T>{
    private Link<T> first;

    public SortedList() {
        this.first = null;
    }

    public void insert(Link<T> link) {
        T key = link.getData();

        Link previous = null;
        Link current = first;

        while (current != null && key.equals(current.getData())) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            first = link;
        } else {
            previous.setNext(link);
        }

        link.setNext(current);
    }

    public void delete(T key) {
        Link previous = null;
        Link current = first;

        while (current != null && !key.equals(current.getData())) {
            previous = current;
            current = current.getNext();
        }


        if (previous == null) {
            first = first.getNext();
        } else {
            previous.setNext(current.getNext());
        }
    }

    public Link find(T key) {
        Link current = first;

        while (current != null && current.getData().equals(key)) {
            if (current.getData() == key) {
                return  current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void display() {
        Link current = first;

        System.out.print("List (first --> last): ");
        while (current != null) {
            System.out.print(current + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
