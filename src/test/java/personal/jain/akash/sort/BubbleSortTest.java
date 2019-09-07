package personal.jain.akash.sort;

import org.junit.Before;

import personal.jain.akash.sort.impl.BubbleSort;

public class BubbleSortTest extends SortBaseTest {

	@Before
	public void beforeEach() {
		sort = new BubbleSort();
		testsList = SortBaseTest.testDataReader.getTestsList();
	}
}
