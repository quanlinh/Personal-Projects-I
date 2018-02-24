import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {


        // the triplets are unique
        List<List<Integer>> tripletsListSumToZero = new ArrayList<>();
        // Need a sorted method
        Sorted newSorted = new Sorted();
        newSorted.insertionSorted(nums);
//            Collections.sort(nums); // assume sort is nlogn
        for (int i = 0; i < nums.length - 1; i++) {
            // after the array had been sorted, we can search for
            // others two value that sum to the current value to zero
            // and a[i] = -(a[j]+a[k]) and and a[k] # a[j] #a[k
            // The array after sorring is
            // So we looking for sum of two numbers that add up with (-4 -1) = -5; so basically we need 5
            // we search for what?
            Search newSearch = new Search();
            int indexSearch = newSearch.binarySearch(nums,-(nums[i] + nums[i + 1]));
            if (indexSearch < i) {
                continue;
            }// ignore since it duplicate
            if (indexSearch != -1) {
                // if we found it we put it into the list
                List<Integer> triplest = new ArrayList<>();
                triplest.add(nums[i]);
                triplest.add(nums[i + 1]);
                triplest.add(nums[indexSearch]);

                tripletsListSumToZero.add(triplest);
            }
        }
        return tripletsListSumToZero;
    }

    // S = [-4,-1, -1, 0, 1, 2]

    //let test it: so on the first search -(nums[0] + nums[1]) = -(-4+(-1)) = 5 search will return -1 : we do nothing
    // on the second search -(nums[1] + nums[2]) = -(-1+ (-1)) = 2 we found 2. list = [-1,-1,2]
    // on the third search -(nums[2] + nums[3]) = -(-1+0)     = 1; search succses, we found 1: so list =      [-1,-1,2], [-1,0,1]
    // on the fourth search -(nums[3]+nums[4])  = -(0+1)= -1, we found -1 at nums[1] and -1 at nums[2], but they are less than a, so
    // we ingore it
    // on the last search, we -(nums[4] + nums[5]) = 3 and search return -1; we return two index //and out of loop -

}
