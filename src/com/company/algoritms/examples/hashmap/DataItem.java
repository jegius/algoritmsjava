package com.company.algoritms.examples.hashmap;

public class DataItem <T>{
    private T key;

    DataItem(T key) {
        this.key = key;
    }

    T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "key=" + key +
                '}';
    }
}
