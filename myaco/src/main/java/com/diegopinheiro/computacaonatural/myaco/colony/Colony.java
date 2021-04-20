/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopinheiro.computacaonatural.myaco.colony;

import java.util.ArrayList;

import com.diegopinheiro.computacaonatural.myaco.graph.GraphAdapter;
import com.diegopinheiro.computacaonatural.myaco.transitionStrategies.TransitionStrategy;
import com.diegopinheiro.computacaonatural.myaco.util.Solution;



/**
 *
 * @author deb_c
 */
public class Colony {
	
	private ArrayList<Ant> ants;
	private int size;
	private GraphAdapter graph;
	private TransitionStrategy transitionStrategy;
	private Solution bestSolution;
	private ArrayList<Solution> currentSolutions;
    
	public Colony(
			GraphAdapter graph, 
			int size, 
			TransitionStrategy transitionStrategy) {
		
		this.ants = new ArrayList<Ant>();
		this.size = size;
		this.graph = graph;
		this.transitionStrategy = transitionStrategy;
		this.initializeAnts();
		this.bestSolution = new Solution(graph, Double.MAX_VALUE);
	}
	
	private void initializeAnts(){
		this.ants = new ArrayList<Ant>();
		for (int i = 0; i < this.size; i++) {
			Ant ant = new Ant(i, this.graph, this.transitionStrategy);
			ants.add(ant);
		}
		
	}
    public void findSolutions(){
    	ArrayList<Solution> currentSolutions = new ArrayList<Solution>();
    	for (Ant ant: this.ants) {
    		Solution currentSolution = ant.findSolution();
    		currentSolutions.add(currentSolution);
    		if (currentSolution.getCost() < this.bestSolution.getCost()) {
    			this.bestSolution = currentSolution;
    		}
    	}
    	this.currentSolutions = currentSolutions;
    }
}
