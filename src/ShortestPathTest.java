/*
*
* Compilare con
*
* javac ShortestPathTest.java
*
* Eseguire con
*
* java ShortestPathTest <FILENAME>
*
* FILENAME e' il nome di un file che contiene la descrizione di un grafo:
* ad ogni riga del file si riportano gli indici di due nodi collegati da un arco
* separati da un TAB. 
* Dopo aver letto il grafo, lo crea, lo stampa, effettua una ricerca dei cammini
* che hanno il primo vertice come sorgente sia con BellmanFord che con Dijkstra.
* Dopo ogni ricerca stampa i risultati.
*/

import java.io.*;
import java.util.*;
import datastructure.graph.*;
import algorithm.graph.SSSP.*;

public class ShortestPathTest {	
		
	public static void main( String[] args ) {
			
		try {
			
			long start_t, end_t, elapsed, min;
			double sec;
			
			File file = new File(args[0]);
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			ArrayList<Integer> src = new ArrayList<Integer>();
			ArrayList<Integer> dst = new ArrayList<Integer>();
			ArrayList<Double> pesi = new ArrayList<Double>();
			String st,strest;
			int max=0,s,d,v,v2;
			double p;
			while ((st = br.readLine()) != null) {
				v = st.indexOf("\t");
				s = Integer.valueOf(st.substring(0,v));
				strest = st.substring(v+1);
				v2 = strest.indexOf("\t");
				d = Integer.valueOf(strest.substring(0,v2));
				p = Double.valueOf(strest.substring(v2+1));
				if (s>max) max=s;
				if (d>max) max=d;
				src.add(s);
				dst.add(d);
				pesi.add(p);
			}
			
			WeightedGraph<Integer> g = 
				new WeightedGraphAL<Integer>();

			ArrayList<Vertex<Integer>> nodi = 
				new ArrayList<Vertex<Integer>>(max+1);
			for (int i=0; i<=max; i++)
				nodi.add(g.addVertex(i));
			for (int j=0; j<src.size(); j++) {
				g.addEdge(new WeightedEdge<Integer>(nodi.get(src.get(j)),
					nodi.get(dst.get(j)),pesi.get(j)));
			}			
			
			SSSP<Integer> cammini;
			Map<Vertex<Integer>,Double> dist;
			
			// Invoca l'esecuzione di Bellman-Ford
			cammini = new BellmanFord<Integer>();
			cammini.compute(g,nodi.get(0));
		    dist = cammini.distance();
			for (int i=0; i<dist.size(); i++) {
				System.out.println( "Distanza nodo " + nodi.get(i).data + " : " +
					dist.get(nodi.get(i)) );
			}
			
			System.out.println();
				
			// Invoca l'esecuzione di Dijkstra
		    cammini = new Dijkstra<Integer>();
			cammini.compute(g,nodi.get(0));
		    dist = cammini.distance();
			for (int i=0; i<dist.size(); i++) {
				System.out.println( "Distanza nodo " + nodi.get(i).data + " : " +
					dist.get(nodi.get(i)) );
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
 
 
