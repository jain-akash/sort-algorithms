package personal.jain.akash.sort.testdata;

import personal.jain.akash.sort.api.ISort.Order;

public interface ISingleTestData<G> {
	G[] getArray();
	G[] getSortedArray();
	Order getOrder();
}
