package com.company.algoritms.examples.tree.binarytree;

/**
 * Выполнение операций добавления и поиска O(log2 N). Будет
 * эфективнее связанного списка и отсортированного массива при работе с
 * большим колличеством данных.
 * */
public class Tree <T>{
    private Node<T> root;

    public T find(long key) {
        Node<T> current = root;

        while (current.getId() != key) {
            if (key < current.getId()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }

            if (current == null) {
                return null;
            }
        }
        return current.getData();
    }

    public void insert(long id, T data) {
        Node<T> newNode = new Node<>();
        newNode.setId(id);
        newNode.setData(data);

        if (root == null) {
            root = newNode;
        } else {
            Node<T> current = root;
            Node<T> parent;

            while (true) {
                parent = current;

                if (id < current.getId()) {
                    current = current.getLeftChild();

                    if (current == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    current = current.getRightChild();

                    if (current == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(long key) {
        Node<T> current = root;
        Node<T> parent = root;
        boolean isLeftChild = true;

        while (current.getId() != key) {
            parent = current;

            if (key < current.getId()) {
                isLeftChild = true;
                current = current.getLeftChild();
            } else {
                isLeftChild = false;
                current = current.getRightChild();
            }
            if (current == null) {
                return false;
            }
        }
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        } else {
            Node<T> successor = getSuccessor(current);

            if (current == root) {
                root = successor;
            } else if(isLeftChild) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
        }
        return true;
    }

    public T minimum() {
        Node<T> current = root;
        Node<T> last = null;

        while (current != null) {
            last = current;
            current = current.getLeftChild();
        }

        assert last != null;
        return last.getData();
     }

     public T maximum() {
        Node<T> current = root;
        Node<T> last = null;

        while (current != null) {
            last = current;
            current = current.getRightChild();
        }

         assert last != null;
         return last.getData();
     }

     private Node<T> getSuccessor(Node<T> deletedNode) {
        Node<T> successorParent = deletedNode;
        Node<T> successor = deletedNode;
        Node<T> current = deletedNode.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != deletedNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(deletedNode.getRightChild());
        }

        return  successor;
     }
}
