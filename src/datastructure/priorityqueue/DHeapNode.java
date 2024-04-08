package datastructure.priorityqueue;

/**
 * Generic priority queue node class
 * @param <K> type of the key value
 * @param <D> type of the data object
 */
public class DHeapNode<K,D> implements PriorityQueueNode {
	/** key value */
	protected K key;
	/** data object */
	protected D data;
	/** node index */
	protected int index;

	/**
   	 * Constructs a priority queue node containing the pair (key,data) with index i
	 * @param key key value
	 * @param data data associated to the key value  
   	 * @param i the node index  
	 */		
	public DHeapNode(K key, D data, int i) {
		this.data = data; this.key = key; this.index = i;
	}
	
	/**
	 * Returns the node key
	 * @return the node key
	 */
	public K getKey() {
		return this.key;
	}

	/**
	 * Returns the node data
	 * @return the node data
	 */
	public D getData() {
		return this.data;
	}

	/**
	 * Modifies the node key
	 * @param newKey the new node key
	 */	
	protected void setKey(K newKey) {
		this.key = newKey;
	}

	/**
	 * Returns the node index
	 * @return the node index
	 */	
	protected int getIndex() {
		return this.index;
	}

	/**
	 * Modifies the node index
	 * @param i the new node index
	 */		
	protected void setIndex(int i) {
		this.index = i;
	}

}
