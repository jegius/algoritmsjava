package com.company.algoritms.examples.tree.treetwothreefour;

public class DataItem {
    private long data;

    public DataItem(long data) {
        this.data = data;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "data=" + data +
                '}';
    }
}
