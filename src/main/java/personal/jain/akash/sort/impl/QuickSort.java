package personal.jain.akash.sort.impl;

import personal.jain.akash.sort.api.ISort;

public class QuickSort implements ISort {

	private static int choosePivot(int start, int end) {
		return start + (end - start)/2;
	}
	
	private static <G extends Comparable<? super G>> void partitionAroundPivot
		(G[] arr, int start, int end, Order order) {
		if(start < end) {
			int pivotIndex = QuickSort.choosePivot(start, end);
			int actualPivotPosition = start;
			Utils.swap(arr, end, pivotIndex);
			for(int iterator = start; iterator < end; ++ iterator) {
				if(order.equals(Order.ASCENDING) && arr[iterator].compareTo(arr[end]) < 0
						|| order.equals(Order.DESCENDING) && arr[iterator].compareTo(arr[end]) > 0) {
					if(iterator != actualPivotPosition) {
						Utils.swap(arr, actualPivotPosition, iterator);
					}
					++actualPivotPosition;
				}
			}
			Utils.swap(arr, end, actualPivotPosition);
			partitionAroundPivot(arr, start, actualPivotPosition - 1, order);
			partitionAroundPivot(arr, actualPivotPosition + 1, end, order);
			
		}
	}
	
	@Override
	public <G extends Comparable<? super G>> G[] sort(G[] arr, Order order) {
		if( arr == null || order == null)
			return null;
		QuickSort.partitionAroundPivot(arr, 0, arr.length - 1, order);
		return arr;
	}

}
