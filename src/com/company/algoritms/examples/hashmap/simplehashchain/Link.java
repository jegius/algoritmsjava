package com.company.algoritms.examples.hashmap.simplehashchain;

public class Link <T> {
    private T data;
    private Link next;

    public Link(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Link{" +
                "data=" + data +
                '}';
    }
}
