package personal.jain.akash.sort;

import org.junit.Before;

import personal.jain.akash.sort.impl.SelectionSort;

public class SelectionSortTest extends SortBaseTest {
	@Before
	public void beforeEach() {
		sort = new SelectionSort();
		testsList = SortBaseTest.testDataReader.getTestsList();
	}
}
