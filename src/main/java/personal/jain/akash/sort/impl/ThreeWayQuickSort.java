package personal.jain.akash.sort.impl;

import personal.jain.akash.sort.api.ISort;

public class ThreeWayQuickSort implements ISort {

	private static int choosePivot(int start, int end) {
		return start + (end - start)/2;
	}

	private static <G extends Comparable<? super G>> void partitionAroundPivot
		(G[] arr, int start, int end, Order order) {
		if(start < end) {
			int pivotIndex = ThreeWayQuickSort.choosePivot(start, end);
			int leftPartitionEnd = start;
			int midPartitionLength = 0;
			Utils.swap(arr, end, pivotIndex);
			for(int iterator = start; iterator < end; ++ iterator) {
				if(order.equals(Order.ASCENDING) && arr[iterator].compareTo(arr[end]) < 0
						|| order.equals(Order.DESCENDING) && arr[iterator].compareTo(arr[end]) > 0) {
					if(iterator != leftPartitionEnd) {
						Utils.swap(arr, leftPartitionEnd + midPartitionLength, iterator);
						Utils.swap(arr, leftPartitionEnd + midPartitionLength, leftPartitionEnd);
					}
					++leftPartitionEnd;
				}
				else if (arr[iterator].compareTo(arr[end]) == 0) {
					if(iterator != leftPartitionEnd + midPartitionLength) {
						Utils.swap(arr, leftPartitionEnd + midPartitionLength, iterator);
					}
					++midPartitionLength;
				}
			}
			Utils.swap(arr, end, leftPartitionEnd + midPartitionLength);
			partitionAroundPivot(arr, start, leftPartitionEnd - 1, order);
			partitionAroundPivot(arr, leftPartitionEnd + midPartitionLength + 1, end, order);
			
		}
	}
	@Override
	public <G extends Comparable<? super G>> G[] sort(G[] arr, Order order) {
		if( arr == null || order == null)
			return null;
		ThreeWayQuickSort.partitionAroundPivot(arr, 0, arr.length - 1, order);
		return arr;
	}

}
