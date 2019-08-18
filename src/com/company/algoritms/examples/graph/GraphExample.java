package com.company.algoritms.examples.graph;

import com.company.algoritms.enums.ExampleType;
import com.company.algoritms.examples.Example;
import com.company.algoritms.examples.graph.dijkstrasalgorithm.DijkstraGraph;
import com.company.algoritms.examples.graph.weightedgraphs.WeightedGraph;

public class GraphExample implements Example {
    private final ExampleType type;

    public GraphExample(ExampleType type) {
        this.type = type;
    }

    @Override
    public void showExample() {
        walkInDepth();
        miniPanningTree();
        topographyGraph();
        weightedGraph();
        dijkstra();
    }

    private void dijkstra() {
        DijkstraGraph dijkstraGraph = new DijkstraGraph();
        dijkstraGraph.addVertex('A');
        dijkstraGraph.addVertex('B');
        dijkstraGraph.addVertex('C');
        dijkstraGraph.addVertex('D');
        dijkstraGraph.addVertex('E');
        dijkstraGraph.addEdge(0, 1, 50);
        dijkstraGraph.addEdge(0, 3, 80);
        dijkstraGraph.addEdge(1, 2, 60);
        dijkstraGraph.addEdge(1, 3, 90);
        dijkstraGraph.addEdge(2, 4, 40);
        dijkstraGraph.addEdge(3, 2, 20);
        dijkstraGraph.addEdge(3, 4, 70);
        dijkstraGraph.addEdge(4, 1, 50);

        System.out.println("Shortest paths");
        dijkstraGraph.path();
        System.out.println();
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

        System.out.print("Visits: ");
        graph.wideWalk();
        System.out.println();

        System.out.print("Visits: ");
        graph.miniPanningTree();
        System.out.println();
    }

    private void weightedGraph() {
        WeightedGraph weightedGraph = new WeightedGraph();
        weightedGraph.addVertex('A');
        weightedGraph.addVertex('B');
        weightedGraph.addVertex('C');
        weightedGraph.addVertex('D');
        weightedGraph.addVertex('E');
        weightedGraph.addVertex('F');

        weightedGraph.addEdge(0, 1, 6);
        weightedGraph.addEdge(0, 3, 4);
        weightedGraph.addEdge(1, 2, 10);
        weightedGraph.addEdge(1, 3, 7);
        weightedGraph.addEdge(1, 4, 7);
        weightedGraph.addEdge(2, 3, 8);
        weightedGraph.addEdge(2, 4, 5);
        weightedGraph.addEdge(2, 5, 6);
        weightedGraph.addEdge(3, 4, 12);
        weightedGraph.addEdge(4, 5, 7);

        System.out.print("Minimum spanning tree: ");
        weightedGraph.getMinimumSpanningTree();
        System.out.println();

    }

    private void topographyGraph() {
        TopographyGraph graph = new TopographyGraph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');

        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

        graph.topography();
    }

    private void miniPanningTree() {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        System.out.print("Visits: ");
        graph.miniPanningTree();
        System.out.println();
    }

    @Override
    public ExampleType getType() {
        return type;
    }
}
