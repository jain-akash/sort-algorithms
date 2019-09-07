package personal.jain.akash.sort.impl;

import personal.jain.akash.sort.api.ISort;

public class HeapSort implements ISort {

	private enum HEAP_TYPE {
		MIN, MAX;
	}
	private <G extends Comparable<? super G>> void heapify(G[] arr, int size, int root,
			HEAP_TYPE type ) {
		int newRoot = root;
		int left = root * 2 + 1;
		int right = root * 2 + 2;
		
		if(left < size 
				&& ( type.equals(HEAP_TYPE.MAX) && arr[left].compareTo(arr[newRoot]) > 0
						|| type.equals(HEAP_TYPE.MIN) && arr[left].compareTo(arr[newRoot]) < 0)) {
			newRoot = left;
		}
		if(right < size 
				&& ( type.equals(HEAP_TYPE.MAX) && arr[right].compareTo(arr[newRoot]) > 0
						|| type.equals(HEAP_TYPE.MIN) && arr[right].compareTo(arr[newRoot]) < 0)) {
			newRoot = right;
		}
		if(newRoot != root) {
			Utils.swap(arr, newRoot, root);
			heapify(arr, size, newRoot, type);
		}
	}
	@Override
	public <G extends Comparable<? super G>> G[] sort(G[] arr, Order order) {
		if(arr == null || order == null)
			return null;	
		HEAP_TYPE type = order.equals(Order.ASCENDING) ? HEAP_TYPE.MAX : HEAP_TYPE.MIN;
		for(int iHeapCreator = arr.length / 2 - 1; iHeapCreator >= 0 ; -- iHeapCreator) {
			heapify(arr, arr.length, iHeapCreator, type);
		}
		
		for(int iterator = 0; iterator < arr.length; ++ iterator) {
			Utils.swap(arr, 0, arr.length - 1 - iterator);
			heapify(arr, arr.length - 1 - iterator, 0, type);
		}
		return arr;
	}

}
