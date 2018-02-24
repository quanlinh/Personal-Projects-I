public class Sorted {
    /**
     * This method will sorted array using insertion sort
     *
     * @param array Array of Integers
     *              How to sort array in place?
     */
    public void insertionSorted(int[] array) {
        // Edge Case:
//        if  (array.length == 1) return array;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
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
    private void swapArrayElement(int[] a,int i,int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;

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


}
