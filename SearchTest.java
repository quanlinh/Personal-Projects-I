import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void binarySearch() {
        int[] arraySorted = {0,1,2,3,4,5,6,7,8,9};
        int[] arraySortedZero = {0,0,0};
        Search newSearch = new Search();
        // Test search element not in the list
        assertTrue(-1 == newSearch.binarySearch(arraySorted,-2));
        assertTrue(-1 == newSearch.binarySearch(arraySorted,10));
        // Test first element search
        assertTrue(0 == newSearch.binarySearch(arraySorted,0));
        // Test last element search
        assertTrue(9 == newSearch.binarySearch(arraySorted,9));
        // Test middle element search
        assertTrue(5 == newSearch.binarySearch(arraySorted,5));
        System.out.println(newSearch.binarySearch(arraySortedZero,0));


    }

}