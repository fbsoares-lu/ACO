/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aco;

/**
 *
 * @author deb_c
 */
import java.util.HashSet;
import java.util.Set;

public class Graph {


    public Graph() {
    }

    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public Graph createGraph(Graph graph) {

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

       // nodeA.addDestination(nodeB, 10);
        //nodeA.addDestination(nodeC, 15);

        //nodeB.addDestination(nodeD, 12);
        //nodeB.addDestination(nodeF, 15);

        //nodeC.addDestination(nodeE, 10);

        //nodeD.addDestination(nodeE, 2);
        //nodeD.addDestination(nodeF, 1);

        //nodeF.addDestination(nodeE, 5);

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        /*
        char l = 'A';
        for (int i = 0; i < 6; i++) {
            Node node = new Node(l);
            l++;
            graph.addNode(node);
        }*/

        return graph;
    }
}
