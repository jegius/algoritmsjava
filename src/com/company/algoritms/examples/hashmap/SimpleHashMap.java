package com.company.algoritms.examples.hashmap;

import com.company.algoritms.examples.ExampleCollection;

public class SimpleHashMap implements ExampleCollection<Long> {
    protected DataItem<Long>[] hashArray;
    protected Long size;
    protected DataItem<Long> noneItem;

    SimpleHashMap(Long size) {
        this.size = size;
        this.hashArray = new DataItem[size.intValue()];
        this.noneItem = new DataItem(-1);
    }

    public void display() {
        System.out.println("Table entry: ");

        for (DataItem<Long> dataItem : hashArray) {
            if (dataItem != null) {
                System.out.print(dataItem.getKey() + " ");
            } else {
                System.out.print(" ** ");
            }
        }
        System.out.println();
    }

    public void insert(DataItem<Long> item) {
        Long key = item.getKey();
        int hash = getHash(key);

        while (hashArray[hash] != null && hashArray[hash].getKey().intValue() != -1) {
            ++hash;
            hash %= size;
        }
        hashArray[hash] = item;
    }

    public DataItem<Long> delete(Long key) {
        int hash = getHash(key);

        while (hashArray[hash] != null) {
            if (hashArray[hash].getKey().equals(key)) {
                DataItem<Long> temp = hashArray[hash];
                hashArray[hash] = noneItem;
                return temp;
            }
            hash++;
            hash %= size;
        }
        return null;
    }

    public DataItem<Long> find(Long key) {
        int hash = getHash(key);

        while (hashArray[hash] != null) {
            if (hashArray[hash].getKey() == key) {
                return hashArray[hash];
            }
            hash++;
            hash %= size;
        }
        return null;
    }

    protected int getHash(Long key) {
        return (int) (key.intValue() % size);
    }

    @Override
    public void insert(Long value) {
        this.insert(new DataItem<>(value));
    }
}
