/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aco;

import graph.Att48GraphCreator;
import graph.Eil51GraphCreator;
import graph.GraphAdapter;
import graph.GraphCreator;
import java.io.IOException;
import util.Solver;
import java.util.Set;
import pheromoneStrategy.ASPheromoneStrategy;
import pheromoneStrategy.PheromoneStrategy;
import pheromoneStrategy.SACOPheromoneStrategy;
import transitionStrategies.AntSystenTransitionStrategy;
import transitionStrategies.SACOTransitionStrategy;
import transitionStrategies.TransitionStrategy;

/**
 *
 * @author deb_c
 */
public class Main {

    public static void main(String[] args) {
        GraphCreator creator = new Att48GraphCreator();
        //GraphCreator creator = new Eil51GraphCreator();
        GraphAdapter graph = creator.createGraph(); // cria grafo do Att48

        int maxIterations = 100;
        double alpha = .9;
        double beta = 2;
        int colonySize = 50; // qtd de formiga
        double rho = .5;
        double q = 20;
        //PheromoneStrategy pheromoneStrategy = new SACOPheromoneStrategy(rho);
        PheromoneStrategy pheromoneStrategy = new ASPheromoneStrategy(rho,q);
        //TransitionStrategy transitionStrategy = new SACOTransitionStrategy(alpha); // escolhe o tipo de transicao
        TransitionStrategy transitionStrategy = new AntSystenTransitionStrategy(alpha, beta);
        Solver solver = new Solver(maxIterations, colonySize, transitionStrategy, pheromoneStrategy);
        solver.solve(graph);

    }

}
