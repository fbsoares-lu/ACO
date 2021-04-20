/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aco;

import java.util.ArrayList;

import aco.graph.Graph;
import aco.graph.Node;
import aco.transitionStrategies.CalculateTransitionStrategy;

/**
 *
 * @author deb_c
 */
public class Ant {
    
	private double alpha;
    private double beta;
    private Graph graph; 
    private CalculateTransitionStrategy transitionStrategy;
    
    public Ant(double alpha, 
    		double beta, 
    		Graph graph, 
    		CalculateTransitionStrategy transitionStrategy) {
    	this.alpha = alpha;
    	this.beta = beta;
    	this.graph = graph;
    	this.transitionStrategy = transitionStrategy;
    }
    
    public Graph getGraph() {
    	return this.graph;
    }
    
    public Solution findSolution(){
    	ArrayList<Node> unvisitedNodes = this.graph.getNodes();
    	
    	Node firstRandomNode = this.getFirstNode();
    	
    	Solution foundSolution = new Solution();
    	foundSolution.openSolution(firstRandomNode);
    	unvisitedNodes.remove(firstRandomNode);
    	
    	while (!unvisitedNodes.isEmpty()) {
    		Node nextNode = this.choseNextNode(foundSolution, unvisitedNodes);
    		foundSolution.addNode(nextNode);
    		unvisitedNodes.remove(nextNode);
    	}
    
    	foundSolution.closeSolution();
 
    	return foundSolution;
    }
    
    private Node choseNextNode(Solution foundSolution, ArrayList<Node> unvisitedNodes) {
    	Node currentNode = foundSolution.curentNode();
    	ArrayList<Node> nodeNeighbors = unvisitedNodes; // simplifying for TSP
    	double probabilitySum = 0;
    	double[] probabilities = new double[nodeNeighbors.size()];
    	for (int i = 0; i < nodeNeighbors.size(); i++) {
    		Node nodeOut = nodeNeighbors.get(i);
    		double probabilityNodeOut = this.transitionStrategy.probability(currentNode, nodeOut, this); 
    		probabilities[i] = probabilityNodeOut;
    		probabilitySum += probabilityNodeOut;
    	}
    	
    	for (int i = 0; i < nodeNeighbors.size(); i++) {
    		probabilities[i] /=  probabilitySum;
    	}
    	
    	RouletteWheel rouletteWheel = new RouletteWheel();
    	Node chosenNode = rouletteWheel.returnChoice(probabilities, nodeNeighbors);
    	return chosenNode ;
    	
	}

	private Node getFirstNode() {
    	int randomIndex = (int)(Math.random() * this.graph.getNodes().size());    	
    	Node firstRandomNode = null;
    	
    	int i = 0;
    	for (Node n : this.graph.getNodes()) {
    		if(i == randomIndex) {
    			firstRandomNode = n;
    			break;
    		}
    		i++;
    	}
    	
    	return firstRandomNode;
    }
    
    
    
    public void findNextNode(){
    
    }
    
    public double fitness() {
    	
    }
    
    public void depositPheromone() {
    	
    }
    
}
