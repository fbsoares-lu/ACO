/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopinheiro.computacaonatural.myaco.util;

import com.diegopinheiro.computacaonatural.myaco.colony.Colony;
import com.diegopinheiro.computacaonatural.myaco.graph.GraphAdapter;
import com.diegopinheiro.computacaonatural.myaco.transitionStrategies.TransitionStrategy;




/**
 *
 * @author deb_c
 */
public class Solver {
        
	private int maxIterations; 
	private int colonySize;
	private TransitionStrategy transitionStrategy;
	private Solution bestSolution;

	public Solver(int maxIterations, int colonySize, TransitionStrategy transitionStrategy) {
		this.maxIterations = maxIterations;
		this.colonySize = colonySize;
		this.transitionStrategy = transitionStrategy;
		this.bestSolution = null;
		
	}
	 
    public void solve(GraphAdapter graph) {
    	Colony colony = new Colony(graph, this.colonySize, this.transitionStrategy);
    	for(int i = 0; i < maxIterations; i ++) {
    		colony.findSolutions();
    	}
    	
    	
    }
    

    
}
