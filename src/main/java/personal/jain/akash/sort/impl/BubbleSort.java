package personal.jain.akash.sort.impl;

import personal.jain.akash.sort.api.ISort;

public class BubbleSort implements ISort {
	
	@Override
	public <G extends Comparable<? super G>> G[] sort(G[] arr, Order order) {
		if(arr == null)
			return null;
		for(int outerIterator = 0; outerIterator < arr.length; ++outerIterator) {
			boolean isArraySortedNow = true;
			for(int innerIterator = 1; innerIterator < arr.length - outerIterator; ++innerIterator) {
				int compareResult = arr[innerIterator].compareTo(arr[innerIterator-1]); 
 				if( order.equals(Order.ASCENDING) && compareResult < 0
 						|| order.equals(Order.DESCENDING) && compareResult > 0) {
 					Utils.swap(arr, innerIterator, innerIterator-1);
 					isArraySortedNow = false;
				}
			}
			if(isArraySortedNow) {
				break;
			}
		}
		return arr;
	}

}
