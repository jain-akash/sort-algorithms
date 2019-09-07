package personal.jain.akash.sort.impl;

public class Utils {
	public static <G extends Comparable<? super G>> void swap(G[] arr, int fromIndex, int toIndex) {
		if(fromIndex > -1 && toIndex > -1 
				&& arr != null && arr.length > fromIndex && arr.length > toIndex) {
			G temp = arr[fromIndex];
			arr[fromIndex] = arr[toIndex];
			arr[toIndex] =  temp;
		}
	}
}
