package com.company.algoritms.examples.graph.dijkstrasalgorithm;

public class DistanceParent {
    private int distance;
    private int parentVertex;

    public DistanceParent(int parentVertex, int distance) {
        this.distance = distance;
        this.parentVertex = parentVertex;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getParentVertex() {
        return parentVertex;
    }

    public void setParentVertex(int parentVertex) {
        this.parentVertex = parentVertex;
    }
}
