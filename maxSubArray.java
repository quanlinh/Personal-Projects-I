import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class maxSubArray {
    /**
     *
     * @param nums The arrays we need to find the maximum subarrays
     * @return the max values of the maximum sub arrays
     *
     * In this method; we are given arrays including negative numbers
     * We find the maximum subarrays of all possible values
     *
     * This is original hindsight of page   75 Introductions to Algorithms
     *  Use the following ideas to develop a nonrecursive, linear-time algorithm
     *  for the maximum-subarray problem. Start at the left end of the array
     *  ,and progress toward the right, keeping track of the maximum subarray seen
     *  so far. Knowing a maximum subarray A[1..j], extend the answer to find a
     *  maximum subarray end at index j+1 by using the following observation:
     *      a maximum subarray of A[1..j + 1] is either a maximum subarray of A[1..j]
     *      or a subarray A[i..j + 1], for some 1 <= i <= j+1. Determine a maximum
     *      sub array fo the form A[i...j +1] in constant time based on knowing a maximum
     *      subarray ending at index j.
     */
    public static int maxSubArray(int[] nums) {
        // Keeping track of the maximum sub arrays.
        // I wonder what happends when all element is negative ?
        int size = nums.length;
        int currentSum = nums[0];
        int maxSum = nums[0];
        for(int j = 1; j < size; j++) {
            int nextValue =  nums[j];
            if(currentSum + nextValue < nextValue)                currentSum = nextValue;
            else                                                  currentSum += nextValue;
            // update the maxSum
            if(currentSum > maxSum) maxSum = currentSum;
        }
        return maxSum;

    }

    public static int maxProfit(int[] prices) {
        int size = prices.length;
        if(size <= 1) return 0;
        int currentSum = prices[1]-prices[0];
        int maxSum = 0;
        for(int j = 2; j < size; j++) {
            int nextValue = prices[j]-prices[j-1];
            if(currentSum + nextValue < nextValue)              currentSum = nextValue;
            else                                                currentSum += nextValue;

            // update the maxProfit
            if(currentSum > maxSum) maxSum = currentSum;
        }
        if(maxSum < 0) return 0;
        return maxSum;
    }

    /**
     *
     * @param nums
     * @return
     * The cons here is that when the maximum is negative, the subsequences is
     * only possible of maxSum. Why, since when all negative in arrays, the only
     * way to get the maxSum is the the largest negative numbers. 
     */
    public static int[] maxSubArrayWithIndexSubsequences(int[] nums) {
        // TODO there is still bugs on hackerrank but I am not sure how
        // The maximum Subarrays is correct, but the value is not enough
        // in the subsequences
        // Keeping track of the maximum sub arrays.
        // I wonder what happends when all element is negative ?
        int size = nums.length;
        int currentSum = nums[0];
        int maxSum = nums[0];
        int start=0, end=-1;
        int subsequences = 0;
//        int negativeSubsequences;
        if(maxSum > 0) subsequences = maxSum;
//        else negativeSubsequences = maxSum;
        for(int j = 1; j < size; j++) {

            int nextValue =  nums[j];
            if(nextValue > 0) {
                subsequences += nextValue;
            }


            if(currentSum + nextValue < nextValue)
            {
                currentSum = nextValue;
                start = j;
            }
            else currentSum += nextValue;
            // update the maxSum
            if(currentSum > maxSum){
                maxSum = currentSum;
                end = j;
            }
        }
        if(subsequences == 0 && maxSum < 0) subsequences = maxSum;
        int[] maxSumAndMaxSubsequences = {maxSum,subsequences};
        return maxSumAndMaxSubsequences;
    }


    public static void main(String agrs[]) throws FileNotFoundException {
//        int[] nums = {-1,-2};
////        System.out.println(maxSubArray(nums));
//
//        // Checking max Profit
//        int[] prices1 = {7,1,5,3,6,4};
//        assert (maxProfit(prices1) == 5);
//        int[] prices2 = {7,6,4,3,1};
//        assert (maxProfit(prices2) == 0);
//
//        int[] subSequences = {2,-1,2,3,4,-5};
//        int[] maxSumAndMaxSubsequences = maxSubArrayWithIndexSubsequences(subSequences);
//        for(int i = 0; i < maxSumAndMaxSubsequences.length; i++) {
//           System.out.println(maxSumAndMaxSubsequences[i]);
//        }
//        int[] subSequences2 = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] maxSumAndMaxSubsequences2 = maxSubArrayWithIndexSubsequences(subSequences2);
//        for(int i = 0; i < maxSumAndMaxSubsequences2.length; i++) {
//            System.out.println(maxSumAndMaxSubsequences2[i]);
//        }
//
        int[] subSequences3 = {-4,-3,-2,-1};
        int[] maxSumAndMaxSubsequences3 = maxSubArrayWithIndexSubsequences(subSequences3);
        for(int i = 0; i < maxSumAndMaxSubsequences3.length; i++) {
            System.out.println(maxSumAndMaxSubsequences3[i]);
        }

        int[] subSequences4 = {1,2,3,4};
        int[] maxSumAndMaxSubsequences4 = maxSubArrayWithIndexSubsequences(subSequences4);
        for(int i = 0; i < maxSumAndMaxSubsequences4.length; i++) {
            System.out.println(maxSumAndMaxSubsequences4[i]);
        }
        // They want to max when negative also
        int[] subSequences5 = {-100,-1};
        int[] maxSumAndMaxSubsequences5 = maxSubArrayWithIndexSubsequences(subSequences5);
        for(int i = 0; i < maxSumAndMaxSubsequences5.length; i++) {
            System.out.println(maxSumAndMaxSubsequences5[i]);
        }
        // Test case of hacker ranks
//        System.err.println(agrs[1]);
//        String fileName = agrs[0];
        Scanner in  = new Scanner(new File("E:\\PersonalProjectGitHub\\Personal-Projects-I\\input01_maximum_subArrays_AndSequence.txt"));



        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int[] result = maxSubArrayWithIndexSubsequences(arr);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");

        }





    }


}
