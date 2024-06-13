package algorithm.sorting;

import java.sql.Array;

/**
 * This class contains various sorting algorithms
 */
public class Sorting {

	private static void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	private static int min(int[] A){
		int min = A[0];
		for(int i=1; i<A.length; i++){
			if(A[i]<min){
				min = A[i];
			}
		}
		return min;
	}
	private static int max(int[] A){
		int max = A[0];
		for(int i=1; i<A.length; i++){
			if(A[i]>max){
				max = A[i];
			}
		}
		return max;
	}

	/**
	 * Sorts the specified array into ascending numerical order in &Theta;(n<sup>2</sup>)
	 * <firstIndex>
	 * Implements the selectionsort algorithm.
	 * <ul>
	 * <li> Worst/Average/Best-case cost: &Theta;(n<sup>2</sup>)
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void selectionsort(int[] A) {
		for(int i=0; i<A.length-1; i++){
			int m=i;
			for(int j=i; j<A.length; j++){
				if(A[j]<A[m]){
					m=j;
				}
			}
			if(m!=i){
				swap(A, i, m);
			}
		}
	}

	/**
	 * Sorts the specified array into ascending numerical order in O(n<sup>2</sup>)
	 * <firstIndex>
	 * Implements the insertionsort algorithm.
	 * <ul>
	 * <li> Worst/Average-case cost: &Theta;(n<sup>2</sup>)
	 * <li> Best-case cost: &Theta;(n)
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void insertionsort(int A[]) {
		for(int i=1; i<A.length; i++){
			int j=i;
			while(j>0 && A[j]<A[j-1]){
				swap(A, j, j-1);
				j--;
			}
		}
	}

 	/**
	 * Sorts the specified array into ascending numerical order in &Theta;(nlogn)
	 * <firstIndex>
	 * Implements the mergesort algorithm.
	 * <ul>
	 * <li> Worst/Average/Best-case cost: &Theta;(nlogn)
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void mergesort(int[] A) {
		mergesortfunction(A, 0, A.length-1);
	}

	private static void mergesortfunction(int[] A, int firstIndex, int lastIndex){
		if(firstIndex<lastIndex){
			int middleIndex = (firstIndex + lastIndex) / 2;
			mergesortfunction(A, firstIndex, middleIndex);
			mergesortfunction(A, middleIndex + 1, lastIndex);
			merge(A, firstIndex, middleIndex, lastIndex);
		}
	}

	private static void merge(int[] A, int firstIndex, int middleIndex, int lastIndex){
		int[] B = new int [lastIndex-firstIndex+1];
		int i = firstIndex;//i itera il primo sottoarray
		int j = middleIndex+1;//j itera il secondo sottoarray
		int k = 0;//k itera l'array B

		while(i<=middleIndex && j<=lastIndex){//il primo while va a ordinare gli elementi dei due sottoarray
			if(A[i] <= A[j]){// in odine crescente, e si ferma quando uno dei due sottoarray non ha più elementi
				B[k] = A[i];
				i++;
			}else{
				B[k] = A[j];
				j++;
			}
			k++;
		}
		while(i<=middleIndex){//gli altri due while finiscono il lavoro
			B[k] = A[i];
			k++;
			i++;
		}
		while(j<=lastIndex){
			B[k] = A[j];
			k++;
			j++;
		}
		for(k=0; k <lastIndex-firstIndex+1; k++){//il for trasferisce tutti gli elementi di B in A
			A[firstIndex+k] = B[k];
		}
	}

	/**
	 * Sorts the specified array into ascending numerical order in O(n<sup>2</sup>) and O(nlogn) on average
	 * <firstIndex>
	 * Implements the quicksort algorithm.
	 * <ul>
	 * <li> Worst-case cost:  &Theta;(n<sup>2</sup>)
	 * <li> Average/Best-case cost: &Theta;(nlogn)
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void quicksort(int A[]) {
		quicksortfunction(A, 0, A.length-1);
	}
	private static void quicksortfunction(int[] A, int firstIndex, int lastIndex){
		if(firstIndex < lastIndex){
			int middleIndex = partition(A, firstIndex, lastIndex);
			quicksortfunction(A, firstIndex, middleIndex-1);
			quicksortfunction(A, middleIndex+1, lastIndex);
		}
	}

	private static int partition(int[] A, int p, int r){
		int x = A[r];
		int i = p;
		for(int j = p; j<r; j++){
			if(A[j]<=x){
				swap(A, i, j);
				i++;
			}
		}
		swap(A, i, r);
		return i;
	}

	/**
	 * Sorts the specified array into ascending numerical order in &Theta;(n+k)
	 * <firstIndex>
	 * Implements the countingsort algorithm.
	 * <ul>
	 * <li> Worst/Average/Best-case cost: &Theta;(n+k), where k = max(<code>A</code>)-min(<code>A</code>)+1
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void countingsort(int A[]) {
		int min = min(A), max = max(A), k = max - min + 1;
		int[] B = new int [k];
		for(int i=0; i<k; i++){
			B[i] = 0;
		}
		for(int i=0; i<A.length; i++){
			B[A[i]-min] ++;
		}
		int j=0;
		for(int i=0; i<k; i++){
			while(B[i]>0){
				A[j] = i+min;
				B[i]--;
				j++;
			}
		}
	}

	public static void heapsort(int A[]){
		heapify(A, A.length-1, 0);
		for(int i = A.length-1; i > 0; i--){
			int k = A[0];
			A[0] = A[i];
			fixHeap(A, A.length, 0);
			A[i] = k;

		}
	}

	private static void heapify(int A[], int n, int i){
		if(i<=n){
			heapify(A, n, 2*i);
			heapify(A, n, 2*i + 1);
			fixHeap(A, n, i);
		}
	}

	private static void fixHeap(int[] A, int c, int i){
		if(2*i <= c){
			int max = 2*i;
			if(2*i + 1 <= c && A[2*i] < A[2*i + 1]){
				max = 2*i + 1;
			}
			if(A[i] < A[max]){
				swap(A, max, i);
				fixHeap(A, c, max);
			}
		}
	}
}
