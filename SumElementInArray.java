
public class SumElementInArray {
    /**
     *
     * @param n the n element of the array need to be sum
     * @param ar the array of integer
     * @return total
     */
    public int sumArrayRecursive(int n, int[] ar) {
        if(n == 0) return 0;
        return ar[n-1] + sumArrayRecursive(n-1,ar);
    }

    public int sumArrayForLoop(int n, int[] ar) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ar[i];
        }
        return sum;
    }

}
