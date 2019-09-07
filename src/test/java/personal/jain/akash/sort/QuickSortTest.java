package personal.jain.akash.sort;

import org.junit.Before;

import personal.jain.akash.sort.impl.QuickSort;

public class QuickSortTest extends SortBaseTest {
	@Before
	public void beforeEach() {
		sort = new QuickSort();
		testsList = SortBaseTest.testDataReader.getTestsList();
	}
}
