package chap.ten.simple.pracs.udemy.graphs;

import java.util.List;

/**
 * First simple graph interface 
 * @author srividhya
 *
 */
public interface Graph {
	
	public enum GraphType {
		directed, undirected;
	}
	
	public void addEdge(int v1, int v2);
	
	public List<Integer> getAdjacentVertices(int v);
}
