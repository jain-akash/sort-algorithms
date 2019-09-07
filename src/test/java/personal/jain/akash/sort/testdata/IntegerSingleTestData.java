package personal.jain.akash.sort.testdata;

import personal.jain.akash.sort.api.ISort.Order;

public class IntegerSingleTestData implements ISingleTestData<Integer>{

	private Integer[] array;
	private Integer[] sortedArray;
	private Order order;
	
	public IntegerSingleTestData(Integer[] array,Integer[] sortedArray) {
		this.array = array;
		this.sortedArray = sortedArray;
	}
	
	public IntegerSingleTestData() {
		super();
	}
	
	@Override
	public Integer[] getArray() {
		return array;
	}

	@Override
	public Integer[] getSortedArray() {
		return sortedArray;
	}

	@Override
	public Order getOrder() {
		return order;
	}
}
