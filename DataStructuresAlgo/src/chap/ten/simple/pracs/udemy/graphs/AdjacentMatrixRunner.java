package chap.ten.simple.pracs.udemy.graphs;

import java.util.List;

/**
 * Executes adjacent matrix 
 * @author Srividhya
 *
 */
public class AdjacentMatrixRunner {

	public static void main(String[] args) {
		
		AdjacentMatrix adjacentMatrix = new AdjacentMatrix(5, Graph.GraphType.directed);
		adjacentMatrix.addEdge(0, 1);
		adjacentMatrix.addEdge(0, 2);
		adjacentMatrix.addEdge(1, 3);
		adjacentMatrix.addEdge(2, 4);
		adjacentMatrix.addEdge(4, 2);
		adjacentMatrix.addEdge(4, 3);
		
		System.out.println("Edge value for node 4 ");
		
		List<Integer> adjacentList4 = adjacentMatrix.getAdjacentVertices(4);
		for (int i : adjacentList4)
			System.out.println(i);
		
		System.out.println("Edge value for node ");
		
		List<Integer> adjacentList2 = adjacentMatrix.getAdjacentVertices(2);
		for (int i : adjacentList2)
			System.out.println(i);
	}
}
