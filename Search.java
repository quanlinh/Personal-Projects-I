public class Search {
    /**
     * @param searchArray
     * @param searchElement
     * @return the index of the the searchElement, -1 if not found
     */
    public int binarySearch(int[] searchArray,int searchElement) {
        int low = 0;
        int hi = searchArray.length - 1;
        // if odd; divide / will give less than one miss
        // (0 + 10)/2 = 5  = 5: 0 1 2 3 4 5 6 7 8 9 10
        // if even; (0 + 9)/2 = 4: 0 1 2 3 4 5 6 7 8 9
        int mid = (low + hi) / 2 + 1; // solved for two element array
        // only one element
        if (low == hi) {
            if (searchArray[low] == searchElement) {
                return low;
            } else {
                return -1;
            }
        }
        // Go to left
        if (searchElement < searchArray[mid]) {
            return binarySearch(searchArray,searchElement,low,mid - 1);
            // Go to right
        } else if (searchElement > searchArray[mid]) {
            return binarySearch(searchArray,searchElement,mid + 1,hi);
        } else {
            assert (searchElement == searchArray[mid]);
            return mid;
        }


//        return -1; // not found
    }

    /**
     * helper method to help binary Search
     *
     * @param searchArray
     * @param searchElement
     * @param low
     * @param hi
     */
    private int binarySearch(int[] searchArray,int searchElement,int low,int hi) {
        // The last element to consider
        // only one element
        if (low == hi) {
            System.err.println(searchArray[low]);
            System.err.println(searchElement);
            if (searchArray[low] == searchElement) {
                return low;
            } else {
                return -1;
            }
        }
        int mid = (low + hi) / 2 + 1;

        if (searchElement < searchArray[mid]) {
            return binarySearch(searchArray,searchElement,low,mid - 1);
        } else if (searchElement > searchArray[mid]) {
            return binarySearch(searchArray,searchElement,mid + 1,hi);
        } else {
            assert (searchElement == searchArray[mid]);
            return mid;
        }
//        return -1;// not makes sense
    }
}
