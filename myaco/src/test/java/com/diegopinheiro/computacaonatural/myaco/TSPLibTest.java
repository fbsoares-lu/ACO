package com.diegopinheiro.computacaonatural.myaco;



import java.io.File;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.nio.tsplib.TSPLIBImporter;
import org.jgrapht.util.SupplierUtil;
import org.junit.Assert;
import org.junit.Test;



/**
 * Unit test for simple App.
 */
public class TSPLibTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
    	File file = new File("src/main/res/att48.tps.txt");
		Graph<Integer, DefaultWeightedEdge> graph=new SimpleDirectedWeightedGraph<>(SupplierUtil.createIntegerSupplier(1), SupplierUtil.createDefaultWeightedEdgeSupplier());
		TSPLIBImporter<Integer, DefaultWeightedEdge> importer=new TSPLIBImporter<>();
		importer.importGraph(graph, file);

		int[] optimalTour =new int[]{1,
				8,
				38,
				31,
				44,
				18,
				7,
				28,
				6,
				37,
				19,
				27,
				17,
				43,
				30,
				36,
				46,
				33,
				20,
				47,
				21,
				32,
				39,
				48,
				5,
				42,
				24,
				10,
				45,
				35,
				4,
				26,
				2,
				29,
				34,
				41,
				16,
				22,
				3,
				23,
				14,
				25,
				13,
				11,
				12,
				15,
				40,
				9};	
		double tourLength=0;
		for(int i=0; i<optimalTour.length; i++){
		    int j=(i+1)%optimalTour.length;
		    DefaultWeightedEdge arc = graph.getEdge(optimalTour[i],optimalTour[j]);
		    tourLength+=graph.getEdgeWeight(arc);
		}
		double expected = 10628.0;
		System.out.println("Tour length: "+tourLength);
		Assert.assertEquals(tourLength, expected, 0.00001);
		
	}
    
}
