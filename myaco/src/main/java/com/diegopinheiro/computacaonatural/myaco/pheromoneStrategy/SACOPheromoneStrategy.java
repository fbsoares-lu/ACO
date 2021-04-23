/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopinheiro.computacaonatural.myaco.pheromoneStrategy;

import java.util.ArrayList;

import com.diegopinheiro.computacaonatural.myaco.colony.Ant;
import com.diegopinheiro.computacaonatural.myaco.colony.Colony;
import com.diegopinheiro.computacaonatural.myaco.graph.EdgeAdapter;
import com.diegopinheiro.computacaonatural.myaco.graph.GraphAdapter;
import com.diegopinheiro.computacaonatural.myaco.graph.NodeAdapter;

/**
 *
 * @author deb_c
 */
public class SACOPheromoneStrategy extends PheromoneStrategy{
	
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
    
}
