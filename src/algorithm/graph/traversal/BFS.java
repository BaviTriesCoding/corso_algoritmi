package algorithm.graph.traversal;

import datastructure.graph.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;

/**
 * Implementation of the graph traversal interface by using a breadth-first search
 * @param <D> type of the data object in the graph vertexes
 */
public class BFS<D> implements Traversal<D, VisitedVertex<D>> {
	
	/**
   	 * Constructs a BFS object exposing the visit method
	 */	
	public BFS() {
		
	}
	
	public ArrayList<VisitedVertex<D>> visit(Graph<D> graph, Vertex<D> source) {
		Vertex<D> u, v;
		ArrayList<Edge<D>> adj;
		Map<Vertex<D>, Boolean> visited = new HashMap<Vertex<D>, Boolean>();
		ArrayList<VisitedVertex<D>> l = new ArrayList<VisitedVertex<D>>();
		Queue<Vertex<D>> q = new ArrayDeque<Vertex<D>>();	
			
		ArrayList<Vertex<D>> vert = graph.vertexes();	
		for (int i=0; i<vert.size(); i++) {
			visited.put(vert.get(i), false);
		}
		visited.put(source, true);
		l.add(new VisitedVertex<D>(source,null));
		q.add(source);
		while (!q.isEmpty()) {
			u = q.remove();
			adj = graph.outEdges(u);
			for (int j=0; j<adj.size(); j++) {
				v = (adj.get(j)).dest;
				if (!visited.get(v)) {
					visited.put(v,true);
					l.add(new VisitedVertex<D>(v,u));
					q.add(v);
				}
			}			
		}
		return l;
	}
		
}
