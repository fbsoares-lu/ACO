/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopinheiro.computacaonatural.myaco.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import com.diegopinheiro.computacaonatural.myaco.graph.NodeAdapter;


/**
 *
 * @author deb_c
 */
public class RouletteWheel {
//    int choice = 0;
//    double sum;
//    double u = Math.random();

    public RouletteWheel() {
    }

	public NodeAdapter returnChoice(double[] probabilities, ArrayList<NodeAdapter> nodeNeighbors) {
		double r = Math.random();
		int choice = 0;
		double sum = probabilities[choice]; 
		
		while (sum < r){
			choice ++;
			sum += probabilities[choice];
		}  
		return nodeNeighbors.get(choice);
	}
    
//    public Node returnChoice(Probability p, Set<Node> n){
//        Iterator<Node> nodeAsIterator = n.iterator();
//        Node choice = nodeAsIterator.next();
//        sum = p.calculaProbabilidade(choice);
//               
//        while(sum < u){
//            choice = nodeAsIterator.next();
//            sum += p.calculaProbabilidade(choice);
//        }
//        return choice;
//    }
    
    
}
