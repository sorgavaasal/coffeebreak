package chap.ten.simple.pracs.udemy.graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjacencySetGraph implements Graph {
	
	List<NodeGraph> vertexList;
	GraphType graphType;
	int verticesNumber = 0;
	
	public AdjacencySetGraph(int verticesNumber, GraphType graphType) {
		this.verticesNumber = verticesNumber;
		this.graphType = graphType;
		vertexList = new ArrayList<>();
		
		for (int i = 0; i < verticesNumber; ++i) {
			vertexList.add(new NodeGraph(i));
		}
	}
	

	@Override
	public void addEdge(int v1, int v2) {
		this.vertexList.get(v1).addEdge(v2);
	}

	@Override
	public List<Integer> getAdjacentVertices(int v) {
		return this.vertexList.get(v).getAdjacencyList();
	}

}
