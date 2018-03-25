import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomnessTest {
    @Test
    void shuffle() {
        int[] sortedArray = {0,1,2,3,4,5,6,7,8,9,10};
        int count = 0;
        Randomness randomness = new Randomness();
        randomness.shuffle(sortedArray);
        for(int i = 0; i < sortedArray.length; i++) {
            if(sortedArray[i] == i) count++;
        }
        assertFalse(count == sortedArray.length);
    }

}