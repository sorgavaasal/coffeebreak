package chap.ten.simple.pracs.udemy.graphs;

/**
 * Distance info which has distance to source 
 * and the last vertex has visited 
 * @author srividhya
 *
 */
public class DistanceInfo {
	
	private int distance = -1; 
	private int lastVertex = -1;

	public int getDistance() {
		return distance;
	}
	public DistanceInfo setDistance(int distance) {
		this.distance = distance;
		return this;
	}
	
	public int getLastVertex() {
		return lastVertex;
	}
	public DistanceInfo setLastVertex(int lastVertex) {
		this.lastVertex = lastVertex;
		return this;
	}

}
