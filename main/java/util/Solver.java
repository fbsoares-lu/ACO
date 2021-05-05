/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import colony.Colony;
import graph.GraphAdapter;
import java.util.ArrayList;
import pheromoneStrategy.PheromoneStrategy;
import transitionStrategies.TransitionStrategy;

/**
 *
 * @author deb_c
 */
public class Solver {

    private int maxIterations;
    private int colonySize;
    private TransitionStrategy transitionStrategy;
    private Solution bestSolution;
    private PheromoneStrategy pheromoneStrategy;

    public Solver(int maxIterations, int colonySize, TransitionStrategy transitionStrategy, PheromoneStrategy pheromoneStrategy) {
        this.maxIterations = maxIterations;
        this.colonySize = colonySize;
        this.transitionStrategy = transitionStrategy;
        this.bestSolution = null;
        this.pheromoneStrategy = pheromoneStrategy;
    }

    public void solve(GraphAdapter graph) {
        Colony colony = new Colony(graph, this.colonySize, this.transitionStrategy, pheromoneStrategy);
        for (int i = 0; i < maxIterations; i++) {
            colony.findSolutions();
        }
        System.out.println("grafo final " + colony.getBestSolution().toString());

    }
}
