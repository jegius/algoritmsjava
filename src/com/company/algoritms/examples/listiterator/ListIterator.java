package com.company.algoritms.examples.listiterator;

public class ListIterator {
    private Link current;
    private Link previous;
    private LinkedList list;

    public ListIterator(LinkedList list) {
        this.list = list;
        reset();
    }

    public void reset() {
        current = list.getFirst();
        previous = null;
    }

    public boolean isEnd() {
        return (current.next == null);
    }

    public void nextLink() {
        previous = current;
        current = current.next;
    }

    public Link getCurrent() {
        return current;
    }

    public void insertAfter(long data) {
        Link link = new Link(data);

        if (list.isEmpty()) {
            list.setFirst(link);
            current = link;
        } else {
            link.next = current.next;
            current.next = link;
            nextLink();
        }
    }

    public void insertBefore(long data) {
        Link link = new Link(data);

        if (previous == null) {
            link.next = list.getFirst();
            list.setFirst(link);
            reset();
        } else {
            link.next = previous.next;
            previous.next = link;
            current = link;
        }
    }

    public long deleteCurrent() {
        long value = current.data;

        if (previous == null) {
            list.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;

            if(isEnd()){
                reset();
            } else {
                current = current.next;
            }
        }
        return value;
    }
}
