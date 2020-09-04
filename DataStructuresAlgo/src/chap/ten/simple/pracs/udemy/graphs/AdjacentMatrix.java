package chap.ten.simple.pracs.udemy.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Graph storage adjacent matrix 
 * @author srividhya
 *
 */
public class AdjacentMatrix implements Graph {
	
	private int[][] adjacentMatrix;
	
	private int verticesNumber;
	
	private GraphType graphType;
	
	public AdjacentMatrix(int verticesNumber, GraphType graphType) {
		this.verticesNumber = verticesNumber;
		this.graphType = graphType;
		
		adjacentMatrix = new int[verticesNumber][verticesNumber];
		
		for (int i = 0; i < verticesNumber; ++i) {
			for (int j = 0; j < verticesNumber; ++j) {
				adjacentMatrix[i][j] = 0;
			}
		}
	}
	

	@Override
	public void addEdge(int v1, int v2) {
		adjacentMatrix[v1] [v2] = 1;
		
		if (this.graphType == Graph.GraphType.undirected)
			adjacentMatrix[v2][v1] = 1;
	}
	
	@Override
	public List<Integer> getAdjacentVertices(int v) {
		
		List<Integer> returnList = new ArrayList<>();
		
		for (int i = 0; i < verticesNumber; ++i) {
			if (adjacentMatrix[v][i] == 1) {
				returnList.add(i);
			}
		}
		
		return returnList;
	}

}
