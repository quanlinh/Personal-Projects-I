import java.util.Random;

public class Randomness {
    /**
     *  shuffle will make a cards randomly distributed in linear time
     *  precondition: arrays should be shorted
     *  postcondition: arrays should be random
     * @param a
     */
    public void shuffle(int[] a) {
        // TODO need to fix bugs, shuffle is wrong
        int N = a.length;
        Sorted s = new Sorted();

        for(int i = 0; i < N; i++) {
            // r return random between 0 and 1 in Unif(0,1)
//            int r = Math.random();
            Random random = new Random();
            int r = random.nextInt(i+1);

            s.swapArrayElement(a,i,r);
        }

    }


}
