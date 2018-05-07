public class Sorted {
    /**
     * This method will sorted array using insertion sort
     *
     * @param array Array of Integers
     *              How to sort array in place?
     */
    public void insertionSorted(int[] array) {
        int N = array.length;
        // Edge Case:
        if  (N == 1 || N == 0) return ;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isFirstLessThanSecond(array[j],array[i])) {
                    swapArrayElement(array,i,j);
                }
            }

        }
    }

    /**
     * swap two element of an array
     * this method is swap the elements array
     */
    public void swapArrayElement(int[] a,int i,int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;

    }

    /**
     * Two keys property
     * First: after selecting the min, it is not consider it any more
     * Second: it may swaps with itself if even though the mean point to same element: is any way to avoid it?
     * @param array
     */
    public void selectionSorted(int [] array) {
        int N = array.length;
        // Edge Case:
        if  (N == 1 || N == 0) return ;
        // run the out side loop start at min + 1
        for(int i = 0; i < N; i++) {
            int min = i;
            // run the inside loop looking min element to swap
            for (int j = i+1; j < N; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            swapArrayElement(array,min,i);
        }

    }

    /**
     * Using comparable to compare two objects
     *
     * @param first
     * @param second
     * @return true if the first less than second, false if equals or greater than
     */
    private boolean isFirstLessThanSecond(Comparable first,Comparable second) {
        return first.compareTo(second) < 0;
    }

    /**
     * Check whether the array really sorted
     *
     * @return false if not sorted, true otherwise
     */
    public boolean isArraySorted(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            if (isFirstLessThanSecond(array[i],array[i - 1])) return false;
        }
        return true;
    }

    /**
     * This is the bottom up mergeSort strategy learn from Coursera Algo offers by Princeton
     * @param array the array need to be sort
     * concise industrial-strength code, if you have space.
     * Pass through array, merging subarrays of size 1.
     * Repeat for subarrays of size 2, 4, 8, 16....
     */
    public void bottomUpMergeSortedInteger(int[] array) {
        int N = array.length;
        int[] temporaryArray = new int[N];
        // the loop is running logN times, since each time it double the array
        for (int sz = 1; sz < N; sz = sz+sz) {
            // update lo each time as the sz of subarrays
            for (int lo = 0; lo < N-sz; lo += sz+sz) {
                merge(array, temporaryArray, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }

    public void merge (int[] array, int[] aux,  int lo, int mid, int hi) {

        assert isSorted(array, lo, hi); // precondition: a[lo...mid] sorted
        assert isSorted(array, mid+1, hi); // precondition: a[mid+1...hi] sorted
        // copy
        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }
        // merge
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)               array[k] = aux[j++]; // i is exhausted move to j element
            else if (j > hi)                array[k] = aux[i++]; // j is exhausted move to i element
            else if (aux[j] < aux[i])       array[k] = aux[j++];
            else                            array[k] = aux[i++];

        }
        assert isSorted(array, lo, hi);     // postcondition: a[lo..hi] sorted
    }

    public boolean isSorted(int[] array, int lo, int hi) {
        int N = array.length;
        for(int i = 0; i < N; i++) {
            if(array[i] > array[i+1]) return false;
        }
        return true;
    }

    public void shellSorted(int[] a ) {
        int N = a.length;
        // Edge Case:
        if  (N == 1 || N == 0) return ;
        int h = 1;
        while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, ...
        // h here is the largest h-sorted that need to be
        System.err.println(h);
        while ( h >= 1)
        { // h-sorted the array
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && a[j] < a[j-h]; j -= h) {
                    swapArrayElement(a,j,j-h);
                }
            }
            // update h right here by divide by 3
            h = h/3;
        }

    }
    /**
     * threeWayQuickSorted Coursera Algorithms I Princenton
     */
    public void threeWayQuickSorted(int[] a) {
        int N = a.length;
        threeWayQuickSorted(a,0,N-1);

    }

    private void threeWayQuickSorted(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lessThan = lo, greaterThan = hi;
        int i = lo;
        int value = a[lo];
        while (i <= greaterThan)
        {
            if(a[i] < value)
                swapArrayElement(a,i++,lessThan++);
            else if(a[i] > value)
                swapArrayElement(a,i,greaterThan--);
            else i++;
        }
        threeWayQuickSorted(a,lo,lessThan-1);
        threeWayQuickSorted(a,greaterThan+1,hi);
    }


}
