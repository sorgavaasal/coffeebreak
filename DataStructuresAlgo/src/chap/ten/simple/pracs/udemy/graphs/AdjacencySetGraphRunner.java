package chap.ten.simple.pracs.udemy.graphs;

import java.util.List;

import chap.ten.simple.pracs.udemy.graphs.Graph.GraphType;

/**
 * Runner program for testing Adjacency Graph
 * @author srividhya
 *
 */
public class AdjacencySetGraphRunner {
	
	public static void main(String[] args) {
		
		AdjacencySetGraph setGraph = new AdjacencySetGraph(5, GraphType.directed);
		setGraph.addEdge(0, 1);
		setGraph.addEdge(0, 2);
		setGraph.addEdge(1, 3);
		setGraph.addEdge(2, 3);
		setGraph.addEdge(4, 1);
		setGraph.addEdge(4, 3);
		
		List<Integer> adjacencyList0 = setGraph.getAdjacentVertices(0);
		System.out.println("===0=== Node");
		adjacencyList0.forEach(System.out::print);

		System.out.println();

		List<Integer> adjacencyList4 = setGraph.getAdjacentVertices(4);
		System.out.println("===4=== Node");
		adjacencyList4.forEach(System.out::print);
 		
	}

}
