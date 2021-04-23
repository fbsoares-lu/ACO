package com.diegopinheiro.computacaonatural.myaco.transitionStrategies;

import java.util.ArrayList;

import com.diegopinheiro.computacaonatural.myaco.colony.Ant;
import com.diegopinheiro.computacaonatural.myaco.graph.NodeAdapter;



public class SACOTransitionStrategy extends TransitionStrategy{

	private double alpha;
	
	
	public SACOTransitionStrategy(double alpha) {
		this.alpha = alpha;
		
	}
	
	@Override
	public double calculateScore(NodeAdapter nodeIn, NodeAdapter nodeOut, Ant ant) {
		double pheromone = ant.getPheromone(nodeIn, nodeOut);
		return Math.pow(pheromone, this.alpha);
	}

}
