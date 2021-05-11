/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;

/**
 *
 * @author deb_c
 */
public class GraphAdapter {

    private ArrayList<NodeAdapter> nodes;
    private ArrayList<EdgeAdapter> edges;

    public GraphAdapter() {
        this.nodes = new ArrayList<NodeAdapter>();
        this.edges = new ArrayList<EdgeAdapter>();
    }

    public void addNode(NodeAdapter nodeA) {
        nodes.add(nodeA);
    }

    public void addEdge(NodeAdapter nodeIn, NodeAdapter nodeOut, double cost) {
        EdgeAdapter newEdge = new EdgeAdapter(nodeIn, nodeOut, cost);
        this.edges.add(newEdge);
    }

    public void addEdge(EdgeAdapter e) {
        this.ensureNode(e.getNodeIn());
        this.ensureNode(e.getNodeOut());
        this.edges.add(e);
    }

    private void ensureNode(NodeAdapter n) {
        if (!this.nodes.contains(n)) {
            this.nodes.add(n);
        }
    }

    public ArrayList<NodeAdapter> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<NodeAdapter> nodes) {
        this.nodes = nodes;
    }

    public ArrayList<NodeAdapter> getNeighbors(NodeAdapter currentNode) {
        // TODO Auto-generated method stub
        return null;
    }

    public EdgeAdapter getEdge(NodeAdapter nodeIn, NodeAdapter nodeOut) {
        EdgeAdapter e = new EdgeAdapter(nodeIn, nodeOut);
        int i = this.edges.indexOf(e);
        return this.edges.get(i);
    }

    public double getPheromone(NodeAdapter nodeId, NodeAdapter nodeOut) {

        return getEdge(nodeId, nodeOut).getPheromone();
    }

    public ArrayList<EdgeAdapter> getEdges() {
        return this.edges;
    }

    public double[][] getPheromoneMatrix() {
        double[][] pheromoneMatrix = new double[nodes.size()][nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            NodeAdapter nodeI = nodes.get(i);
            for (int j = 0; j < nodes.size(); j++) {
                NodeAdapter nodeJ = nodes.get(j);
                if (i != j) {
                    EdgeAdapter edgeIJ = this.getEdge(nodeI, nodeJ);
                    pheromoneMatrix[i][j] = edgeIJ.getPheromone();
                }
            }
        }
        return pheromoneMatrix;
    }

}
