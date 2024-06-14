/*
*
* Compilare con
*
* javac GraphVisitTest.java
*
* Eseguire con
*
* javac GraphVisitTest.java <FILENAME>
*
* FILENAME e' il nome di un file che contiene la descrizione di un grafo:
* ad ogni riga del file si riportano gli indici di due nodi collegati da un arco
* separati da un TAB. 
* Dopo aver letto il grafo, lo crea, lo stampa, effettua sia una BFS che una DFS 
* e stampa i risultati.
*/

import java.io.*;
import java.util.*;
import datastructure.graph.*;
import algorithm.graph.traversal.*;
	
public class GraphVisitTest {	
		
	public static void main( String[] args ) {
			
		try {
			
			long start_t, end_t, elapsed, min;
			double sec;
			
			File file = new File(args[0]);
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			ArrayList<Integer> src = new ArrayList<Integer>();
			ArrayList<Integer> dst = new ArrayList<Integer>();
			String st;
			int max=0,s,d,v;
			while ((st = br.readLine()) != null) {
				v = st.indexOf("\t");
				s = Integer.valueOf(st.substring(0,v));
				d = Integer.valueOf(st.substring(v+1));
				if (s>max) max=s;
				if (d>max) max=d;
				src.add(s);
				dst.add(d);
			}
			Graph<Integer> g = new GraphAL<Integer>();
			
			ArrayList<Vertex<Integer>> nodi = 
				new ArrayList<Vertex<Integer>>(max+1);
			for (int i=0; i<=max; i++)
				nodi.add(g.addVertex(i));
			for (int j=0; j<src.size(); j++) 
				g.addEdge(new Edge<Integer>(nodi.get(src.get(j)),
					nodi.get(dst.get(j))));
	
			ArrayList<Vertex<Integer>> vert = g.vertexes();
			for (int i=0; i<g.vertexNum(); i++) {
				System.out.println("Adiacenti a: "+(vert.get(i)).data );
				ArrayList<Edge<Integer>> archi = g.outEdges(vert.get(i));
				for (int j=0; j<g.outDegree(vert.get(i)); j++) {
					System.out.print( "  "+ ((archi.get(j)).dest).data );
				}
				System.out.println();
			}
			
			//versione BFS
			Traversal<Integer,VisitedVertex<Integer>> visBFS = 
				new BFS<Integer>();
			ArrayList<VisitedVertex<Integer>> l1 = visBFS.visit(g,nodi.get(0));
			for (int i=0; i<l1.size(); i++)
				System.out.println( l1.get(i).visited.data+" "+
					((l1.get(i).parent != null) ? l1.get(i).parent.data : -1)); 

			//versione DFS
			Traversal<Integer,VisitedVertexDFS<Integer>> visDFS = 
				new DFS<Integer>();
			ArrayList<VisitedVertexDFS<Integer>> l2 = visDFS.visit(g,nodi.get(0));
			for (int i=0; i<l2.size(); i++)
				System.out.println( l2.get(i).visited.data+" "+
					((l2.get(i).parent != null) ? l2.get(i).parent.data : -1) +
					" "+l2.get(i).dt+" "+l2.get(i).ft);			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
 
 
