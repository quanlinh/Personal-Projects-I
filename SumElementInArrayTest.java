import static org.junit.jupiter.api.Assertions.*;

class SumElementInArrayTest {


    public static void main(String args[]) {
        int totalRun = 100;
        SumElementInArray sumElementInArray = new SumElementInArray();
        int[] array = new int[10000];
        Math.random();

        for(int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 100);
        }
        // Stress tess
        for (int i = 0; i < totalRun; i++) {
            assertTrue ( sumElementInArray.sumArrayForLoop(array.length,array)
                   == sumElementInArray.sumArrayRecursive(array.length,array));

        }

    }
}