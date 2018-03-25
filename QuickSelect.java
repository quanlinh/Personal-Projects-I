import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class QuickSelect {

    public int findKthNumber(int n, int k) {
        // Big Questions? What condition to compare when two numbers in lexical graphical order?
        // create an array with lexicalgraphical order

        String [] a = new String[n];
        for(int i = 0; i < n; i++) {
            a[i] = (i+1) + "";
        }
        // shuffle the array
        Collections.shuffle(Arrays.asList(a));
        // use the quick Select algorithms
        int lo = 0;
        int hi = n-1;
        k--;
        while( hi > lo) {
            int j = partition(a,lo,hi);
            System.err.println(" return j " + j);
            if      (j < k) lo = j + 1;
            else if (j > k) hi = j - 1;

            else return Integer.parseInt((a[k]));
        }
        return Integer.parseInt(a[k]);

    }


    public void shuffle(String[] a) {
        int N = a.length;

        for(int i = 0; i < N; i++) {
            // r return random between 0 and 1 in Unif(0,1)
            Random random = new Random();
            int r = random.nextInt(i+1);
            swapArrayElement(a,i,r);
        }

    }

    /**
     * swap two element of an array
     * this method is swap the elements array
     */
    public void swapArrayElement(String[] a,int i,int j) {
        String t = a[i];
        a[i] = a[j];
        a[j] = t;

    }

    /*
    * partition around the pivot
    */

    public int partition(String[] a, int lo, int hi){
        int i = lo;
        int j = hi+1;
        while (lo < hi) {
            // find item on the left to swap
            while (a[lo].compareTo(a[++i]) > 0) {
                System.err.println(a[lo]);
                System.err.println("i " + a[i]);
                System.err.println(a[lo].compareTo(a[i]));
                System.err.println("break");
                if (i == hi) break;
            }
            // find item on the right to swap
            while(a[lo].compareTo(a[--j]) <= 0) {
                System.err.println(a[lo]);
                System.err.println(" j = " + j + " " +a[j]);
                System.err.println(a[lo].compareTo(a[j]));
                if (j == lo) break;

            }
            if (i >= j) break;  // check if the pointer cross
            swapArrayElement(a,i,j);
        }

        swapArrayElement(a,lo,j);
        return j; // return index of item now know to be in place

    }


}
