/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aco;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import aco.graph.Node;

/**
 *
 * @author deb_c
 */
public class RouletteWheel {
    int choice = 0;
    double sum;
    double u = Math.random();

    public RouletteWheel() {
    }

	public Node returnChoice(double[] probabilities, ArrayList<Node> nodeNeighbors) {
		// TODO Auto-generated method stub
		return null;
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
