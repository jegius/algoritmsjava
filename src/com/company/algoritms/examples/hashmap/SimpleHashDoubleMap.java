package com.company.algoritms.examples.hashmap;

public class SimpleHashDoubleMap extends SimpleHashMap {

    private static final int HASH_CONST = 5;


    SimpleHashDoubleMap(Long size) {
        super(size);
    }

    private int stepSizeHash(Long size) {
        return HASH_CONST - size.intValue() % HASH_CONST;
    }

    @Override
    public void insert(DataItem<Long> item) {
        int hash = getHash(item.getKey());
        int stepSize = stepSizeHash(item.getKey());

        while (hashArray[hash] != null && hashArray[hash].getKey() != -1) {
            hash +=  stepSize;
            hash %= size;
        }
        hashArray[hash] = item;
    }

    @Override
    public DataItem<Long> delete(Long key) {
        int hash = getHash(key);
        int stepSize = stepSizeHash(key);

        while (hashArray[hash] != null) {
            if (hashArray[hash].getKey().equals(key)) {
                DataItem temp = hashArray[hash];
                hashArray[hash] = noneItem;
                return  temp;
            }
            hash += stepSize;
            hash %= size;
        }
        return  null;
    }

    @Override
    public DataItem<Long> find(Long key) {
        int hash = getHash(key);
        int stepSize = stepSizeHash(key);

        while (hashArray[hash] != null) {
            if (hashArray[hash].getKey().equals(key)) {
                return hashArray[hash];
            }
            hash += stepSize;
            hash %= size;
        }
        return null;
    }
}
