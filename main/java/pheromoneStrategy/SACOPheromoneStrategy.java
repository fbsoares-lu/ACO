/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pheromoneStrategy;

import colony.Ant;
import colony.Colony;
import graph.EdgeAdapter;
import graph.GraphAdapter;
import graph.NodeAdapter;
import java.util.ArrayList;
import util.Solution;

/**
 *
 * @author deb_c
 */
public class SACOPheromoneStrategy extends PheromoneStrategy {

    private double rho;

    public SACOPheromoneStrategy(double rho) {
        this.rho = rho;
    }

    @Override
    public void updatePheromoneGlobal(Colony colony) {
        GraphAdapter graph = colony.getGraph();
        for (EdgeAdapter edge : graph.getEdges()) {
            double pheromone = edge.getPheromone();
            double reducedPheromone = pheromone * (1 - this.rho);
            edge.setPheromone(reducedPheromone);
        }
    }

    @Override
    public void updatePheromoneLocal(Ant ant) {

    }

    @Override
    public void depositPheromone(Colony colony) {
     
        for(Ant ant: colony.getAnts()){
            Solution solution =  ant.getSolution();
            double reinforcement = 1/solution.getCost();
            for(EdgeAdapter edgeAdapter : solution.getVisitedEdges()){
                double pheromone = edgeAdapter.getPheromone();
                pheromone += reinforcement;
                edgeAdapter.setPheromone(pheromone);
            }
        }
    }

}
