package personal.jain.akash.sort.impl;

import java.lang.reflect.Array;

import personal.jain.akash.sort.api.ISort;

public class MergeSort implements ISort {

	private <G extends Comparable<? super G>> G[] merge(G[] arr1, G[] arr2, Order order) {
		@SuppressWarnings("unchecked")
		G[] arr =(G[]) Array.newInstance(Comparable.class, arr1.length + arr2.length);
		int fIterator = 0, iterator1 = 0, iterator2 = 0;
		while(iterator1 < arr1.length) {
			if(iterator2 < arr2.length) {
				if(order.equals(Order.ASCENDING) && arr1[iterator1].compareTo(arr2[iterator2]) <= 0
						|| order.equals(Order.DESCENDING) && arr1[iterator1].compareTo(arr2[iterator2]) >= 0	)
					arr[fIterator++] = arr1[iterator1++];
				else
					arr[fIterator++] = arr2[iterator2++];
			}
			else
				arr[fIterator++] = arr1[iterator1++];
		}
		while(iterator2 < arr2.length) {
			arr[fIterator++] = arr2[iterator2++];
		}
		return arr;
	}
	
	@SuppressWarnings("unchecked")
	private <G extends Comparable<? super G>> G[] recursiveMerge(G[] arr, Order order) {
		int start = 0; 
		int end = arr.length - 1;
		if(end < 1)
			return arr;
		else if( end == 1) {
			if(order.equals(Order.ASCENDING) && arr[start].compareTo(arr[end]) > 0
					|| order.equals(Order.DESCENDING) && arr[start].compareTo(arr[end]) < 0) {
				Utils.swap(arr, start, end);
			}
			return arr;
		}
		else {
			int mid = start + ( end - start) / 2;
			G[] arr1 =(G[]) Array.newInstance(Comparable.class, mid - start + 1);
			G[] arr2 =(G[]) Array.newInstance(Comparable.class, end - mid);
			for(int i = start; i <= mid; i++) 
				arr1[i - start] = arr[i];
			for(int i = mid + 1; i <= end; i++) 
				arr2[i - mid -1] = arr[i];
			return merge(recursiveMerge(arr1, order), recursiveMerge(arr2, order), order);
		}
	}
	
	@Override
	public <G extends Comparable<? super G>> G[] sort(G[] arr, Order order) {
		if( arr == null || order == null)
			return null;
		return recursiveMerge(arr, order);
	}

}
