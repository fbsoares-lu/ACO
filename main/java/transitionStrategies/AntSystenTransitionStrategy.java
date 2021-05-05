/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transitionStrategies;

import colony.Ant;
import graph.NodeAdapter;
import java.util.ArrayList;

/**
 *
 * @author deb_c
 */
public class AntSystenTransitionStrategy extends TransitionStrategy {

    private double alpha;
    private double beta;

    public AntSystenTransitionStrategy(double alpha, double beta) {
        super();
        this.alpha = alpha;
        this.beta = beta;
    }

    @Override
    public double calculateScore(NodeAdapter nodeIn, NodeAdapter nodeOut, Ant ant) {
        double pheromone = ant.getPheromone(nodeIn, nodeOut);
        double cost = 1 / ant.getGraph().getEdge(nodeIn, nodeOut).getCost();

        return Math.pow(pheromone, this.alpha) * Math.pow(cost, this.beta);
    }
}
