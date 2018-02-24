import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SortedTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insertionSorted() {
        int[] array = {5,7,1,2,4,6,0};
        int[] arraySorted = {0,1,2,4,5,6,7};
        Sorted theSorted = new Sorted();
        theSorted.insertionSorted(array);
        for (int i = 0; i < array.length; i++) {
            System.err.println(array[i]);
            System.err.println(arraySorted[i]);
            assertTrue(array[i] == arraySorted[i]);
        }
    }

}