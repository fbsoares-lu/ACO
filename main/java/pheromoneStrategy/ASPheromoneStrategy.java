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

/**
 *
 * @author deb_c
 */
public class ASPheromoneStrategy extends PheromoneStrategy{

    private double rho;
    
    public ASPheromoneStrategy(double rho) {
		super();
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
        
        double sum = 0;
        
        for (EdgeAdapter edge : graph.getEdges()) {
        	sum += edge.getPheromone();
        }
        
        for (EdgeAdapter edge : graph.getEdges()) {
        	double newPheromone = edge.getPheromone() + sum;
        	edge.setPheromone(newPheromone);
        }
    }

    @Override
    public void updatePheromoneLocal(Ant ant) {

    }
    
}
