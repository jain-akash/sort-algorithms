package personal.jain.akash.sort;

import org.junit.Before;

import personal.jain.akash.sort.impl.InsertionSort;

public class InsertionSortTest extends SortBaseTest {

	@Before
	public void beforeEach() {
		sort = new InsertionSort();
		testsList = SortBaseTest.testDataReader.getTestsList();
	}
}
