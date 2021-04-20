/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aco;

import java.util.Set;

import aco.graph.Graph;
import aco.graph.Node;

/**
 *
 * @author deb_c
 */
public class Main {

        static Graph graph = new Graph();


    public static void main(String[] args) {
        
        graph = graph.createGraph(graph);
        imprimeGraph();
    }

   

    private static void imprimeGraph() {
        for (int i = 0; i < 6; i++) {
            Set<Node> n = graph.getNodes();
            System.out.println(n.toString());

        }
    }

}
