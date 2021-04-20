/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aco;

import java.util.ArrayList;

import aco.graph.Node;

/**
 *
 * @author deb_c
 */
public class Solution {
    
	private ArrayList<Node> visitedNodes;
	
//	private ArrayList<Edges> visitedEdges;
	private double cost;
	
	
	public Solution() {
		this.visitedNodes = new ArrayList<Node>();
		this.cost = 0;
	}
	
	public void openSolution(Node node) {
		this.visitedNodes.add(node);
	}
	
	public void closeSolution() {
		Node firstNode = this.visitedNodes.get(0);
		this.addNode(firstNode);
	}
	
	

	public void addNode(Node node) {
		this.visitedNodes.add(node);
//		this.cost += cost do edge do graph; !
	}
	
	public Node curentNode() {
		int size = this.visitedNodes.size();
		return this.visitedNodes.get(size-1);
	}
	
	public double getCost() {
		return this.cost;
	}
}
