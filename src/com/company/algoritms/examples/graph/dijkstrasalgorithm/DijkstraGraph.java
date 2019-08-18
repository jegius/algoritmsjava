package com.company.algoritms.examples.graph.dijkstrasalgorithm;

import com.company.algoritms.examples.graph.weightedgraphs.Vertex;

public class DijkstraGraph {
    private final int MAX_VERTEX = 20;
    private final int INFINITY = 1000000;
    private Vertex[] vertexList;
    private int[][] adjacencyMatrix;
    private int vertexQuantity;
    private int treeQuantity;
    private DistanceParent[] paths;
    private int currentVertex;
    private int startToCurrent;

    public DijkstraGraph() {
        this.vertexList = new Vertex[MAX_VERTEX];
        adjacencyMatrix = new int[MAX_VERTEX][MAX_VERTEX];
        vertexQuantity = 0;
        treeQuantity = 0;

        for (int index = 0; index < MAX_VERTEX; index++) {
            for (int innerIndex = 0; innerIndex < MAX_VERTEX; innerIndex++) {
                adjacencyMatrix[index][innerIndex] = INFINITY;
            }
        }

        paths = new DistanceParent[MAX_VERTEX];
    }

    public void addVertex(char label) {
        vertexList[vertexQuantity++] = new Vertex(label);
    }

    public void addEdge(int start, int end, int weight) {
        adjacencyMatrix[start][end] = weight;
    }

    public void path() {
        int startTree = 0;
        vertexList[startTree].setInTree(true);
        treeQuantity = 1;

        for (int index = 0; index < vertexQuantity; index++) {
            int temp = adjacencyMatrix[startTree][index];
            paths[index] = new DistanceParent(startTree, temp);
        }

        while (treeQuantity < vertexQuantity) {
            int min = getMin();
            int minDistance = paths[min].getDistance();

            if (minDistance == INFINITY) {
                System.out.println("There are unreachable vertices");
                break;
            } else {
                currentVertex = min;
                startToCurrent = paths[min].getDistance();
            }
            vertexList[currentVertex].setInTree(true);
            treeQuantity++;
            adjacencyPath();
        }

        displayPaths();

        treeQuantity = 0;
        for (int index = 0; index < vertexQuantity; index++) {
            vertexList[index].setInTree(false);
        }
    }

    private int getMin() {
        int minDistance = INFINITY;
        int min = 0;

        for (int index = 1; index < vertexQuantity; index++) {
            if (!vertexList[index].isInTree() && paths[index].getDistance() < minDistance) {
                minDistance = paths[index].getDistance();
                min = index;
            }
        }
        return min;
    }

    private void adjacencyPath() {
        int column = 1;

        while (column < vertexQuantity) {
            if (vertexList[column].isInTree()) {
                column++;
                continue;
            }
            int currentToFringe = adjacencyMatrix[currentVertex][column];
            int startToFringe = startToCurrent + currentToFringe;
            int pathDistance = paths[column].getDistance();

            if (startToFringe < pathDistance) {
                paths[column].setParentVertex(currentVertex);
                paths[column].setDistance(startToFringe);
            }
            column++;
        }

    }

    private void displayPaths() {
        for (int index = 0; index < vertexQuantity; index++) {
            System.out.print(vertexList[index].getLabel() + "=");
            if (paths[index].getDistance() == INFINITY) {
                System.out.print("inf");
            } else {
                System.out.print(paths[index].getDistance());
            }

            char parent = vertexList[paths[index].getParentVertex()].getLabel();
            System.out.print("(" + parent + ")");
        }
        System.out.println();
    }
}
