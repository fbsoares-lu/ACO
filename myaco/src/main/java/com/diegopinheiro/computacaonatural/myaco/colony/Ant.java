/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopinheiro.computacaonatural.myaco.colony;

import java.util.ArrayList;

import com.diegopinheiro.computacaonatural.myaco.graph.GraphAdapter;
import com.diegopinheiro.computacaonatural.myaco.graph.NodeAdapter;
import com.diegopinheiro.computacaonatural.myaco.transitionStrategies.TransitionStrategy;
import com.diegopinheiro.computacaonatural.myaco.util.RouletteWheel;
import com.diegopinheiro.computacaonatural.myaco.util.Solution;

/**
 *
 * @author deb_c
 */
public class Ant {
    
	private int id;
	private double alpha;
    private double beta;
    private GraphAdapter graph; 
    private Solution currentSolution;
    private TransitionStrategy transitionStrategy;
    private ArrayList<NodeAdapter> unvisitedNodes;
    private RouletteWheel rouletteWheel;
    
    public Ant(int id, 
    		GraphAdapter graph, 
    		TransitionStrategy transitionStrategy) {
    	this.id = id;
    	this.graph = graph;
    	this.transitionStrategy = transitionStrategy;
    	this.currentSolution = null;
    	this.unvisitedNodes = new ArrayList<NodeAdapter>();
    	this.rouletteWheel  = new RouletteWheel();
    }
    
    public GraphAdapter getGraph() {
    	return this.graph;
    }
    
    
    public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	public double getBeta() {
		return beta;
	}

	public void setBeta(double beta) {
		this.beta = beta;
	}

	public TransitionStrategy getTransitionStrategy() {
		return transitionStrategy;
	}

	public void setTransitionStrategy(TransitionStrategy transitionStrategy) {
		this.transitionStrategy = transitionStrategy;
	}

	public void setGraph(GraphAdapter graph) {
		this.graph = graph;
	}

	public Solution findSolution(){
		// ArrayList<NodeAdapter> unvisitedNodes = this.graph.getNodes();
        this.unvisitedNodes = this.graph.getNodes();
    	
    	NodeAdapter firstRandomNode = this.getFirstNode();
    	
    	Solution foundSolution = new Solution(this.graph);
    	foundSolution.openSolution(firstRandomNode);
    	unvisitedNodes.remove(firstRandomNode);
    	
    	while (!unvisitedNodes.isEmpty()) {
    		NodeAdapter nextNode = this.choseNextNode(foundSolution);
    		foundSolution.addNode(nextNode);
    		unvisitedNodes.remove(nextNode);
    	}
    
    	foundSolution.closeSolution();
 
    	return foundSolution;
    }
	
	public void depositPheromone() {
		double cost = this.currentSolution.getCost();
    	
    }
    
    private NodeAdapter choseNextNode(Solution foundSolution) {
    	NodeAdapter currentNode = foundSolution.curentNode();
    	ArrayList<NodeAdapter> nodeNeighbors = this.unvisitedNodes; // simplifying for TSP
    	
    	double[] probabilities = this.transitionStrategy.calculateProbabilities(currentNode, this);
    	
    	NodeAdapter chosenNode = this.rouletteWheel.returnChoice(probabilities, nodeNeighbors);
    	return chosenNode ;
    	
	}

	private NodeAdapter getFirstNode() {
    	int randomIndex = (int)(Math.random() * this.graph.getNodes().size());    	
    	NodeAdapter firstRandomNode = null;
    	
    	int i = 0;
    	for (NodeAdapter n : this.graph.getNodes()) {
    		if(i == randomIndex) {
    			firstRandomNode = n;
    			break;
    		}
    		i++;
    	}
    	
    	return firstRandomNode;
    }
    
    public double getPheromone(NodeAdapter nodeId, NodeAdapter nodeOut) {
    	return this.graph.getPheromone(nodeId, nodeOut);
    }
    
    public void findNextNode(){
    
    }
    
    public double fitness() {
    	return this.currentSolution.getCost();
    }
    
    
    
    public ArrayList<NodeAdapter> getUnvisitedNodes() {
    	return this.unvisitedNodes;
    }
    
}
