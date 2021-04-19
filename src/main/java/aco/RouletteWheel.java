/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aco;

import java.util.Iterator;
import java.util.Set;

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
    
    public Node returnChoice(Probability p, Set<Node> n){
        Iterator<Node> nodeAsIterator = n.iterator();
        Node choice = nodeAsIterator.next();
        sum = p.calculaProbabilidade(choice);
               
        while(sum < u){
            choice = nodeAsIterator.next();
            sum += p.calculaProbabilidade(choice);
        }
        return choice;
    }
    
    
}
