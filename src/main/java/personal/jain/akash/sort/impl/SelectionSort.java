package personal.jain.akash.sort.impl;

import personal.jain.akash.sort.api.ISort;

public class SelectionSort implements ISort {

	@Override
	public <G extends Comparable<? super G>> G[] sort(G[] arr, Order order) {
		if(arr == null)
			return null;
		for(int curPosIterator = 0; curPosIterator < arr.length; ++ curPosIterator) {
			G tempNextItem = arr[curPosIterator];
			int nextItemToBeplacedIndex = curPosIterator;
			for(int nextItemFinder = curPosIterator + 1; nextItemFinder < arr.length; ++ nextItemFinder) {
				if(order.equals(Order.ASCENDING) && arr[nextItemFinder].compareTo(tempNextItem) < 0
						|| order.equals(Order.DESCENDING) && arr[nextItemFinder].compareTo(tempNextItem) > 0) {
					tempNextItem = arr[nextItemFinder];
					nextItemToBeplacedIndex = nextItemFinder;
				}
			}
			if(nextItemToBeplacedIndex != curPosIterator)
				Utils.swap(arr, curPosIterator, nextItemToBeplacedIndex);
		}
		return arr;
	}

}
