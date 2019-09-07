package personal.jain.akash.sort.impl;

import personal.jain.akash.sort.api.ISort;

public class InsertionSort implements ISort {

	@Override
	public <G extends Comparable<? super G>> G[] sort(G[] arr, Order order) {
		if( arr == null)
			return null;
		for(int iterator = 1; iterator < arr.length; ++ iterator) {
			G temp = arr[iterator];
			int sortedIterator = iterator - 1;
			for( ; sortedIterator >= 0; -- sortedIterator) {
				if(order.equals(Order.ASCENDING) && temp.compareTo(arr[sortedIterator]) < 0
						|| order.equals(Order.DESCENDING) && temp.compareTo(arr[sortedIterator]) > 0) {
					arr[sortedIterator + 1] = arr[sortedIterator]; 
				}
				else
					break;
			}
			arr[sortedIterator+1] = temp;
		}
		return arr;
	}

}
