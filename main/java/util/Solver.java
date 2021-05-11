/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import colony.Colony;
import graph.EdgeAdapter;
import graph.GraphAdapter;
import graph.NodeAdapter;
import java.io.IOException;
import java.io.PrintWriter;
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
            
            if(i% 10 == 0){
                System.out.println(" iteration " + i + " :" );
                printPheromone(graph);
            }
            colony.findSolutions();
        }
        System.out.println("grafo final " + colony.getBestSolution().toString());

    }

    public void printPheromone(GraphAdapter graph) {
        double[][] matrix = graph.getPheromoneMatrix();

        for (int i = 0; i < matrix.length; i++) {
            String line = "";
            for (int j = 0; j < matrix.length; j++) {
                line += String.format("%.3f", matrix[i][j]) + " , ";
            }
            System.out.println(line);
        }

    }

}
