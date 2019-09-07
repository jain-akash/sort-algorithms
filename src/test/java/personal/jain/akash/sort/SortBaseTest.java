package personal.jain.akash.sort;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import personal.jain.akash.sort.api.ISort;
import personal.jain.akash.sort.api.ISort.Order;
import personal.jain.akash.sort.testdata.ISingleTestData;
import personal.jain.akash.sort.testdata.TestDataReader;

public class SortBaseTest {
	protected ISort sort;
	protected List<ISingleTestData<Integer>> testsList;
	
	protected static TestDataReader testDataReader;
	
	@BeforeClass
	public static void setup() throws JsonParseException, JsonMappingException, IOException {
		testDataReader = new TestDataReader("tests-sort-base.json");
	}
	
	public static void testSortArray(ISingleTestData<Integer> testData, ISort sort) {
		assertArrayEquals(testData.getSortedArray(),
				sort.sort(testData.getArray(), testData.getOrder()));
	}
	
/*	public static <G extends Comparable<? super G>> boolean compareArray(G[] arr1, G[] arr2) {
		if( arr1 == arr2)
			return true;
		else if( arr1 == null && arr2 != null || arr2 == null && arr1 != null)
			return false;
		else if ( arr1.length != arr2.length)
			return false;
		else {
			for(int iterator = 0; iterator < arr1.length; ++ iterator) {
				if(!arr1[iterator].equals(arr2[iterator]))
					return false;
			}
			return true;
		}
	}*/
	
	@Test
	public void runTests() {
		assertNotNull("tests list is not null", testsList);
		assertTrue("tests list is not empty" ,testsList.size() > 0);
		
		testsList.forEach(item -> { SortBaseTest.testSortArray(item, sort); });
	}
	
	@Test
	public void runNullArrayTest() {
		assertNull("For null array null object is returned", 
				sort.sort(null, Order.ASCENDING));
	}
	
	@Test
	public void runEmptyArrayTest() {
		Integer[] a = {};
		assertArrayEquals(a, sort.sort(a, Order.ASCENDING));
	}
}
