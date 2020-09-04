package chap.ten.simple.pracs.udemy.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Stores nodes information to be used in 
 * the Graph 
 * @author srividhya
 *
 */
public class NodeGraph {
	
	private int vertexNumber;
	
	private Set<Integer> adjacencySet = new HashSet<>();
	
	public NodeGraph(int vertexNumber) {
		this.vertexNumber = vertexNumber;
	}
	
	public void addEdge(int vertexNumber) {
		this.adjacencySet.add(vertexNumber);
	}
	
	public List<Integer> getAdjacencyList() {
		List<Integer> returnList = new ArrayList<>(adjacencySet);
		Collections.sort(returnList);
		return returnList;
	}
	

}
