import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {



        // the triplets are unique
        List<List<Integer>> tripletsListSumToZero = new ArrayList<>();
        // Need a sorted method
//        Sorted newSorted = new Sorted();
//        newSorted.insertionSorted(nums);
        int arraySize = nums.length;
        if (nums.length < 3) return tripletsListSumToZero;
        Arrays.sort(nums);
        for (int i = 0; i < arraySize - 2; i++) {
            if (nums[i] > 0) break; // impossible to have sum to zero
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                for (int j = i + 1; j < arraySize - 1; j++) {
                    if ((nums[j] != nums[j + 1])) {


                        // after the array had been sorted, we can search for
                        // others two value that sum to the current value to zero
                        // and a[i] = -(a[j]+a[k]) and and a[k] # a[j] #a[k
                        // So we looking for sum of two numbers that add up with (-4 -1) = -5; so basically we need 5
                        // we search for what?
                        Search newSearch = new Search();
                        int indexSearch = newSearch.binarySearch(nums,-nums[i] - nums[j]);
//            if (indexSearch <= j) {
//                continue;
//            }// ignore since it duplicate
                        // ignore edgeCase when they are all zeros
                        if (indexSearch != -1 && indexSearch > j) {
//                        System.err.println("i " + i);
//                        System.err.println("j " + j);
//                        System.err.println("indexSearch " + indexSearch);
                            // if we found it we put it into the list
                            List<Integer> triplest = new ArrayList<>();
                            triplest.add(nums[i]);
                            triplest.add(nums[j]);
                            triplest.add(nums[indexSearch]);
                            tripletsListSumToZero.add(triplest);
                        }

                    }
                }
            }

        }
        return tripletsListSumToZero;
    }

    /*public List<List<Integer>> threeSum(int[] nums) {


        // the triplets are unique
        List<List<Integer>> tripletsListSumToZero = new ArrayList<>();
        //Sorted the array
        Arrays.sort(nums);
//        System.err.println("nums size " + nums.length);
//        List numsList = new ArrayList(nums.length);
        Integer[] numList = new Integer[nums.length];
//        System.err.println(numsList.size());
//        Sorted newSorted = new Sorted();
//        newSorted.insertionSorted(nums);
        for (int i = 0; i < numsList.size() - 1; i++) {
            // after the array had been sorted, we can search for
            // others two value that sum to the current value to zero
            // and a[i] = -(a[j]+a[k]) and and a[k] # a[j] #a[k
            // So we looking for sum of two numbers that add up with (-4 -1) = -5; so basically we need 5
            // we search for what?
//            Search newSearch = new Search();
//            int indexSearch = newSearch.binarySearch(nums,-(nums[i] + nums[i + 1]));
            int indexSearch = Collections.binarySearch(numsList,-((Integer)numsList.get(i) + (Integer)numsList.get(i+1)));
            System.err.println(indexSearch);
            if (indexSearch < i) {
                continue;
            }// ignore since it duplicate
            if (indexSearch != -1) {
                // if we found it we put it into the list
                List<Integer> triplest = new ArrayList<>();
                triplest.add((Integer)numsList.get(i));
                triplest.add((Integer)numsList.get(i+1));
                triplest.add((Integer)numsList.get(indexSearch));

                tripletsListSumToZero.add(triplest);
            }
        }*/
//        return tripletsListSumToZero;
//    }
    // S = [-4,-1, -1, 0, 1, 2]

    //let test it: so on the first search -(nums[0] + nums[1]) = -(-4+(-1)) = 5 search will return -1 : we do nothing
    // on the second search -(nums[1] + nums[2]) = -(-1+ (-1)) = 2 we found 2. list = [-1,-1,2]
    // on the third search -(nums[2] + nums[3]) = -(-1+0)     = 1; search succses, we found 1: so list =      [-1,-1,2], [-1,0,1]
    // on the fourth search -(nums[3]+nums[4])  = -(0+1)= -1, we found -1 at nums[1] and -1 at nums[2], but they are less than a, so
    // we ingore it
    // on the last search, we -(nums[4] + nums[5]) = 3 and search return -1; we return two index //and out of loop -

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
            return binarySearch(searchArray,searchElement,mid,hi);
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
            return binarySearch(searchArray,searchElement,mid,hi);
        } else {
            assert (searchElement == searchArray[mid]);
            return mid;
        }
    }

}
