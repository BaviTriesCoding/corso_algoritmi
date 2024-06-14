package algorithm.graph.traversal;

import datastructure.graph.*;
import java.util.ArrayList;

/**
 * Generic graph traversal interface
 * @param <D> type of the data object in the graph vertexes
 * @param <V> type of the visited vertexes returned by the traversal
 */
public interface Traversal<D,V extends VisitedVertex<D>> {

	/**
	 * Performs a visit of a passed graph and returns tha ArrayList with the visited vertexes
	 * @param graph the graph to visit
	 * @param source the initial source vertex (irrelevant in case of DFS)
	 * @return the ArrayList with the visited vertexes
	 */	
	public ArrayList<V> visit(Graph<D> graph, Vertex<D> source);

}