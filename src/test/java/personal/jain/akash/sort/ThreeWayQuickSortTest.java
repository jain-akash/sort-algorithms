package personal.jain.akash.sort;

import org.junit.Before;

import personal.jain.akash.sort.impl.ThreeWayQuickSort;

public class ThreeWayQuickSortTest extends SortBaseTest {

	@Before
	public void beforeEach() {
		sort = new ThreeWayQuickSort();
		testsList = SortBaseTest.testDataReader.getTestsList();
	}
}
