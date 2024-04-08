/* ************************************************
 * Classe per testare le PriorityQueue.
 *
 * Esempio di esecuzione:
 *
 * java PriorityQueueTest fileIn fileOut 
 *
 * dove "fileIn" è il nome di un file contenente parole
 * e "fileOut" è il nome di un file dove verranno scritte
 * le parole in fileIn in ordine non decrescente di lunghezza
 *
 * Il test popola una coda con priorità con le parole
 * in fileIn usando la loro lunghezza come chiave.
 * Successivamente ad una parola ogni cento si raddoppia
 * la chiave, e poi per le stesse parole le chiave viene
 * dimezzata (riportando le chiavi al valore iniziale).
 * Infine si estraggono le parole dalla coda e si inseriscono
 * nel file fileOut. 
 *
 * *************************************************/

import java.io.*;
import java.util.ArrayList;

import datastructure.priorityqueue.*;

public class PriorityQueueTest {
	
	/*
	* Main per leggere un file di parole e riordinarle in modo
	* crescente in base alla lunghezza
	*/
	public static void main( String[] args ) {
			
		try {
			
			// Legge parole dal fileIn e
				 
			File file = new File(args[0]);
			BufferedReader br = new BufferedReader(new FileReader(file));
			ArrayList<String> words = new ArrayList<String>();
			String st;
			while ((st = br.readLine()) != null) {
				words.add(st);
			}
		
			// Inserisce le parole in una priority queue usando la length come chiave
		
			PriorityQueue<Integer,String,DHeapNode<Integer,String>> pq = 
				new DHeap<Integer,String>();
			
			DHeapNode<Integer,String> node;
			
			ArrayList<DHeapNode<Integer,String>> nodes = 
				new ArrayList<DHeapNode<Integer,String>>();
				
		 	for (int i = 0; i < words.size(); i++) {
				node = pq.insert(words.get(i).length(), words.get(i));	
				nodes.add(node); 
			}
			
			// Raddoppia la chiave ogni 100 parole
			
		 	for (int i = 0; i < words.size(); i = i + 100) {
				node = nodes.get(i);
				pq.increaseKey(node.getKey() * 2, node);
			}
			
			// Dimezza la chiave ogni 100 parole
			
		 	for (int i = 0; i < words.size(); i = i + 100) {
				node = nodes.get(i);
				pq.decreaseKey(node.getKey() / 2, node);
			}
			
			// Estrae le parole dalla priority queue e le inserisce in fileOut
			
			PrintWriter writer = new PrintWriter(args[1]);
			for (int i = 0; i < words.size(); i++) {
				writer.println(pq.findMin());
				pq.deleteMin();	 
			}	
			writer.close();
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
 
 
