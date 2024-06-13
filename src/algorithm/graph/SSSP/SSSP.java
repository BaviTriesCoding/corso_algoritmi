package algorithm.graph.SSSP;

import datastructure.graph.*;
import java.util.Map;

/**
 * Generic search of shortest paths from a given source vertex
 * @param <D> type of the data object in the graph vertexes
 */
public interface SSSP<D> {

	/**
	 * Computes the shortest paths in a graph from a given source
	 * @param graph the graph on which the shortest paths must be computed
	 * @param source the initial source vertex
	 */	
	public void compute(WeightedGraph<D> graph, Vertex<D> source);

	/**
	 * Returns the distances computed during the last execution of compute
	 * @return a map associating to each vertex the corresponding computed distance
	 */	
	public Map<Vertex<D>,Double> distance();

	/**
	 * Returns the tree with the shortest paths computed during the last execution of compute
	 * @return a map associating to each vertex the parent vertex in the tree with the shortest paths
	 */	
	public Map<Vertex<D>,Vertex<D>> parent();

}
