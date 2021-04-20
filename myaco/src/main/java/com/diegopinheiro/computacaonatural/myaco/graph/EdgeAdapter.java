package com.diegopinheiro.computacaonatural.myaco.graph;

public class EdgeAdapter {

	private NodeAdapter nodeIn;
	private NodeAdapter nodeOut;
	private double cost;
	private double pheromone;
	
	public EdgeAdapter(NodeAdapter nodeIn, NodeAdapter nodeOut) {
		this.nodeIn = nodeIn;
		this.nodeOut = nodeOut;
		this.cost = 0;
		this.pheromone = 0;		
	}
	
	public EdgeAdapter(NodeAdapter nodeIn, NodeAdapter nodeOut, double cost) {
		this.nodeIn = nodeIn;
		this.nodeOut = nodeOut;
		this.cost = cost;
		this.pheromone = 0;		
	}

	public NodeAdapter getNodeIn() {
		return nodeIn;
	}

	public void setNodeIn(NodeAdapter nodeIn) {
		this.nodeIn = nodeIn;
	}

	public NodeAdapter getNodeOut() {
		return nodeOut;
	}

	public void setNodeOut(NodeAdapter nodeOut) {
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof EdgeAdapter) {
			EdgeAdapter aEdge = (EdgeAdapter)obj;
			return this.nodeIn.equals(aEdge.nodeIn) && this.nodeOut.equals(nodeOut);
		}
		return false;
	}
	
	
}
