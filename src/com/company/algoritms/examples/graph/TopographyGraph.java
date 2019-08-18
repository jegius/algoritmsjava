package com.company.algoritms.examples.graph;

public class TopographyGraph  extends Graph{
    private char[] sortedArray;

    public TopographyGraph() {
        this.sortedArray = new char[MAX_VERTEXES];
    }

    @Override
    public void addEdge(int start, int end) {
        adjacencyMatrix[start][end] = 1;
    }

    void topography() {
        int originalVertexQuantity = vertexQuantity;

        while (vertexQuantity > 0) {
            int currentVertex = noSuccessors();

            if (currentVertex == -1) {
                System.out.println("Error: Graph has cycles.");
                return;
            }
            sortedArray[vertexQuantity - 1] = vertexList[currentVertex].getLabel();

            deleteVertex(currentVertex);
        }

        System.out.print("Topologically sorted order: ");
        for (int index = 0; index < originalVertexQuantity; index++) {
            System.out.print(sortedArray[index]);
        }
        System.out.println();
    }

    private int noSuccessors() {
        boolean isEdge;

        for (int row = 0; row < vertexQuantity; row++) {
            isEdge = false;

            for (int column = 0; column < vertexQuantity; column++) {
                if (adjacencyMatrix[row][column] > 0) {
                    isEdge = true;
                    break;
                }
            }
            if (!isEdge) {
                return row;
            }
        }
        return -1;
    }
    void deleteVertex(int vertexIndex) {
        if (vertexIndex != vertexQuantity - 1) {
            for (int index = vertexIndex; index < vertexQuantity - 1; index++) {
                vertexList[index] = vertexList[index + 1];
            }

            for (int row = vertexIndex; row < vertexQuantity - 1; row++) {
                moveRowUp(row, vertexQuantity);
            }

            for (int column = vertexIndex; column < vertexQuantity - 1; column++) {
                moveColumnLeft(column, vertexQuantity - 1);
            }
        }
        vertexQuantity--;
    }

    private void moveRowUp(int row, int length) {
        for (int column = 0; column < length; column++) {
            adjacencyMatrix[row][column] = adjacencyMatrix[row + 1][column];
        }
    }

    private void moveColumnLeft(int column, int length) {
        for (int row = 0; row < length; row++) {
            adjacencyMatrix[row][column] = adjacencyMatrix[row][column + 1];
        }
    }
}
