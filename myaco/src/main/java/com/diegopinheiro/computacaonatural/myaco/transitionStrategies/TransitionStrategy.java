package com.diegopinheiro.computacaonatural.myaco.transitionStrategies;

import com.diegopinheiro.computacaonatural.myaco.colony.Ant;
import com.diegopinheiro.computacaonatural.myaco.graph.NodeAdapter;

public abstract class TransitionStrategy {
	
	public abstract double[] calculateProbabilities(NodeAdapter nodeId, Ant ant);
}
