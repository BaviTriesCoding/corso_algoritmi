package algorithm.graph.SSSP;

import datastructure.graph.*;
import datastructure.priorityqueue.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

/**
 * Implementation of the Dijkstra algorithm for the computation of the shortest paths
 * from a given source vertex.
 * @param <D> type of the data object in the graph vertexes
 */	
public class Dijkstra<D> implements SSSP<D> {
	
	/** Map with the distances computed by the last execution of compute */
	private Map<Vertex<D>,Double> distance;

	/** Map with the parent relation computed by the last execution of compute */
	private Map<Vertex<D>,Vertex<D>> parent;
		
	/**
   	 * Constructs a Dijkstra object exposing the compute, distance and parent methods
	 */	
	public Dijkstra(){ 
	
	}	
		
	public Map<Vertex<D>,Double> distance() {
		return this.distance;
	}

	public Map<Vertex<D>,Vertex<D>> parent() {
		return this.parent;
	}
	
	public void compute(WeightedGraph<D> graph, Vertex<D> source) {
				
	}

}

