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
public abstract class TransitionStrategy {

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

    public abstract double calculateScore(NodeAdapter nodeIn, NodeAdapter nodeOut, Ant ant);
}
