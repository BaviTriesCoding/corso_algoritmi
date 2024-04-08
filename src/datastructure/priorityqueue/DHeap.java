package datastructure.priorityqueue;

import java.util.ArrayList;

/**
 * Priority queue implementation based on d-heap
 * @param <K> type of the key value
 * @param <D> type of the data object 
 */	
public class DHeap<K extends Comparable<K>,D> 
	implements PriorityQueue<K,D,DHeapNode<K,D>>{
	
	/** ArrayList containing the priority queue nodes 
	 *  Useful methods on ArrayList<E>:                   
	 *  boolean add(E e)
	 * 		Appends the specified element to the end of this list
	 *  E 		get(int index)
	 *		Returns the element at the specified position in this list
	 *  E 		set(int index, E element)
	 *		Replaces the element at the specified position in this list 
	 *		with the specified element.
	 * 	E 		remove(int index)
	 *		Removes the element at the specified position in this list.	
	 */	
	private ArrayList<DHeapNode<K,D>> nodes;

    /** Number of elements in the priority queue */
	private int n;

    /** Degree of the d-heap */	
	private int d;

	/**
	 * Creates an empty d-heap (default value of the degree = 4)
	 */
	public DHeap(){
		this(4);
	}

	/**
	 * Creates an empty d-heap
	 * @param d the degree of the d-heap
	 */
	public DHeap(int d){
		this.n = 0;
		this.nodes = new ArrayList<DHeapNode<K,D>>();
		this.d = d;
	}

	public D findMin() {

	}

	public DHeapNode<K,D> insert(K key, D data) {

	}

	public D delete(DHeapNode<K,D> node) {

	}

	public D deleteMin() {

	}
	
	public void increaseKey(K newKey, DHeapNode<K,D> node) {

	}

	public void decreaseKey(K newKey, DHeapNode<K,D> node) {
		
	}

	public boolean isEmpty() {

	}

	/**
	 * Move a priority queue node up to re-fix the heap 
	 */	
	private void moveUp(DHeapNode<K,D> v) {
		DHeapNode<K,D> f = father(v);
		while (v.getIndex() > 0 && (v.getKey()).compareTo(f.getKey()) < 0) {
			swap(v, f);
			f = father(v);
		}
	}

	/**
	 * Move a priority queue node down to re-fix the heap 
	 */
	private void moveDown(DHeapNode<K,D> v) {
		DHeapNode<K,D> min = minSon(v);
		while(min != null && (v.getKey()).compareTo(min.getKey()) > 0) {
			swap(v, min);
			min = minSon(v);			
		}
	}

	/**
	 * Swaps two nodes in the ArrayList 
	 */
	private void swap(DHeapNode<K,D> n1, DHeapNode<K,D> n2) {
		nodes.set(n1.getIndex(),n2);
		nodes.set(n2.getIndex(),n1);
		int temp = n1.getIndex();
		n1.setIndex(n2.getIndex());
		n2.setIndex(temp);
	}

	/**
	 * Returns the father node of a given priority queue node
	 * (returns null in case such node is the root)	  
	 */	
	private DHeapNode<K,D> father(DHeapNode<K,D> v) {
		if (v.getIndex() == 0) return null;
		return nodes.get( (v.getIndex()-1)/d );
	}

	/**
	 * Returns the son node with minimal key of a given priority queue node
	 * (returns null in case such node is a leaf)	  
	 */
	private DHeapNode<K,D> minSon(DHeapNode<K,D> v) {
		int f = (d * (v.getIndex())) + 1;
		if (f >= n) return null;
		DHeapNode<K,D> min = nodes.get(f);
		for (int i=f+1; (i < f+d) && (i < n); i++) {
			if ( ((nodes.get(i)).getKey()).compareTo(min.getKey()) < 0 )
				min = nodes.get(i);
		}
		return min;
	}

}
