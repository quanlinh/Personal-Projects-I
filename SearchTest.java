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
        Search newSearch = new Search();
        // Test search element not in the list
        assertTrue(-1 == newSearch.binarySearch(arraySorted,-2));
        assertTrue(0 == newSearch.binarySearch(arraySorted,0));
    }

}