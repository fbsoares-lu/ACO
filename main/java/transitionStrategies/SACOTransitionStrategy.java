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
public class SACOTransitionStrategy extends TransitionStrategy {

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
