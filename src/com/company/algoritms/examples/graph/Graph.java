package com.company.algoritms.examples.graph;
import com.company.algoritms.examples.queue.SimpleQueue;
import com.company.algoritms.examples.stack.SimpleStack;

public class Graph {
    final int MAX_VERTEXES = 20;
    int[][] adjacencyMatrix;
    int vertexQuantity;
    Vertex[] vertexList;

    /**
     * Нужен для обхода в глубину
     */
    private SimpleStack simpleStack;

    /**
     * Нужен для обхода в ширину.
     */
    private SimpleQueue simpleQueue;

    Graph() {
        this.vertexList = new Vertex[MAX_VERTEXES];
        this.adjacencyMatrix = new int[MAX_VERTEXES][MAX_VERTEXES];
        this.vertexQuantity = 0;
        this.simpleStack = new SimpleStack(100);
        this.simpleQueue = new SimpleQueue(100);

        for (int index = 0; index < MAX_VERTEXES; index++) {
            for (int innerIndex = 0; innerIndex < MAX_VERTEXES; innerIndex++) {
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

    public void miniPanningTree() {
        vertexList[0].setVisited(true);
        simpleStack.push(0);

        while (!simpleStack.isEmpty()) {
            int currentVertex = (int) simpleStack.peek();
            int vertex = getAdjacencyUnvisitedVertex(currentVertex);

            if (vertex == -1) {
                simpleStack.pop();
            } else {
                vertexList[vertex].setVisited(true);
                simpleStack.push(vertex);

                displayVertex(currentVertex);
                displayVertex(vertex);
                System.out.print(" ");
            }
        }

        for (int index = 0; index < vertexQuantity; index++) {
            vertexList[index].setVisited(false);
        }
    }

    public void wideWalk() {
        vertexList[0].setVisited(true);
        displayVertex(0);
        simpleQueue.insert(0L);
        int secondVertex;

        while (!simpleQueue.isEmpty()) {
            int firstVertex = simpleQueue.remove().intValue();

            while ((secondVertex = getAdjacencyUnvisitedVertex(firstVertex)) != -1) {
                vertexList[secondVertex].setVisited(true);
                displayVertex(secondVertex);
                simpleQueue.insert((long) secondVertex);
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
        return -1;
    }

    void displayVertex(int vertexIndex) {
        System.out.print(vertexList[vertexIndex].getLabel());
    }
}
