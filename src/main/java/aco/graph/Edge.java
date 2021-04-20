package aco.graph;

public class Edge {

	private Node nodeIn;
	private Node nodeOut;
	private double cost;
	private double pheromone;
	
	public Edge(Node nodeId, Node nodeOut) {
		this.nodeIn = nodeIn;
		this.nodeOut = nodeOut;
	}

	public Node getNodeIn() {
		return nodeIn;
	}

	public void setNodeIn(Node nodeIn) {
		this.nodeIn = nodeIn;
	}

	public Node getNodeOut() {
		return nodeOut;
	}

	public void setNodeOut(Node nodeOut) {
		this.nodeOut = nodeOut;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getPheromone() {
		return pheromone;
	}

	public void setPheromone(double pheromone) {
		this.pheromone = pheromone;
	}
	
	
}
