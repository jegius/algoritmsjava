package com.company.algoritms.examples.graph;

import com.company.algoritms.examples.stack.SimpleStack;

public class Graph {
    private final int MAX_VERTEXES = 20;
    private Vertex vertexList[];
    private int adjacencyMatrix[][];
    private int vertexQuantity;
    private SimpleStack simpleStack;

    Graph() {
        vertexList = new Vertex[MAX_VERTEXES];
        adjacencyMatrix = new int[MAX_VERTEXES][MAX_VERTEXES];
        vertexQuantity = 0;
        simpleStack = new SimpleStack(100);

        for (int index = 0; index < MAX_VERTEXES; index++) {
            for (int innerIndex = 0; innerIndex < MAX_VERTEXES; innerIndex++){
                adjacencyMatrix[index][innerIndex] = 0;
            }
        }
    }

    public void addVertex(char mark) {
        vertexList[vertexQuantity++] = new Vertex(mark);
    }

    public void walkInDepth() {
        vertexList[0].setVisited(true);
        displayVertex(0);
        simpleStack.push(0);

        while (!simpleStack.isEmpty()) {
            int vertex = getAdjacencyUnvisitedVertex((int) simpleStack.peek());

            if (vertex == -1) {
                simpleStack.pop();
            } else {
                vertexList[vertex].setVisited(true);
                displayVertex(vertex);
                simpleStack.push(vertex);
            }
        }

        for (int index = 0; index < vertexQuantity; index++) {
            vertexList[index].setVisited(false);
        }
    }

    public void addEdge(int start, int end) {
        adjacencyMatrix[start][end] = 1;
        adjacencyMatrix[end][start] = 1;
    }

    private int getAdjacencyUnvisitedVertex(int vertex) {
        for (int index = 0; index < vertexQuantity; index++) {
            if (adjacencyMatrix[vertex][index] == 1 && !vertexList[index].isVisited()) {
                return index;
            }
        }
        return  -1;
    }

    void displayVertex(int vertexIndex){
        System.out.print(vertexList[vertexIndex].getLabel());
    }
}
