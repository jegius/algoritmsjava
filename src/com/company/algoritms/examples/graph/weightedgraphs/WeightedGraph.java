package com.company.algoritms.examples.graph.weightedgraphs;


public class WeightedGraph {
    private final int MAX_VERTEX = 20;
    private final int INFINITY = 1000000;
    private Vertex vertexList[];
    private int[][] adjacencyMatrix;
    private int vertexQuantity;
    private int currentVertex;
    private PriorityQueue priorityQueue;
    private int treeQuantity;

    public WeightedGraph() {
        this.vertexList = new Vertex[MAX_VERTEX];
        this.adjacencyMatrix = new int[MAX_VERTEX][MAX_VERTEX];
        this.vertexQuantity = 0;

        for (int index = 0; index < MAX_VERTEX; index++) {
            for (int innerIndex = 0; innerIndex < MAX_VERTEX; innerIndex++) {
                adjacencyMatrix[index][innerIndex] = INFINITY;
            }
        }

        priorityQueue = new PriorityQueue();
    }

    public void addVertex(char label) {
        vertexList[vertexQuantity++] = new Vertex(label);
    }

    public void addEdge(int start, int end, int weight) {
        adjacencyMatrix[start][end] = weight;
        adjacencyMatrix[end][start] = weight;
    }

    public void display(int vertex) {
        System.out.println(vertexList[vertex].getLabel());
    }

    public void getMinimumSpanningTree() {
        currentVertex = 0;
        while (treeQuantity < vertexQuantity - 1) {
            vertexList[currentVertex].setInTree(true);
            treeQuantity++;

            for (int index = 0; index < vertexQuantity; index++) {
                if (index == currentVertex) {
                    continue;
                }
                if (vertexList[index].isInTree()){
                    continue;
                }
                int distance = adjacencyMatrix[currentVertex][index];

                if (distance == INFINITY) {
                    continue;
                }
                putInPriorityQueue(index, distance);
            }
            if (priorityQueue.size() == 0) {
                System.out.println("GRAPH NOT CONNECTED");
                return;
            }
            Edge edge = priorityQueue.removeMin();
            int sourceVertex = edge.getSourceVertex();
            currentVertex = edge.getEndVertex();

            System.out.print(vertexList[sourceVertex].getLabel());
            System.out.print(vertexList[currentVertex].getLabel());
            System.out.print(" ");
        }

        for (int index = 0; index < vertexQuantity; index++) {
            vertexList[index].setInTree(false);
        }
    }

    public void putInPriorityQueue(int newVertex, int newDistance) {
        int queueIndex = priorityQueue.find(newVertex);

        if (queueIndex != -1) {
            Edge temp = priorityQueue.peekPosition(queueIndex);
            int oldDistance = temp.getDistance();

            if (oldDistance > newDistance) {
                priorityQueue.removeByPosition(queueIndex);
                Edge edge = new Edge(currentVertex, newVertex, newDistance);
                priorityQueue.insert(edge);
            }
        } else {
            Edge edge = new Edge(currentVertex, newVertex,  newDistance);
            priorityQueue.insert(edge);
        }
    }
}
