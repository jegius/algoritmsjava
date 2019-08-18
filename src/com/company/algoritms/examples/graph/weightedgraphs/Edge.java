package com.company.algoritms.examples.graph.weightedgraphs;

public class Edge {
    private int sourceVertex;
    private int endVertex;
    private int distance;

    public int getSourceVertex() {
        return sourceVertex;
    }

    public void setSourceVertex(int sourceVertex) {
        this.sourceVertex = sourceVertex;
    }

    public int getEndVertex() {
        return endVertex;
    }

    public void setEndVertex(int endVertex) {
        this.endVertex = endVertex;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Edge(int sourceVertex, int endVertex, int distance) {
        this.sourceVertex = sourceVertex;
        this.endVertex = endVertex;
        this.distance = distance;
    }
}
