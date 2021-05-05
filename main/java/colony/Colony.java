/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colony;

import graph.EdgeAdapter;
import graph.GraphAdapter;
import java.util.ArrayList;
import pheromoneStrategy.PheromoneStrategy;
import pheromoneStrategy.SACOPheromoneStrategy;
import transitionStrategies.TransitionStrategy;
import util.Solution;

/**
 *
 * @author deb_c
 */
public class Colony {

    private ArrayList<Ant> ants;
    private int size;
    private GraphAdapter graph;
    private TransitionStrategy transitionStrategy;
    private Solution bestSolution;
    private ArrayList<Solution> currentSolutions;
    private PheromoneStrategy pheromonesStrategy;

    public Colony(
            GraphAdapter graph,
            int size,
            TransitionStrategy transitionStrategy, PheromoneStrategy pheromonesStrategy) {

        this.ants = new ArrayList<Ant>();
        this.size = size;
        this.graph = graph;
        this.transitionStrategy = transitionStrategy;
        this.initializeAnts();
        this.bestSolution = new Solution(graph, Double.MAX_VALUE);
        this.pheromonesStrategy = pheromonesStrategy;
        this.initializePheromone();
    }

    private void initializeAnts() {
        this.ants = new ArrayList<Ant>();
        for (int i = 0; i < this.size; i++) {

            Ant ant = new Ant(i, this.graph, this.transitionStrategy);
            ants.add(ant);
        }

    }

    public Solution getBestSolution() {

        return bestSolution;
    }

    public void findSolutions() {
        ArrayList<Solution> currentSolutions = new ArrayList<Solution>();
        for (Ant ant : this.ants) {
            Solution currentSolution = ant.findSolution();
            currentSolutions.add(currentSolution);
            if (currentSolution.getCost() < this.bestSolution.getCost()) {
                this.bestSolution = currentSolution;
                
            }

            updatePheromone();
        }
        System.out.println(bestSolution.getCost());
        this.currentSolutions = currentSolutions;
    }

    public GraphAdapter getGraph() {
        return graph;
    }

    public void updatePheromone() {
        this.pheromonesStrategy.updatePheromoneGlobal(this);
        for (Ant ant : this.ants) {
            this.pheromonesStrategy.updatePheromoneLocal(ant);
        }
    }

    private void initializePheromone() {
        for (EdgeAdapter edge : this.graph.getEdges()) {
            edge.setPheromone(Math.random());
        }
    }

}
