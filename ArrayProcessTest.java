import org.junit.jupiter.api.Test;

class ArrayProcessTest {
    @Test
    void singleNumber() {
        int[] findOne = {1,3,1,-1,3};
        ArrayProcess aPro = new ArrayProcess();
        aPro.singleNumber(findOne);
    }

}