/* ************************************************
 * Classe per testare le UnionFind.
 *
 * Esempio di esecuzione:
 *
 * java UnionFindTest fileIn
 *
 * dove "fileIn" è il nome di un file di testo che in 
 * ogni riga contiene due interi separati da un TAB;
 * gli interi rappresentano incroci e due interi sulla
 * stessa riga rappresentano due incroci collegati da una
 * strada
 *
 * Il test legge il file, crea un nodo in una struttura
 * union-find e effettua delle union sugli insiemi a cui
 * appartengono due incroci collegati da una strada.
 * Dopo aver effettuato le union legge coppie di incroci 
 * e comunica se tali incroci sono direttamente o indirettamente
 * collegati.
 *
 * Come file di esempio, si può utilizzare la rappresentazione
 * delle strade del texas roadNet-TX.txt. E' interessante notare
 * che esistono coppie di incroci non collegati, ad esempio
 * 0 1309432
 * *************************************************/

import java.io.*;
import java.util.*;

import datastructure.unionfind.*;

@SuppressWarnings("unchecked")
public class UnionFindTest {	
		
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
			
			UFnode[] elems = new UFnode[max+1];
			UnionFind uf = new QuickFindSize<Object>();
			for (int i=0; i<elems.length; i++) elems[i]=uf.makeSet(null);
			
			start_t = System.currentTimeMillis();

			for (int i = 0; i < src.size(); i++) {
				uf.union(uf.find(elems[src.get(i)]),uf.find(elems[dst.get(i)]));	 
			}
			
			end_t = System.currentTimeMillis();
			elapsed = (end_t - start_t);
			min = elapsed / (60*1000);
			sec = (elapsed - min*60*1000)/1000.0;
			System.out.println("Elaborazione collegamenti: "+min+" min "+sec+" sec");

			Scanner scanner = new Scanner(System.in);
			int u1,u2;
			boolean connected;
			do {
				System.out.println("Inserisci due punti (-1 per terminare):");
				u1 = scanner.nextInt();
				if (u1 == -1) break;
				u2 = scanner.nextInt();
				start_t = System.currentTimeMillis();
				connected = (uf.find(elems[u1]) == uf.find(elems[u2]));
				end_t = System.currentTimeMillis();
				elapsed = (end_t - start_t);
				min = elapsed / (60*1000);
				sec = (elapsed - min*60*1000)/1000.0;
				System.out.println("Controllo connessione: "+min+" min "+sec+" sec");
				if (connected)
					System.out.println("collegati");
				else
					System.out.println("scollegati");
			} while (u1 != -1);
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
 
 
