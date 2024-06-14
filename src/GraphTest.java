/*
* GraphTest.java 
*
* Compilare con
*
* javac GraphTest.java
*
* Eseguire con
*
* java GraphTest <FILENAME>
*
* FILENAME e' il nome di un file che contiene la descrizione di un grafo:
* ad ogni riga del file si riportano gli indici di due nodi collegati da un arco
* separati da un TAB. 
* Dopo aver letto il grafo, lo crea, cancella il primo arco del primo vertice e 
* poi stampa i vertici del grafo e l'elenco dei nodi adiacenti ad ogni vertice.
*/

import java.io.*;
import java.util.*;
import datastructure.graph.*;

public class GraphTest {	
		
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
			Graph<Integer> g = 	new GraphAL<Integer>();
			ArrayList<Vertex<Integer>> nodi = 
				new ArrayList<Vertex<Integer>>(max+1);
			for (int i=0; i<=max; i++)
				nodi.add(g.addVertex(i));
			for (int j=0; j<src.size(); j++) 
				g.addEdge(new Edge<Integer>(nodi.get(src.get(j)),
					nodi.get(dst.get(j))));

			ArrayList<Edge<Integer>> a = g.outEdges(nodi.get(0));
			g.removeEdge(a.get(0));
			
			ArrayList<Vertex<Integer>> vert = g.vertexes();
			for (int i=0; i<g.vertexNum(); i++) {
				System.out.println("Adiacenti a: "+(vert.get(i)).data );
				ArrayList<Edge<Integer>> archi = g.outEdges(vert.get(i));
				for (int j=0; j<g.outDegree(vert.get(i)); j++) {
					System.out.print( "  "+ ((archi.get(j)).dest).data );
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
 
 
