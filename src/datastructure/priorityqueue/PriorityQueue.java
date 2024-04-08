package datastructure.priorityqueue;

/**
 * Generic priority queue interface
 * @param <K> type of the key value
 * @param <D> type of the data object
 * @param <N> type of the node object
 */
public interface PriorityQueue<K,D,N extends PriorityQueueNode> {

	/**
	 *  Returns the minimum datum
	 *  (returns null if the priority queue is empty)	
	 *  @return the minimum
	 */
	public D findMin();
	
	/**
	 *  Inserts and returns the node (key,data)	
   	 *  @param key key value
   	 *  @param data data associated to the key value
	 *  @return the inserted node
	 */
	public N insert(K key, D data);
	
	/**
	 *  Deletes a given node 
   	 *  (returns null if the priority queue is empty)	
	 *  @param node the node to remove
	 *  @return the removed node
	 */
	public D delete(N node);

	/**
	 *  Deletes the node containing the minimum data
   	 *  (returns null if the priority queue is empty)	
	 *  @return the removed node (if any)
	 */
	public D deleteMin();

	/**
	 *  Increases the key of a given node
   	 *  @param newKey the new value for the key
	 *  @param node the node where the key should be reduced
	 */	
	public void increaseKey(K newKey, N node);
	
	/**
	 *  Decreases the key of a given node
   	 *  @param newKey the new value for the key
	 *  @param node the node where the key should be reduced
	 */
	public void decreaseKey(K newKey, N node);
		
	/**
	 *  Checks if the priority queue is empty
	 *  @return true if the priority queue is empty, false otherwise
	 */
	public boolean isEmpty();

}
