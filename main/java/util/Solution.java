/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import graph.EdgeAdapter;
import graph.GraphAdapter;
import graph.NodeAdapter;
import java.util.ArrayList;

/**
 *
 * @author deb_c
 */
public class Solution {

    private GraphAdapter graph;
    private ArrayList<NodeAdapter> visitedNodes;
    private ArrayList<EdgeAdapter> visitedEdges;
    private double cost;

    public Solution(GraphAdapter graph) {
        this.graph = graph;
        this.visitedNodes = new ArrayList<NodeAdapter>();
        this.visitedEdges = new ArrayList<EdgeAdapter>();
        this.cost = 0;
    }

    public Solution(GraphAdapter graph, double cost) {
        this.graph = graph;
        this.visitedNodes = new ArrayList<NodeAdapter>();
        this.visitedEdges = new ArrayList<EdgeAdapter>();
        this.cost = cost;
    }

    public void openSolution(NodeAdapter node) {
        this.visitedNodes.add(node);
    }

    public ArrayList<EdgeAdapter> getVisitedEdges() {
        return visitedEdges;
    }

    public void closeSolution() {
        NodeAdapter firstNode = this.visitedNodes.get(0);
        this.addNode(firstNode);
    }

    public void addNode(NodeAdapter node) {
        NodeAdapter lastNode = this.curentNode();
        this.visitedNodes.add(node);
        EdgeAdapter edge = this.graph.getEdge(lastNode, node);
        this.visitedEdges.add(edge);
        this.cost += edge.getCost();
    }

    public NodeAdapter curentNode() {
        int size = this.visitedNodes.size();
        return this.visitedNodes.get(size - 1);
    }

    public double getCost() {
        return this.cost;
    }

    @Override
    public String toString() {
        String caminho = "";
        for (NodeAdapter node : this.visitedNodes) {
            caminho +=  node.getId() + " - ";
        }
        return caminho;
    }
    
    
}
