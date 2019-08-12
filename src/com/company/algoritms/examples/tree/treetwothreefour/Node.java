package com.company.algoritms.examples.tree.treetwothreefour;

public class Node {
    public static final int ORDER = 4;
    private int length;
    private Node parent;
    private Node[] children = new Node[ORDER];
    private DataItem[] items = new DataItem[ORDER - 1];

    public void connectChild(int childNumber, Node child) {
        children[childNumber] = child;
        if (child != null) {
            child.parent = this;
        }
    }

    public Node disconnectChild(int childNumber) {
        Node tempNode = children[childNumber];
        children[childNumber] = null;

        return tempNode;
    }

    public Node getChild(int childNumber) {
        return children[childNumber];
    }

    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return children[0] == null;
    }

    public int getLength() {
        return length;
    }

    public DataItem getItem(int index) {
        return items[index];
    }

    public boolean isFull() {
        return length == ORDER - 1;
    }

    public int findItem(long elementForSearch) {
        for (int elementIndex = 0; elementIndex < ORDER - 1; elementIndex++) {
            if (items[elementIndex] == null) {
                break;
            } else if (items[elementIndex].getData() == elementForSearch) {
                return elementIndex;
            }
        }
        return -1;
    }

    public int insertItem(DataItem newItem) {
        length++;

        long newKey = newItem.getData();

        for (int elementIndex = ORDER - 2; elementIndex >= 0; elementIndex--) {
            if (items[elementIndex] == null) {
                continue;
            } else {
                long thisKey = items[elementIndex].getData();

                if (newKey < thisKey) {
                    items[elementIndex + 1] = items[elementIndex];
                } else {
                    items[elementIndex + 1] = newItem;
                    return elementIndex + 1;
                }
            }
        }
        items[0] = newItem;
        return 0;
    }

    public DataItem removeItem() {
        DataItem temp = items[length - 1];
        items[length - 1] = null;
        length--;
        return temp;
    }

    public void displayNode() {
        for (DataItem item: items) {
            System.out.println(item);
        }
    }
}
