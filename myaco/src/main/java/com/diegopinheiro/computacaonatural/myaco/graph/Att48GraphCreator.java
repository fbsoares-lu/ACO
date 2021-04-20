package com.diegopinheiro.computacaonatural.myaco.graph;

import java.io.File;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.nio.tsplib.TSPLIBImporter;
import org.jgrapht.util.SupplierUtil;

public class Att48GraphCreator extends GraphCreator{

	@Override
	public GraphAdapter createGraph() {
		GraphAdapter graphAdapter = new GraphAdapter();
		String name  ="src/main/res/att48.tps.txt";
		File file = new File(name);
		Graph<Integer, DefaultWeightedEdge> graphTSPLib =new SimpleDirectedWeightedGraph<>(SupplierUtil.createIntegerSupplier(1), SupplierUtil.createDefaultWeightedEdgeSupplier());
		TSPLIBImporter<Integer, DefaultWeightedEdge> importer=new TSPLIBImporter<>();
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
