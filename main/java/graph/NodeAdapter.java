/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author deb_c
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NodeAdapter {

    private Integer id;

//    private String name;
//    private LinkedList<Node> shortestPath = new LinkedList<>();
//    private Integer distance = Integer.MAX_VALUE;
//    private double propability;
//    private double pheromones;
//    private Map<Node, Integer> adjacentNodes = new HashMap<>();
    public NodeAdapter(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

//    public void addDestination(Node destination, int distance) {
//        adjacentNodes.put(destination, distance);
//    }
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//    public Map<Node, Integer> getAdjacentNodes() {
//        return adjacentNodes;
//    }
//
//    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
//        this.adjacentNodes = adjacentNodes;
//    }
//    public Integer getDistance() {
//        return distance;
//    }
//
//    public void setDistance(Integer distance) {
//        this.distance = distance;
//    }
//
//    public List<Node> getShortestPath() {
//        return shortestPath;
//    }
//
//    public void setShortestPath(LinkedList<Node> shortestPath) {
//        this.shortestPath = shortestPath;
//    }
//
//    public double getPropability() {
//        return propability;
//    }
//
//    public void setPropability(double propability) {
//        this.propability = propability;
//    }
//
//    public double getPheromones() {
//        return pheromones;
//    }
//
//    public void setPheromones(double pheromones) {
//        this.pheromones = pheromones;
//    }
//    @Override
//    public String toString() {
//        return "Node{" + "name=" + name  + ", shortestPath=" + shortestPath  +", adjacentNodes=" + adjacentNodes + '}' + "\n";
//    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NodeAdapter) {
            NodeAdapter aNode = (NodeAdapter) obj;
            return this.id == aNode.id;
        }
        return false;
    }

}
