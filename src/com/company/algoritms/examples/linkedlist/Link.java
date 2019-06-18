package com.company.algoritms.examples.linkedlist;

public class Link {
    public long id;
    public Double data;
    Link next;

    public Link(long id, Double data) {
        this.id = id;
        this.data = data;
        this.next = null;
    }

    public Link(Double data) {
        this.data = data;
        this.next = null;
    }

    public void display() {
        System.out.println("{" + id + ", " + data + "} ");
    }
}
