package com.company.algoritms.examples.tree.treetwothreefour;

public class TreeTwoThreeFour {
    private Node root = new Node();

    public int find(long key) {
        Node currentNode = root;
        int childNumber;

        while (true) {
            if ((childNumber = currentNode.findItem(key)) != -1) {
                return childNumber;
            } else if (currentNode.isLeaf()){
                return -1;
            } else {
                currentNode = getNextChild(currentNode, key);
            }
        }
    }

    public void insert(long newData) {
        Node currentNode = root;
        DataItem tempItem = new DataItem(newData);

        while (true) {
            if (currentNode.isFull()) {
                split(currentNode);
                currentNode = currentNode.getParent();
                currentNode = getNextChild(currentNode, newData);
            } else if (currentNode.isLeaf()) {
                break;
            } else {
                currentNode = getNextChild(currentNode, newData);
            }
        }
        currentNode.insertItem(tempItem);
    }

    private void split(Node thisNode) {
        DataItem firstItem;
        DataItem secondItem;
        Node parent;
        Node firstChild;
        Node secondChild;
        int itemIndex;

        secondItem = thisNode.removeItem();
        firstItem = thisNode.removeItem();
        firstChild = thisNode.disconnectChild(2);
        secondChild = thisNode.disconnectChild(3);
        Node newRigth = new Node();

        if (thisNode == root) {
            root = new Node();
            parent = root;
            root.connectChild(0, thisNode);
        } else {
            parent = thisNode.getParent();
        }

        itemIndex = parent.insertItem(firstItem);
        int parentItemsLength = parent.getLength();

        for (int elementIndex = parentItemsLength - 1; elementIndex > itemIndex; elementIndex--) {
            Node temp = parent.disconnectChild(elementIndex);
            parent.connectChild(elementIndex + 1, temp);
        }

        parent.connectChild(itemIndex + 1, newRigth);

        newRigth.insertItem(secondItem);
        newRigth.connectChild(0, firstChild);
        newRigth.connectChild(1, secondChild);
    }

    private Node getNextChild(Node node, long newValue) {
        int elementIndex;
        int length = node.getLength();

        for (elementIndex = 0; elementIndex < length; elementIndex++) {
            if (newValue < node.getItem(elementIndex).getData()) {
                return node.getChild(elementIndex);
            }
        }
        return node.getChild(elementIndex);
    }

    public void displayTree() {
        recDisplayTree(root, 0, 0);
    }

    private void recDisplayTree(Node node, int level, int childNumber) {
        System.out.print("Level=" + level + " child=" + childNumber + " ");
        node.displayNode();

        int length = node.getLength();

        for (int elementIndex = 0; elementIndex < length + 1; elementIndex++) {
            Node nextNode = node.getChild(elementIndex);

            if (nextNode != null) {
                recDisplayTree(nextNode, level + 1, elementIndex);
            } else {
                return;
            }
        }
    }
}
