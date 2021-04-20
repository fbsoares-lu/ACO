package aco.transitionStrategies;

import aco.Ant;
import aco.graph.Node;

public abstract class CalculateTransitionStrategy {
	
	public abstract double probability(Node nodeId, Node nodeOut, Ant ant);
}
