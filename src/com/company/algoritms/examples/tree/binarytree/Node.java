package com.company.algoritms.examples.tree.binarytree;

class Node <T> {
    private T data;
    private long id;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }
}
