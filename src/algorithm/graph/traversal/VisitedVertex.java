package algorithm.graph.traversal;

import datastructure.graph.*;

/**
 * Generic vertex returned by a graph visit
 * @param <D> type of the data object in the graph vertexes
 */
public class VisitedVertex<D> {
	
	/** visited vertex */
	public Vertex<D> visited;

	/** parent of the visited vertex */
	public Vertex<D> parent;
	
	/**
   	 * Constructs a visited vertex
	 * @param visited visited vertex
   	 * @param parent parent of the visited vertex
	 */	
	public VisitedVertex(Vertex<D> visited, Vertex<D> parent) {
		this.visited = visited;
		this.parent = parent;
	}
	
}
