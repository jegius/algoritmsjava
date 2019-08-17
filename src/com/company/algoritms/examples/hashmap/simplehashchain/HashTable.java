package com.company.algoritms.examples.hashmap.simplehashchain;

import com.company.algoritms.examples.ExampleCollection;

public class HashTable implements ExampleCollection<Long> {
    private SortedList<Long>[] hashArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        hashArray = new SortedList[size];
        for (int index = 0; index < size; index++) {
            hashArray[index] = new SortedList<>();
        }
    }

    public void display() {
        for(SortedList sortedList: hashArray) {
            sortedList.display();
        }
    }

    private Long hashFunction(Long key) {
        return  key % size;
    }

    public void insert(Link<Long> link) {
        Long key = link.getData();
        Long hash = hashFunction(key);
        hashArray[hash.intValue()].insert(link);
    }

    public void delete(Long key) {
        Long hash = hashFunction(key);
        hashArray[hash.intValue()].delete(key);
    }

    public Link find(Long key) {
        Long hash = hashFunction(key);
        return hashArray[hash.intValue()].find(key);
    }

    @Override
    public void insert(Long value) {
        insert(new Link<>(value));
    }
}
