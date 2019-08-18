package com.company.algoritms.examples.graph;

import com.company.algoritms.enums.ExampleType;
import com.company.algoritms.examples.Example;

public class GraphExample implements Example {
    private final ExampleType type;

    public GraphExample(ExampleType type) {
        this.type = type;
    }

    @Override
    public void showExample() {
        walkInDepth();
    }

    private void walkInDepth() {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        System.out.print("Visits: ");
        graph.walkInDepth();
        System.out.println();
    }

    @Override
    public ExampleType getType() {
        return type;
    }
}
