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
	public double[] calculateProbabilities(NodeAdapter nodeIn, Ant ant) {
		ArrayList<NodeAdapter> nodeNeighbors = ant.getUnvisitedNodes();

		double[] probabilities = new double[nodeNeighbors.size()];

		double probabilitySum = 0;

		for (int i = 0; i < nodeNeighbors.size(); i++) {
			NodeAdapter nodeOut = nodeNeighbors.get(i);
			double probabilityNodeOut = this.calculateScore(nodeIn, nodeOut, ant);
			probabilities[i] = probabilityNodeOut;
			probabilitySum += probabilityNodeOut;
		}

		for (int i = 0; i < nodeNeighbors.size(); i++) {
			probabilities[i] /= probabilitySum;
		}

		return probabilities;
	}

	private double calculateScore(NodeAdapter nodeIn, NodeAdapter nodeOut, Ant ant) {
        double pheromone = ant.getPheromone(nodeIn, nodeOut);
        double cost = 1 /ant.getGraph().getEdge(nodeIn, nodeOut).getCost();

        return Math.pow(pheromone, this.alpha) * Math.pow(cost, this.beta);
    }

}
