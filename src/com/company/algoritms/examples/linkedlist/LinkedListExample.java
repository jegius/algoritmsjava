package com.company.algoritms.examples.linkedlist;

import com.company.algoritms.examples.Example;

public class LinkedListExample implements Example  {

    @Override
    public void showExample() {
        baseLinkedListShowCase();
        insertAndDeleteByIdShowCase();
        firstLastListShowCase();
        sortedListShowCase();
        insertSortShowCase();
    }

    private void baseLinkedListShowCase() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(2.33);
        linkedList.insert(34.33);
        linkedList.insert(52.33);
        linkedList.insert(233.3332);
        linkedList.insert(87782.33);

        linkedList.displayList();
        clearList(linkedList);
        linkedList.displayList();

    }

    private void firstLastListShowCase() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(23.3);
        linkedList.insert(23.3);
        linkedList.insert(2344.3);

        linkedList.insertLast(323.3);
        linkedList.insertLast(323.332);
        linkedList.insertLast(32433.33);

        linkedList.displayList();
        System.out.println("===========================");

        linkedList.deleteFirst();
        System.out.println("===========================");
        linkedList.displayList();
    }

    private void insertSortShowCase() {
        int size = 10;

        Link[] links = new Link[size];

        for (int index = 0; index < size; index++) {
            Double random = (Double) (Math.random() * 99);
            Link newLink = new Link(random);
            links[index] = newLink;
        }

        System.out.print("Unsorted array: ");

        for (Link element: links) {
            System.out.print(element.data + " ");
        }
        System.out.println();

        SortedLinkedList sortedLinkedList = new SortedLinkedList(links);

        for (int index = 0; index < size; index++) {
            links[index] = sortedLinkedList.remove();
        }

        System.out.print("Sorted Array: ");

        for (Link link: links) {
            System.out.print(link.data + " ");
        }
        System.out.println();
    }

    private void sortedListShowCase() {
        SortedLinkedList sortedLinkedList = new SortedLinkedList();
        sortedLinkedList.insert(2223.3);
        sortedLinkedList.insert(2123213.2);
        sortedLinkedList.insert(21313.2);
        sortedLinkedList.insert(2.22);

        sortedLinkedList.displayList();
    }

    private void insertAndDeleteByIdShowCase() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(12.12);
        linkedList.insert(112312.12);
        linkedList.insert(123434.12);
        linkedList.insert(1234.2);
        linkedList.insert(1223423.2);

        linkedList.displayList();

        System.out.println("===========================");

        Link foundItem = linkedList.find(2);
        foundItem.display();

        System.out.println("===========================");

        linkedList.delete(2);

        linkedList.displayList();
    }

    private void clearList(LinkedList linkedList) {

        while (!linkedList.isEmpty()) {
            Link deletedItem = linkedList.deleteFirst();
            System.out.println("deleted: ");
            deletedItem.display();
        }
    }
}
