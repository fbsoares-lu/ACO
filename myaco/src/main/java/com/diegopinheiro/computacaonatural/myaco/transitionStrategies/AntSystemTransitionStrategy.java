package com.diegopinheiro.computacaonatural.myaco.transitionStrategies;

import java.util.ArrayList;

import com.diegopinheiro.computacaonatural.myaco.colony.Ant;
import com.diegopinheiro.computacaonatural.myaco.graph.NodeAdapter;

public class AntSystemTransitionStrategy extends TransitionStrategy {

	private double alpha;
	private double beta;

	public AntSystemTransitionStrategy(double alpha, double beta) {
		super();
		this.alpha = alpha;
		this.beta = beta;
	}

	@Override
	public double calculateScore(NodeAdapter nodeIn, NodeAdapter nodeOut, Ant ant) {
        double pheromone = ant.getPheromone(nodeIn, nodeOut);
        double cost = 1 /ant.getGraph().getEdge(nodeIn, nodeOut).getCost();

        return Math.pow(pheromone, this.alpha) * Math.pow(cost, this.beta);
    }

}
