/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.io.File;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.nio.tsplib.TSPLIBImporter;
import org.jgrapht.util.SupplierUtil;

/**
 *
 * @author deb_c
 */
public class Eil51GraphCreator extends GraphCreator {

      @Override
    public GraphAdapter createGraph() {
        GraphAdapter graphAdapter = new GraphAdapter();
        String name = "src/main/res/eil51.tps.txt";
        File file = new File(name);
        Graph<Integer, DefaultWeightedEdge> graphTSPLib = new SimpleDirectedWeightedGraph<>(SupplierUtil.createIntegerSupplier(1), SupplierUtil.createDefaultWeightedEdgeSupplier());
        TSPLIBImporter<Integer, DefaultWeightedEdge> importer = new TSPLIBImporter<>();
        importer.importGraph(graphTSPLib, file);

        for (DefaultWeightedEdge e : graphTSPLib.edgeSet()) {

            Integer nodeIn = graphTSPLib.getEdgeSource(e);
            Integer nodeOut = graphTSPLib.getEdgeTarget(e);
            double cost = graphTSPLib.getEdgeWeight(e);

            NodeAdapter adapterNodeIn = new NodeAdapter(nodeIn);
            NodeAdapter adapterNodeOut = new NodeAdapter(nodeOut);
            EdgeAdapter adapterEdge = new EdgeAdapter(adapterNodeIn, adapterNodeOut, cost);
            graphAdapter.addEdge(adapterEdge);
        }

        return graphAdapter;
    }
    
}
