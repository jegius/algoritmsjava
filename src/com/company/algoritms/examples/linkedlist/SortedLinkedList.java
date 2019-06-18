package com.company.algoritms.examples.linkedlist;

import com.company.algoritms.examples.ExampleCollection;

public class SortedLinkedList implements ExampleCollection<Double> {

    private Link first;
    private long elementCount;

    public SortedLinkedList() {
        this.first = null;
        this.elementCount = 0;
    }

    public SortedLinkedList(Link[] links) {
        this.first = null;
        for (Link link : links) {
            insert(link);
        }
    }

    /**
     * Вставка O(N) (в среднем O(N/2) из-за того
     * что позицию нужно определять перебором списка)
     *
     * Поиск и удаление наименьшего значения О(1), так как
     * наименьший элемент всегда находися в начале списка.
     *
     * Соритрованный LinkedList можно использовать для
     * сортировки других коллекций, так как элементы вствленные
     * в такой list будут автоматически отсортированы. Алгоритмическая
     * сложность такой сортировки O(pow(2))/4 из-за того что в
     * общем случае каждый элмемент приходится сравнивать с половиной
     * элементов находящихся в коллекции.
     *
     * Сортировака методом вставки с помощью SortedLinkedList заниматет в двое
     * больше памяти по сравнению с сортировкой с исользованием простого массива
     * Из-за того что связанный список должне находися в памяти одновременно с массивом.
     *
     * Такой способ подходит для сортировки небольших объемов данных
     * */
    @Override
    public void insert(Double value) {

        Link newLink = new Link(elementCount++, value);
        Link previous = null;
        Link current = first;

        while (current != null && value > current.data) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = newLink;
        } else {
            previous.next = newLink;
        }
        newLink.next = current;
    }

    public void insert(Link link) {
        Link previous = null;
        Link current = first;

        while (current != null && link.data > current.data) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            first = link;
        } else {
            previous.next = link;
        }
        link.next = current;
    }

    /**
     * Удаление O(N) (в среднем O(N/2) из-за того
     * что позицию нужно определять перебором списка)
     * */
    public Link remove() {
        Link temp = first;
        first = first.next;
        return temp;
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
