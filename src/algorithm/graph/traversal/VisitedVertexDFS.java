package algorithm.graph.traversal;

import datastructure.graph.*;

/**
 * Visited vertex dusing a DFS
 * @param <D> type of the data object in the graph vertexes
 */
public class VisitedVertexDFS<D> extends VisitedVertex<D> {

	/** discovery time */
	public int dt;

	/** finish time */
	public int ft;
	
	/**
   	 * Constructs a vertex visited during a DFS
	 * @param visited visited vertex
   	 * @param parent parent of the visited vertex
	 */	
	public VisitedVertexDFS(Vertex<D> visited, Vertex<D> parent) {
		super(visited, parent);
	}
	
}
