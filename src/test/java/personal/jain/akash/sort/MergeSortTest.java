package personal.jain.akash.sort;

import org.junit.Before;

import personal.jain.akash.sort.impl.MergeSort;

public class MergeSortTest extends SortBaseTest {

	@Before
	public void beforeEach() {
		sort = new MergeSort();
		testsList = SortBaseTest.testDataReader.getTestsList();
	}
}
