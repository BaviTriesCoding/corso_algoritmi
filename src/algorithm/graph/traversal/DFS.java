package algorithm.graph.traversal;

import datastructure.graph.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Implementation of the graph traversal interface by using a depth-first search
 * @param <D> type of the data object in the graph vertexes
 */
public class DFS<D> implements Traversal<D, VisitedVertexDFS<D>> {
	
	private int time;
	private ArrayList<VisitedVertexDFS<D>> l;
	private Map<Vertex<D>, Boolean> visited;
		
	/**
   	 * Constructs a DFS object exposing the visit method
	 */	
	public DFS() {
		
	}
	
	private void DFSvisit(Graph<D> g, VisitedVertexDFS<D> v) {
		ArrayList<Edge<D>> adj;
		Vertex<D> u = v.visited, w;
		
		visited.put(u,true);
		l.add(v);
		time++;
		v.dt = time;
		adj = g.outEdges(u);
		for (int j=0; j<adj.size(); j++) {
			w = (adj.get(j)).dest;
			if (!visited.get(w)) 
				DFSvisit(g, new VisitedVertexDFS<D>(w,u));
		}	
		time++;
		v.ft = time;
	}

	public ArrayList<VisitedVertexDFS<D>> visit(Graph<D> graph, Vertex<D> source) {
		visited = new HashMap<Vertex<D>, Boolean>();
		Vertex<D> u;
		time = 0;
		
		ArrayList<Vertex<D>> vert = graph.vertexes();	
		for (int i=0; i<vert.size(); i++) {
			visited.put(vert.get(i), false);
		}
		
		l = new ArrayList<VisitedVertexDFS<D>>();
		for (int i=0; i<vert.size(); i++) {
			u = vert.get(i);
			if (!visited.get(u)) 
				DFSvisit(graph, new VisitedVertexDFS<D>(u,null));
		}
		return l;
	}
		
}
