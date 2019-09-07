package personal.jain.akash.sort;
import org.junit.Before;

import personal.jain.akash.sort.impl.HeapSort;

public class HeapSortTest extends SortBaseTest {
	@Before
	public void beforeEach() {
		sort = new HeapSort();
		testsList = SortBaseTest.testDataReader.getTestsList();
	}
}
